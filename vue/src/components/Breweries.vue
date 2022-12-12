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

#breweriesList{
  font-size: 46px;
  border-style: ridge;
  border-width: 10px;
  border-radius: 10px;
  width: 300px;
  margin: auto;
  display: flex;
  flex-direction: column;
  padding: 20px;
  background-image: url("https://cdn.pixabay.com/photo/2018/02/15/14/37/paper-3155438_1280.jpg");
}
</style>