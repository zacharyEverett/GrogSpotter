<template>
  
  <div id="reviews">
      <link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet'>
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
          <img class="hop" v-for="rating in review.rating" :key="rating" src="@/../randompicturesofbeer\HopsIcon-removebg-preview.png" alt="hops icon">
          <img class="hop" v-for="thing in antiReviews" :key="thing" src="@/../randompicturesofbeer/LightGhost.png" alt="ghost hop"/>
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
        reviews: [],
        antiReviews: [],
    }
},

created(){
    BackendServices.getBeerReviews(this.$route.params.beerID).then(response => {
        response.data.forEach(element => {
            this.reviews.push(element)
            this.antiReviews.push(element)
            this.antiReviews.forEach(thing => {
                thing.review = 5 - thing.review;
            })
        })
    })
},

computed: {
    numOfGhost(review) {
        return (5 - review.rating);
    },
    makeArray() {
        let count = 0;
        for (let i = 5; i > this.reviews.rating; i--) {
            count++;
        }
        return count;
    }
}
}
</script>

<style>
.review {
    border:8px solid black;
    background-color: rgb(207, 10, 10);
    margin: 20px;
}

h3 {
    font-family: Lobster;
}

.hop {
    width: 50px;
}
</style>