<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>

<html>
<head>
  <title><c:out value="${self.title}" /></title>

  <meta http-equiv="content-Script-Type" content="text/javascript"/>
  <meta http-equiv="content-Style-Type" content="text/css"/>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
  <meta http-equiv="content-language" content="de"/>

  <cm:include self="${currentTopic}" view="layout"/>
</head>

<body>
<div id="page">

  <div id="logo">
    <a href="#">
      <div id="logoImg"></div>
    </a>
  </div>


  <div id="titleBarLeft"></div>
  <div id="titleBarMid"></div>
  <div id="titleBarTop"></div>
  <div id="titleBar">
	  <div id="title">
	    <cm:include self="${currentTopic.rootTopic}" view="link" />
	  </div>
  </div>

  <div id="nav">
    <div id="taxNav">
      <cm:include self="${currentTopic}" view="navigation"/>
    </div>
    <div id="navTail"></div>
  </div>

  <div id="content">
    <cm:include self="${self}" view="main"/>
  </div>
  
</div>
</body>
</html>
