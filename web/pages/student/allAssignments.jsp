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

				<htm:div style="width: 150px;border-right: 1px solid #CCCCCC;min-height: 400px;padding-right: 10px;">

					<af:spacer height="25" />

					<h:outputText value="Courses" styleClass="menu_title" />

					<af:spacer height="15" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAllAssignments.selectAllCourses}"
									styleClass="link">
									<h:outputText value="All Courses" styleClass="link"
										rendered="#{studentAllAssignments.activedCourse != null}" />
									<h:outputText value="All Courses" styleClass="link_hover"
										rendered="#{studentAllAssignments.activedCourse == null}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{studentAllAssignments.courses}" var="course"
						binding="#{studentAllAssignments.coursesTable}" width="100%">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{studentAllAssignments.selectCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != studentAllAssignments.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == studentAllAssignments.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

				<af:spacer width="20" />

				<htm:div style="width: 630px;">

					<af:spacer height="25" />

					<h:outputText value="Assignments" styleClass="title" />

					<af:spacer height="30" />

					<h:dataTable value="#{studentAllAssignments.submissions}"
						var="submission"
						binding="#{studentAllAssignments.submissionsTable}" width="100%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty studentAllAssignments.submissions}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Title" />
							</f:facet>
							<h:commandLink action="#{studentAllAssignments.assignmentInfo}"
								styleClass="tableLink">
								<h:outputText value="#{submission.assignment.title}"
									styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Start Date" />
							</f:facet>
							<h:commandLink action="#{studentAllAssignments.assignmentInfo}"
								styleClass="tableLink">
								<h:outputText value="#{submission.assignment.startDate}"
									styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="End Date" />
							</f:facet>
							<h:commandLink action="#{studentAllAssignments.assignmentInfo}"
								styleClass="tableLink">
								<h:outputText value="#{submission.assignment.endDate}"
									styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Status" />
							</f:facet>
							<h:commandLink action="#{studentAllAssignments.assignmentInfo}"
								styleClass="tableLink">
								<h:outputText value="Submitted"
									rendered="#{submission.submissionDate != null}"
									styleClass="tableLink" />
								<h:outputText value="Pending"
									rendered="#{submission.submissionDate == null}"
									styleClass="tableLink" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<htm:table rendered="#{empty studentAllAssignments.submissions}">
						<htm:tr>
							<htm:td>
								<h:outputText value="There are no assignments." />
							</htm:td>
						</htm:tr>
					</htm:table>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>