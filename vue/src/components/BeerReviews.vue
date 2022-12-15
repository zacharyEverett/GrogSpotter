<template>
  <div id="reviews">
    <button
      class="button-87"
      v-show="this.newReview.username"
      v-on:click="show = !show"
    >
      Leave a Review
    </button>
    <p>Average rating: {{ avgRating }}</p>

    <div class="MainRating">
      <img class="wholeRating"
        v-for="num in avgFloor" :key="num"
        src="@/../randompicturesofbeer/HopsIcon-removebg-preview.png"
        alt=""
      />
      <span v-if="!percOfHop"></span>
      <img class="wholeRating"
        v-else-if="percOfHop == 1"
        src="@/../randompicturesofbeer/QuarterHop-removebg-preview.png"
        alt=""
      />
      <img class="wholeRating"
        v-else-if="percOfHop == 2"
        src="@/../randompicturesofbeer/HalfHop-removebg-preview.png"
        alt=""
      />
      <img class="wholeRating"
        v-else
        src="@/../randompicturesofbeer/ThreeQuarterHop-removebg-preview.png"
        alt=""
      />
      <img class="wholeRating"
        v-for="num in 5 - avgCeiling" :key="num"
        src="@/../randompicturesofbeer/GhostHop.png"
        alt=""
      />
    </div>

    <form v-if="show == true" v-on:submit="addBeerReview">
      <div>
        <label for="review-title" />
        <input
          type="text"
          id="review-title"
          placeholder="Review Title"
          onfocus="placeholder=''"
          onblur="placeholder='Review Title'"
          v-model="newReview.title"
          required
        />
        <select
          name="rating"
          id="rating"
          v-model="newReview.rating"
          placeholder="Rating"
          required
        >
          <option value=" " disabled selected hidden>Choose a Rating</option>
          <option value="1">1 = Least Satisfied</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5 = Most Satisfied</option>
        </select>
      </div>
      <div>
        <textarea
          name="review-body"
          id="review-body"
          rows="8"
          cols="50"
          placeholder="Type Review Here"
          onfocus="placeholder=''"
          onblur="placeholder='Type Review Here'"
          v-model="newReview.reviewBody"
        ></textarea>
      </div>
      <button class="button-78" type="submit">Submit</button>
    </form>

    <h1>Reviews:</h1>
    <div class="review" v-for="review in reviews" :key="review.reviewId">
      <h1>{{ review.title }}</h1>
      <h3>GrogLover: {{ review.username }}</h3>
      <h4>Rating: {{ review.rating }}/5</h4>
      <img
        class="hop"
        v-for="rating in review.rating"
        :key="rating"
        src="@/../randompicturesofbeer\HopsIcon-removebg-preview.png"
        alt="hops icon"
      />
      <img
        class="hop"
        v-for="thing in 5 - review.rating"
        :key="thing"
        src="@/../randompicturesofbeer/LightGhost.png"
        alt="ghost hop"
      />
      <p>{{ review.reviewBody }}</p>
    </div>
  </div>
</template>

<script>
import BackendServices from "../services/BackendServices";

export default {
  data() {
    return {
      show: false,
      reviews: [],
      antiReviews: [],
      newReview: {
        username: this.$store.state.user.username,
        title: "",
        beerId: this.$route.params.beerID,
        rating: "",
        reviewBody: "",
      },
    };
  },
  methods: {
    addBeerReview() {
      BackendServices.addBeerReview(this.newReview).then(() =>
        this.resetForm()
      );
    },
    resetForm() {
      this.newReview = {};
      this.show = false;
    },
  },
  computed: {
    avgRating() {
      if (!this.reviews[0]) {
        return 0;
      }
      let count = 0;
      let totalRating = 0;
      this.reviews.forEach((element) => {
        count++;
        totalRating += element.rating;
      });
      return (totalRating / count).toFixed(2);
    },
    avgFloor() {
      return Math.floor(this.avgRating);
    },
    avgCeiling() {
      return Math.ceil(this.avgRating);
    },
    halfOrNot() {
      return this.avgRating < Math.floor(this.avgRating);
    },
    percOfHop() {
      let dec = this.avgRating - Math.floor(this.avgRating);
      if (dec < 0.01) {
        return 0;
      } else
      if (dec < .4) {
        return 1;
      } else
      if (dec < .6) {
        return 2;
      } 
      return 3;
    }
  },

  created() {
    BackendServices.getBeerReviews(this.$route.params.beerID).then(
      (response) => {
        response.data.forEach((element) => {
          this.reviews.push(element);
        });
      }
    );
  },
};
</script>

<style scoped>
h1,
h2,
h3,
h4,
p {
  color: antiquewhite;
}
.review {
  border: 8px solid black;
  border-radius: 9px;
  background-color: rgb(184, 37, 37);
  margin: 20px;
}
input[disabled] {
  background-color: rgb(180, 180, 180);
}
form {
  display: flex;
  border-style: inset;
  border-width: 10px;
}

.hop {
  width: 50px;
}

.button-87 {
  margin: auto;
}

.button-78 {
  width: 100%;
}

.wholeRating {
  width: 200px;
}
</style>