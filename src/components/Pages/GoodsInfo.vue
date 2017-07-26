<template>
  <div class="GoodsInfo">
	<input type="button" class="btn-back" onclick="history.back();" value="X"/>
	<div></div>
	<div class="goods_info" v-if="goodsInfo">
		<div class="goods_name">{{goodsInfo.name}}</div>
		<div class="goods_img">
			<img :src="goodsInfo.picture" alt="" >
		</div>
		<div class = "novelty" v-if="goodsInfo.novelty==true">Новинка!</div>
		<div class = "goods_title">Описание: </div>
		<div class = "title_value">{{goodsInfo.notes}}</div>
		<div class = "goods_title">Остаток: </div>
		<div class = "title_value">{{goodsInfo.amount}} шт.</div>
		<div class = "goods_title price">Цена: </div>
		<div class= "title_value price">
			<b>{{goodsInfo.price}} руб.</b>
				<button v-show="notInCart(goodsInfo)" class="add_btn" @click="addToCart()">Купить</button>
				<img v-show="!notInCart(goodsInfo)" src="../../assets/ok.png" alt="" class="in_cart"> 
		</div>
	</div>
  </div>
</template>

<script>
import VueResource from 'vue-resource'	

export default {
    computed: {
        resource: function() {
            return this.$resource('http://localhost:8080/rest/goods{/id}')
        }
    },
	data() {
		return {
			goodsInfo: {}
		}
	},
	methods: {
      	notInCart: function(goodsInfo) {
			var list_goods = this.$store.state.goods_list
			var key_list = list_goods.map(function(gods_simp){
				return gods_simp.id
			})
			var inCart = key_list.includes(goodsInfo.id)
//			console.log(inCart)
          return !inCart
        },
		getGoods: function(){
			//console.log("route = "+ this.$route)
			var goodsId = this.$route.params.id
			this.resource.get({id:goodsId}).then(function(response){
				this.goodsInfo = response.data
			})
		},
		addToCart(){
			this.$store.dispatch('addCart',this.goodsInfo)
		}
	},
	created: function() {
		this.getGoods()
	}
}
</script>