<template>
  <div>
    <div id="beersList">
      <h2>Beers on tap:</h2>
      <ul id="beersList">
        <li v-for="beer in beers" :key="beer.beerId">
          <router-link
            :to="{
              name: 'beerView',
              params: { id: beer.breweryId, beerID: beer.beerId },
            }"
          >
            {{ beer.beerName }}
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

//my thought is to make each beer its own little card, 
so a div that goes through a v-for from the beers array
- zach
<script>
import BackendServices from '../services/BackendServices';

export default {
  data() {
    return {
      beers: [],
    };
  },
  created() {
    BackendServices.getBeerList(this.$route.params.id)
      .then((returned) => {
        returned.data.forEach((element) => {
          this.beers.push(element);
        });
      });
  },
};
</script>

<style>
</style>