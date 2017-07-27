<template>
	<div class="category">
		<div id="left">
			<div class="category" v-for="category in categories" v-if="category.parent_id==0" @click="hasChoosen(category)">
				<span v-if="category.folder">{{open ? 'v' : '>'}}</span>
				{{ category.name }}
<!--					<ul v-shov="open" >
					</ul> -->
				
			</div>
			
		</div>
	</div>
<!--	<div></div>
<script type="text/x-template" id="item-template">
  <li>
    <div
      :class="{bold: isFolder}"
      @click="toggle"
      >
      <span v-if="isFolder">{{open ? "v" : '>'}}</span>
      {{model.name}}
      
    </div>
    <ul v-show="open" v-if="isFolder">
      <item
        class="item"
        v-for="model in model.children"
        :model="model">
      </item>
      <li class="add" @click="addChild">+</li>
    </ul>
  </li>
</script>


<ul id="demo">
  <item
    class="item"
    :model="treeData">
  </item>
</ul>
-->
</template>

<script>
export default {
	data() {
		return {
			url: 'http://usd-bogdanov:8080/rest/category',
			categories: [],
			open: false
		}
	},
	methods: {
		findCategories: function() {
			this.$http.get(this.url).then(function(response){
//				console.log(response)
				this.categories = response.data
			}, function(error){
				if(error)  {
					throw error
				}
			})
		},
		hasChoosen: function (category){
			console.log("Выбрана категория: "+ category.name )
			if (category.folder) {
				this.open = !this.open
			}

			var f ={}
			f.name="category"
			f.val=category.id
			this.$store.dispatch("setFilter",f)
			
		}
	},
	created: function() {
		this.findCategories()
	}
}
</script>

<!-- 
<script type="text/x-template" id="item-template">
  <li>
    <div
      :class="{bold: isFolder}"
      @click="toggle"
      @dblclick="changeType">
      {{model.name}}
      <span v-if="isFolder">[{{open ? '-' : '+'}}]</span>
    </div>
    <ul v-show="open" v-if="isFolder">
      <item
        class="item"
        v-for="model in model.children"
        :model="model">
      </item>
      <li class="add" @click="addChild">+</li>
    </ul>
  </li>
</script>-->


