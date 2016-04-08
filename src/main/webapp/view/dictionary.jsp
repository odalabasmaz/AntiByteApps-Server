<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="generator" content="HTML Tidy for Windows (vers 14 February 2006), see www.w3.org"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../js/angular.min.js" type="text/javascript"></script>
    <script src="../js/app.js" type="text/javascript"></script>
    <title>Anti-Byte Apps</title>
</head>

<body style="padding:0px 20px;">
<h3>Dictionary - Word Validator</h3>

<div ng-app="" ng-controller="searchController" ng-show="is_visible">
    Word: <input type="text" ng-model="searchContent"/>&nbsp;&nbsp;
    <button ng-click="search()">Search</button>
    </br></br>
    Result: <input type="text" ng-model="result" readonly="readonly"></textarea>
</div>
</body>
</html>
