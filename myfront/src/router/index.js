import Vue from 'vue'
import VueRouter from 'vue-router'
// import blogindex from "../components/blogindex/blogindex";
// import index from '../components/index/index'
// import login from "../components/login/login";
// import rightContent from '../components/right-content/right-content'
// import taglist from "../components/taglist/taglist";
// import backend from "../components/back-end/backend";
// import welcome from "../components/welcome/welcome";
// import allArticle from '../components/all-article/all-article'
// import updateArticle from "../components/updateArticle/updateArticle";
// import friend from "../components/friend/friend";
// import PersonalSetting from "../components/PersonalSetting/PersonalSetting";
// import writeArticle from "../components/writeArticle/writeArticle";
import friendList from "../components/friendList/friendList";
// import blogview from "../components/blogview/blogview";
// import searchBlog from "../components/searchBlog/searchBlog";
// import about from "../components/about/about";
// import classify from "../components/classify/classify";
import liuyan from "../components/liuyan/liuyan";
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('../components/index/index')
  },
  {
    path: '/blogindex',
    component: () => import('../components/blogindex/blogindex'),
    children:[
      {
        path: '/',
        component: () => import('../components/right-content/right-content')
      },
      {
        path: '/taglist',
        name: 'taglist',
        component: () => import('../components/taglist/taglist')
      },
      {
        path: '/blogview',
        component: () => import('../components/blogview/blogview')
      },
      {
        path: '/searchblog',
        name: 'searchBlog',
        component: () => import('../components/searchBlog/searchBlog')
      },
      {
        path: '/about',
        component: () => import('../components/about/about')
      },
      {
        path: '/classify',
        component: () => import('../components/classify/classify'),
        // children:[
        //           {
        //             path: '/classifyRight',
        //             component: classifyRight
        //           }
        //         ]
      },
      {
        path: '/liuyan',
        component: () => import('../components/liuyan/liuyan')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('../components/login/login')
  },
  {
    path: '/backend',
    component: () => import('../components/back-end/backend'),
    redirect: '/backend/welcome',
    children:[
      {
        path: '/backend/welcome',
        component: () => import('../components/welcome/welcome')

      },
      {
        path: '/backend/allArticle',
        component: () => import('../components/all-article/all-article')

      },
      {
        path: '/backend/update',
        component: () => import('../components/updateArticle/updateArticle')

      },
      {
        path: '/backend/friend',
        component: () => import('../components/friend/friend')

      },
      {
        path: '/backend/setting',
        component: () => import('../components/PersonalSetting/PersonalSetting'),
        meta: {keepAlive: true}
      },
      {
        path: '/backend/write',
        component: () => import('../components/writeArticle/writeArticle'),
        meta: {keepAlive: true}
      }

    ]
  }

]

const router = new VueRouter({
  mode: 'history',
  // base: process.env.BASE_URL,
  base: '/',
  routes
})

export default router


router.beforeEach((to, from , next) =>{
  NProgress.start()
  if(to.path === '/') return next()
  if(to.path === '/blogindex') return next()
  if(to.path === '/taglist') return next()
  if(to.path === '/friendList') return next()
   if(to.path === '/login') return next()
  if(to.path==='/blogview') return next()
  if(to.path === '/searchblog') return next()
  if(to.path === '/about') return next()
  if(to.path === '/classify') return next()
  if(to.path === '/classifyRight') return next()
  if(to.path === '/liuyan') return next()
   let s = sessionStorage.getItem("id")

   if(s == null) return next('/login')
   return next()
})


router.afterEach((to, from)=>{
  NProgress.done()

})
