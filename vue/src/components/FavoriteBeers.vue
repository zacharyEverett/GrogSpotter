<template>
  <div>
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
      (this.favorites = []),
        BackendServices.deleteFavorite(this.deleted).then(
          (this.favorites = [])
        );

      this.refresh();
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
  },
};
</script>

<style>
.fav {
  background-color: rgb(184, 37, 37);
  border-style: inset;
  border-width: 10px;
  border-radius: 5px;
}
</style>