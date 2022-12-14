<template>
  <div>
      <h2>Manage Breweries</h2>
      <ul >
          <li class="brewery" v-for="brewery in breweries" :key="brewery.breweryID">{{brewery.breweryName}}</li>
      </ul>
      <div>
    <h1>Update Brewery Info</h1>
    <button v-on:click="show = !show">Update Brewery Info</button>
    <button v-on:click="showAddBeer = !showAddBeer">Add a Beer</button>
    <add-beer v-if="showAddBeer == true">Add a Beer</add-beer>
    <!-- <div>
    <form id="add-beer" v-if="showAddBeer == true" v-on:submit.prevent="addNewBeer">
            <div>
                <label for="brewery-id"></label>
                <input type="number" id="brewery-id" placeholder="Brewery Id" 
                onfocus="this.placeholder = ''"
                onblur="this.placeholder = 'Brewery Id'"
                v-model="newBeer.breweryId"/>
            </div>
            <div>
                <label for="beer-Name"></label>
                <input type="text" id="beer_name" placeholder="Beer Name" 
                onfocus="this.placeholder = ''"
                onblur="this.placeholder = 'Beer Name'"
                v-model="newBeer.beerName"/>
            </div>
            
            <div>
                <label for="abv"></label>
                <input type="text" id="abv" placeholder="ABV"
                onfocus="this.placeholder = ''"
                onblur="this.placeholder = 'ABV'"
                v-model="newBeer.abv"/>
            </div>
            <div>
                <label for="beer-type"></label>
                <input type="text" id="beer-type" placeholder="Beer Type"
                onfocus="this.placeholder = ''"
                onblur="this.placeholder = 'Beer Type'"
                v-model="newBeer.beerType"/>
            </div>
            
            <div>
                <label for="beer-description"></label>
                <textarea name="beer-description" id="beer-description" rows="8" cols="50" placeholder="Beer Description" 
                onfocus="this.placeholder = ''"
                onblur="this.placeholder = 'Beer Description'"
                v-model="newBeer.beerDescription"></textarea>
            </div>
            <button type="submit">Submit</button>
      </form>
      </div> -->
      <div>
    <form id="add-brewery" v-if="show == true" v-on:submit.prevent="updateBrewery">
      <div>
        <label for="brewery-Name" />
        <input
          type="text"
          id="brewery_name"
          
          v-model="breweries[0].breweryName"
        />
      </div>
      <div>
        <select
          name="select-state"
          id="select-state"
          aria-placeholder="Select State"
          v-model="breweries[0].stateAbv"
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
          v-model="breweries[0].streetAddress"
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
          v-model="breweries[0].city"
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
          v-model="breweries[0].zip"
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
          v-model="breweries[0].timeOpen"
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
          v-model="breweries[0].timeClosed"
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
          v-model="breweries[0].history"
        ></textarea>
      </div>
      <button type="submit">Submit</button>
    </form>
    </div>
  </div>
  </div>
</template>

<script>
import BackendServices from '../services/BackendServices'
import AddBeer from './AddBeer.vue';
export default {
  components: { AddBeer },
    
    
    
    data(){
        return {
          show: false,
          showAddBeer: false,
        updatedBrewery: {
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

            breweries: []
        }
    },
    methods: {
        updateBrewery() {
        BackendServices.updateBrewery(this.breweries[0].breweryID,this.breweries[0]).then(() => {
                this.resetForm();
        });
       
    },
    resetForm() {
      this.updatedBrewery = {};
    },
    
    },
    created(){
        this.updatedBrewery = BackendServices.findBreweriesByBrewerId(this.$store.state.user.id).then((response) =>{
            response.data.forEach(element => {
                this.breweries.push(element)
                console.log(this.breweries[0]);
            });
        })
        
    }
}
</script>

<style>
textarea{
  width: 100%;
}

</style>