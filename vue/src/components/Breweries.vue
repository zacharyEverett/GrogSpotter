<template>
  <div id="breweriesList">
    BREWERIES
    <ul>
      <li
        v-for="brewery in this.$store.state.breweries"
        v-bind:key="brewery.id"
      >
        <router-link
          :to="{ name: 'brewery', params: { id: brewery.breweryID } }"
        >
          {{ brewery.breweryName }}
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      breweries: [],
    };
  },
  created() {
    this.$store.commit("SET_BREWERIES");
  },
  methods: {},
};
</script>

<style>
li {
  font-family: 'Courier New', Courier, monospace;
  font-size: 24pt;
  font-weight: bold;
  text-decoration: none;
}
  

#breweriesList{
  font-size: 42px;
  border-style: ridge;
  border-width: 10px;
  border-radius: 10px;
  font-weight: bold;
  margin: auto;
  width: 300px;
  padding: 20px;
  background-image: url("https://cdn.pixabay.com/photo/2018/02/15/14/37/paper-3155438_1280.jpg");
}
</style>