<template>
  <div>
      <h1>Your Favorites:</h1>
    <div v-for="beer in favorites" :key="beer.beerId" class="fav">
      <h1>{{ beer.beerName }}</h1>
      <h2>Type: {{ beer.beerType }} | Abv: {{ beer.abv }}%</h2>
      <h3>{{ beer.beerDescription }}</h3>
    </div>
  </div>
</template>

<script>
import BackendServices from '../services/BackendServices';
export default {
    data(){
        return {
            favorites: []
        }
    },
    created(){
        BackendServices.getFavorites(this.$store.state.user.id).then(
            (returned) => {
                returned.data.forEach(element => {
                    this.favorites.push(element)
                });
            }
        )
    }
};
</script>

<style>
</style>