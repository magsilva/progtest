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

				<af:spacer height="30" />

				<h:outputText value="Editar Perfil" styleClass="title"/>

				<af:spacer height="30" />

				<h:messages styleClass="message"/>

				<h:panelGrid columns="2">
					<h:outputText value="Nome Completo*:" />
					<h:inputText value="#{studentEditProfile.name}" />
					<h:outputText value="E-mail*:" />
					<h:inputText value="#{studentEditProfile.email}" />
					<h:outputText value="Senha*:" />
					<h:inputSecret value="#{studentEditProfile.password}" />
					<h:outputText value="Confirmação Senha*:" />
					<h:inputSecret value="#{studentEditProfile.confirmationPassword}" />
				</h:panelGrid>

				<af:spacer height="30" />

				<h:commandButton value="Cancelar" action="#{studentEditProfile.cancel}" />
				<h:commandButton value="Salvar" action="#{studentEditProfile.edit}" />

			</h:form>

		</htm:center>
		
	</f:subview>
</jsp:root>