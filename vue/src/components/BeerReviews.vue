<template>
  
  <div id="reviews">
        <button v-on:click="show = !show">Leave a Review</button>
          <form v-if="show == true">
          <div>
              <div>
            <label for="username"/>
            <input type="text" name="userId" placeholder="Username"
            onfocus="placeholder=''"
            onblur="placeholder='Username'"
            v-model="newReview.userId"/>
            </div>
            <div>
                <label for="selectBeer"/>
                <input type="number" placeholder="Beer Id" disabled
                onfocus="placeholder=''"
                onblur="placeholder='Beer Id'"
                v-model="newReview.beerId"/>
            </div>
            <label for="review-title"/>
            <input type="text" id="review-title" placeholder="Review Title"
            onfocus="placeholder=''"
            onblur="placeholder='Review Title'"
            v-model="newReview.title"/>
            <select name="rating" id="rating" v-model="newReview.rating" placeholder="Rating">
                <option value="" disabled selected hidden>Choose a Rating</option>
                <option value=1>1 = Least Satisfied</option>
                <option value=2>2</option>
                <option value=3>3</option>
                <option value=4>4</option>
                <option value=5>5 = Most Satisfied</option>
            </select>
            </div>
            <div>
            <textarea name="review-body" id="review-body" rows="8" cols="50" placeholder="Type Review Here"
            onfocus="placeholder=''"
            onblur="placeholder='Type Review Here'" v-model="newReview.reviewBody"></textarea>
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
        reviews: [],
        newReview: {
            username:'',
            title:'',
            beerId:this.$route.params.beerID,
            rating:'',
            reviewBody:'',
        }
    }
},
methods: {
    addBeerReview() {
        BackendServices.addBeerReview(this.newReview);
        this.resetForm();
    },
    resetForm() {
        this.newReview = {};
        this.show = false;
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
input[disabled]{
    background-color: rgb(180, 180, 180);
}
</style>