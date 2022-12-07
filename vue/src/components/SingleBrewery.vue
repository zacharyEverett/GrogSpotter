<template>
  <div>
      <h1 id="name"> {{ brewery.breweryName }} </h1>
      <h3 id="address">{{ brewery.breweryAddress }}</h3>
      <p>{{ brewery.history }}</p>


  </div>
</template>

<script>
import axios from 'axios'
export default {
    props: ['Brewery'],
    data(){
        return {
        brewery: {
            
          }, 
        }
        
    },
    created(){
      axios.get("breweries/"+this.$route.params.id).then(response =>
      this.brewery = response.data)
    }

}
</script>

<style>

</style>