<template>
  <div class="home">
    <router-link :to="{name: 'addBrewery'}">Add a Brewery   </router-link>
      <router-link :to="{name: 'addBeer'}">Add a Beer </router-link>
    <div id="description">
      <img src="../imgs/dance-beer.gif" alt="" id="image">
      <p>This is a sick application where you can find beers and stuff. </p>
    </div>
    <cards></cards>
  </div>
</template>

<script>


import Cards from '../components/Cards.vue';


export default {
  created(){
    this.$store.commit('SET_BREWERIES')
  },
  components: { Cards },
  
  

    Cards};
</script>

<style >

  #description {
    display: flex;
    justify-content: center;
   
  }

  .home{
    background-image: url("https://townsquare.media/site/657/files/2022/09/attachment-josh-olalde-Ygu9Qx309s-unsplash.jpg?w=980&q=75");
    background-size: 100%;
    position: relative;
    background-attachment: fixed;
  }

  
  #description p {
    display: flex;
    justify-content: center;
    flex-direction: row;
    margin-top: 13%;
  }
</style>
