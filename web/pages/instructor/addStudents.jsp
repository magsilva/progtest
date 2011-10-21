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
		
			<htm:div style="width: 800px; text-align: left">

				<af:spacer height="20" />

				<af:spacer width="5" />

				<h:commandLink
					action="#{instructorAddStudents.back}" styleClass="topmenu_link">
					<h:outputText value="&lt;&lt; Back to Courses"
						styleClass="topmenu_link" />
				</h:commandLink>

			</htm:div>

			<h:panelGrid columns="2" style="width: 800px" columnClasses="menu">

				<htm:div
					style="width: 150px; padding-left: 10px; padding-right: 20px; border-right: 1px solid #CCCCCC; border-left: 1px solid #CCCCCC; min-height: 400px;">

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

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText value="Add Students" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Search and select the students that you want to add to the course." />

					<af:spacer height="20" />

					<h:inputText value="#{instructorAddStudents.keyword}" />

					<h:commandButton value="Search"
						action="#{instructorAddStudents.search}" />

					<af:spacer height="20" />

					<h:selectManyCheckbox disabled="true"
						value="#{instructorAddStudents.selectedStudents}"
						layout="pageDirection"
						rendered="#{!empty instructorAddStudents.enrolledStudents}">
						<f:selectItems value="#{instructorAddStudents.enrolledStudents}" />
					</h:selectManyCheckbox>

					<h:selectManyCheckbox
						value="#{instructorAddStudents.selectedStudents}"
						layout="pageDirection"
						rendered="#{!empty instructorAddStudents.students}"
						onchange="submit()"
						valueChangeListener="#{instructorAddStudents.change}">
						<f:selectItems value="#{instructorAddStudents.students}" />
					</h:selectManyCheckbox>

					<h:outputText value="No student found."
						rendered="#{empty instructorAddStudents.students and empty instructorAddStudents.enrolledStudents}" />

					<af:spacer height="30" />

					<h:commandButton value="Cancel"
						action="#{instructorAddStudents.cancel}" />
					<h:commandButton value="Finalize"
						action="#{instructorAddStudents.add}"
						disabled="#{empty instructorAddStudents.selectedStudents}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>