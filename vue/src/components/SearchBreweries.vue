<template>
  <div>
    <div class="searchBox">
      <form action="submit">
        <label for="search">Type in a city to discover breweries: </label>
        <input type="text" name="search" v-model="searchTerm" />
        <button type="submit" @click.prevent="search()">Find the Grog!</button>
      </form>
    </div>

    <div class="results" v-if="isSearched">
      <div class="brewery" v-for="brewery in foundBreweries" :key="brewery.id">
        <h2>{{ brewery.name }}</h2>
        <h3>{{ brewery.street }}</h3>
        <h3>{{ brewery.city }}, {{ brewery.state }}</h3>
        <a :href="brewery.website_url"> {{ brewery.website_url }} </a>
      </div>
    </div>
  </div>
</template>

<script>
import BackendServices from "../services/BackendServices";
export default {
  data() {
    return {
      searchTerm: "",
      isSearched: false,
      foundBreweries: [],
    };
  },
  methods: {
    search() {
      if (this.searchTerm != "") {
          this.foundBreweries = [];
       BackendServices.findBreweries(this.searchTerm).then(response => {
           response.data.forEach(element => {
               this.foundBreweries.push(element);
           });
       })
        this.isSearched = true;
      }
    },
  },
};
</script>

<style>
.searchBox {
  z-index: 1000;
}
.results {
  border: 1px solid black;
}
.brewery{
  background-image: url("https://cdn.pixabay.com/photo/2018/02/15/14/37/paper-3155438_1280.jpg");
  text-align: center;
  border-style: inset;
  resize: horizontal;
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: rgb(252, 216, 216);
  font-size: 24px;
  text-align: center;
  text-shadow: 1px 1px 2px red, 0 0 1em blue, 0 0 0.2em blue;
}

</style>