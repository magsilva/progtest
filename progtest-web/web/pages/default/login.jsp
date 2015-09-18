<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:htm="http://jsftutorials.net/htmLib"
	<jsp:directive.page contentType="text/html;charset=iso-8859-1" />

	<f:subview id="content">

		<htm:center>

			<h:form>

				<htm:div
					style="width: 400px; padding-left: 20px; padding-right: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;">

					<h:outputText value="Login" styleClass="title" />

					<h:outputText value="Enter your username and password." />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Username*:" styleClass="label" />
						<h:inputText value="#{login.userName}" />
						<h:outputText value="Password*:" styleClass="label" />
						<h:inputSecret value="#{login.password}" />
					</h:panelGrid>

					<h:commandButton value="Sign in" action="#{login.login}" />

				</htm:div>

			</h:form>

		</htm:center>

	</f:subview>
</jsp:root>
