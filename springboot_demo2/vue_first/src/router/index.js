import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manger.vue'

Vue.use(VueRouter)

const routes = [
  {
    //后台页面
    path: '/root',
    name: 'Manger',
    component: () => import(/* webpackChunkName: "about" */ '../views/Manger.vue'),
    redirect:"/root/home",
    children:[
      {path: 'home', name: '首页', component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')},
      {path: 'user', name: '用户管理', component: () => import(/* webpackChunkName: "about" */ '../views/User.vue')},
      {path: 'role', name: '权限管理', component: () => import(/* webpackChunkName: "about" */ '../views/Role.vue')},
      {path: 'menu', name: '菜单管理', component: () => import(/* webpackChunkName: "about" */ '../views/Menu.vue')},
      {path: 'userinfo', name: '个人信息', component: () => import(/* webpackChunkName: "about" */ '../views/UserInfo.vue')},
    ]
  },
  {
    //前台页面
    path: '/',
    name: 'FontHome',
    component: () => import(/* webpackChunkName: "about" */ '../views/frontdesk/FontManger.vue'),
    redirect:"/fonthome",
    children:[
      {path: 'fonthome', name: '前台首页', component: () => import(/* webpackChunkName: "about" */ '../components/FontHome.vue')},
      {path: 'groupexercise', name: '组卷练习', component: () => import(/* webpackChunkName: "about" */ '../views/frontdesk/GroupExercise.vue')},
      {path: 'fontexercise', name: '练习总首页', component: () => import(/* webpackChunkName: "about" */ '../views/frontdesk/FontExercise.vue')},
      {path: 'exercise', name: '练习首页', component: () => import(/* webpackChunkName: "about" */ '../views/frontdesk/Exercise.vue')},
      {path: 'companyquestion', name: '公司真题', component: () => import(/* webpackChunkName: "about" */ '../views/frontdesk/CompanyQuestion.vue')},
      {path: 'onlinejudgment', name: '在线编程', component: () => import(/* webpackChunkName: "about" */ '../views/frontdesk/OnlineJudgment.vue')},
    ]
  },

  {
    path: '/login',
    name: '登录',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  },{
    path: '/Register',
    name: '注册',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Register.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
