<template>
  <div>
      <router-link :to="{name: 'breweries'}">Back to Brewery List</router-link> |
      <router-link :to="{name: 'beerView'}">Beer Info</router-link>
      <single-brewery></single-brewery>
      <beer-list></beer-list>
      <brewery-reviews></brewery-reviews>
  </div>
</template>

<script>
import BeerList from '../components/BeerList.vue'
import SingleBrewery from '../components/SingleBrewery.vue'
import BreweryReviews from '../components/BreweryReviews.vue'
export default {
  components: { SingleBrewery, BeerList, BreweryReviews },

}
</script>

<style>

</style>