<template>
  <div>
    <h1>{{ beer.beerName }}</h1>
    <h2>Type: {{ beer.beerType }} | Abv: {{ beer.abv }}%</h2>
    <h3>{{ beer.beerDescription }}</h3>
    <div class="buttons">
      <button class="button-87" @click="addFavorited()">
        Favorite this beer
      </button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import BackendServices from "../services/BackendServices";

export default {
  data() {
    return {
      beer: {},
      favorited: {},
    };
  },
  created() {
    console.log("Called created()");
    axios.get("/beers/" + this.$route.params.beerID).then((response) => {
      this.beer = response.data;
      this.favorited = {
        user_id: this.$store.state.user.id,
        beer_id: this.beer.beerId,
      };
    });
  },
  methods: {
    addFavorited() {
      BackendServices.addToFavorites(this.favorited);
    },
  },
};
</script>

<style scoped>
h1,h2,h3{
  color: white;
}
div {
  text-align: center;
}
.buttons{
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>