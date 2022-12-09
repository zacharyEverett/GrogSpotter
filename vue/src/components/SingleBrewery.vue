<template>
  <div>
    <div id="info">
      <h1 id="name">{{ brewery.breweryName }}</h1>
      <h3 id="address">{{ brewery.streetAddress }}</h3>
      <h4>{{brewery.city}}, {{brewery.stateAbv}} {{brewery.zip}}</h4>
      <p>{{ brewery.history }}</p>
    </div>
    <div id="beersList">
      <div id="beer"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  props: ["Brewery"],
  data() {
    return {
      brewery: {},
    };
  },
  created() {
    axios
      .get("breweries/" + this.$route.params.id)
      .then((response) => (this.brewery = response.data));
  },
};
</script>

<style>
#info{
  border-style: inset;
  border-width: 10px;
  border-color: black;
  border-radius: 25px;
  text-align: center;
}
</style>