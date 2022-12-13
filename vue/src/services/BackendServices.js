import axios from "axios";




export default {
    
    // Beer Controller
    getAllBeers() {
        return axios.get('/beers')
    },
    getBeerList(breweryID) {
        return axios.get(`/breweries/${breweryID}/beers`)
    },
    getBeerByID(id) {
        return axios.get('/beers/' + id)
    },
    addBeer(beer) {
        return axios.post('/addBeer', beer)
    },

    // Breweries
    getAllBreweries() {
        return axios.get('/breweries')
    },
    getBreweryByID(id) {
        return axios.get(`/breweries/${id}`)
    },
    addBrewery(brewery) {
        return axios.post('/registerBrewery', brewery)
    },

    // Reviews    
    getBeerReviews(beerID) {
        return axios.get('/reviews/beer/'+ beerID)
    },
    getAllBeerReviews() {
        return axios.get('/reviews/beers')
    },
    getBreweryReviews(breweryId) {
        return axios.get(`/reviews/brewery/${breweryId}`)
    },
    getAllBreweryReviews() {
        return axios.get('/reviews/brewery')
    },
    getReviewsByUser(userID) {
        return axios.get(`/reviews/user/${userID}`)
    },

    addBreweryReview(review) {
        return axios.post('/addReview/brewery', review)
    },
    addBeerReview(review) {
        return axios.post('/addReview/beer', review)
    },
    findBreweries(city){
        return axios.get(`/search/${city}`)
    },
    findBreweriesByBrewerId(id){
        return axios.get(`/breweries/manage/${id}`)
    },

    addToFavorites(entry){
        return axios.post('/addBeer/favorites', entry);
    },

    getFavorites(id){
        return axios.get(`beers/favorites/${id}`);
       
    }

}