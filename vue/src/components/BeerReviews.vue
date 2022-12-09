<template>
  
  <div id="reviews">
        <button v-on:click="show = !show">Leave a Review</button>
          <form v-if="show == true">
          <div>
            <label for="review-title"/>
            <input type="text" id="review-title" placeholder="Review Title"/>
            <select name="rating" id="rating">
                <option value=1>1 = Least Satisfied</option>
                <option value=2>2</option>
                <option value=3>3</option>
                <option value=4>4</option>
                <option value=5>5 = Most Satisfied</option>
            </select>
            </div>
            <div>
            <textarea name="review-body" id="review-body" rows="8" cols="50"></textarea>
            </div>
            <button type="submit">Submit</button>
      </form>
      
      <h1>Reviews: </h1>
      <div class="review" v-for="review in reviews" :key="review.reviewId">
          <h3> {{review.title}} </h3>
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
        show: false,
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
</style>