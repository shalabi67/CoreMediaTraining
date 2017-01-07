<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${not empty self.data}">
  <img src="<cm:link target="${self.data}" />"
       <c:if test="${!empty self.caption}">
          alt="<c:out value="${self.caption}" />"
       </c:if>
       title="<c:out value="${self.title}" />" />
  <c:if test="${!empty self.caption}">
    <div class="caption">
      <c:out value="${self.caption}" />
    </div>
  </c:if>
</c:if>
