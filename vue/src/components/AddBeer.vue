<template>
<div id="addbeer">
  <h1>Add a Beer</h1>
  <form id="add-beer" v-on:submit.prevent="addNewBeer">
            <div>
                <label for="brewery-id"></label>
                <input type="hidden" id="brewery-id" placeholder="Brewery Id" 
                onfocus="this.placeholder = ''"
                onblur="this.placeholder = 'Brewery Id'"
                :value="breweryId"/>
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
            <button class="button-78" type="submit">Submit</button>
      </form>
</div>
</template>

<script>
import BackendServices from '../services/BackendServices'
export default {
    props:['breweryId'],
    data(){
        return{
            newBeer:{
                breweryId: this.breweryId,
                beerName: '',
                abv: '',
                beerType: '',
                beerDescription:'',
            }
        }
    },


methods: {
    addNewBeer() {
      BackendServices.addBeer(this.newBeer)
     
      this.resetForm();
    },
    resetForm() {
      this.newReview = {};
      this.newBeer = {
                breweryId: '',
                beerName: '',
                abv: '',
                beerType: '',
                beerDescription:'',
                }
    //   this.showForm = false;
    },
},
}
</script>

<style scoped>
#addbeer{
    background-image: url("https://townsquare.media/site/657/files/2022/09/attachment-josh-olalde-Ygu9Qx309s-unsplash.jpg?w=980&q=75");
    background-size: 100%;
}

textarea{
    width: 100%;
}

.button-78{
  width: 100%;
}
</style>