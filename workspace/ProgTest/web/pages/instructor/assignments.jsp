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

			<h:panelGrid columns="3" style="width: 800px" columnClasses="menu">

				<htm:div style="width: 170px;">

					<af:spacer height="25" />

					<h:outputText value="Courses" styleClass="menu_title"
						rendered="#{!empty instructorAssignments.courses}" />

					<af:spacer height="5"
						rendered="#{!empty instructorAssignments.courses}" />

					<h:dataTable value="#{instructorAssignments.courses}" var="course"
						binding="#{instructorAssignments.coursesTable}" width="100%"
						rendered="#{!empty instructorAssignments.courses}">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{instructorAssignments.selectCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != instructorAssignments.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == instructorAssignments.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="40"
						rendered="#{!empty instructorAssignments.courses}" />

					<h:outputText value="Actions" styleClass="menu_title"
						rendered="#{instructorAssignments.activedCourse != null}" />

					<af:spacer height="10"
						rendered="#{instructorAssignments.activedCourse != null}" />

					<h:panelGrid columns="2"
						rendered="#{instructorAssignments.activedCourse != null}">
						<af:image source="/images/create.png" />
						<h:commandLink action="#{instructorAssignments.create}"
							styleClass="link">
							<h:outputText value="Create New Assignment" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2"
						rendered="#{instructorAssignments.activedCourse != null}">
						<af:image source="/images/create.png" />
						<h:commandLink action="#{instructorAssignments.add}"
							styleClass="link">
							<h:outputText value="Add New Assignment" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="60" />

				<htm:div style="width: 570px;"
					rendered="#{!empty instructorAssignments.assignments}">

					<af:spacer height="20" />

					<h:outputText value="Assignments" styleClass="title" />

					<af:spacer height="20" />

					<t:dataList value="#{instructorAssignments.assignments}"
						var="assignment"
						binding="#{instructorAssignments.assignmentsTable}"
						layout="orderedList">
						<h:column>
							<h:commandLink action="#{instructorAssignments.view}" styleClass="link">
								<h:outputText value="#{assignment.title}" styleClass="link" />
								<af:spacer height="10" />
							</h:commandLink>
						</h:column>
					</t:dataList>

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{empty instructorAssignments.assignments}">

					<af:spacer height="20" />

					<h:outputText value="Assignments" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="No courses selected."
						rendered="#{instructorAssignments.activedCourse == null}" />

					<h:outputText value="There is no assignment in this course"
						rendered="#{instructorAssignments.activedCourse != null}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>