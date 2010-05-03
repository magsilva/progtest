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

					<h:outputText value="Courses" styleClass="menu_title" />

					<af:spacer height="15" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentOutstandingAssignments.selectAllCourses}"
									styleClass="link">
									<h:outputText value="All courses" styleClass="link"
										rendered="#{studentOutstandingAssignments.activedCourse != null}" />
									<h:outputText value="All courses" styleClass="link_hover"
										rendered="#{studentOutstandingAssignments.activedCourse == null}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{studentOutstandingAssignments.courses}"
						var="course"
						binding="#{studentOutstandingAssignments.coursesTable}"
						width="100%">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink
								action="#{studentOutstandingAssignments.selectCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != studentOutstandingAssignments.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == studentOutstandingAssignments.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

				<af:spacer width="15" />

				<htm:div style="width: 615px;">

					<af:spacer height="20" />

					<h:outputText value="Pending Assignments" styleClass="title" />

					<af:spacer height="30" />

					<h:dataTable value="#{studentOutstandingAssignments.evaluations}"
						var="avaliation"
						binding="#{studentOutstandingAssignments.evaluationsTable}"
						width="100%"
						rendered="#{!empty studentOutstandingAssignments.evaluations}">
						<h:column>
							<htm:table styleClass="grid">
								<htm:tr styleClass="tableHeader">
									<htm:td>
										<h:outputText value="#{avaliation.assignment.title}" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="10" />
										<h:outputText value="#{avaliation.assignment.description}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="5" />
										<h:outputText value="Deadline: " styleClass="label" />
										<h:outputText value="#{avaliation.assignment.endDate}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="5" />
										<h:outputText value="Status: " styleClass="label" />
										<h:outputText value="Sent"
											rendered="#{avaliation.submissionDate != null}" />
										<h:outputText value="Pending"
											rendered="#{avaliation.submissionDate == null}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr align="right">
									<htm:td>
										<h:commandButton value="Send"
											action="#{studentOutstandingAssignments.submitAssignment}" />
										<af:spacer width="5" />
										<h:commandButton value="View"
											action="#{studentOutstandingAssignments.assignmentInfo}" />
									</htm:td>
								</htm:tr>
							</htm:table>
							<af:spacer height="20" />
						</h:column>
					</h:dataTable>

					<htm:table
						rendered="#{empty studentOutstandingAssignments.evaluations}">
						<htm:tr>
							<htm:td>
								<h:outputText value="There are no pending assignments." />
							</htm:td>
						</htm:tr>
					</htm:table>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>