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

		<h:form>

			<af:spacer height="75" />

			<htm:div
				style="width: 500px; padding-left: 20px; padding-right: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;">

				<h:outputText value="Register New Student" styleClass="title" />

				<af:spacer height="20" />

				<h:outputText value="Enter the student informations." />

				<af:spacer height="20" />

				<h:messages styleClass="message" />

				<h:panelGrid columns="2">
					<h:outputText value="Username*:" />
					<h:inputText value="#{instructorRegisterStudent.userName}" />
					<h:outputText value="Full Name*:" />
					<h:inputText value="#{instructorRegisterStudent.name}" />
					<h:outputText value="E-mail*:" />
					<h:inputText value="#{instructorRegisterStudent.email}" />
					<h:outputText value="Password*:" />
					<h:inputSecret value="#{instructorRegisterStudent.password}" />
					<h:outputText value="Confirmation Password*:" />
					<h:inputSecret
						value="#{instructorRegisterStudent.confirmationPassword}" />
				</h:panelGrid>

				<af:spacer height="30" />

				<h:commandButton value="Cancel"
					action="#{instructorRegisterStudent.cancel}" />
				<h:commandButton value="Finalize"
					action="#{instructorRegisterStudent.register}" />

			</htm:div>

		</h:form>

	</f:subview>
</jsp:root>