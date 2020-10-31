<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ng-app="reportApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
    var _contextPath = "${pageContext.request.contextPath}";
</script>

<!-- CSS lib -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">



 

 <style type="text/css">
 
.mb.card-body{
    text-align: center;
}
.mb.btn{
    border-radius: 0;
    box-shadow: 0.5px 1px 2px hsla(0, 0%, 20%, 1);
}
.mb.btn:hover{
    transform: translateY(-2px);
    box-shadow: 2px 2px 5px hsla(0, 0%, 20%, 1);
}
.mb.card{
    border-radius: 0px / 0px;
    overflow: hidden;
    box-shadow: 0.5px 1px 2px hsla(0, 0%, 20%, 1);
}
 
 </style>

</head>
<body>

<div class="container">
	<div class="row">
		<div class="container">
		 <h2 class="text-center">The Rick and Morty</h2>
    <br>
	<div class="row">
	    <div class="col-md-4">
    		<div class="card mb">
              <img class="card-img-top" src="http://www.placehold.it/286x180" alt="Card image cap">
              <div class="card-body mb">
                <a href="<c:url value = "/character/"/>" class="btn btn-primary mb">Character</a>
              </div>
            </div>
        </div>
        <div class="col-md-4">
    		<div class="card mb">
              <img class="card-img-top" src="http://www.placehold.it/286x180" alt="Card image cap">
              <div class="card-body mb">
           
              <a href="<c:url value = "/episode/"/>" class="btn btn-primary mb">Episode</a>
              </div>
            </div>
        </div>
        <div class="col-md-4">
    		<div class="card mb">
              <img class="card-img-top" src="http://www.placehold.it/286x180" alt="Card image cap">
              <div class="card-body mb">
               <a href="<c:url value = "/report/"/>" class="btn btn-primary mb">Report</a>
              </div>
            </div>
        </div>
	</div>
</div>
	</div>
</div>


 
</body>
</html>