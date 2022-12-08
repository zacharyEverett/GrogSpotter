<template>
  <div id="reviews">
      <h1>Reviews: </h1>
      <div class="review" v-for="review in reviews" :key="review.reviewId">
          <h3> {{review.title}} </h3>
          <h4>Rating: {{ review.rating }}/5</h4>
          <p> {{ review.reviewBody }} </p>
      </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
data(){
    return {
        reviews: []
    }
},
created(){
    axios.get('/reviews/breweries' + this.$route.params.breweryID).then(response => {
        response.data.forEach(element => {
            this.reviews.push(element)
        });
    })
}
}
</script>

<style>
.review {
    border:1px solid black;
}
</style>