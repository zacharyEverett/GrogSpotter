<template>
  <div class="body">
    <br/>
    
      <router-link class="button-87" :to="{name: 'brewery'}">Back to Brewery</router-link>
    
    
      
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
  position: relative;
  background-attachment: fixed;
}

.button-87{
  margin: auto;
}

</style>