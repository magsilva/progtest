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

			<af:spacer height="30" />

			<h:outputText value="Registrar Novo Aluno" styleClass="title" />

			<af:spacer height="20" />

			<h:outputText
				value="Dica: Se o aluno já estiver registrado no sistema, você pode simplesmente adiciona-lo ao curso." />

			<af:spacer height="20" />

			<h:outputText value="Informe os dados do aluno." />

			<af:spacer height="20" />

			<h:messages styleClass="message" />

			<h:panelGrid columns="2">
				<h:outputText value="Nome de Usuário*:" />
				<h:inputText value="#{instructorRegisterStudent.userName}" />
				<h:outputText value="Nome Completo*:" />
				<h:inputText value="#{instructorRegisterStudent.name}" />
				<h:outputText value="E-mail*:" />
				<h:inputText value="#{instructorRegisterStudent.email}" />
				<h:outputText value="Senha*:" />
				<h:inputSecret value="#{instructorRegisterStudent.password}" />
				<h:outputText value="Confirmação Senha*:" />
				<h:inputSecret
					value="#{instructorRegisterStudent.confirmationPassword}" />
			</h:panelGrid>

			<af:spacer height="30" />

			<h:commandButton value="Cancelar"
				action="#{instructorRegisterStudent.cancel}" />
			<h:commandButton value="Finalizar"
				action="#{instructorRegisterStudent.register}" />

		</h:form>

	</f:subview>
</jsp:root>