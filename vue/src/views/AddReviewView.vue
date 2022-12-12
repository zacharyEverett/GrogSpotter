<template>
  <div>
      <router-link :to="{name: 'beerView'}"><div class="button-87">Back to Beer</div></router-link>
      <add-review></add-review>
  </div>
</template>

<script>
import AddReview from '../components/AddReview.vue'
export default {
    components: {AddReview},

}
</script>

<style>
/*  Button CSS */
.button-87 {
  margin: auto;
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