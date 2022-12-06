<template>
  <div>
      <h1> {{ brewery.breweryName }} </h1>


  </div>
</template>

<script>
import axios from 'axios'
export default {
    props: ['Brewery'],
    data(){
        return {
        brewery: {
            breweryID: 0,
            breweryName: "",
            breweryAddress: "",
            timeOpen: null,
            timeClosed: null,
            history: null,
            beersList: null,
            active: true
          }  
        }
        
    },
    created(){
      this.brewery = axios.get("/breweries/{this.$route.params.id}").data
    }

}
</script>

<style>

</style>