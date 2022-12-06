<template>
  <div id="breweriesList">
      Breweries Will Go Here
      <ul>
        <li v-for="brewery in this.$store.state.breweries" v-bind:key="brewery.id" :brewery="brewery"> <router-link :to=""> {{ brewery.breweryName }} </router-link> </li>
      </ul>
  </div>
</template>

<script>

export default {
data() {
  return {
    breweries: [],
  }
  },
  created(){
    this.$store.commit('SET_BREWERIES')
  },
  methods:{
    
  }
  
}
</script>

<style>

</style>