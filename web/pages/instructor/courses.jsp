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

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{instructorCourses.selectAllCourses}"
									styleClass="link">
									<h:outputText value="All Courses" styleClass="link"
										rendered="#{course != null}" />
									<h:outputText value="All Courses" styleClass="link_hover"
										rendered="#{course == null}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{instructorCourses.courses}" var="course"
						binding="#{instructorCourses.coursesMenu}" width="100%"
						rendered="#{!empty instructorCourses.courses}">
						<h:column>
							<af:spacer height="5" />
							<h:commandLink action="#{instructorCourses.selectMenuCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != instructorCourses.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == instructorCourses.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="40" />

					<h:outputText value="Actions" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/create.png" />
						<h:commandLink action="#{instructorCourses.create}"
							styleClass="link">
							<h:outputText value="New Course" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2"
						rendered="#{instructorCourses.course != null}">
						<af:image source="/images/edit.png" />
						<h:commandLink action="#{instructorCourses.edit}"
							styleClass="link">
							<h:outputText value="Edit Course" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2"
						rendered="#{instructorCourses.course != null}">
						<af:image source="/images/remove.png" />
						<h:commandLink action="#{instructorCourses.remove}"
							styleClass="link">
							<h:outputText value="Remove Course" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="50" />

				<htm:div style="width: 570px;"
					rendered="#{instructorCourses.course == null}">

					<af:spacer height="25" />

					<h:outputText value="All Courses" styleClass="title" />

					<af:spacer height="25" />

					<h:dataTable value="#{instructorCourses.courses}" var="course"
						binding="#{instructorCourses.coursesTable}" width="100%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty instructorCourses.courses}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Course" />
							</f:facet>
							<h:commandLink action="#{instructorCourses.selectTableCourse}"
								styleClass="tableLink">
								<h:outputText value="#{course.name}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Start Date" />
							</f:facet>
							<h:commandLink action="#{instructorCourses.selectTableCourse}"
								styleClass="tableLink">
								<h:outputText value="#{course.startDate}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="End Date" />
							</f:facet>
							<h:commandLink action="#{instructorCourses.selectTableCourse}"
								styleClass="tableLink">
								<h:outputText value="#{course.endDate}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<t:dataList value="#{instructorAssignments.assignments}" var="assignment"
						binding="#{instructorAssignments.assignmentsTable}"
						rendered="#{!empty instructorAssignments.assignments}">
						<t:column>
							<h:commandLink action="#{instructorAssignments.view}"
								styleClass="tableLink">
								<h:outputText value="#{asignment.title}" styleClass="tableLink" />
							</h:commandLink>
						</t:column>
					</t:dataList>

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{instructorCourses.course != null}">

					<af:spacer height="25" />

					<h:outputText value="#{instructorCourses.course.name}"
						styleClass="title" />

					<af:spacer height="25" />

					<h:outputText value="Name: " styleClass="label" />
					<h:outputText value="#{instructorCourses.course.name}" />

					<af:spacer height="10" />

					<h:outputText value="Start Date: " styleClass="label" />
					<h:outputText value="#{instructorCourses.course.startDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="End Date: " styleClass="label" />
					<h:outputText value="#{instructorCourses.course.endDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>