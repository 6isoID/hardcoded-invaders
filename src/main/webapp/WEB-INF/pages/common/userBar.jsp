<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="label.userBar.loginText" /><c:out value="${sessionScope.client.userName}" />.<a href="logout.html"><spring:message code="label.userBar.logout" /></a>