<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
 body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidebar to 120px */
.w3-sidebar {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}} */
</style>
<body>
<div class="w3-container" style="margin-left:120px;">
<div class="row">
<button class="w3-button w3-circle w3-black"  onclick="document.getElementById('add_dansala_model').style.display='block'">+</button>
 <a class="w3-button w3-circle w3-black" href="map.html">+</a>
 
  </div>
  <h2>Centering Content in Table</h2>

  <table class="w3-table-all w3-centered" >
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Points</th>
    </tr>
    <tr>
      <td>Jill</td>
      <td>Smith</td>
      <td>50</td>
    </tr>
    <tr>
      <td>Eve</td>
      <td>Jackson</td>
      <td>94</td>
    </tr>
    <tr>
      <td>Adam</td>
      <td>Johnson</td>
      <td>67</td>
    </tr>
    <tr>
      <td>Bo</td>
      <td>Nilson</td>
      <td>35</td>
    </tr>
  </table>
</div>
<!--------------- START ADD DANSALA MODAL---------------->
	
  <div id="add_dansala_model" class="w3-modal">
    <div class="w3-modal-content">
      <div class="w3-container">
        <span onclick="document.getElementById('add_dansala_model').style.display='none'" class="w3-button w3-display-topright">&times;</span>
      	<div class="w3-row w3-center w3-black"><h5>Add Branch</5></div>
      	<div>
      	<hr/>
      		<div class="w3-row">
      			<div class="w3-col s12 m3">Name</div>
      			<div class="w3-col s12 m9">   <input class="w3-input w3-border w3-light-grey" type="text"></div>
      		</div>
      		 <div class="w3-row">
      			<div class="w3-col  s12 m3">Category</div>
      			<div class="w3-col s12 m9">Name</div>
      		</div>
      		 <div class="w3-row">
      			<div class="w3-col s12 m3">Longitude</div>
      			<div class="w3-col s12 m9">  <input class="w3-input w3-border w3-light-grey" type="text"></div>
      		</div>
      		 <div class="w3-row">
      			<div class="w3-col s12 m3">Latitude</div>
      			<div class="w3-col s12 m9">  <input class="w3-input w3-border w3-light-grey" type="text"></div>
      		</div>
      		
      		<div class="w3-row w3-center">
      			  <button class="w3-button w3-black w3-round-large">Submit</button>
      		      <button class="w3-button w3-black w3-round-large" onclick="document.getElementById('add_dansala_model').style.display='none'">Cancel</button>
      		</div>
      	</div>
      	<hr/>
  
      </div>
    </div>
  </div>

<!--------------- END ADD DANSALA MODAL  ----------------> 


</body>
</html>