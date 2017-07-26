<template>
	<section class="shop">
		<category></category>
		<goods></goods>
		<div></div><!-- очищающий блок -->
	</section>
</template>

<script>
import Category from '../Category.vue'
import Goods from '../Goods.vue'

export default {
  name: 'app',
  components: { Category, Goods }
}
</script>