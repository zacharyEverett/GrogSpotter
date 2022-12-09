<template>
  <div>
      <router-link :to="{name: 'beerView'}">Back to Beer</router-link>
      <add-review></add-review>
  </div>
</template>

<script>
import AddReview from '../components/AddReview.vue'
export default {
    components: {AddReview},

}
</script>

<style>

</style>