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

				<h:commandLink action="#{instructorAssignment.back}"
					styleClass="topmenu_link">
					<h:outputText value="&lt;&lt; Back to Courses"
						styleClass="topmenu_link" />
				</h:commandLink>

			</htm:div>

			<h:panelGrid columns="2" style="width: 800px;" columnClasses="menu">

				<htm:div
					style="width: 150px; padding-right: 10px; padding-left: 10px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC; min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText value="Assignment" styleClass="menu_title" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{instructorAssignment.selectAboutView}"
									styleClass="link">
									<h:outputText value="Properties" styleClass="link"
										rendered="#{instructorAssignment.viewId != 0}" />
									<h:outputText value="Properties" styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 0}" />
								</h:commandLink>
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
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{instructorAssignment.tools}" var="tool"
						width="100%" rendered="#{!empty instructorAssignment.reports}"
						cellpadding="0" cellspacing="0">
						<h:column>
							<af:spacer height="20" />
							<h:outputText value="#{tool.name} Reports"
								styleClass="menu_title" />
							<h:dataTable value="#{instructorAssignment.reports}" var="report"
								binding="#{instructorAssignment.reportsTable}" width="100%"
								cellpadding="0" cellspacing="0">
								<h:column>
									<h:commandLink rendered="#{tool.name == report.tool}"
										action="#{instructorAssignment.selectReportView}"
										styleClass="link">
										<h:outputText value="#{report.name}" styleClass="link"
											rendered="#{instructorAssignment.report.name != report.name}" />
										<h:outputText value="#{report.name}" styleClass="link_hover"
											rendered="#{instructorAssignment.report.name == report.name}" />
									</h:commandLink>
								</h:column>
							</h:dataTable>
						</h:column>
					</h:dataTable>

					<af:spacer height="20" />

					<h:outputText value="Actions" styleClass="menu_title" />

					<h:panelGrid columns="2"
						rendered="#{instructorAssignment.downloadable != null}">
						<af:image source="/images/download.png" />
						<h:outputLink value="#{instructorAssignment.downloadable}"
							styleClass="link">
							<h:outputText value="Download File" styleClass="topmenu_link" />
						</h:outputLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/edit.png" />
						<h:commandLink action="#{instructorAssignment.edit}"
							styleClass="link">
							<h:outputText value="Edit Assignment" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/execute.png" />
						<h:commandLink
							onclick="document.getElementById('hidepage').style.visibility = 'visible';"
							action="#{instructorAssignment.execute}" styleClass="link">
							<h:outputText value="Execute Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/evaluation.png" />
						<h:commandLink
							onclick="document.getElementById('hidepage').style.visibility = 'visible';"
							action="#{instructorAssignment.evaluate}" styleClass="link">
							<h:outputText value="Evaluate Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/remove.png" />
						<h:commandLink
							action="#{instructorAssignment.remove}" styleClass="link">
							<h:outputText value="Remove Assignment" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<htm:div
					style="width: 595px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorAssignment.viewId == 0}">

					<af:spacer height="25" />

					<h:outputText value="Assignment Properties" styleClass="title" />

					<af:spacer height="25" />

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

				<htm:div
					style="width: 595px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorAssignment.viewId == 1}">

					<af:spacer height="25" />

					<h:outputText value="Grade" styleClass="title" />

					<af:spacer height="25" />

					<h:dataTable value="#{instructorAssignment.submissions}"
						var="submission"
						binding="#{instructorAssignment.submissionsTable}" width="96%"
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
							<h:outputText value="#{submission.grade}" />
						</h:column>
					</h:dataTable>

					<h:outputText value="No students in the course."
						rendered="#{empty instructorAssignment.submissions}" />

				</htm:div>

				<htm:div
					style="width: 595px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorAssignment.viewId == 2}">

					<af:spacer height="25" />

					<h:outputText
						value="#{instructorAssignment.title} Program &gt; #{instructorAssignment.report.name}"
						styleClass="title" />

					<af:spacer height="25" />

					<h:dataTable value="#{instructorAssignment.report.sections}"
						var="section" width="100%">
						<h:column>

							<h:outputText value="#{section.title}" styleClass="subtitle" />

							<af:spacer height="25" />

							<h:dataTable value="#{section.objects}" var="object" width="100%">
								<h:column>

									<h:outputText value="#{object.textValue}"
										style="background: #{object.textColor};font-family:Courier New;font-size:10pt;color:#000000"
										rendered="#{object.type == 0}" escape="false" />

									<h:dataTable value="#{object.tableRows}" var="row"
										headerClass="tableHeader" rowClasses="tableRow" width="95%"
										rendered="#{object.type == 1}">
										<h:column rendered="#{object.tableHeader.column1 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column1}" />
											</f:facet>
											<h:outputText value="#{row.column1}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column2 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column2}" />
											</f:facet>
											<h:outputText value="#{row.column2}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column3 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column3}" />
											</f:facet>
											<h:outputText value="#{row.column3}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column4 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column4}" />
											</f:facet>
											<h:outputText value="#{row.column4}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column5 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column5}" />
											</f:facet>
											<h:outputText value="#{row.column5}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column6 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column6}" />
											</f:facet>
											<h:outputText value="#{row.column6}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column7 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column7}" />
											</f:facet>
											<h:outputText value="#{row.column7}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column8 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column8}" />
											</f:facet>
											<h:outputText value="#{row.column8}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column9 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column9}" />
											</f:facet>
											<h:outputText value="#{row.column9}" />
										</h:column>
										<h:column rendered="#{object.tableHeader.column10 != null}">
											<f:facet name="header">
												<h:outputText value="#{object.tableHeader.column10}" />
											</f:facet>
											<h:outputText value="#{row.column10}" />
										</h:column>
									</h:dataTable>

									<af:spacer height="10" rendered="#{object.type == 2}" />

									<htm:center rendered="#{object.type == 2}">
										<h:graphicImage value="#{object.figurePath}"
											rendered="#{object.type == 2}" />
									</htm:center>

									<af:spacer height="10" rendered="#{object.type == 0}" />

									<af:spacer height="25" rendered="#{object.type == 1}" />

								</h:column>
							</h:dataTable>

							<af:spacer height="25" />

						</h:column>
					</h:dataTable>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>