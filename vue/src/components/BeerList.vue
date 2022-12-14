<template>
  <div>
    <div id="beersList">
      <h2>Beers on tap:</h2>
      <ul id="beerList">
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
#beersList{background-image: url("https://cdn.pixabay.com/photo/2018/02/15/14/37/paper-3155438_1280.jpg");
  border-style: inset;
  border-width: 10px;
  border-color: black;
  border-radius: 25px;
  text-align: center;
  color: rgb(73, 36, 36);
  width: 50%;
  margin: auto;
}
li{
  font-size: 24px;
}

</style>