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
								<h:commandLink
									action="#{instructorStudents.selectAllCourses}"
									styleClass="link">
									<h:outputText value="All Courses" styleClass="link"
										rendered="#{course != null}" />
									<h:outputText value="All Courses" styleClass="link_hover"
										rendered="#{course == null}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{instructorStudents.courses}" var="course"
						binding="#{instructorStudents.coursesMenu}" width="100%"
						rendered="#{!empty instructorStudents.courses}">
						<h:column>
							<af:spacer height="5" />
							<h:commandLink action="#{instructorStudents.selectMenuCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != instructorStudents.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == instructorStudents.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="40" />

					<h:outputText value="Actions" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/create.png" />
						<h:commandLink action="#{instructorStudents.add}"
							styleClass="link">
							<h:outputText value="New Student" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="50" />

				<htm:div style="width: 570px;"
					rendered="#{!empty instructorStudents.students}">

					<af:spacer height="25" />

					<h:outputText value="All Students" styleClass="title"
						rendered="#{instructorStudents.activedCourse == null}" />
					<h:outputText
						value="Students in #{instructorStudents.activedCourse}"
						styleClass="title"
						rendered="#{instructorStudents.activedCourse != null}" />

					<af:spacer height="25" />

					<h:dataTable value="#{instructorStudents.students}"
						var="student"
						binding="#{instructorStudents.studentsTable}" width="100%"
						rowClasses="tableRow" headerClass="tableHeader">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Username" />
							</f:facet>
							<h:commandLink action="#{instructorStudents.view}"
								styleClass="tableLink">
								<h:outputText value="#{student.userName}" styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Name" />
							</f:facet>
							<h:commandLink action="#{instructorStudents.view}"
								styleClass="tableLink">
								<h:outputText value="#{student.name}"
									styleClass="tableLink" />
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="E-mail" />
							</f:facet>
							<h:commandLink action="#{instructorStudents.view}"
								styleClass="tableLink">
								<h:outputText value="#{student.email}"
									styleClass="tableLink" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{empty instructorStudents.students}">

					<af:spacer height="25" />

					<h:outputText value="All Students" styleClass="title"
						rendered="#{instructorStudents.activedCourse == null}" />
					<h:outputText
						value="Students in #{instructorStudents.activedCourse}"
						styleClass="title"
						rendered="#{instructorStudents.activedCourse != null}" />

					<af:spacer height="25" />

					<h:outputText value="There aren't any student." />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>