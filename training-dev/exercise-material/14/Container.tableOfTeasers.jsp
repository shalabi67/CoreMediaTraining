<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:if test="${not empty self.title}">
  <div class="containerHeadline"><c:out value="${self.title}" /></div>
</c:if>

<div class="containerTable">
	<c:forEach items="${self.contents}" var="content" varStatus="status">
		<div class="containerTableContent">
			<div class="${status.index % 2 == 0 ? 'containerContentEven' : 'containerContentOdd'}">
				<cm:include self="${content}" view="teaser" />
		  </div>
	  </div>
	</c:forEach>
</div>
