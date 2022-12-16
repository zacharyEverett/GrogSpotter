<template>
  <div class="beer">
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
      this.$alert("We added that to your favorites for ya'.", "Glug-Glug-Yum!", 'success');
    },
  },
};
</script>

<style scoped>
h1,h2,h3{
  color: rgb(199, 94, 24);
}
div {
  text-align: center;
}
.buttons{
  display: flex;
  justify-content: center;
  align-items: center;
}
.beer{
  background-image: url("https://cdn.pixabay.com/photo/2018/02/15/14/37/paper-3155438_1280.jpg");
  border-style: inset;
  border-width: 10px;
  border-color: black;
  border-radius: 25px;
  text-align: center;
  color: rgb(73, 36, 36);
  width: 50%;
  margin: auto;
}
</style>