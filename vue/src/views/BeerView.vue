<template>
  <div>
      <router-link :to="{name: 'brewery'}">Back to Brewery </router-link>
      <router-link :to="{name: 'reviewView'}">Leave A Review </router-link>
      <beer></beer>
  </div>
</template>

<script>
import Beer from '../components/Beer.vue'
export default {
  components: { Beer },

}
</script>

<style>

</style>