<template>
  <div class="container">
    <div id="discover">
      <router-link :to="{ name: 'breweries' }"> Discover Breweries</router-link>
    </div>
    <div id="yourBeers">Your Beers</div>
  </div>
</template>

<script>
export default {};
</script>

<style>
#discover,
#yourBeers {
  background-color: black;
  color: white;
  display: flex;
  justify-content: center;
  text-align: center;
  align-items: center;
  width: 30%;
  height: 200px;
  margin-top: 10%;
}

.container {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
</style>