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
								<h:commandLink action="#{instructorHome.selectAllCourses}"
									styleClass="link">
									<h:outputText value="All Courses" styleClass="link"
										rendered="#{course != null}" />
									<h:outputText value="All Courses" styleClass="link_hover"
										rendered="#{course == null}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{instructorHome.courses}" var="course"
						binding="#{instructorHome.coursesMenu}" width="100%"
						rendered="#{!empty instructorHome.courses}">
						<h:column>
							<af:spacer height="5" />
							<h:commandLink action="#{instructorHome.selectMenuCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != instructorHome.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == instructorHome.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText value="Actions" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/create.png" />
						<h:commandLink action="#{instructorHome.newCourse}"
							styleClass="link">
							<h:outputText value="New Course" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2"
						rendered="#{instructorHome.course != null}">
						<af:image source="/images/create_assignment.png" />
						<h:commandLink action="#{instructorHome.newAssignment}"
							styleClass="link">
							<h:outputText value="New Assignment" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2"
						rendered="#{instructorHome.course != null}">
						<af:image source="/images/add_student.png" />
						<h:commandLink action="#{instructorHome.newStudent}"
							styleClass="link">
							<h:outputText value="New Student" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2"
						rendered="#{instructorHome.course != null}">
						<af:image source="/images/edit.png" />
						<h:commandLink action="#{instructorHome.editCourse}"
							styleClass="link">
							<h:outputText value="Edit Course" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2"
						rendered="#{instructorHome.course != null}">
						<af:image source="/images/remove.png" />
						<h:commandLink action="#{instructorHome.removeCourse}"
							styleClass="link">
							<h:outputText value="Remove Course" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorHome.course == null}">

					<af:spacer height="25" />

					<h:outputText value="All Courses" styleClass="title" />

					<af:spacer height="25" />

					<h:outputText value="Please, create a course to start!"
						rendered="#{empty instructorHome.courses}" />

					<h:dataTable value="#{instructorHome.courses}" var="course"
						binding="#{instructorHome.coursesTable}" width="96%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty instructorHome.courses}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Name" />
							</f:facet>
							<h:commandLink action="#{instructorHome.selectTableCourse}"
								styleClass="tableLink">
								<h:outputText value="#{course.name}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Start Date" />
							</f:facet>
							<h:commandLink action="#{instructorHome.selectTableCourse}"
								styleClass="tableLink">
								<h:outputText value="#{course.startDate}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="End Date" />
							</f:facet>
							<h:commandLink action="#{instructorHome.selectTableCourse}"
								styleClass="tableLink">
								<h:outputText value="#{course.endDate}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorHome.course != null}">

					<af:spacer height="25" />

					<h:outputText value="#{instructorHome.course.name}"
						styleClass="title" />

					<af:spacer height="5" />

					<h:outputText value="Start Date: " styleClass="label" />
					<h:outputText value="#{instructorHome.course.startDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer width="25" />

					<h:outputText value="End Date: " styleClass="label" />
					<h:outputText value="#{instructorHome.course.endDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="30" />

					<h:outputText value="Assignments" styleClass="subtitle" />

					<af:spacer height="15" />

					<h:outputText value="Any assignmnets in this course!"
						rendered="#{empty instructorHome.assignments}" />

					<h:dataTable value="#{instructorHome.assignments}" var="assignment"
						binding="#{instructorHome.assignmentsTable}" width="96%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty instructorHome.assignments}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Title" />
							</f:facet>
							<h:commandLink action="#{instructorHome.viewAssignment}"
								styleClass="tableLink">
								<h:outputText value="#{assignment.title}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Start Date" />
							</f:facet>
							<h:commandLink action="#{instructorHome.viewAssignment}"
								styleClass="tableLink">
								<h:outputText value="#{assignment.startDate}"
									styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="End Date" />
							</f:facet>
							<h:commandLink action="#{instructorHome.viewAssignment}"
								styleClass="tableLink">
								<h:outputText value="#{assignment.endDate}"
									styleClass="tableLink" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText value="Students" styleClass="subtitle" />

					<af:spacer height="15" />

					<h:outputText value="Any students in this course!"
						rendered="#{empty instructorHome.students}" />

					<h:dataTable value="#{instructorHome.students}" var="student"
						binding="#{instructorHome.studentsTable}" width="96%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty instructorHome.students}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Username" />
							</f:facet>
							<h:commandLink action="#{instructorHome.viewStudent}"
								styleClass="tableLink">
								<h:outputText value="#{student.userName}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Name" />
							</f:facet>
							<h:commandLink action="#{instructorHome.viewStudent}"
								styleClass="tableLink">
								<h:outputText value="#{student.name}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="E-mail" />
							</f:facet>
							<h:commandLink action="#{instructorHome.viewStudent}"
								styleClass="tableLink">
								<h:outputText value="#{student.email}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>