import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import {createRouter,createWebHistory} from 'vue-router'
import getpostsApp  from "./components/getPosts.vue";
import createpostApp from './components/createPost.vue';
import postdetailsApp from './components/postDetails.vue';
import updateApp from './components/updatePost.vue'
import deleteApp from './components/deletePost.vue'

const routes = [
    {
        path:'/posts',
        component:getpostsApp,
        children:[
            {
                path:'/posts/:id',
                component:postdetailsApp,
                props:true
            }
        ]
    },
    {
        path:'/createpost',
        component:createpostApp
    },
    {
        path:'/updatePost',
        component:updateApp
    },
    {
        path:'/deletePost',
        component:deleteApp
    },
]

const router = createRouter({
    history:createWebHistory(),
    routes,
})

createApp(App).use(router).mount('#app')
