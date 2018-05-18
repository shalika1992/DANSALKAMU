<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>	
<script src="https://cdn.datatables.net/fixedcolumns/3.2.4/js/dataTables.fixedColumns.min.js"></script>

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
        <h5>Category</h5>
        
    <!-----------------------------------    START DANSAL CATEGORY TABEL ------------------------------------>
        <table class="w3-table w3-striped w3-white display" id="dansalCategoryTable"  style="width:100%">
    		  <thead>
            <tr>
                <th>ID</th>
                <th>ICON</th>
                <th>NAME</th> 
                <th>EDIT</th>  
            </tr>
        </thead>
          <tbody id="dansalCategoryTableTBody">
          </tbody>

    
        </table>
    <!-----------------------------------    END DANSAL CATEGORY TABEL ------------------------------------>
      </div>
    </div>
  </div>

  <br>

  
<!----------------------   START ADD CATEGORY MODEL ---------------------->

	 <div id="addCategory" class="w3-modal">
    <div class="w3-modal-content w3-card-4">
      <header class="w3-container w3-gray"> 
        <span onclick="removeCategoryModel()" 
        class="w3-button w3-display-topright">&times;</span>
        <h4 class="w3-center">Add Category</h4>
      </header>
      <div class="w3-container ">
      	 <div class="w3-row w6-row">
      	 <div class="w3-col s3 m3 l3"></div>
      	  <div class="w3-col s6 m6 l6">
         <div class="w3-panel w3-center  " id="msg_addcategory" style="diplay:none">
         </div>
         </div>
         <div class="w3-col s3 m3 l3"></div>
         </div>
     	 <div class="w3-row">
     	  <div class="w3-row" id="selectIconDiv">
     	  	<div class="w3-col l4">
	        <label>Select Icon</label>
	        </div>
	   		<div class="w3-col l8">
			<button class="w3-button w3-block" onclick="loadIconList()">Select</button>
			</div>
		 </div>
		  <div id="selectedIconDiv" class="w3-row w6-row" style="display: none">
		  	<div class="w3-col s3 m3 l5"></div>
     	  	<div class="w3-col s6 m6 l2 w3-center w3-light-grey" >
		        <p class="small_title">Selected Icon</p>
		        <img  id="selectedImg"  />
	        </div>
	   		<div class="w3-col s3 m3 l5"></div>
	
		 </div>
		<br/>
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
<!----------------------   END SELECT ICON MODEL -------------------------> 

<!----------------------   START SELECT ICON MODEL -----------------------> 
  <div id="deleteCategoryModel" class="w3-modal w3-animate-opacity">
    <div class="w3-modal-content w3-card-4">
      <header class="w3-container w3-gray"> 
        <span onclick="document.getElementById('deleteCategoryModel').style.display='none'" 
        class="w3-button w3-large w3-display-topright">&times;</span>
        <h4 class="w3-center">Delete Category</h4>
      </header>
      <div class="w3-container w3-center">
        <br/>
        	 <div class="w3-panel " id="msg_deletecategory" style="diplay:none"></div>
        	<div id="dansalCategoryName" ></div>
        	<div id="dansalCategoryIcon" ></div>
        <br/>
        <div class="w3-row w6-row">
			<div class="w3-col s0 l5 "></div>
		 	<div class="w3-col s12 l1 " id="deleteBtnInCategory">
			
			</div>
			<div class="w3-col s12 l1 ">
			<button class="w3-button w3-blue-grey"  onclick="document.getElementById('deleteCategoryModel').style.display='none'">Cancle</button>
			</div>
			<div class="w3-col s0 l5 "></div>
		</div>		
        	<br/>
      </div>

    </div>
  </div>

<!----------------------   END SELECT ICON MODEL -------------------------> 




<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");
var iconList;
var selectedIcon;
var categoryList;
getDansalCategoryList();

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
	  $("#iconModel").hide();


}

