import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
	cartAmount: 0,
	totalSum: 0,
	goods_list: [],
	filter: {}
  },
  getters: {
	  cartAmount(state){
		 // console.log("вызов геттера ")
		  return state.cartAmount
	  },
	  totalSum(state){
		  return state.totalSum
	  },
	  findList(state){
		  return state.goods_list
	  },
	  getFilter(state){
		  return state.filter
	  }
  },
  mutations: {
	setFilter(state,{type,item}){
		console.log("filter: "+item)
		console.log(item)
		state[type][item.name]=item.val
	},
	add(state, {type, item}) {
		state[type].push(item)
	},
	increment (state, {type, item}) {
//      state.cartAmount++
		state[type]+=item
    },
	deleteItem(state, goodsId) {
//		if(state.cartAmount>0){
	//		console.log("Удаляем: "+goodsId)
			var idx = state.goods_list.findIndex(item =>{if(item.id == goodsId) return item})
			var goods = state.goods_list[idx]
			console.log("Индекс: "+idx)
			state.goods_list.splice(idx,1)
			state.cartAmount-=goods.count
			state.totalSum-=goods.count*goods.price
//		}
	},
	decrement (state, {type, item}) {
		console.log("уменьшаем: "+state[type])
//		if(state[type]>0){
			state[type]-=item
			
//		}
    }

  },
  actions: {
	    addCart({commit},goodsInfo) {
			goodsInfo.count=1
			commit('add',{type:'goods_list', item: goodsInfo})
			commit('increment',{type:'cartAmount', item: 1})
			commit('increment',{type:'totalSum', item: goodsInfo.price})
		},
		deleteCart({commit}, goodsId) {
			commit('deleteItem', goodsId)
		},
		findCartList({commit}){
			console.log("корзина товаров")
			return state.goods_list
		},
		increment({commit}, goodsId){
			//console.log("увеличиваем"+store.getters.findList)
			var goods = store.getters.findList.find(item =>{if(item.id == goodsId) return item})
//				console.log("товар: "+goods.count)
			goods.count = goods.count+1
			commit('increment', {type:'cartAmount', item: 1})
			commit('increment',{type:'totalSum', item: goods.price})
		},
		decrement({commit}, goodsId){
			var goods = store.getters.findList.find(item =>{if(item.id == goodsId) return item})
//				console.log("товар: "+goods.count)
			if(goods.count!=1){
				goods.count = goods.count-1
				commit('decrement', {type:'cartAmount', item: 1})
				commit('decrement',{type:'totalSum', item: goods.price})
			}else{
				commit('deleteItem', goodsId)
			}
		},
		setFilter({commit},filter){
			commit('setFilter',{type:'filter', item: filter})
		}
  } 
})

export default store