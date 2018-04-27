<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
 body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidebar to 120px */
.w3-sidebar {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}} */
.w3-button {width:150px;}
.w6-row :empty:before {content:'fill it';visibility:hidden;}
</style>
<body >

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:120px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> My Dashboard</b></h5>
  </header>

  <div class="w3-row-padding w3-margin-bottom">
    <a class="w3-quarter"  href="loadDansalaPage.html">
      <div class="w3-container w3-red w3-padding-16">
        <div class="w3-left"><i class="fa fa-comment w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>52</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>Messages</h4>
      </div>
    </a>
    <div class="w3-quarter" onclick="document.getElementById('addCategory').style.display='block'">
      <div class="w3-container w3-blue w3-padding-16">
        <div class="w3-left"><i class="fa fa-eye w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>99</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>Views</h4>
      </div>
    </div>
    <div class="w3-quarter">
      <div class="w3-container w3-teal w3-padding-16">
        <div class="w3-left"><i class="fa fa-share-alt w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>23</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>Shares</h4>
      </div>
    </div>
    <div class="w3-quarter">
      <div class="w3-container w3-orange w3-text-white w3-padding-16">
        <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>50</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>Users</h4>
      </div>
    </div>
  </div>

  <div class="w3-panel">
    <div class="w3-row-padding" style="margin:0 -16px">
      <div class="w3-third">
        <h5>Regions</h5>
        <img src="/w3images/region.jpg" style="width:100%" alt="Google Regional Map">
      </div>
      <div class="w3-twothird">
        <h5>Feeds</h5>
        <table class="w3-table w3-striped w3-white">
          <tr>
            <td><i class="fa fa-user w3-text-blue w3-large"></i></td>
            <td>New record, over 90 views.</td>
            <td><i>10 mins</i></td>
          </tr>
          <tr>
            <td><i class="fa fa-bell w3-text-red w3-large"></i></td>
            <td>Database error.</td>
            <td><i>15 mins</i></td>
          </tr>
          <tr>
            <td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
            <td>New record, over 40 users.</td>
            <td><i>17 mins</i></td>
          </tr>
          <tr>
            <td><i class="fa fa-comment w3-text-red w3-large"></i></td>
            <td>New comments.</td>
            <td><i>25 mins</i></td>
          </tr>
          <tr>
            <td><i class="fa fa-bookmark w3-text-blue w3-large"></i></td>
            <td>Check transactions.</td>
            <td><i>28 mins</i></td>
          </tr>
          <tr>
            <td><i class="fa fa-laptop w3-text-red w3-large"></i></td>
            <td>CPU overload.</td>
            <td><i>35 mins</i></td>
          </tr>
          <tr>
            <td><i class="fa fa-share-alt w3-text-green w3-large"></i></td>
            <td>New shares.</td>
            <td><i>39 mins</i></td>
          </tr>
        </table>
      </div>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>General Stats</h5>
    <p>New Visitors</p>
    <div class="w3-grey">
      <div class="w3-container w3-center w3-padding w3-green" style="width:25%">+25%</div>
    </div>

    <p>New Users</p>
    <div class="w3-grey">
      <div class="w3-container w3-center w3-padding w3-orange" style="width:50%">50%</div>
    </div>

    <p>Bounce Rate</p>
    <div class="w3-grey">
      <div class="w3-container w3-center w3-padding w3-red" style="width:75%">75%</div>
    </div>
  </div>
  <hr>

  <div class="w3-container">
    <h5>Countries</h5>
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
      <tr>
        <td>United States</td>
        <td>65%</td>
      </tr>
      <tr>
        <td>UK</td>
        <td>15.7%</td>
      </tr>
      <tr>
        <td>Russia</td>
        <td>5.6%</td>
      </tr>
      <tr>
        <td>Spain</td>
        <td>2.1%</td>
      </tr>
      <tr>
        <td>India</td>
        <td>1.9%</td>
      </tr>
      <tr>
        <td>France</td>
        <td>1.5%</td>
      </tr>
    </table><br>
    <button class="w3-button w3-dark-grey">More Countries  <i class="fa fa-arrow-right"></i></button>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Recent Users</h5>
    <ul class="w3-ul w3-card-4 w3-white">
      <li class="w3-padding-16">
        <img src="/w3images/avatar2.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
        <span class="w3-xlarge">Mike</span><br>
      </li>
      <li class="w3-padding-16">
        <img src="/w3images/avatar5.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
        <span class="w3-xlarge">Jill</span><br>
      </li>
      <li class="w3-padding-16">
        <img src="/w3images/avatar6.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
        <span class="w3-xlarge">Jane</span><br>
      </li>
    </ul>
  </div>
  <hr>

  <div class="w3-container">
    <h5>Recent Comments</h5>
    <div class="w3-row">
      <div class="w3-col m2 text-center">
        <img class="w3-circle" src="/w3images/avatar3.png" style="width:96px;height:96px">
      </div>
      <div class="w3-col m10 w3-container">
        <h4>John <span class="w3-opacity w3-medium">Sep 29, 2014, 9:12 PM</span></h4>
        <p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><br>
      </div>
    </div>

    <div class="w3-row">
      <div class="w3-col m2 text-center">
        <img class="w3-circle" src="/w3images/avatar1.png" style="width:96px;height:96px">
      </div>
      <div class="w3-col m10 w3-container">
        <h4>Bo <span class="w3-opacity w3-medium">Sep 28, 2014, 10:15 PM</span></h4>
        <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><br>
      </div>
    </div>
  </div>
  <br>
  <div class="w3-container w3-dark-grey w3-padding-32">
    <div class="w3-row">
      <div class="w3-container w3-third">
        <h5 class="w3-bottombar w3-border-green">Demographic</h5>
        <p>Language</p>
        <p>Country</p>
        <p>City</p>
      </div>
      <div class="w3-container w3-third">
        <h5 class="w3-bottombar w3-border-red">System</h5>
        <p>Browser</p>
        <p>OS</p>
        <p>More</p>
      </div>
      <div class="w3-container w3-third">
        <h5 class="w3-bottombar w3-border-orange">Target</h5>
        <p>Users</p>
        <p>Active</p>
        <p>Geo</p>
        <p>Interests</p>
      </div>
    </div>
  </div>
  
