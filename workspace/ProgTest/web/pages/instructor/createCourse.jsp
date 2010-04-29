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

			<h:outputText value="Criar Novo Curso" styleClass="title" />

			<af:spacer height="20" />

			<h:outputText value="Informe os dados do curso." />

			<af:spacer height="20" />

			<h:messages styleClass="message" />

			<h:panelGrid columns="2">
				<h:outputText value="Nome*:" />
				<h:inputText value="#{instructorCreateCourse.name}" />
				<h:outputText value="Data Início*:" />
				<t:inputDate value="#{instructorCreateCourse.startDate}" popupCalendar="true"/>
				<h:outputText value="Data Término*:" />
				<t:inputDate value="#{instructorCreateCourse.endDate}" popupCalendar="true"/>
			</h:panelGrid>

			<af:spacer height="30" />

			<h:commandButton value="Cancelar"
				action="#{instructorCreateCourse.cancel}" />
			<h:commandButton value="Finalizar"
				action="#{instructorCreateCourse.create}" />

		</h:form>

	</f:subview>
</jsp:root>