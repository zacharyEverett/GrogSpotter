<template>
<div>
  <h1>Add a Beer</h1>
  <form id="add-brewery">
          <div>
            <label for="beer-Name"/>
            <input type="text" id="beer_name" placeholder="Beer Name" 
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'Beer Name'"/>
            </div>
            
            <div>
            <label for="abv"/>
            <input type="text" id="abv" placeholder="ABV"
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'ABV'"/>
            </div>
            <div>
            <label for="beer-type"/>
            <input type="text" id="beer-type" placeholder="Beer Type"
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'Beer Type'"/>
            </div>
            
            <div>
            <textarea name="beer-description" id="beer-description" rows="8" cols="50" placeholder="Beer Description" 
            onfocus="this.placeholder = ''"
            onblur="this.placeholder = 'Beer Description'"></textarea>
            </div>
            <button type="submit">Submit</button>
      </form>
</div>
</template>

<script>
export default {

}
</script>

<style>

</style>