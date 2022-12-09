<template>
  <div>
      <h1>Add a Brewery</h1>
      <form id="add-brewery" v-on:submit.prevent="addNewBrewery">
          <div>
            <label for="brewery-Name"/>
            <input type="text" id="brewery_name" placeholder="Brewery Name" 
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'Brewery Name'"/>
            </div>
            <div>
            <select name="select-state" id="select-state" aria-placeholder="Select State">
                <option value="PA">Pennsylvania</option>
            </select>
            </div>
            <div>
            <label for="street-address"/>
            <input type="text" id="street-address" placeholder="Street Address"
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'Street Address'"/>
            </div>
            <div>
            <label for="city"/>
            <input type="text" id="city" placeholder="City"
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'City'"/>
            </div><div>
            <label for="zip"/>
            <input type="text" id="zip" placeholder="Zip"
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'Zip'"/>
            </div>
            <div>
            <textarea name="brewery-history" id="brewery-history" rows="8" cols="50" placeholder="Brewery History" 
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'Brewery History'"></textarea>
            </div>
            <button type="submit">Submit</button>
      </form>
  </div>
</template>

<script>
export default {
data(){
        return{
            newBrewery:{
                breweryName: '',
                streetAddress: '',
                city: '',
                state:'',
                zip:'',
                timeOpen:'',
                timeClosed:'',
                history:'',
            }
        }
    },


}
</script>

<style scoped>
template {
    background-image: url('https://bloximages.newyork1.vip.townnews.com/hickoryrecord.com/content/tncms/assets/v3/editorial/a/b5/ab51d6b9-6e46-584e-8b88-4a9bfc33dd1e/621e747be417d.image.jpg?resize=749%2C500');
}
</style>