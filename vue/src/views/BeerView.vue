<template>
  <div>
    <nav>
      <router-link :to="{name: 'brewery'}"><div class="button-87">Back to Brewery</div> </router-link>
      <router-link :to="{name: 'reviewView'}"><div class="button-87">Leave A Review </div></router-link>
    </nav>
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