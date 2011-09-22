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

				<htm:div style="width: 170px;"
					rendered="#{studentAssignmentInfo.viewId == 0}">

					<af:spacer height="25" />

					<h:outputText value="Assignment" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectDefaultView}"
									styleClass="link">
									<h:outputText value="Assignment Properties" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 0}" />
									<h:outputText value="Assignment Properties"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 0}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="40" />

					<h:outputText value="Action" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/upload.png" />
						<h:commandLink action="#{studentAssignmentInfo.send}"
							styleClass="link">
							<h:outputText value="Submit Assignment" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<htm:div style="width: 170px;"
					rendered="#{studentAssignmentInfo.viewId != 0}">

					<af:spacer height="25" />

					<h:outputText value="Assignment" styleClass="menu_title" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{studentAssignmentInfo.selectAboutView}"
									styleClass="link">
									<h:outputText value="Assignment Properties" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 1}" />
									<h:outputText value="Assignment Properties"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 1}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectResultView}"
									styleClass="link">
									<h:outputText value="Evaluation Result" styleClass="link"
										rendered="#{studentAssignmentInfo.report.name != 2}" />
									<h:outputText value="Evaluation Result" styleClass="link_hover"
										rendered="#{studentAssignmentInfo.report.name == 2}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="20" />

					<h:outputText value="Reports" styleClass="menu_title"
						rendered="#{!empty studentAssignmentInfo.reports}" />

					<h:dataTable value="#{studentAssignmentInfo.tools}" var="tool"
						width="100%" rendered="#{!empty studentAssignmentInfo.reports}"
						cellpadding="0px" cellspacing="0px">
						<h:column>
							<af:spacer height="20" />
							<h:outputText value="#{tool.name} Reports"
								styleClass="menu_title" />
							<h:dataTable value="#{studentAssignmentInfo.reports}"
								var="report" binding="#{studentAssignmentInfo.reportsTable}"
								width="100%" cellpadding="0px" cellspacing="0px">
								<h:column>
									<h:commandLink rendered="#{tool.name == report.tool}"
										action="#{studentAssignmentInfo.selectReportView}"
										styleClass="link">
										<h:outputText value="#{report.name}" styleClass="link"
											rendered="#{!studentAssignmentInfo.evaluationReport}" />
										<h:outputText value="#{report.name}" styleClass="link_hover"
											rendered="#{studentAssignmentInfo.activedReport.evaluationReport}" />
									</h:commandLink>
								</h:column>
							</h:dataTable>
						</h:column>
					</h:dataTable>

					<af:spacer height="20" />

					<h:outputText value="Actions" styleClass="menu_title" />

					<h:panelGrid columns="2"
						rendered="#{studentAssignmentInfo.downloadable != null}">
						<af:image source="/images/download.png" />
						<h:outputLink value="#{studentAssignmentInfo.downloadable}"
							styleClass="link">
							<h:outputText value="Download File" styleClass="topmenu_link" />
						</h:outputLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/upload.png" />
						<h:commandLink action="#{studentAssignmentInfo.send}"
							styleClass="link">
							<h:outputText value="Submit Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/execute.png" />
						<h:commandLink action="#{studentAssignmentInfo.execute}"
							styleClass="link">
							<h:outputText value="Execute Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/evaluation.png" />
						<h:commandLink action="#{studentAssignmentInfo.evaluate}"
							styleClass="link">
							<h:outputText value="Evaluate Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="20" />

				<htm:div style="width: 600px;"
					rendered="#{studentAssignmentInfo.viewId == 0}">

					<af:spacer height="25" />

					<h:outputText value="Assignment Properties" styleClass="title" />

					<af:spacer height="25" />

					<h:outputText value="Title: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.title}" />

					<af:spacer height="10" />

					<h:outputText value="Description: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.description}" />

					<af:spacer height="10" />

					<h:outputText value="Start Date: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.startDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="Deadline: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.endDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{studentAssignmentInfo.viewId == 1}">

					<af:spacer height="25" />

					<h:outputText value="Assignment Properties" styleClass="title" />

					<af:spacer height="25" />

					<h:outputText value="Title: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.title}" />

					<af:spacer height="10" />

					<h:outputText value="Description: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.description}" />

					<af:spacer height="10" />

					<h:outputText value="Start Date: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.startDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="Deadline: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.endDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="Submission Date: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.submissionDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="Suggested Grade: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.score}" />

					<af:spacer height="10" />

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{studentAssignmentInfo.viewId == 2}">

					<af:spacer height="25" />

					<h:outputText value="#{studentAssignmentInfo.report.name}"
						styleClass="title" />

					<af:spacer height="25" />

					<h:dataTable value="#{studentAssignmentInfo.report.sections}"
						var="section" width="100%">
						<h:column>

							<h:outputText value="#{section.title}" styleClass="subtitle" />

							<af:spacer height="25" />

							<h:dataTable value="#{section.objects}" var="object" width="100%">
								<h:column>

									<h:outputText value="#{object.textValue}"
										style="background: #{object.textColor};font-family:Courier New;font-size:10pt;color:#000000;"
										rendered="#{object.type == 0}" escape="false" />

									<h:dataTable value="#{object.tableRows}" var="row"
										headerClass="tableHeader" rowClasses="tableRow" width="100%"
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

									<h:graphicImage value="#{object.figurePath}"
										rendered="#{object.type == 2}" />

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