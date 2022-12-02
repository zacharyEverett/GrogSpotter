<template>
  <div class="home">
    <div id="description">
      <p>This is a sick application where you can find beers and stuff. </p>
    </div>
    <cards></cards>
  </div>
</template>

<script>


import Cards from '../components/Cards.vue';


export default {
  components: { Cards },
  

    Cards};
</script>

<style >
  #description p {
    display: flex;
    justify-content: center;
    flex-direction: row;
    margin-top: 13%;
  }
</style>
