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

			<h:panelGrid columns="4" style="width: 800px" columnClasses="menu">

				<af:spacer width="10" />

				<htm:div style="width: 170px;">

					<af:spacer height="25" />

					<h:outputText value="Actions" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/create.png" />
						<h:commandLink action="#{instructorAddStudents.register}"
							styleClass="link">
							<h:outputText value="Register Student" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="50" />

				<htm:div style="width: 570px;">

					<af:spacer height="25" />

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

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>