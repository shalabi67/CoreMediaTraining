<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${!empty self.title}">
  <div class="headline">
    <a href="<cm:link target="${self}"/>"><c:out value="${self.title}" /></a>
  </div>
</c:if>

<div class="article">
<c:if test="${not empty self.image}">
  <div class="teaserImage">
    <a href="<cm:link target="${self}"/>"><cm:include self="${self.image['0']}" view="thumbnail"/></a>
  </div>
</c:if>

<div class="articleContent">
<a href="<cm:link target="${self}"/>"><b>Read more...</b></a>
</div>
</div>