<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:if test="${!empty self.title}">
  <div class="containerHeadline"><c:out value="${self.title}" /></div>
</c:if>

<div class="containerList">
	<c:forEach items="${self.contents}" var="content">
		<div class="containerListContent">
			<cm:include self="${content}" view="teaser" />
    </div>
	</c:forEach>
</div>