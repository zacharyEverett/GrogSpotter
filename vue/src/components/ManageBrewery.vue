<template>
  <div>
      <h2>Manage Breweries</h2>
      <ul >
          <li class="brewery" v-for="brewery in breweries" :key="brewery.breweryID">{{brewery.breweryName}}</li>
      </ul>
  </div>
</template>

<script>
import BackendServices from '../services/BackendServices'
export default {
    data(){
        return {
            breweries: []
        }
    },
    created(){
        BackendServices.findBreweriesByBrewerId(this.$store.state.user.id).then((response) =>{
            response.data.forEach(element => {
                this.breweries.push(element)
            });
        })
    }
}
</script>

<style>

</style>