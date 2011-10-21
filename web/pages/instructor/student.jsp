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

			<htm:div style="width: 800px; text-align: left">

				<af:spacer height="20" />

				<af:spacer width="5" />

				<h:commandLink action="#{instructorStudent.back}"
					styleClass="topmenu_link">
					<h:outputText value="&lt;&lt; Back to Courses"
						styleClass="topmenu_link" />
				</h:commandLink>

			</htm:div>

			<h:panelGrid columns="2" style="width: 800px" columnClasses="menu">

				<htm:div
					style="width: 150px; padding-left: 10px; padding-right: 20px; border-right: 1px solid #CCCCCC; border-left: 1px solid #CCCCCC; min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText value="Action" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/remove.png" />
						<h:commandLink action="#{instructorStudent.remove}"
							styleClass="link">
							<h:outputText value="Remove Student" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText value="#{instructorStudent.name}"
						styleClass="title" />

					<af:spacer height="3" />

					<h:outputText value="Username: " styleClass="label" />
					<h:outputText value="#{instructorStudent.userName}" />

					<af:spacer width="25" />

					<h:outputText value="E-mail: " styleClass="label" />
					<h:outputText value="#{instructorStudent.email}" />

					<af:spacer height="30" />
					
					<h:outputText value="Grades" styleClass="subtitle" />

					<af:spacer height="15" />

					<h:outputText value="There is no assignment for this student."
						rendered="#{empty instructorStudent.submissions}" />

					<h:dataTable value="#{instructorStudent.submissions}" var="submission"
						binding="#{instructorStudent.submissionsTable}" width="96%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty instructorStudent.submissions}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Assignment" />
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

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>