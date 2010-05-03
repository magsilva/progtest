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
						rendered="#{!empty instructorCourses.courses}" />

					<af:spacer height="5"
						rendered="#{!empty instructorCourses.courses}" />

					<h:dataTable value="#{instructorCourses.courses}" var="course"
						binding="#{instructorCourses.coursesTable}" width="100%"
						rendered="#{!empty instructorCourses.courses}">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{instructorCourses.selectCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != instructorCourses.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == instructorCourses.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="40"
						rendered="#{!empty instructorCourses.courses}" />

					<h:outputText value="Actions" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/create.png" />
						<h:commandLink action="#{instructorCourses.create}"
							styleClass="link">
							<h:outputText value="Create New Course" styleClass="topmenu_link" />
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

				<af:spacer width="60" />

				<htm:div style="width: 570px;"
					rendered="#{instructorCourses.course != null}">

					<af:spacer height="20" />

					<h:outputText value="Course Properties" styleClass="title" />

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

					<af:spacer height="10" />

					<h:outputText value="Instructor: " styleClass="label" />
					<h:outputText value="#{instructorCourses.course.instructor.name}" />

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{instructorCourses.course == null}">

					<af:spacer height="20" />

					<h:outputText value="Course Properties" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="No course selected." />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>