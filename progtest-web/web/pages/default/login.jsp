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

				<af:spacer height="70" />

				<htm:div
					style="width: 400px; padding-left: 20px; padding-right: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;">

					<h:outputText value="Login" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Enter your username and password." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Username*:" styleClass="label" />
						<h:inputText value="#{login.userName}" />
						<h:outputText value="Password*:" styleClass="label" />
						<h:inputSecret value="#{login.password}" />
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandButton value="Sign in" action="#{login.login}" />

				</htm:div>

				<af:spacer height="120" />

			</h:form>

		</htm:center>

	</f:subview>
</jsp:root>