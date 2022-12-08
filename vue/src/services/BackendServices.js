import axios from "axios";

export default {
    
  getBeerReviews(beerID) {
    return axios.get('/reviews/beer/'+ beerID)
  },

  getBeerList(breweryID) {
      return axios.get(`/breweries/${breweryID}/beers`)
  }

}