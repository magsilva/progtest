<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:tiles="http://tiles.apache.org/tags-tiles">
	<jsp:directive.page contentType="text/html;charset=iso-8859-1" />

	<tiles:insertDefinition name="page.studentTemplate">
		<tiles:putAttribute name="title" value="ProgTest" />
		<tiles:putAttribute name="content" type="template"
			value="/pages/student/addTestCases.jsp" />
	</tiles:insertDefinition>

</jsp:root>
