import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/fonts/iconfont'
import './assets/fonts/iconfont1'
import './assets/fonts/iconfont2'
import './common/css/index.css'
import './common/js/util'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
// use
Vue.use(mavonEditor)

Vue.use(ElementUI)
// axios.defaults.baseURL = 'http://47.94.218.213:8082//blog/'
//  axios.defaults.baseURL = 'http://localhost:8082/'
axios.defaults.baseURL=process.env.VUE_APP_API_URL
//axios.defaults.baseURL = 'http://121.41.122.156:8081/blog/'
Vue.prototype.$http = axios
Vue.config.productionTip = false

// axios.interceptors.request.use(config=>{
//     NProgress.start()
//    return config
// })
//
//
// axios.interceptors.response.use(config=>{
//     NProgress.done()
//   return config
// })
new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app')



// //在路由对象上 挂载路由导航守卫
// router.beforeEach((to,from,next) => {
//   //to 将要访问的路径
//   //from 代表从哪个路径跳转过来
//   //next 是一个函数，表示放行
//   //  1.next() 放行   2.next('/login') 强制跳转到login
//
//   if(to.path === '/login') return next();//如果用户访问登录页，直接放行
//   const tokenStr = window.sessionStorage.getItem('token')//获取token
//   if(!tokenStr) return next('/login')//如果没有token 则强制登录
//   next()//如果用户携带了 token 则放行
// })
