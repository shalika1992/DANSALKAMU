<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style>
    
      #map {
        height: 400px;
        width: 100%;
       }
       
        body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidebar to 120px */
.w3-sidebar {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}} *
    </style>
  </head>
  <body>
  <div class="w3-main" style="margin-left:125px;">

    <div id="map" style="height: 600px;width: 100%"></div>
    </div>
    <script>
    
 function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 8,
    center: {lat: 7.550253, lng: 80.753775}
  });

	getDansalInfo(map); 
}



function getDansalInfo(map){
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "getAllDansalJSON.json",
			data:"", 
			dataType : 'json',
			timeout : 10000,
			success : function(data) {
				if (data.message=="SUCCESS") {
				   var dansalList=data.dansalAllList; 
				   	setMarkers(map,dansalList);
				}
			},
			error : function(e) {
			},
			done : function(x) {
				console.log("DONE");
			}
		});

}

	
function setMarkers(map,dansalList) {
  // Adds markers to the map.

  // Marker sizes are expressed as a Size of X,Y where the origin of the image
  // (0,0) is located in the top left of the image.

  // Origins, anchor positions and coordinates of the marker increase in the X
  // direction to the right and in the Y direction down.
  var image = {
    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',

    // This marker is 20 pixels wide by 32 pixels high.
    size: new google.maps.Size(20, 32),
    // The origin for this image is (0, 0).
    origin: new google.maps.Point(0, 0),
    // The anchor for this image is the base of the flagpole at (0, 32).
    anchor: new google.maps.Point(0, 32)
  };
  // Shapes define the clickable region of the icon. The type defines an HTML
  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
  // The final coordinate closes the poly by connecting to the first coordinate.
  var shape = {
    coords: [1, 1, 1, 20, 18, 20, 18, 1],
    type: 'poly'
  };

  for (var i = 0; i < dansalList.length; i++) {
    var dansala = dansalList[i];
    var marker = new google.maps.Marker({
      position: {lat: dansala.latitude, lng: dansala.longitude},
      map: map,
      icon: image,
      shape: shape,
      title: dansala.name,
    });
    
      var infowindow = new google.maps.InfoWindow();
      
    google.maps.event.addListener(marker, "click", (function(marker) {
      // !!! PROBLEM HERE
      return function(evt) {
        var content = marker.getTitle();
        infowindow.setContent(content);
        infowindow.open(map, marker);
      }
    })(marker));



  }
}
    </script>
    <script async defer
  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXeM0xHBDsll7q6T66JFMgUxwtcDE9Fn8&callback=initMap">
    </script>
  </body>
</html>