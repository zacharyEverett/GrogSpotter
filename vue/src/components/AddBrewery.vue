<template>
  <div>
    <h1>Add a Brewery</h1>
    <form id="add-brewery" v-on:submit.prevent="addNewBrewery">
      <div>
        <label for="brewery-Name" />
        <input
          type="text"
          id="brewery_name"
          placeholder="Brewery Name"
          onfocus="this.placeholder = ''"
          onblur="this.placeholder = 'Brewery Name'"
          v-model="newBrewery.breweryName"
        />
      </div>
      <div>
        <select
          name="select-state"
          id="select-state"
          aria-placeholder="Select State"
          v-model="newBrewery.stateAbv"
        >
          <option value="PA">Pennsylvania</option>
        </select>
      </div>
      <div>
        <label for="street-address" />
        <input
          type="text"
          id="street-address"
          placeholder="Street Address"
          onfocus="this.placeholder = ''"
          onblur="this.placeholder = 'Street Address'"
          v-model="newBrewery.streetAddress"
        />
      </div>
      <div>
        <label for="city" />
        <input
          type="text"
          id="city"
          placeholder="City"
          onfocus="this.placeholder = ''"
          onblur="this.placeholder = 'City'"
          v-model="newBrewery.city"
        />
      </div>
      <div>
        <label for="zip" />
        <input
          type="text"
          id="zip"
          placeholder="Zip"
          onfocus="this.placeholder = ''"
          onblur="this.placeholder = 'Zip'"
          v-model="newBrewery.zip"
        />
      </div>
      <div>
        <label for="time-open" />
        <input
          type="time"
          id="time=open"
          placeholder="11:00"
          onfocus="this.placeholder = ''"
          onblur="this.placeholder = '11:00'"
          v-model="newBrewery.timeOpen"
        />
      </div>
      <div>
        <label for="time-closed" />
        <input
          type="time"
          id="time=closed"
          placeholder="23:00"
          onfocus="this.placeholder = ''"
          onblur="this.placeholder = '23:00'"
          v-model="newBrewery.timeClosed"
        />
      </div>
      <div>
        <textarea
          name="brewery-history"
          id="brewery-history"
          rows="8"
          cols="50"
          placeholder="Brewery History"
          onfocus="this.placeholder = ''"
          onblur="this.placeholder = 'Brewery History'"
          v-model="newBrewery.history"
        ></textarea>
      </div>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import BackendServices from "../services/BackendServices";
export default {
  data() {
    return {
      newBrewery: {
        breweryName: "",
        streetAddress: "",
        city: "",
        stateAbv: "",
        zip: "",
        timeOpen: "",
        timeClosed: "",
        history: "",
        brewer_id: this.$store.state.user.id
      },
    };
  },
  methods: {
    addNewBrewery() {
      BackendServices.addBrewery(this.newBrewery);
      this.resetForm();
    },
    resetForm() {
      this.newBrewery = {};
      //   this.showForm = false;
    },
  },
};
</script>

<style scoped>
template {
  background-image: url("https://bloximages.newyork1.vip.townnews.com/hickoryrecord.com/content/tncms/assets/v3/editorial/a/b5/ab51d6b9-6e46-584e-8b88-4a9bfc33dd1e/621e747be417d.image.jpg?resize=749%2C500");
}
textarea{
    width: 294px;
}
form>div{
    width: 294px;
}
</style>