function removeCategoryModel(){
	  $('#categoryName').val("");
	  $('#msg_addcategory').hide();
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
            	$('#msg_addcategory').empty();
            	if(json.successMsg!=null){           	
            		$('#msg_addcategory').append(json.successMsg);
            		$('#msg_addcategory').addClass('w3-pale-green ');
            		getDansalCategoryList();
            		
            	}
            	else if(json.errorMsg!=null){
            		$('#msg_addcategory').append(json.errorMsg);
            		$('#msg_addcategory').addClass('w3-pale-red');
            	}
            	else if(json.warnningMsg!=null){
            		$('#msg_addcategory').append(json.warnningMsg);
            		$('#msg_addcategory').addClass('w3-pale-yellow');
            	}
            
               $('#msg_addcategory').show();      
            },
			error : function(e) {
				alert("Error"+e.responseText);
			},
			done : function(x) {
				console.log("DONE");
			}
        }); 
    }

//-------------------------------------- END ADD NEW CATEGORY------------------------------------------------//


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
//-------------------------------------- END GET ICON LIST ------------------------------------------------//

//-------------------------------------- START GET DANSAL CATEGORY LIST------------------------------------------------//
function getDansalCategoryList(){
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "getAllDansalCategoryJSON.json",
			data:"", 
			dataType : 'json',
			timeout : 10000,
			success : function(data) {
				if (data.message=="SUCCESS") {
					categoryList=data.dansalCategoryList;
					addDataForDansalCategoryTable(categoryList);
								
				}
			},
			error : function(e) {
			},
			done : function(x) {
				console.log("DONE");
			}
		});
}

//-------------------------------------- END GET DANSAL CATEGORY LIST ------------------------------------------------//

function addDataForDansalCategoryTable(dansalCategoryList){
			$( "#dansalCategoryTableTBody" ).empty();
			for (i = 0; i <dansalCategoryList.length; i++) { 
			 	var url="${pageContext.request.contextPath}/resources/img/icons/"+dansalCategoryList[i].url+".png";
				var imageDiv="<img style='width:13%' id="+'"icon'+i+'"'+"src='"+url+"'>";
				var deleteIcon="<img style='width:15%' "+  "onclick="+'"showDeleteCategoryModel('+i+')"'+" src='${pageContext.request.contextPath}/resources/img/common/delete.png'>";
				var updateIcon="<img style='width:15%' "+  "onclick="+'"updateCategory()"'+" src='${pageContext.request.contextPath}/resources/img/common/update.png'>";
			 	var row=" <tr id="+'"row'+i+'"'+"> <td> "+(i+1)+" </td> <td>"+imageDiv +"</td>   <td>"+dansalCategoryList[i].type+"</td>  <td>" +deleteIcon+" " +updateIcon+"</td>    </tr>"; 
		     $("#dansalCategoryTableTBody").append(row);
	}
}


function showDeleteCategoryModel(categoryId){
	$('#msg_deletecategory').empty()
	$('#dansalCategoryName').empty();
	$('#dansalCategoryIcon').empty();
	$('#deleteBtnInCategory').empty();
	var url="${pageContext.request.contextPath}/resources/img/icons/"+categoryList[categoryId].url+".png";
    var icon="<img "+"src='"+url+"'>";
	$('#dansalCategoryName').append(categoryList[categoryId].type);
	$('#dansalCategoryIcon').append(icon);
	$('#deleteBtnInCategory').append('<button class="w3-button w3-blue-grey" onclick="deleteCategory('+categoryId+')"'+'>Delete</button>');
	document.getElementById('deleteCategoryModel').style.display='block';

}

function deleteCategory(categoryId){
	$('#msg_deletecategory').empty();
;
	 $.ajax({
            url: 'deleteDansalCategoryJSON.json',
            data:{'categoryId':categoryList[categoryId].categoryId,'iconId':categoryList[categoryId].iconId},
            type: 'POST',
            success: function(json) {
            	
            	if(json.successMsg!=null){
            		$('#msg_deletecategory').append(json.successMsg);
            		$('#msg_deletecategory').addClass('w3-pale-green');           	
            		getDansalCategoryList();
            		
            	}
            	else if(json.errorMsg!=null){
            	$('#msg_deletecategory').append(json.errorMsg);
            		$('#msg_deletecategory').addClass('w3-pale-red'); 
            		
            	}
            
               
            },
			error : function(e) {
				alert("Error"+e.responseText);
			},
			done : function(x) {
				
			}
        }); 

}

function updateCategory(){
	alert("this is update function")
}



$(document).ready(function() {
    $('#dansalCategoryTable').DataTable( {
       "scrollY":"200px",
       "scrollCollapse": true,
       "paging":   false,
       "ordering": false,
       "info":     false,
       "searching":false
    } );
} );
</script>

</body>
</html>
