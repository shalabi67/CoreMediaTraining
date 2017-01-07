<%@ page contentType="text/html;charset=utf-8" session="true"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
  <c:when test="${not empty self.url}">
    <link rel="stylesheet" href="<c:url value="${self.url}" />" type="text/css" media="all"/>
  </c:when>
  <c:otherwise>
    <link rel="stylesheet" href="<cm:link target="${self.raw}"/>" type="text/css" media="all"/>
  </c:otherwise>
</c:choose>
