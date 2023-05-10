<template>
  <div>
  <el-col :span="12" >
  <el-col :span="4"><el-tag  round>Java在线编辑器</el-tag></el-col>
  <el-col  :span="2">
    <el-button size="mini" type="success"  round  @click="doSubmit()">运行<i class="el-icon-caret-right el-icon--right"></i></el-button>
  </el-col>
  </el-col>
  <el-col :span="12"> <!--    <el-col :offset="20" :span="2">--> <!--      <el-button size="mini" round>Clear<i class="el-icon-refresh el-icon&#45;&#45;right"></i></el-button>--> <!--    </el-col>-->
  </el-col>
  <el-col>&nbsp;</el-col>
  <el-col :span="24">
  <el-col :span="12">
    <el-card style="width:100%;height: 700px;" :body-style="{padding:'0'}" >
      <textarea  ref="JavaSourcesCode" ></textarea>
    </el-card>
  </el-col>
  <el-col :span="12">
    <el-card style="width:100%;height: 100px" :body-style="{padding:'10px'}">
      <el-row >
        <el-col  :span="3">
          <el-checkbox v-model="ifLimitTime" size="mini" label="限时" border></el-checkbox>
        </el-col>
        <el-col :offset="2" :span="10">
          <el-input size="mini" v-if="ifLimitTime" placeholder="1000(单位：毫秒,默认1S)" v-model="postData.excuteTimeLimit"
          ></el-input>
        </el-col>
      </el-row >
      <el-col :span="24">&nbsp;</el-col>
      <el-row >
        <el-col  :span="3">
          <el-checkbox v-model="ifArgs" size="mini" label="输入参数" border></el-checkbox>
        </el-col>
        <el-col :offset="2"  :span="10">
          <el-input size="mini" v-if="ifArgs" placeholder="在此输入args参数,多个以空格分隔" v-model="postData.excuteArgs"
          ></el-input>
        </el-col>
      </el-row>
    </el-card>
    <el-card style="width:100%;height: 200px" :body-style="{padding:'0'}" shadow="hover">
      <el-alert
          title="运行信息"
          type="success"
          :closable="false"
          style="height: 40px;"
      >
      </el-alert>
      <p>运行耗时(毫秒)：{{result.excuteDurationTime}}</p>
      <p>编译状态：{{result.message}}</p>
      <el-col style="height: 160px; padding:20px"></el-col>
    </el-card>
    <el-card style="width:100%;height: 400px" :body-style="{padding:'0'}">
      <el-alert
          title="运行结果"
          type="success"
          :closable="false"
          style="height: 40px;"
      >
      </el-alert>
      <el-col style="height: 360px; padding:0px">
        <p>{{result.excuteResult}}</p>
      </el-col>
    </el-card>
  </el-col>
  </el-col>
  </div>
</template>
<script>
//引入全局实例
import codeMirror from'codemirror'
//核心样式
import 'codemirror/lib/codemirror.css'
//语法高亮
import 'codemirror/mode/clike/clike.js'
const CodeMirror = window.CodeMirror || codeMirror
export default {
  data () {
    return {
        ifLimitTime:false,//是否限时
        ifArgs:false,//是否输入参数
        postData:{//用户界面输入信息
        excuteTimeLimit:"",//限时
        excuteArgs:"",//输入参数
        javaSource:"",//源码
      },
        result:{//用户得到结果
        message:"暂未编译",//编译状态
        excuteDurationTime:"0",//运行耗时(毫秒)
        excuteResult:">",//执行结果
      },
      editorCodeMirror:null,//java编辑器文本域

    }
  },
  mounted () {
    // 初始化
    this.initCodeMirror();
  },
  methods: {
    initCodeMirror(){
      // 初始化编辑器实例，传入需要被实例化的文本域对象和默认配置
      this.editorCodeMirror = CodeMirror.fromTextArea(this.$refs.JavaSourcesCode,{
        mode:"text/x-java",//选择对应代码编辑器的语言
        tabSize:2,//缩进格式
        lineNumbers:true,//显示行号
        line:true,
      })
      this.editorCodeMirror.setSize("100%","700px");//设置编辑器大小
      this.editorCodeMirror.setValue(
          "public class Main{\n" +
          "                public static void main(String[] args){\n" +
          "                    System.out.println(\"hello world!\");\n" +
          "  }\n" +
          "}"
      )
      console.log(this.$refs.JavaSourcesCode)
    },
    doSubmit(){//运行JAVA代码
      this.postData.javaSource=this.editorCodeMirror.getValue();
      this.request.post("/api/demo",this.postData.javaSource).then(res => {
      console.log(res.date)
      })
    }
  }
} </script>

