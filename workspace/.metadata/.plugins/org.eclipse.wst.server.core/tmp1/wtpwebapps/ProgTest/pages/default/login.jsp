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

				<h:outputText value="Acesso" styleClass="title" />

				<af:spacer height="30" />

				<h:outputText
					value="Entre com o seu nome de usuário e senha ou registre-se." />

				<af:spacer height="20" />

				<h:messages styleClass="message" />

				<h:panelGrid columns="2">
					<h:outputText value="Nome de Usuário*:" styleClass="label" />
					<h:inputText value="#{login.userName}" />
					<h:outputText value="Senha*:" styleClass="label" />
					<h:inputSecret value="#{login.password}" />
				</h:panelGrid>

				<af:spacer height="20" />

				<h:commandButton value="Entrar" action="#{login.login}" />

				<af:spacer height="120" />

			</h:form>

		</htm:center>

	</f:subview>
</jsp:root>