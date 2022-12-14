<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <label for="type"> Brewer or GrogLover? </label>
      <select name="type" v-model="user.role">
        <option value="brewer"> Brewer </option>
        <option value="user"> GrogLover </option>
      
      >
      </select>
      <div class="buttons-register">
        <button class="button-87" type="submit">
        Create Account
      </button>
      <router-link :to="{ name: 'login' }">
        <div class="button-87">Have an account?</div></router-link>
      </div>
    </form>
    <router-link :to="{name: 'registerBrewery'}">Register As Brewery </router-link>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>

#register{
  background-image: url("https://townsquare.media/site/657/files/2022/09/attachment-josh-olalde-Ygu9Qx309s-unsplash.jpg?w=980&q=75");
  background-size: 100%;
}

input, select{
  border-radius: 10px;
  height: 35px;
}

h1{
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: rgb(252, 216, 216);
  font-size: 48px;
  text-align: center;
  text-shadow: 1px 1px 2px red, 0 0 1em blue, 0 0 0.2em blue;
}

.buttons-register{
  display: flex;
  flex-direction: column;
}

label{
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: rgb(252, 216, 216);
  font-size: 30px;
  text-align: center;
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
