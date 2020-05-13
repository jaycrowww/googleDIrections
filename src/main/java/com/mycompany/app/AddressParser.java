package com.mycompany.app;

/* Used to return addresses for distance query */
//TODO possibly return georef if its more accurate

public final class AddressParser {

    // If Place object then just get address method
    public static Address parse(Place place){
        return  place.getAddress();
    }


    // If its a search term
    public static Address parseLocalLandmark(String searchTerm, Place place){
        // HTTP call to googles API
        /* Assumingly, in goes the search term. Google returns the first bakery based on distance? Has it already
        * calculated the dist at this point? Is it worthwhile to do two calls? optimise into one call ideally.
        * NOTE: will need reference of what is considered 'local' whats the candidate houses address
        * kind of works to submit 'bakery near <addressString>' while using the string  */
        //TODO implement return address
    }


//    public static Address parse(String geoRef){
//
//    }

}
