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

			<h:outputText value="Add Students" styleClass="title" />

			<af:spacer height="20" />

			<h:outputText
				value="Select the students that you want to add to the course."
				rendered="#{!empty instructorAddStudents.students}" />

			<af:spacer height="20"
				rendered="#{!empty instructorAddStudents.students}" />

			<h:selectManyCheckbox
				value="#{instructorAddStudents.selectedStudents}"
				layout="pageDirection"
				rendered="#{!empty instructorAddStudents.students}">
				<f:selectItems value="#{instructorAddStudents.students}" />
			</h:selectManyCheckbox>

			<h:outputText value="No student found."
				rendered="#{empty instructorAddStudents.students}" />

			<af:spacer height="30" />

			<h:commandButton value="Cancel"
				action="#{instructorAddStudents.cancel}" />
			<h:commandButton value="Finalize"
				action="#{instructorAddStudents.add}"
				rendered="#{!empty instructorAddStudents.students}" />

		</h:form>

	</f:subview>
</jsp:root>