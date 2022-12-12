<template>
  <div id="addReview">
        <form v-on:submit.prevent="addReview">
          <div>
            <label for="username"/>
            <input type="text" v-model="newReview.username"/>
            <label for="userId"/>
            <input type="number" id="userId" placeholder="User Id"
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'User Id'"
            v-model="newReview.userId"/>
            <label for="review-title"/>
            <input type="text" id="review-title" placeholder="Review Title"
            v-model="newReview.title"/>
            <select name="rating" id="rating">
                <option value=1>1</option>
                <option value=2>2</option>
                <option value=3>3</option>
                <option value=4>4</option>
                <option value=5>5</option>
            </select>
            </div>
            <textarea name="review-body" id="review-body" rows="8" cols="50" placeholder="Type Review Here"
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'Type Review Here'"
            v-model="newReview.reviewBody"></textarea>
            <button type="submit">Submit</button>
      </form>
    </div>
</template>

<script>
import BackendServices from '@/services/BackendServices'
export default {
  
  data(){
  return {
    newReview: {
      username: '',
      title: '',
      rating: '',
      reviewBody: '',
    }
  }
},

  methods: {
  addReview() {
    BackendServices.addBeerReview(this.newReview)
    //this.resetForm();
  },
  resetForm() {
      this.newReview = {};
    //   this.showForm = false;
    },
}
}
</script>

<style>

</style>