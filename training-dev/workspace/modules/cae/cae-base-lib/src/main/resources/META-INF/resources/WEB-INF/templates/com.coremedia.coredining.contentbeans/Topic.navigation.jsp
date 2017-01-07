<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<cm:include self="${self.rootTopic}" view="navigationRecursively">
  <cm:param name="parentTopic" value="${self.rootTopic}"/>
  <cm:param name="index" value="1"/>
  <cm:param name="pathElements" value="${self.pathElements}"/>
  <cm:param name="currentTopic" value="${self}"/>
</cm:include>