<!----------------------   START ADD CATEGORY MODEL ---------------------->

	 <div id="addCategory" class="w3-modal">
    <div class="w3-modal-content w3-card-4">
      <header class="w3-container w3-gray"> 
        <span onclick="removeCategoryModel()" 
        class="w3-button w3-display-topright">&times;</span>
        <h4 class="w3-center">Add Category</h4>
      </header>
      <div class="w3-container">
      <br/>
     	 <div class="w3-row">
     	  <div class="w3-row" id="selectIconDiv">
     	  	<div class="w3-col l4">
	        <label>Select Icon</label>
	        </div>
	   		<div class="w3-col l8">
			<button class="w3-button w3-block" onclick="loadIconList()">Select</button>
			</div>
		 </div>
		  <div id="selectedIconDiv" class="w3-row" style="display: none">
     	  	<div class="w3-col s6 m6 l4">
	        <label>Selected Icon</label>
	        </div>
	   		<div class="w3-col s4 m4 l1">
			<img  id="selectedImg"  />
			</div>
		 </div>
		 <div class="w3-row">
		 	<div class="w3-col l4">
			<label>Add Name</label>
			</div>
			<div class="w3-col l8">
			<input class="w3-input" type="text" id="categoryName">
			</div>
		</div>
		<br/>
		
		<div class="w3-row w6-row">
			<div class="w3-col s0 l5 "></div>
		 	<div class="w3-col s12 l1 w3-center">
			<button class="w3-button w3-blue-grey" onclick="addNewCategory()">Save</button>
			</div>
			<div class="w3-col s12 l1 w3-center">
			<button class="w3-button w3-blue-grey" onclick="removeCategoryModel()">Cancle</button>
			</div>
			<div class="w3-col s0 l5 "></div>
		</div>		

		</div>
		 <br/>
      </div>
      <footer class="w3-container w3-gray">
        
      </footer>
    </div>
  </div>

  
