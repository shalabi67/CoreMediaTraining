<%@ page contentType="text/html;charset=utf-8" session="false"%>
<%@ taglib prefix="cm" uri="http://www.coremedia.com/2004/objectserver-1.0-2.0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${self.clientCodes}" var="clientCode">
   <cm:include self="${clientCode}" view="${clientCode.format[0].content.name}" />
</c:forEach>
