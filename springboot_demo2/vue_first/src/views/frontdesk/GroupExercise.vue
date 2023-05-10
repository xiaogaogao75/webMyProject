<template>
  <div>
    <!--单选头部-->
    <div  style=" font-size: 20px; top: 0px "  >
      <div style="text-align: left;display: inline-block" @click="$router.push('/exercise')" ><i class="el-icon-back"  ></i> 退出练习</div>
      <div style="display: inline-block;margin-left: 320px" >数据结构训练</div>
      <div  style="float: right;display: inline-block">
        <i class="el-icon-time"  ></i> {{ `${hr}: ${min}: ${sec}` }}
        <el-button v-show="isshow1" @click="begin" round type="primary" style="top: 25% ;position: relative ;font-size: 15px">开始答题</el-button>
        <el-button v-show="!isshow1" @click="open" round type="danger" style="font-size: 16px">&nbsp;&nbsp; 交卷 &nbsp;&nbsp;</el-button>
      </div>
    </div>
    <!--单选内容-->
    <div id="exerciseContext"style="display: none;" >
        <el-divider/>
        <div >
          <span >1.{{title1.titleName}}</span>
          <p></p>
          <el-radio-group v-model="resource1" @change="getValue1()" >
            <el-radio style="margin-left: 20px;"  label="A">{{title1.titleAnswerA}}</el-radio>
            <el-radio style="margin-left: 20px;" label="B">{{title1.titleAnswerB}}</el-radio>
            <el-radio style="margin-left: 20px;" label="C">{{title1.titleAnswerC}}</el-radio>
            <el-radio style="margin-left: 20px;" label="D">{{title1.titleAnswerD}}</el-radio>
          </el-radio-group>
        </div>
        <div style="margin: 20px;display:none" id="box" >
          <span><b>你的答案:</b> &nbsp;{{resource1}}</span>
          <span v-if="this.title1.titleAnswer===this.resource1"style="color: green">答案正确</span>
          <span v-else style="color: red" >答案错误</span>
          <p><b>本题答案:&nbsp;{{title1.titleAnswer}}</b> </p>
          <div style="margin: 20px;width: 80%" ><b>本题解析:</b>{{title1.titleAnalysis}}</div>
        </div>
        <el-divider/>
        <div >
            <span  >2.{{title2.titleName}}</span>
            <p></p>
            <el-radio-group v-model="resource2" @change="getValue2()" >
              <el-radio style="margin-left: 20px;" label="A">{{title2.titleAnswerA}}</el-radio>
              <el-radio style="margin-left: 20px;" label="B">{{title2.titleAnswerB}}</el-radio>
              <el-radio style="margin-left: 20px;" label="C">{{title2.titleAnswerC}}</el-radio>
              <el-radio style="margin-left: 20px;" label="D">{{title2.titleAnswerD}}</el-radio>
            </el-radio-group>
        </div>
        <div style="margin: 20px;display:none" id="box2">
          <span><b>你的答案:</b> &nbsp;{{resource2}}</span>
          <span v-if="this.title2.titleAnswer===this.resource2"style="color: green">答案正确</span>
          <span v-else style="color: red" >答案错误</span>
          <p><b>本题答案:&nbsp;{{title2.titleAnswer}}</b> </p>
          <div style="margin: 20px;width: 80%" ><b>本题解析:</b>{{title2.titleAnalysis}}</div>
        </div>
        <el-divider/>
        <div >
            <span >3.{{title3.titleName}}</span>
            <p></p>
            <el-radio-group v-model="resource3" @change="getValue3()" >
              <el-radio style="margin-left: 20px;" label="A">{{title3.titleAnswerA}}</el-radio>
              <el-radio style="margin-left: 20px;" label="B">{{title3.titleAnswerB}}</el-radio>
              <el-radio style="margin-left: 20px;" label="C">{{title3.titleAnswerC}}</el-radio>
              <el-radio style="margin-left: 20px;" label="D">{{title3.titleAnswerD}}</el-radio>
            </el-radio-group>
        </div>
      <div style="margin: 20px;display:none" id="box3">
        <span><b>你的答案:</b> &nbsp;{{resource3}}</span>
        <span v-if="this.title3.titleAnswer===this.resource3"style="color: green">答案正确</span>
        <span v-else style="color: red" >答案错误</span>
        <p><b>本题答案:&nbsp;{{title3.titleAnswer}}</b> </p>
        <div style="margin: 20px;width: 80%" ><b>本题解析:</b>{{title3.titleAnalysis}}</div>
      </div>
        <el-divider/>
        <div >
            <span >4.{{title4.titleName}}</span>
            <p></p>
            <el-radio-group v-model="resource4" @change="getValue4()" >
              <el-radio style="margin-left: 20px;" label="A">{{title4.titleAnswerA}}</el-radio>
              <el-radio style="margin-left: 20px;" label="B">{{title4.titleAnswerB}}</el-radio>
              <el-radio style="margin-left: 20px;" label="C">{{title4.titleAnswerC}}</el-radio>
              <el-radio style="margin-left: 20px;" label="D">{{title4.titleAnswerD}}</el-radio>
            </el-radio-group>
        </div>
      <div style="margin: 20px;display:none" id="box4">
        <span><b>你的答案:</b> &nbsp;{{resource4}}</span>
        <span v-if="this.title4.titleAnswer===this.resource4"style="color: green">答案正确</span>
        <span v-else style="color: red" >答案错误</span>
        <p><b>本题答案:&nbsp;{{title4.titleAnswer}}</b> </p>
        <div style="margin: 20px;width: 80%" ><b>本题解析:</b>{{title4.titleAnalysis}}</div>
      </div>
        <el-divider/>
        <div >
            <span >5.{{title5.titleName}}</span>
            <p></p>
            <el-radio-group v-model="resource5" @change="getValue5()" >
              <el-radio style="margin-left: 20px;" label="A">{{title5.titleAnswerA}}</el-radio>
              <el-radio style="margin-left: 20px;" label="B">{{title5.titleAnswerB}}</el-radio>
              <el-radio style="margin-left: 20px;" label="C">{{title5.titleAnswerC}}</el-radio>
              <el-radio style="margin-left: 20px;" label="D">{{title5.titleAnswerD}}</el-radio>
            </el-radio-group>
        </div>
      <div style="margin: 20px;display:none" id="box5">
        <span><b>你的答案:</b> &nbsp;{{resource5}}</span>
        <span v-if="this.title5.titleAnswer===this.resource5"style="color: green">答案正确</span>
        <span v-else style="color: red" >答案错误</span>
        <p><b>本题答案:&nbsp;{{title5.titleAnswer}}</b> </p>
        <div style="margin: 20px;width: 80%" ><b>本题解析:</b>{{title5.titleAnalysis}}</div>
      </div>
        <el-divider/>

    </div>
  </div>
