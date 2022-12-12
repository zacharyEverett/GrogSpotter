<template>
  <div id="reviews">
      <button class="button-87" v-on:click="show = !show">Leave a Review</button>
          <form v-if="show == true" v-on:submit.prevent="addBreweryReview">
          <div>
              <div>
            <label for="username"/>
            <input type="text" name="userId" placeholder="Username"
            onfocus="placeholder=''"
            onblur="placeholder='Username'"
            v-model="newReview.username"/>
            </div>
            <div>
                <label for="selectBrewery"/>
                <input type="number" placeholder="Brewery Id" disabled
            
                onfocus="placeholder=''"
                onblur="placeholder='Brewery Id'"
                v-model="newReview.breweryId"/>
            </div>
            <label for="review-title"/>
            <input type="text" id="review-title" placeholder="Review Title"
            onfocus="placeholder=''"
            onblur="placeholder='Review Title'"
            v-model="newReview.title"/>
            <select name="rating" id="rating" v-model="newReview.rating">
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
// import axios from 'axios'
import BackendServices from '../services/BackendServices'
export default {
data(){
    return {
        reviews: [],
        show: false,
        newReview: {
            username:'',
            title:'',
            breweryId:this.$route.params.id,
            rating:'',
            reviewBody:'',
        }
    }
},
// created(){
//     axios.get('/reviews/breweries' + this.$route.params.breweryID).then(response => {
//         response.data.forEach(element => {
//             this.reviews.push(element)
//         });
//     })
// }
methods: {
    addBreweryReview() {
        BackendServices.addBreweryReview(this.newReview).then(() =>
        this.resetForm());
    },
    resetForm() {
        this.newReview = {};
        this.show = false;
    }
},
created(){
    BackendServices.getBreweryReviews(this.$route.params.breweryId).then(response => {
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
textarea{
    width:295px;
}
</style>