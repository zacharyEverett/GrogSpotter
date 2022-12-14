<template>
  <div class="body">
    <br/>
    <div class="button-87">
      <router-link :to="{name: 'brewery'}"><h3>Back to Brewery</h3> </router-link>
    </div>
    
      
      <beer></beer>
    <beer-reviews></beer-reviews>
      <br/>
  </div>
</template>

<script>
import Beer from '../components/Beer.vue'
import BeerReviews from '../components/BeerReviews.vue'
export default {
  components: { Beer, BeerReviews },

}
</script>

<style scoped>
.body {
  background-image: url("https://www.befreewithlee.com/wp-content/uploads/2020/07/gerrie-van-der-walt-2uSnxq3M4GE-unsplash-1-scaled.jpg");
  background-size: 100%;
  background-attachment: fixed;
}

.button87 {
  margin:0%;
  padding:0%;
}
</style>