</template>
<style>

</style>
<script>

// 需引入elementUI配合提示，或者自行制作
export default {
  data() {
    return {
      //计时器
      isshow1: true,
      time: '',
      hr: 0, min: 10, sec: 0,
      //题目
      //题目的判断
      jup:'',
      //返回的abcd
      resource1: '',
      resource2: '',
      resource3: '',
      resource4: '',
      resource5: '',
      //数据库查询的赋值
      title1:{},
      title2:{},
      title3:{},
      title4:{},
      title5:{},
    }
  },
  methods: {
    load() {
      this.request.get("/groupexercise/").then(res => {
        this.title1=res[0]
        console.log(res)
        this.title2=res[1]
        this.title3=res[2]
        this.title4=res[3]
        this.title5=res[4]
        document.getElementById("box").style.height="0px";
        document.getElementById("box2").style.height="0px";
        document.getElementById("box3").style.height="0px";
        document.getElementById("box4").style.height="0px";
        document.getElementById("box5").style.height="0px";
        document.getElementById("exerciseContext").style.height="1080px";
      })
    },
    getValue1(){
      console.log(this.resource1); // 打印的值，就是被选中的radio的值，1,2
    },
    getValue2(){
      console.log(this.resource2); // 打印的值，就是被选中的radio的值，1,2
    },
    getValue3(){
      console.log(this.resource3); // 打印的值，就是被选中的radio的值，1,2
    },
    getValue4(){
      console.log(this.resource4); // 打印的值，就是被选中的radio的值，1,2
    },
    getValue5(){
      console.log(this.resource5); // 打印的值，就是被选中的radio的值，1,2
    },
    begin() {
      // 点击按钮后开始计算指定长度的时间
      this.time = (Date.parse(new Date()) + ((0.17 * 60 * 60)) * 1000-12000);
      // 开始执行倒计时
      // 更换按钮，根据情况选择v-if或v-show
      this.isshow1 = false
      //调用开始提示框
      this.beginopen()
    },
    beginopen() {
      this.$confirm('即将开始练习，是否继续？', '提示您！', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.countdown();
        this.load()
        document.getElementById("exerciseContext").style.display="block";
        this.$message({
          type: 'success',
          message: '开始考试!',

        });
      }).catch(() => {
        window.location.reload();
        this.$message({
          type: 'info',
          message: '已取消考试'

        });
      });
    },
    countdown() {
      const end = this.time; // 定义结束时间
      const now = Date.parse(new Date()); // 获取本地时间
      const msec = end - now; // 定义总共所需的时间
      // 将时间戳进行格式化
      let hr = parseInt(msec / 1000 / 60 / 60 % 24);
      let min = parseInt(msec / 1000 / 60 % 60);
      let sec = parseInt(msec / 1000 % 60);
      // 倒计时结束时的操作
      const that = this;
      if (this.hr ===0 && this.min ===0 && this.sec ===0) {
        console.log('时间已经结束，答题完毕');
        this.countdownnotiome()
        this.hr = 0;
        this.min = 10;
        this.sec = 0;

      } else {
        // 如时间未归零则继续在一秒后执行
        this.hr = hr > 9 ? hr : '0' + hr;
        this.min = min > 9 ? min : '0' + min;
        this.sec = sec > 9 ? sec : '0' + sec;
        setTimeout(that.countdown, 1000)
      }
    },
    countdownnotiome() {

      this.$alert('考试已截至！', '提醒您！', {
        confirmButtonText: '确定'
      }).then((action) => {
        // eleUI的确定结束回调函数方法
        if (action === 'confirm') {
          this.hr = 0;
          this.min = 0;
          this.sec = 0;
          console.log(this.hr + ',' + this.min + ',' + this.sec);
          this.isshow1 = true;
          // window.location.reload()

        }
        this.$message({
          type: 'success',
          message: '交卷成功!',
        });
      })},
    open() {
      this.$confirm('即将结束答题, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then((action) => {
        // eleUI的确定结束回调函数方法
        if (action === 'confirm') {
          this.hr = 0;
          this.min = 0;
          this.sec = 0;
          console.log(this.hr + ',' + this.min + ',' + this.sec);
          this.isshow1 = true;
          // window.location.reload();
          document.getElementById("box").style.height="200px";
          document.getElementById("box").style.display="block";
          document.getElementById("box2").style.height="200px";
          document.getElementById("box2").style.display="block";
          document.getElementById("box3").style.height="200px";
          document.getElementById("box3").style.display="block";
          document.getElementById("box4").style.height="200px";
          document.getElementById("box4").style.display="block";
          document.getElementById("box5").style.height="200px";
          document.getElementById("box5").style.display="block";
        }
        this.$message({
          type: 'success',
          message: '交卷成功!'
        });
      }).catch(() => {
        // 点击取消后
        this.$message({
          type: 'info',
          message: '已取消交卷'
        });
      });

    }
  }
}
</script>