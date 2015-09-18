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

		<htm:center>

			<h:form>

				<af:spacer height="75" />

				<htm:div
					style="width: 500px; padding-left: 20px; padding-right: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;">

					<h:outputText value="Edit Profile" styleClass="title" />

					<af:spacer height="30" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Full Name*:" />
						<h:inputText value="#{studentEditProfile.name}" />
						<h:outputText value="E-mail*:" />
						<h:inputText value="#{studentEditProfile.email}" />
						<h:outputText value="Password*:" />
						<h:inputSecret value="#{studentEditProfile.password}" />
						<h:outputText value="Confirmation Password*:" />
						<h:inputSecret value="#{studentEditProfile.confirmationPassword}" />
					</h:panelGrid>

					<af:spacer height="30" />

					<h:commandButton value="Cancel"
							action="#{studentEditProfile.cancel}" />
					<h:commandButton value="Save" 
							action="#{studentEditProfile.edit}" />

				</htm:div>

			</h:form>

		</htm:center>

	</f:subview>
</jsp:root>