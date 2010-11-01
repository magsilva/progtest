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

					<h:outputText value="Assignment" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{instructorAssignment.selectAboutView}"
									styleClass="link">
									<h:outputText value="Assignment Properties" styleClass="link"
										rendered="#{instructorAssignment.viewId != 0}" />
									<h:outputText value="Assignment Properties"
										styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 0}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{instructorAssignment.selectGradesView}"
									styleClass="link">
									<h:outputText value="Grades" styleClass="link"
										rendered="#{instructorAssignment.viewId != 1}" />
									<h:outputText value="Grades" styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 1}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="30" />

					<h:outputText value="Reports" styleClass="menu_title"
						rendered="#{!empty instructorAssignment.files}" />

					<h:dataTable value="#{instructorAssignment.files}" var="file"
						binding="#{instructorAssignment.filesTable}" width="100%"
						rendered="#{!empty instructorAssignment.files}">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{instructorAssignment.selectReportView}"
								styleClass="link">
								<h:outputText value="#{file.name}" styleClass="link"
									rendered="#{file.name != instructorAssignment.activedReport}" />
								<h:outputText value="#{file.name}" styleClass="link_hover"
									rendered="#{file.name == instructorAssignment.activedReport}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText value="Actions" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/edit.png" />
						<h:commandLink action="#{instructorAssignment.edit}"
							styleClass="link">
							<h:outputText value="Edit Assignment" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/remove.png" />
						<h:commandLink action="#{instructorAssignment.remove}"
							styleClass="link">
							<h:outputText value="Remove Assignment" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="60" />

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 0}">

					<af:spacer height="20" />

					<h:outputText value="Assignment Properties" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Title: " styleClass="label" />
					<h:outputText value="#{instructorAssignment.title}" />

					<af:spacer height="10" />

					<h:outputText value="Description: " styleClass="label" />
					<h:outputText value="#{instructorAssignment.description}" />

					<af:spacer height="10" />

					<h:outputText value="Start Date: " styleClass="label" />
					<h:outputText value="#{instructorAssignment.startDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="Deadline: " styleClass="label" />
					<h:outputText value="#{instructorAssignment.endDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 1}">

					<af:spacer height="20" />

					<h:outputText value="Grade" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{instructorAssignment.submissions}"
						var="submission"
						binding="#{instructorAssignment.submissionsTable}" width="100%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty instructorAssignment.submissions}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Student" />
							</f:facet>
							<h:outputText value="#{submission.student.userName}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Name" />
							</f:facet>
							<h:outputText value="#{submission.student.name}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Grade" />
							</f:facet>
							<h:outputText value="#{submission.score}" />
						</h:column>
					</h:dataTable>

					<h:outputText value="No students in the course."
						rendered="#{empty instructorAssignment.submissions}" />

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 2}">

					<af:spacer height="20" />

					<h:outputText value="#{instructorAssignment.report.name}" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{instructorAssignment.report.records}" var="record"
						headerClass="tableHeader"
						binding="#{instructorAssignment.reportTable}"
						rowClasses="tableRow" width="100%">
						<h:column rendered="#{instructorAssignment.report.header.column1 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column1}" />
							</f:facet>
							<h:outputText value="#{record.column1}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column2 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column2}" />
							</f:facet>
							<h:outputText value="#{record.column2}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column3 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column3}" />
							</f:facet>
							<h:outputText value="#{record.column3}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column4 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column4}" />
							</f:facet>
							<h:outputText value="#{record.column4}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column5 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column5}" />
							</f:facet>
							<h:outputText value="#{record.column5}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column6 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column6}" />
							</f:facet>
							<h:outputText value="#{record.column6}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column7 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column7}" />
							</f:facet>
							<h:outputText value="#{record.column7}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column8 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column8}" />
							</f:facet>
							<h:outputText value="#{record.column8}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column9 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column9}" />
							</f:facet>
							<h:outputText value="#{record.column9}" />
						</h:column>
						<h:column rendered="#{instructorAssignment.report.header.column10 != null}">
							<f:facet name="header">
								<h:outputText value="#{instructorAssignment.report.header.column10}" />
							</f:facet>
							<h:outputText value="#{record.column10}" />
						</h:column>
					</h:dataTable>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>