<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <button type="submit" class="button-87"><h3>Sign in</h3></button>
      <router-link :to="{ name: 'register' }">
        <h3 class="button-87">Need an account?</h3></router-link>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
h1{
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: rgb(252, 216, 216);
  font-size: 48px;
  text-align: center;
  text-shadow: 1px 1px 2px red, 0 0 1em blue, 0 0 0.2em blue;
}

label{
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: rgb(252, 216, 216);
  font-size: 30px;
  text-align: center;
  text-shadow: 1px 1px 2px red, 0 0 1em blue, 0 0 0.2em blue;
}

h3{
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: rgb(252, 216, 216);
  font-size: 16px;
  text-align: center;
  font-weight: bold;
  text-shadow: 1px 1px 2px red, 0 0 1em blue, 0 0 0.2em blue;
}

button{
  text-shadow: 1px 1px 2px red, 0 0 1em blue, 0 0 0.2em blue;
}

form{
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

/*  Button CSS */
.button-87 {
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
