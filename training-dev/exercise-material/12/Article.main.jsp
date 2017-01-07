<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${!empty self.title}">
	<div class="articleHeadline"><c:out value="${self.title}" /></div>
</c:if>

<div class="article">
	<c:if test="${not empty self.image}">
	  <div class="articleImage">
	    <cm:include self="${self.image[0]}" view="main"/>
	  </div>
	</c:if>
	
	<div class="articleContent">
		<c:if test="${not empty self.text}">
			<cm:include self="${self.text}" />
		</c:if>
		
		<c:if test="${fn:length(self.related) ge 1}">
			<p class="p--heading-2">Related:</p>
			<ul>
				<c:forEach var="rel" items="${self.related}">
					<li><cm:include self="${rel}" view="link"/></li>
				</c:forEach>
			</ul>
		</c:if>
	</div>
</div>