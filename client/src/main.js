import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import store from './store'
import jsonp from 'jsonp'
import VueResource from 'vue-resource'

var Shop = require('./components/Pages/Shop.vue')
var Client = require('./components/Pages/Client.vue')
var About = require('./components/Pages/About.vue')
var Contacts = require('./components/Pages/Contacts.vue')
var Help = require('./components/Pages/Help.vue')
var Cart = require('./components/Pages/Cart.vue')
var GoodsInfo = require('./components/Pages/GoodsInfo.vue')

Vue.use(VueRouter)
Vue.use(VueResource)

var router = new VueRouter({
  routes: [
    { path: '/', component: Shop },
    { path: '/client', component: Client },
    { path: '/about', component: About },
    { path: '/contacts', component: Contacts },
    { path: '/help', component: Help },
    { path: '/cart', component: Cart },
	{ path: '/goodsInfo/:id', name: 'goodsInfo', component: GoodsInfo }
  ]
})

new Vue({
	el: '#app',
	render: h => h(App),
	router: router,
	store: store
})
