<template>
    
  <div id="reviews">
      <link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet'>
      <h1>Reviews: </h1>
      <div class="review" v-for="review in reviews" :key="review.reviewId">
          <h3> Review Title  </h3>
          <h4>Rating: {{ review.rating }}/5</h4>
          <p> {{ review.reviewBody }} </p>
      </div>
  </div>
</template>

<script>
import BackendServices from '../services/BackendServices'

export default {
data(){
    return {
        reviews: []
    }
},

created(){
    BackendServices.getBeerReviews(this.$route.params.beerID).then(response => {
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

h3 {
    font-family: Lobster;
}
</style>