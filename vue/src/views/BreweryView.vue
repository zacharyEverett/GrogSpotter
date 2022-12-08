<template>
  <div>
      <router-link :to="{name: 'breweries'}">Back to Brewery List</router-link> |
      <router-link :to="{name: 'beerView'}">Beer Info</router-link>
      <single-brewery></single-brewery>
      <beer-list></beer-list>
  </div>
</template>

<script>
import BeerList from '../components/BeerList.vue'
import SingleBrewery from '../components/SingleBrewery.vue'
export default {
  components: { SingleBrewery, BeerList },

}
</script>

<style>

</style>