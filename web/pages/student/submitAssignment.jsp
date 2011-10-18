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

			<af:spacer height="75" />

			<htm:div
				style="width: 500px; padding-left: 20px; padding-right: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;">

				<h:outputText value="Submit Assignment" styleClass="title" />

				<af:spacer height="30" />

				<h:outputText
					value="Select a .zip file with the source code (.java files) of the program and test cases." />

				<af:spacer height="30" />

				<h:messages styleClass="message" />

				<h:panelGrid columns="2">
					<h:outputText value="File*:" styleClass="label" />
					<t:inputFileUpload value="#{studentSubmitAssigment.file}"
						storage="file" />
				</h:panelGrid>

				<af:spacer height="30" />

				<h:commandButton value="Cancel"
					action="#{studentSubmitAssigment.cancel}" />
				<h:commandButton value="Finalize"
					onclick="document.getElementById('hidepage').style.visibility = 'visible';"
					action="#{studentSubmitAssigment.upload}" />

			</htm:div>

		</h:form>

	</f:subview>
</jsp:root>