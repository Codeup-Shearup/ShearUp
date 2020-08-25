// (function (listener) {
//
//     //==========Variables Below==========================//
//     var latLong = $("#cords"); // Outputs lat/long to HTML
//     var output = $("#output"); // Main DIV for html
//     var submitButton = $("#addressSubmit"); // For assigning button click
//     var map = document.getElementById("maps"); //For assigning div for google maps to draw on
//     var latLongString = ""; // Make lat/long to string
//     var outputString = ""; // Make entire HTML structure output to string
//
//
// //=========Setting up map API options
// var mapOptions = {
//     // Set the zoom level
//     zoom: 4,
//     // This sets the center of the map at our location
//     center: {
//         lat:  40.15555,
//         lng: -98.489602
//     }
// };
//
//
//     // Setting up map variables
//
//     var mapBox = new google.maps.Map(map, mapOptions);
//     var geocoder = new google.maps.Geocoder();
//     var myLatlng = new google.maps.LatLng(40.15555,-98.489602);
//     var lat = myLatlng.lat();
//     var long = myLatlng.lng();
//     var newLatLong = "";
//     //first lat/long run:
//     latLong.html("Lat: " + parseFloat(lat).toFixed(2) + "," + " Long: " + parseFloat(long).toFixed(2));
//     //Draggable marker
//     var marker = new google.maps.Marker({
//         position: myLatlng,
//         map: mapBox,
//         draggable:true,
//         title:"What a drag!"
//
//     });
//
//
//     function codeAddress() {
//         var address = document.getElementById('address').value; //Grabs value in address input
//         geocoder.geocode( { 'address': address}, function(results, status) {
//             if (status === 'OK') {
//                 mapBox.setCenter(results[0].geometry.location);       //Move map center to location
//                 marker.setPosition(results[0].geometry.location);    //Move marker to position
//                 lat = results[0].geometry.location.lat();            //Reset lat to new value
//                 long = results[0].geometry.location.lng();           //Reset long to new value
//                 latLongString = "";                                  //Ensure latLong string is empty
//                 latLongString += "Lat: "+ parseFloat(lat).toFixed(2) + ", Long: " + parseFloat(long).toFixed(2); //Cat lat and long and fix them to lower floats
//                 latLong.html(latLongString); //output fixed string
//                 latLongString = "";          //reset lat/long string and output string to ensure we do not get repeats on getWeather() call
//                 outputString = "";
//                 //Reloads new weather data
//                 getWeather();  // Call getWeather and render new weather results
//             } else {
//                 alert('Geocode was not successful for the following reason: ' + status);
//             }
//         });
//     }
//
//
//
//
// //Calls codeAddress() on click
//     submitButton.click(function() {
//         codeAddress();
//     });
//
//
//
// })();