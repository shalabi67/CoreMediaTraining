<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${!empty self.contentContainers}">
 <!--  Decide how to render the first container. 
       In case there is a second one, it is the introduction
       rendered as a normal articel, otherwise it is teaserable content
 -->
  <c:choose>
    <c:when test="${!empty self.contentContainers[1]}">
      <cm:include self="${self.contentContainers[0]}" view="main" />
    </c:when>
    <c:otherwise>
      <cm:include self="${self.contentContainers[0]}" view="tableOfTeasers" />
    </c:otherwise>
  </c:choose>
  <c:if test="${!empty self.contentContainers[1]}">
    <cm:include self="${self.contentContainers[1]}" view="tableOfTeasers" />
  </c:if>
</c:if>
