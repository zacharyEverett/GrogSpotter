<template>
  <div>
      <h2> Beers on tap: </h2>
      <ul id="beersList">
          <li v-for="beer in beers" :key="beer.beerId">
              {{beer.beerName}}
          </li>
      </ul>
  </div>
</template>

//my thought is to make each beer its own little card, 
so a div that goes through a v-for from the beers array
- zach
<script>
import axios from 'axios'
export default {
data(){
    return {
        beers: []
    }
}, 
created(){
    axios.get("/breweries/" + this.$route.params.id + '/beers').then(returned => 
        {returned.data.forEach(element => {
          this.beers.push(element);
        });})
}
}

</script>

<style>

</style>