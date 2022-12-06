<template>
  <div id="breweriesList">
      Breweries Will Go Here
      <ul>
        <li v-for="brewery in this.breweries" v-bind:key="brewery.id">{{ brewery.breweryName }}</li>
      </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
data() {
  return {
    breweries: [],
  }
  },
  created(){
    this.createList();
  },
  methods:{
    createList(){
      axios.get("/breweries").then(returned => 
      {returned.data.forEach(element => {
        this.breweries.push(element);
      });})
    }
  }
  
}
</script>

<style>

</style>