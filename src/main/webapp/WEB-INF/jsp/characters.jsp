<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ng-app="characterApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
    var _contextPath = "${pageContext.request.contextPath}";
</script>

<!-- CSS lib -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">


 

 <style type="text/css">
 
 .box
{
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 4px 8px 0 rgba(0, 0, 0, 0.19);
    border-radius: 10px;
}
.card
{
    margin-top: 80px;
    height: 300px;
    transition: 0.5s;
}
.card:hover
{
    border: 1px solid red;
    border-radius: 30px;
}
.card .cardImg
{
    height: 100px;
    width: 90%;
    position: relative;
    top: -15px;
    left: 5%;
}
.card .cardImg img
{
    width: 100%;
    height: 100%;
}

.card .info
{
    text-align: center;
}
.card .info h3
{
    color: rgb(70, 66, 66);
}
.card .info p
{
    color: rgb(41, 201, 49);
}

.ligne
{
    display: flex;
}
 
 </style>

</head>
<body>

	<main>
	<div ng-view></div>
	<div ui-view></div>
	</main>

<!-- JS lib -->

 
<script src="https://code.angularjs.org/1.3.3/angular.min.js"></script>
<script src="https://code.angularjs.org/1.3.3/angular-animate.min.js"></script>
<script src="https://code.angularjs.org/1.3.3/angular-sanitize.min.js"></script>
<script src="//angular-ui.github.io/ui-router/release/angular-ui-router.js"></script>
<script src="https://code.angularjs.org/1.3.3/angular-sanitize.min.js"></script>


<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
<script src="https://morgul.github.io/ui-bootstrap4/ui-bootstrap-tpls-3.0.5.min.js"></script>
 
 <script type="text/javascript" src=" <c:url value="/view/character/js/controller.js" />"></script>
</body>
</html>