<!----------------------   END ADD CATEGORY MODEL ------------------------> 

<!----------------------   START SELECT ICON MODEL -----------------------> 
 <div id="iconModel" class="w3-modal">
    <div class="w3-modal-content">
      <div class="w3-container">
        <span onclick="document.getElementById('iconModel').style.display='none'" class="w3-button w3-display-topright">&times;</span>
        <div id="selectIcon" class="w3-row">
	    </div>
   	   </div>
    </div>
  </div>
</div>
<!----------------------   END SELECT ICON MODEL -----------------------> 

  <!-- Footer -->
  <footer class="w3-container w3-padding-16 w3-light-grey">
    <h4>FOOTER</h4>
    <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
  </footer>

  <!-- End page content -->
</div>


<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");
var iconList;
var selectedIcon;

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidebar with the close button
function w3_close() {
    mySidebar.style.display = "none";
    overlayBg.style.display = "none";
}

function loadIconList(){
	document.getElementById('iconModel').style.display='block';
    getIconList();


}
//-------------------------------------- START DISPLAY ICON LIST------------------------------------------------//
function showIconList(){
	$( "#selectIcon" ).empty();
	for (i = 0; i <iconList.length; i++) { 
 	var url="${pageContext.request.contextPath}/resources/img/icons/"+iconList[i].url+".png";
	var row="<div id="+'"icons1"'+ "class="+'"w3-row"'+"></div>";
	var imageDiv="<div  class="+'"w3-col m1 l1 s2"'+ "><img id="+'"icon'+i+'"'+ "onclick="+'"selectImage(this.id)"'+"src='"+url+"'></div>";
	$("#selectIcon").append(row);
	$("#icons1").append(imageDiv);

	}
}
//-------------------------------------- END DISPLAY ICON LIST------------------------------------------------//
function selectImage(selectIconId){
     var image=document.getElementById('#'+selectIconId);
	  if(selectedIcon!=null){
	  	$( '#icon'+selectedIcon ).removeClass("w3-opacity-max");
	  }
	  
	  selectedIcon=selectIconId.slice(4);
      icon=document.getElementById('#'+selectIconId);
	  $( '#'+selectIconId ).addClass("w3-opacity-max");
	  $("#selectedImg").attr("src",$('#'+selectIconId).attr('src'));
	  $("#selectIconDiv").hide();
	   $("#selectedIconDiv").show();

}

function removeCategoryModel(){
		$("#selectIconDiv").show();
	   $("#selectedIconDiv").hide();	
	document.getElementById('addCategory').style.display='none';


}

//---------------------------------------START ADD NEW CATEGORY ------------------------------------------//

    
    function addNewCategory(){
        var categoryName=document.getElementById('#categoryName');
    	var list = {"type": $('#categoryName').val(),"iconId":iconList[selectedIcon].iconId};

       $.ajax({
            url: 'newCategoryJSON.json',
            data:list,
            type: 'POST',
            success: function(json) {
                alert(json.successMsg);
            },
			error : function(e) {
				alert("Error"+e.responseText);
			},
			done : function(x) {
				console.log("DONE");
			}
        }); 
    }




//-------------------------------------- START GET ICON LIST------------------------------------------------//
function getIconList(){
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "getIconJSON.json",
			data:"", 
			dataType : 'json',
			timeout : 10000,
			success : function(data) {
				if (data.message=="SUCCESS") {
					iconList=data.iconList;
					showIconList()		
				}
			},
			error : function(e) {
			},
			done : function(x) {
				console.log("DONE");
			}
		});

}
//-------------------------------------- END GET ICON LIST------------------------------------------------//
</script>

</body>
</html>
