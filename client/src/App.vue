<template>
	<div id="app">
		<div id="page">
			<header>
				<div id="header">
					<router-link to="/"><img src="./assets/logo.png" alt="" class="logo"></router-link>
					<nav>
						<router-link to="/client">Клиентам</router-link>
						<router-link to="/about">О компании</router-link>
						<router-link to="/contacts">Контакты</router-link>
						<router-link to="/help">Помощь</router-link>
					</nav>
					
					<router-link to="/cart">
						<img src="./assets/cart2.png" alt="" class="cart">
						<div v-show="cartAmount>0" class = "cart_amount">
							{{cartAmount}}
						</div>
					</router-link>
				</div>
			</header>

			<router-view></router-view>

		</div>
		<footer>
			<div>© ООО "Тензор", 2017.   Все права защищены</div>
		</footer>
	</div>
</template>

<script>
export default {
  computed: {
    cartAmount() {
	//	console.log("В корзине "+this.$store.getters.cartAmount)
      return this.$store.getters.cartAmount
    }
  }
}
</script>

<style src="./assets/style.css"></style>