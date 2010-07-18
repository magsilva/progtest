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

			<h:outputText value="Edit Course" styleClass="title" />

			<af:spacer height="20" />

			<h:messages styleClass="message" />

			<h:panelGrid columns="2">
				<h:outputText value="Name*:" />
				<h:inputText value="#{instructorEditCourse.name}" />
				<h:outputText value="Start Date*:" />
				<t:inputDate value="#{instructorEditCourse.startDate}" popupCalendar="true"/>
				<h:outputText value="End Date*:" />
				<t:inputDate value="#{instructorEditCourse.endDate}" popupCalendar="true"/>
			</h:panelGrid>

			<af:spacer height="30" />

			<h:commandButton value="Cancel"
				action="#{instructorEditCourse.cancel}" />
			<h:commandButton value="Save"
				action="#{instructorEditCourse.edit}" />

		</h:form>

	</f:subview>
</jsp:root>