<template>
  <div id="addReview">
        <form>
          <div>
            <label for="review-title"/>
            <input type="text" id="review-title" placeholder="Review Title"/>
            <select name="rating" id="rating">
                <option value=1>1</option>
                <option value=2>2</option>
                <option value=3>3</option>
                <option value=4>4</option>
                <option value=5>5</option>
            </select>
            </div>
            <textarea name="review-body" id="review-body" rows="8" cols="50"></textarea>
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