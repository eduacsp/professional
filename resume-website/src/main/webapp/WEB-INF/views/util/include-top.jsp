<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- spring:url value="/resources/img" var="images" />  -->
<spring:url value="/resources/css/style.css" var="styleCss" />
<spring:url value="/resources/css/principal.css" var="coreCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/js/jquery-1.11.1.min.js" var="jqueryJs" />
<!-- <spring:url value="/resources/js/jquery-ui.min.js" var="jqueryUiJs" /> -->
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${styleCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>





