$(document).ready(function() {

	geocoder = new google.maps.Geocoder();
	infowindow = new google.maps.InfoWindow();
	map = new google.maps.Map(document.getElementById('map-canvas'), {
		zoom: 4,
		center: new google.maps.LatLng(37.0,-101.6881252),
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		scrollwheel: false,
		scaleControl: false 
	});

	$.ajax({
		url : getContextPath()+'/getData',
		data : {},
		dataType: "json",
		success : function(responseText) {
			//console.log(responseText);
			if(responseText.status === true){
				//alert("Success");
				var employeeArr=JSON.parse(responseText.employees);
				//console.log("Employee array is : "+ JSON.stringify(employeeArr));
				var addressList = [];
				$.each(employeeArr, function(i, jsonObj){ 
					//console.log("Home address is :" + jsonObj.homeAddress);
					if(jsonObj.homeAddress != null || jsonObj.homeAddress != undefined){
						if(!($.inArray(jsonObj.homeAddress, addressList) > -1)){
							addressList.push(jsonObj.homeAddress);
							codeAddress(jsonObj.homeAddress, jsonObj.deptId);
						}
					}
				});
			}
		}
	});

	$('#submitSearch').on('click',function() {
		$.ajax({
			type: 'POST',
			url : getContextPath()+'/getData',
			data : {'searchParam':$('input[name="searchField"]').val()},
			dataType: "json",
			success : function(responseText) {
				//console.log(responseText);
				createNewMap();
				var employeeArr=JSON.parse(responseText.employees);
				addressList = [];
				$.each(employeeArr, function(i, jsonObj){ 
					//console.log("Home address is :" + jsonObj.homeAddress);
					if(jsonObj.homeAddress != null || jsonObj.homeAddress != undefined){
						if(!($.inArray(jsonObj.homeAddress, addressList) > -1)){
							addressList.push(jsonObj.homeAddress);
							codeAddress(jsonObj.homeAddress, jsonObj.deptId);
						}
					}
				});
			}
		});
	});
});

function createNewMap(){
	map = new google.maps.Map(document.getElementById('map-canvas'), {
		zoom: 4,
		center: new google.maps.LatLng(37.0,-101.6881252),
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		scrollwheel: false,
		scaleControl: false 
	});
}

function codeAddress(address, iconType){
	//console.log("Inside codeAddress method");
	//console.log("Address is : "+ address + " & " + iconType);
	var icon = "http://maps.google.com/mapfiles/ms/icons/red-dot.png";

	geocoder.geocode( {'address':address}, function(results, status){
		//console.log("Result is :"+ results + " & "+ status);
		if(results != null){
			var marker = new google.maps.Marker(
					{
						position: results[0].geometry.location,
						map: map,
						icon: icon
					});
			if (status == google.maps.GeocoderStatus.OK){
				//map.setCenter(results[0].geometry.location);//center the map over the result
				//place a marker at the location
				if(iconType === "301"){
					//alert("healthecare ison");
					icon = 	"http://maps.google.com/mapfiles/ms/icons/blue-dot.png";
				}else if(iconType === "302"){
					icon = "http://maps.google.com/mapfiles/ms/icons/yellow-dot.png";
				}
			} else if (status === google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {    
				setTimeout(function() {
					codeAddress(address, iconType);
				}, 200);
			} else {
				alert('Geocode was not successful for the following reason: ' + status);
			}

			google.maps.event.addListener(marker, 'click', function() {
				infowindow.setContent(address);
				infowindow.open(map, marker);
			});
		}
	});
	//});
}