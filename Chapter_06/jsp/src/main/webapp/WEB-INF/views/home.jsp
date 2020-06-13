<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1><s:message code="spitter.welcome" text="Welcome" /></h1>

    <s:url value="/spitter/register" var="registerUrl" scope="request"/>

    <a href="<s:url value="/spittles" />">Spittles</a> | 
    <a href="${registerUrl}">Register</a>

    <s:url value="/spittles" var="spittlesUrl">
      <s:param name="max" value="60"/>
      <s:param name="count" value="20"/>
    </s:url>

    <s:url value="/spitter/{username}" var="spitterUrl">
      <s:param name="username" value="jbauer"/>
    </s:url>

    <s:url value="/spittles" htmlEscape="true">
      <s:param name="max" value="60"/>
      <s:param name="count" value="20"/>
    </s:url>

    <s:url value="/spittles" var="spittlesJSUrl" javaScriptEscape="true">
      <s:param name="max" value="60"/>
      <s:param name="count" value="20"/>
    </s:url>
  <script>
    var sppittlesUrl = "${spittlesJSUrl}";
  </script>
  <script>
    var sppittlesUrl = "\/spitter\/spittles?max=60&amp;count=20";
  </script>

  <s:escapeBody htmlEscape="true">
    <h1>Hello</h1>
  </s:escapeBody>

    &lt;h1&gt;Hello&lt;/h1&gt;

  <s:escapeBody javaScriptEscape="true">
    <h1>Hello</h1>
  </s:escapeBody>

  </body>
</html>
