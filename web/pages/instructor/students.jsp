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
						rendered="#{!empty instructorStudents.courses}" />

					<af:spacer height="5"
						rendered="#{!empty instructorStudents.courses}" />

					<h:dataTable value="#{instructorStudents.courses}" var="course"
						binding="#{instructorStudents.coursesTable}" width="100%"
						rendered="#{!empty instructorStudents.courses}">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{instructorStudents.selectCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != instructorStudents.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == instructorStudents.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="40"
						rendered="#{!empty instructorStudents.courses}" />

					<h:outputText value="Actions" styleClass="menu_title"
						rendered="#{instructorStudents.activedCourse != null}" />

					<af:spacer height="10"
						rendered="#{instructorStudents.activedCourse != null}" />

					<h:panelGrid columns="2"
						rendered="#{instructorStudents.activedCourse != null}">
						<af:image source="/images/register.png" />
						<h:commandLink action="#{instructorStudents.register}"
							styleClass="link">
							<h:outputText value="Register New Student" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2"
						rendered="#{instructorStudents.activedCourse != null}">
						<af:image source="/images/create.png" />
						<h:commandLink action="#{instructorStudents.add}"
							styleClass="link">
							<h:outputText value="Add New Student" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="60" />

				<htm:div style="width: 570px;"
					rendered="#{!empty instructorStudents.students}">

					<af:spacer height="20" />

					<h:outputText value="Students" styleClass="title" />

					<af:spacer height="20" />

					<t:dataList value="#{instructorStudents.students}"
						var="student"
						binding="#{instructorStudents.studentsTable}"
						layout="orderedList">
						<h:column>
							<h:commandLink action="#{instructorStudents.view}" styleClass="link">
								<h:outputText value="#{student.name}" styleClass="link"/>
								<af:spacer height="10" />
							</h:commandLink>
						</h:column>
					</t:dataList>

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{empty instructorStudents.students}">

					<af:spacer height="20" />

					<h:outputText value="Students" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="No course selected."
						rendered="#{instructorStudents.activedCourse == null}" />

					<h:outputText value="There is no student in this course."
						rendered="#{instructorStudents.activedCourse != null}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>