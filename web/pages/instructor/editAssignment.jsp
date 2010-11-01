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

			<htm:div style="width: 800px;">

				<af:spacer height="30" />

				<h:outputText value="Edit Assignment" styleClass="title" />

				<af:spacer height="20" />

				<h:messages styleClass="message" />

				<h:panelGrid columns="2">
					<h:outputText value="Name*:" />
					<h:inputText value="#{instructorEditAssignment.title}" />
					<h:outputText value="Description*:" />
					<h:inputTextarea value="#{instructorEditAssignment.description}" />
					<h:outputText value="Start Date*:" />
					<t:inputDate value="#{instructorEditAssignment.startDate}"
						popupCalendar="true" />
					<h:outputText value="End Date*:" />
					<t:inputDate value="#{instructorEditAssignment.endDate}"
						popupCalendar="true" />
				</h:panelGrid>

				<af:spacer height="30" />

				<h:commandButton value="Cancel"
					action="#{instructorEditAssignment.cancel}" />
				<h:commandButton value="Save"
					action="#{instructorEditAssignment.edit}" />

			</htm:div>

		</h:form>

	</f:subview>
</jsp:root>