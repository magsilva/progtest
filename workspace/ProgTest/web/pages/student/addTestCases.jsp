<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:afh="http://myfaces.apache.org/trinidad/html"
	xmlns:af="http://myfaces.apache.org/trinidad"
	xmlns:htm="http://jsftutorials.net/htmLib"
	xmlns:t="http://myfaces.apache.org/tomahawk">
	<jsp:directive.page contentType="text/html;charset=iso-8859-1" />

	<f:subview id="content">

		<h:form enctype="multipart/form-data">

			<af:spacer height="30" />

			<h:outputText value="Add Test Cases" styleClass="title" />

			<af:spacer height="30" />

			<h:outputText
				value="Select a .jar file with the source code of the test cases." />

			<af:spacer height="30" />

			<h:messages styleClass="message" />

			<h:panelGrid columns="2">
				<h:outputText value="File*:" />
				<t:inputFileUpload value="#{studentAddTestCases.file}"
					storage="file" />
			</h:panelGrid>

			<af:spacer height="30" />

			<h:commandButton value="Cancel"
				action="#{studentAddTestCases.cancel}" />
			<h:commandButton value="Finalize"
				action="#{studentAddTestCases.upload}" />

		</h:form>

	</f:subview>
</jsp:root>