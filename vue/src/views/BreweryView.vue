<template>
  <div>
      <router-link :to="{name: 'breweries'}">Back to Brewery List</router-link> |
      <router-link :to="{name: 'beerView'}">Beer Info</router-link>
      <single-brewery></single-brewery>
  </div>
</template>

<script>
import SingleBrewery from '../components/SingleBrewery.vue'
export default {
  components: { SingleBrewery },

}
</script>

<style>

</style>