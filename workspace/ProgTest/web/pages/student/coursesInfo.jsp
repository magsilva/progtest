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
					
					<af:spacer height="10" />

					<h:dataTable value="#{studentCoursesInfo.courses}" var="course"
						binding="#{studentCoursesInfo.coursesTable}" width="100%">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{studentCoursesInfo.selectCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != studentCoursesInfo.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == studentCoursesInfo.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

				<af:spacer width="15" />

				<htm:div style="width: 615px;"
					rendered="#{studentCoursesInfo.course != null}">

					<af:spacer height="20" />

					<h:outputText value="Course Properties"
						styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Name: " styleClass="label" />
					<h:outputText value="#{studentCoursesInfo.course.name}" />

					<af:spacer height="10" />

					<h:outputText value="Start Date: " styleClass="label" />
					<h:outputText value="#{studentCoursesInfo.course.startDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="End Date: " styleClass="label" />
					<h:outputText value="#{studentCoursesInfo.course.endDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="Instructor: " styleClass="label" />
					<h:outputText value="#{studentCoursesInfo.course.instructor.name}" />

					<af:spacer height="10" />

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentCoursesInfo.course == null}">

					<af:spacer height="20" />

					<h:outputText value="Course Properties"
						styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="No course selected." />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>