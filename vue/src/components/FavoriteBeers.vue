<template>
  <div class="background">
    <h1>Your Favorites:</h1>
    <br>
    <div v-for="beer in favorites" :key="beer.beerId" class="fav">
      <h1>{{ beer.beerName }}</h1>
      <h2>Type: {{ beer.beerType }} | Abv: {{ beer.abv }}%</h2>
      <h3>{{ beer.beerDescription }}</h3>
      <button class="button-87" @click.prevent="deleteFav(beer.beerId)">
        Remove from Favorites
      </button>
    </div>
  </div>
</template>

<script>
import BackendServices from "../services/BackendServices";
export default {
  data() {
    return {
      favorites: [],
      deleted: {},
    };
  },
  created() {
    this.refresh();
  },
  methods: {
    deleteFav(id) {
      this.deleted = {
        user_id: this.$store.state.user.id,
        beer_id: id,
      };
      this.favorites = this.favorites.filter((item) => this.isFavorited(item.beerId)),
        BackendServices.deleteFavorite(this.deleted).then(
          this.$alert("Favorite removed.", "Destroyed.", "success")
        );
    },
    refresh() {
      BackendServices.getFavorites(this.$store.state.user.id).then(
        (returned) => {
          returned.data.forEach((element) => {
            this.favorites.push(element);
          });
        }
      );
    },
    isFavorited(id) {
      return this.deleted.beer_id != id;
    },
  },
};
</script>

<style>
.fav {
  background-color: rgb(184, 37, 37);
  border-style: inset;
  border-width: 10px;
  border-radius: 5px;
  margin-top: 10px;
  margin-left: 100px;
  margin-right: 100px;
}
h1,h2,h3{
  color:antiquewhite;
}
.background{
  background-image: url("https://typewriter.imgix.net/u/62c9caaa-96a2-47f0-b0ad-a9c6ba359eb5/p/81009/gonzalo-remy-JCIJnIXv7SE-unsplash.jpg?ixlib=rails-2.1.4&auto=format%2Ccompress&crop=faces&fit=crop&h=800&w=800");
  width: 100%;
}
</style>