<template>
  <div id="breweriesList">
    Breweries Will Go Here
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
</style>