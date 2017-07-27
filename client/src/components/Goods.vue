<template>
  <div class="goods">
		<div id="content">
			
			<div class="bar">
				<!-- Создает связь мужду моделью searchString model и текстовым полем -->

				<input type="text" v-model="searchString" placeholder="Введите название товара" />
			</div>
			
			<div class="goods_list" v-for="goodsInfo in filteredGoods">
				<div class="logo-height">
					<router-link :to="{name: 'goodsInfo', params: {id : goodsInfo.id}}"><img :src="goodsInfo.picture" alt="" class="goods_logo"></router-link>
				</div>
				<img src="../assets/rub2.png" alt="" class="rub">
				<div class= "price">
					<b>{{goodsInfo.price}} </b>
					<button v-show="notInCart(goodsInfo)" class="add_btn" @click="addToCart(goodsInfo)">Купить</button>
					<img v-show="!notInCart(goodsInfo)" src="../assets/ok.png" alt="" class="in_cart">
				</div>
				<div>{{ goodsInfo.name }}</div>
				
				<div></div>
			</div>
			<div></div>

		</div>
  </div>
</template>

<script>
import VueResource from 'vue-resource'	

export default {
    computed: {
        resource: function() {
            return this.$resource('http://usd-bogdanov:8080/rest/goods{/id}')
        },
		filteredGoods: function () {
            var goods_array = this.goods,
                searchString = this.searchString,
				filter = this.filter
			
			if(Object.keys(filter).length){
				console.log("фильтруем по категории")
				goods_array = goods_array.filter(function(gods_simp){
						if(gods_simp.categoryId==filter.category)
							return gods_simp
					})
			}
            if(!searchString){
                return goods_array;
            }

            searchString = searchString.trim().toLowerCase();

            goods_array = goods_array.filter(function(item){
                if(item.name.toLowerCase().indexOf(searchString) !== -1){
                    return item;
                }
            })

            // Возвращает массив с отфильтрованными данными.
            return goods_array;
        },
		filter(){
			console.log("компонент товаров получил фильтр: ")
			console.log(this.$store.getters.getFilter.category)
			this.category = this.$store.getters.getFilter.id
			return this.$store.getters.getFilter
		}

    },
	data() {
		return {
			goods: [],
			searchString: "",
			category: 0
			
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

		findGoods: function() {
			this.resource.get().then(function(response){
				this.goods = response.data
			}, function(error){
				if(error)  {
					throw error
				}
			})
		},
		addToCart(goodsInfo){
//			console.log(goodsInfo)
			this.$store.dispatch('addCart',goodsInfo)
		}
	},
	created: function() {
		this.findGoods()
	}
}
</script>

