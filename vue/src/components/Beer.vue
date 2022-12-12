<template>
  <div>
    <h1>{{ beer.beerName }}</h1>
    <h2>Type: {{ beer.beerType }}  |  Abv: {{ beer.abv }}</h2>
    <h3>{{ beer.beerDescription }}</h3>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      beer: {},
    };
  },
  created() {
    axios.get("/beers/" + this.$route.params.beerID).then((response) => {
      this.beer = response.data;
    });
  },
};
</script>

<style scoped>
div{
  text-align: center;
}
</style>