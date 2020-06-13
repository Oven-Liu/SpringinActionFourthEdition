<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div class="spittleView">
  <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
  <div>
    <span class="spittleTime"><c:out value="${spittle.time}" /></span>
  </div>

  Hello <security:authentication property="principal.username" var="loginId" scope="request"/>
  <security:authorize access="hasRole('ROLE_SPITTER')">
    <s:url value="/spittles" var="spittle_url">
      <sf:form modelAttribute="spittle" action="${spittle_url}">
        <sf:label path="text"><s:message code="label.spittle" text="Enter spittle:"/></sf:label>
        <sf:textarea path="text" rows="2" cols="40"/>
        <sf:errors path="text"/>
        <br/>
        <div class="spitIdSubmitIt">
          <input type="submit" value="Spit it!" class="status-btn round-btn disabled">
        </div>
      </sf:form>
    </s:url>
  </security:authorize>

  <security:authorize access="isAuthenticated() and principal.username=='habuma'">
    <a href="/admin">Administration</a>
  </security:authorize>

  <security:authorize url="/admin">
    <spring:url value="/admin" var="admin_url"/>
    <a href="${admin_url}>Administration</a>
  </security:authorize>
</div>
