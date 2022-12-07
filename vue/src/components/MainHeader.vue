<template>
    <div id="nav">
      <header>
        <div id="left">
          <h1>Beer Lovers Only</h1>
        </div>

        <div id="right">
          <router-link v-bind:to="{ name: 'home' }">Home</router-link
          >&nbsp;|&nbsp;
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
          <router-link
            v-bind:to="{ name: 'login' }"
            v-else
            >Login</router-link
          >
        </div>
      </header>
    </div>
</template>

<script>
export default {
    name: "header"
}
</script>

<style>
header {
  background-color: black;
  color: white;
  width: 100%;
  height: 10%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

#left {
  display: flex;
  justify-content: flex-start;
  align-items: flex-end;
}

#right {
  display: flex;
  justify-content: flex-end;
  align-items: flex-end;
}
</style>