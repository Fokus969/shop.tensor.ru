<template>
	<div class="Cart">
		<input type="button" class="btn-back" onclick="history.back();" value="X"/>
		<h2 v-show="!isEmptyCart()">Ваша корзина пуста</h2> 
		<div v-show="isEmptyCart()" class="Item">
			<div class="item_cart cart_list_title">Наименование</div>
			
			<div class="item_cart cart_price cart_list_title">Цена</div>
			<div class = "cart_btn cart_list_title "></div>
			<div class="cart_count cart_list_title cart_list_title_c">Количество</div>
			<div></div>
		</div>

		<div class="Item cart_item" v-for="goods in cart_list">
			<!--<div class="cart_item">-->
				<div class="item_cart">{{ goods.name }}</div>
				<img src="../../assets/rub2.png" alt="" class="rub">
				<div class="item_cart cart_price">{{ goods.price }}</div>
				<div class = "cart_btn">
					<button class="btn_cursor" @click="decrement(goods.id)">-</button>
					<button class="btn_cursor" @click="increment(goods.id)">+</button>
					<button class="btn_cursor" @click="deleteFromCart(goods.id)">X</button>
				</div>
				<div class="cart_count">{{goods.count}}</div>
			<!--</div>-->
		</div><div></div>
		<div v-show="isEmptyCart()" class = "Item total">
			<div class = " ">ИТОГО: <b>{{total}}</b> руб.</div>
		</div>

	</div>
</template>

<script>
export default {
  data() {
    return {
      amount: 0
    }
  },
  methods: {
	isEmptyCart() {
		return this.$store.getters.cartAmount>0
	},
    findCartList() {
		return this.$store.dispatch('findCartList')
    },
	deleteFromCart(goodsId){
		this.$store.dispatch('deleteCart',goodsId)
	},
	increment(goodsId){
		console.log("increment")
		this.$store.dispatch('increment',goodsId)
	},
	decrement(goodsId){
		this.$store.dispatch('decrement',goodsId)
	}
  },
  computed: {
    cart_list() {
      return this.$store.state.goods_list
    },
	total() {
	//	console.log("В корзине "+this.$store.getters.cartAmount)
      return this.$store.getters.totalSum

/*		var sum = 0
		var list = this.$store.state.goods_list
		
		list.forEach(function (element, index, array){
				console.log("total: "+ element.count)
				sum += element.count * element.price
			}
		)
		return sum*/
	}
  }

}
</script>