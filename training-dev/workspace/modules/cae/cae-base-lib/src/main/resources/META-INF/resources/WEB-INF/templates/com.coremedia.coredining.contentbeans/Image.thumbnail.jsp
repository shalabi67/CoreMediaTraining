<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<img src="<cm:link target="${self.data}" />" 
     alt="<c:out value="${self.caption}" />" 
     title="<c:out value="${self.title}" />"
     class="thumbnail">