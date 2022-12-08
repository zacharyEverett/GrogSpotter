<template>
  <div>
      <router-link :to="{name: 'brewery'}">Back to Brewery </router-link>
      <router-link :to="{name: 'reviewView'}">Leave A Review </router-link>
      <beer></beer>
      <beer-reviews></beer-reviews>
  </div>
</template>

<script>
import Beer from '../components/Beer.vue'
import BeerReviews from '../components/BeerReviews.vue'
export default {
  components: { Beer, BeerReviews },

}
</script>

<style>

</style>