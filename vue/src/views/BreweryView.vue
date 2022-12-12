<template>
  <div class="body">
    <div class="navButtons">
      <router-link :to="{ name: 'breweries' }">
        <h4 class="button-87">Back to Brewery List</h4></router-link
      >
      <router-link :to="{ name: 'beerView' }">
        <h4 class="button-87">Beer Info</h4></router-link
      >
    </div>
    <single-brewery></single-brewery>
    <beer-list></beer-list>
    <brewery-reviews></brewery-reviews>
  </div>
</template>

<script>
import BeerList from "../components/BeerList.vue";
import SingleBrewery from "../components/SingleBrewery.vue";
import BreweryReviews from "../components/BreweryReviews.vue";
export default {
  components: { SingleBrewery, BeerList, BreweryReviews },
};
</script>

<style>
.body {
  background-image: url('https://www.befreewithlee.com/wp-content/uploads/2020/07/gerrie-van-der-walt-2uSnxq3M4GE-unsplash-1-scaled.jpg');
  background-size: 100%;
  position: relative;
  background-attachment: fixed;
}
.navButtons {
  display: flex;
  justify-content: space-around;
}
/*  Button CSS */
.button-87 {
  margin: 10px;
  padding: 15px 30px;
  text-align: center;
  text-transform: uppercase;
  transition: 0.5s;
  background-size: 200% auto;
  width: 250px;
  color: white;
  border-radius: 10px;
  display: block;
  border: 0px;
  font-weight: 700;
  box-shadow: 0px 0px 14px -7px #f09819;
  background-image: linear-gradient(
    45deg,
    #ff512f 0%,
    #f09819 51%,
    #ff512f 100%
  );
  cursor: pointer;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.button-87:hover {
  background-position: right center;
  /* change the direction of the change here */
  color: #fff;
  text-decoration: none;
}

.button-87:active {
  transform: scale(0.95);
}
</style>