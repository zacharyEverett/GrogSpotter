<template>
  <div>
    <breweries></breweries>
    <router-link :to="{name: 'brewery'}">Brewery 1</router-link>
  </div>
</template>

<script>
import Breweries from '../components/Breweries.vue'
export default {
  components: { Breweries },

}
</script>

<style>

</style>