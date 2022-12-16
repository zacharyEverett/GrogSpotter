<template>
  <div id="addbrew">
    <h1>Add a Brewery</h1>
    <form id="add-brewery" v-on:submit.prevent="addNewBrewery">
      <div>
        <label for="brewery-Name"/>
        <input
          type="text"
          id="brewery_name"
          placeholder="Brewery Name"
          onfocus="this.placeholder = ''"
          onblur="this.placeholder = 'Brewery Name'"
          v-model="newBrewery.breweryName" required
        />
      </div>
      <div>
        <select
          name="select-state"
          id="select-state"
          aria-placeholder="Select State"
          v-model="newBrewery.stateAbv"
          required
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
          required
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
          required
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
          required
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
          required
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
          required
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
          required
        ></textarea>
      </div>
      <button class="button-78" type="submit">Submit</button>
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

#addbrew{
  background-image: url("https://townsquare.media/site/657/files/2022/09/attachment-josh-olalde-Ygu9Qx309s-unsplash.jpg?w=980&q=75");
  background-size: 100%;
}

template {
  background-image: url("https://bloximages.newyork1.vip.townnews.com/hickoryrecord.com/content/tncms/assets/v3/editorial/a/b5/ab51d6b9-6e46-584e-8b88-4a9bfc33dd1e/621e747be417d.image.jpg?resize=749%2C500");
}
textarea{
    width: 80%;
}
form>div{
    width: 294px;
}
.button-78{
  width: 100%;
}
</style>