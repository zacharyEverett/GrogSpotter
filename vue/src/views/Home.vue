<template>
  <div class="home">
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

  
  #description p {
    display: flex;
    justify-content: center;
    flex-direction: row;
    margin-top: 13%;
  }
</style>
