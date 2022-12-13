<template>
  <div>
    <div class="button-87">
      <router-link :to="{name: 'brewery'}"><h3>Back to Brewery</h3> </router-link>
    </div>
    
      
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