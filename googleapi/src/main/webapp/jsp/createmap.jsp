<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<title>Data Center App</title>
	
	<script src="http://maps.google.com/maps/api/js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"
		type="text/javascript"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/map.js"></script>
	<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" />
	
	<script type="text/javascript">
		function getContextPath() {
			return "<%=request.getContextPath()%>";
		}
	</script>
</head>

<body>
    <h2 class="heading">Data Center App</h2>
	<div class="leftNav">
		<label for="searchField">Search Query</label>
		<input type="text" name="searchField">
		<button id="submitSearch">Search</button>
		<!-- <div>
            <label for="vertical">Vertical</label>
            <input type="radio" name="vertical" value="all">ALL<br>
            <input type="radio" name="vertical" value="IT">IT<br>
            <input type="radio" name="vertical" value="FNA">FNA<br>
        </div>
		
        <div>
            <label for="industry">Industry</label>
            <select id="industry">
                <option value="000">High Tech</option>
                <option value="1">BFSI</option>
                <option value="2">Health Care</option>
                <option value="3">Energy</option>
                <option value="4">Diversified</option>
            </select>
		</div>
        
        <div>
            <label for="client">Client</label>
            <select id="client">
                <option value="">Sample Client</option>
            </select>
		</div>
        
        <div>
            <label for="function">Function</label>
            <input type="radio" name="function" value="sample">Sample<br>
        </div>
        
        <div>
            <label for="product">Product</label>
            <input type="checkbox" name="product" value="sample">Sample<br>
            <input type="checkbox" name="product" value="sample1">Sample1
        </div>
        
        <div>
            <label for="manager">Manager</label>
            <select id="manager">
                <option value="">Sample Manager</option>
            </select>
        </div>
        
        <div>
            <label for="consultantFilter">List Consultants By:</label>
            <input type="radio" name="consultantFilter" value="work">Work Address<br>
            <input type="radio" name="consultantFilter" value="home">Home Address
		</div>
        
        <div>
            <label for="stateFilter">List By State:</label>
            <input type="radio" name="stateFilter" value="work">Work Address<br>
            <input type="radio" name="stateFilter" value="home">Home Address
        </div>
        
        <div>
            <select id="deptId">
                <option value="000">All</option>
                <option value="301">Healthcare</option>
                <option value="302">Finance</option>
            </select>
        </div>  -->
    </div>
	
	<div class="topNav">
		<!-- <label for="clientDropdown">Search</label>
		<select name="clientDropdown">
			<option value="client">Client</option>
			<option value="consultant">Consultant</option>
			<option value="manager">Manager</option>
		</select>
	  	<input type="text"> -->
	</div>
	
	<div id="map-canvas"></div>
</body>

</html>