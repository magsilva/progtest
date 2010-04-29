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

			<h:outputText value="Editar Curso" styleClass="title" />

			<af:spacer height="20" />

			<h:outputText value="Altere os dados desejados." />

			<af:spacer height="20" />

			<h:messages styleClass="message" />

			<h:panelGrid columns="2">
				<h:outputText value="Nome*:" />
				<h:inputText value="#{instructorEditCourse.name}" />
				<h:outputText value="Data In�cio*:" />
				<t:inputDate value="#{instructorEditCourse.startDate}" popupCalendar="true"/>
				<h:outputText value="Data T�rmino*:" />
				<t:inputDate value="#{instructorEditCourse.endDate}" popupCalendar="true"/>
			</h:panelGrid>

			<af:spacer height="30" />

			<h:commandButton value="Cancelar"
				action="#{instructorEditCourse.cancel}" />
			<h:commandButton value="Salvar"
				action="#{instructorEditCourse.edit}" />

		</h:form>

	</f:subview>
</jsp:root>