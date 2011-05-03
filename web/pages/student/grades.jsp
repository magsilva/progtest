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

					<h:outputText value="Courses" styleClass="menu_title" />

					<af:spacer height="15" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{studentGrades.selectAllCourses}"
									styleClass="link">
									<h:outputText value="All Courses" styleClass="link"
										rendered="#{studentGrades.activedCourse != null}" />
									<h:outputText value="All Courses" styleClass="link_hover"
										rendered="#{studentGrades.activedCourse == null}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{studentGrades.courses}" var="course"
						binding="#{studentGrades.coursesTable}" width="100%">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{studentGrades.selectCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != studentGrades.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == studentGrades.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

				<af:spacer width="20" />

				<htm:div style="width: 600px;">

					<af:spacer height="25" />

					<h:outputText value="Grades" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentGrades.submissions}" var="submission"
						binding="#{studentGrades.submissionsTable}" width="100%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty studentGrades.submissions}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Assignments" />
							</f:facet>
							<h:outputText value="#{submission.assignment.title}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Grade" />
							</f:facet>
							<h:outputText value="#{submission.score}" />
						</h:column>
					</h:dataTable>

					<h:outputText value="There are no assignments in this course."
						rendered="#{empty studentGrades.submissions}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>