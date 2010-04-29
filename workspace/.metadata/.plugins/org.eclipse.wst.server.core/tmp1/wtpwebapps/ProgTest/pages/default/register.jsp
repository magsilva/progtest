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

				<af:spacer height="50" />

				<h:outputText value="Registro" styleClass="title"/>

				<af:spacer height="20" />

				<h:outputText
					value="Informe os dados para o cadastro." />

				<af:spacer height="20" />

				<h:messages styleClass="message"/>

				<h:panelGrid columns="2">
					<h:outputText value="Nome de Usuário*:" />
					<h:inputText value="#{register.userName}" />
					<h:outputText value="Nome Completo*:" />
					<h:inputText value="#{register.name}" />
					<h:outputText value="E-mail*:" />
					<h:inputText value="#{register.email}" />
					<h:outputText value="Senha*:" />
					<h:inputSecret value="#{register.password}" />
					<h:outputText value="Confirmação Senha*:" />
					<h:inputSecret value="#{register.confirmationPassword}" />
				</h:panelGrid>

				<af:spacer height="20" />

				<h:commandButton value="Cancelar" action="#{register.cancel}" />
				<h:commandButton value="Registrar" action="#{register.register}" />

			</h:form>

		</htm:center>
		
	</f:subview>
</jsp:root>