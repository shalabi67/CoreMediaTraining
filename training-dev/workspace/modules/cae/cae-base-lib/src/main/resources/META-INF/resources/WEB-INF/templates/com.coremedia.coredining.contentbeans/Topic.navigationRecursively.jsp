<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="naviLevel">
  <c:forEach items="${parentTopic.subTopics}" var="topic">
  	<c:if test="${topic eq currentTopic}">
    	<div class="selected">
    </c:if>
    <div class="naviElement">
	  	<cm:include self="${topic}" view="link" />
	 	</div>
    <c:if test="${topic eq currentTopic}">
    	</div>
    </c:if>
    <c:if test="${topic eq pathElements[index] || topic eq currentTopic}">
      <cm:include self="${topic}" view="navigationRecursively">
        <cm:param name="parentTopic" value="${topic}"/>
        <cm:param name="index" value="${index + 1}"/>
        <cm:param name="pathElements" value="${pathElements}"/>
      </cm:include>
    </c:if>
  </c:forEach>
</div>
