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

			<h:panelGrid columns="2" style="width: 800px" columnClasses="menu">

				<htm:div
					style="width: 150px; padding-left: 10px; padding-right: 20px; border-right: 1px solid #CCCCCC; border-left: 1px solid #CCCCCC; min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText value="Courses" styleClass="menu_title" />

					<af:spacer height="15" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentHome.selectAllCourses}" styleClass="link">
									<h:outputText value="All Courses" styleClass="link"
										rendered="#{studentHome.activedCourse != null}" />
									<h:outputText value="All Courses" styleClass="link_hover"
										rendered="#{studentHome.activedCourse == null}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{studentHome.courses}" var="course"
						binding="#{studentHome.coursesTable}" width="100%">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink
								action="#{studentHome.selectCourse}" styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != studentHome.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == studentHome.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText value="Assignments" styleClass="title" />

					<af:spacer height="30" />

					<h:dataTable value="#{studentHome.submissions}" var="submission"
						binding="#{studentHome.submissionsTable}" width="96%"
						rendered="#{!empty studentHome.submissions}">
						<h:column>
							<htm:table styleClass="grid">
								<htm:tr styleClass="tableHeader">
									<htm:td>
										<h:outputText value="#{submission.assignment.title}" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="10" />
										<h:outputText value="#{submission.assignment.description}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="5" />
										<h:outputText value="Deadline: " styleClass="label" />
										<h:outputText value="#{submission.assignment.endDate}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="5" />
										<h:outputText value="Status: " styleClass="label" />
										<h:outputText value="Submitted"
											rendered="#{submission.submissionDate != null}" />
										<h:outputText value="Pending"
											rendered="#{submission.submissionDate == null}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr align="right">
									<htm:td>
										<h:commandButton value="Submit"
											action="#{studentHome.submitAssignment}"
											rendered="#{submission.submissionDate == null}" />
										<af:spacer width="5" />
										<h:commandButton value="View"
											action="#{studentHome.assignmentInfo}"
											rendered="#{submission.submissionDate != null}" />
									</htm:td>
								</htm:tr>
							</htm:table>
							<af:spacer height="20" />
						</h:column>
					</h:dataTable>

					<htm:table rendered="#{empty studentHome.submissions}">
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