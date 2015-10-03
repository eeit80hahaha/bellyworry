<%@page import="java.util.*"%>
<%@page import="health.model.HealthDiaryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Belly Worry - Enjoy Your Life</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Html5TemplatesDreamweaver.com">
<META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW">
<!-- Remove this Robots Meta Tag, to allow indexing of site -->

<link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="scripts/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Icons -->
<link href="scripts/icons/general/stylesheets/general_foundicons.css"
	media="screen" rel="stylesheet" type="text/css" />
<link href="scripts/icons/social/stylesheets/social_foundicons.css"
	media="screen" rel="stylesheet" type="text/css" />
<!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif]-->
<link rel="stylesheet"
	href="scripts/fontawesome/css/font-awesome.min.css">
<!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif]-->

<link href="scripts/carousel/style.css" rel="stylesheet" type="text/css" />
<link href="scripts/camera/css/camera.css" rel="stylesheet"
	type="text/css" />

<link href="http://fonts.googleapis.com/css?family=Allura"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Aldrich"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet" type="text/css">
<!--     <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css"> -->
<link href="http://fonts.googleapis.com/css?family=Calligraffitti"
	rel="stylesheet" type="text/css">

<link href="styles/custom.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">


<style>
</style>


</head>
<body id="pageBody">
<c:url value="diaryIndex.controller" var="path">
<c:param name="memberNo" value="1000018"></c:param>
<c:param name="year" value="2015"></c:param>
<c:param name="month" value="9"></c:param>
</c:url>
<a href="${path}">111111111111</a>
</body>
</html>