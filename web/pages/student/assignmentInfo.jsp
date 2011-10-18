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

				<h:commandLink
					action="#{studentAssignmentInfo.back}" styleClass="topmenu_link">
					<h:outputText value="&lt;&lt; Back to Assignments"
						styleClass="topmenu_link" />
				</h:commandLink>

			</htm:div>

			<h:panelGrid columns="2" style="width: 800px;" columnClasses="menu">

				<htm:div
					style="width: 150px; padding-right: 10px; padding-left: 10px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC; min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText value="Reports for" styleClass="menu_title" />

					<af:spacer height="0" />

					<h:commandLink
						action="#{studentAssignmentInfo.selectPsTsReports}"
						styleClass="link">
						<h:outputText value="Student Tests" styleClass="link"
							rendered="#{studentAssignmentInfo.instructorTests}" />
						<h:outputText value="Student Tests" styleClass="link_hover"
							rendered="#{!studentAssignmentInfo.instructorTests}" />
					</h:commandLink>

					<af:spacer height="0" />

					<h:commandLink
						action="#{studentAssignmentInfo.selectPsTiReports}"
						styleClass="link">
						<h:outputText value="Instructor Tests" styleClass="link"
							rendered="#{!studentAssignmentInfo.instructorTests}" />
						<h:outputText value="Instructor Tests" styleClass="link_hover"
							rendered="#{studentAssignmentInfo.instructorTests}" />
					</h:commandLink>

					<af:spacer height="20" />

					<h:outputText value="ProgTest Reports" styleClass="menu_title" />

					<af:spacer height="0" />

					<h:commandLink
						action="#{studentAssignmentInfo.selectResultView}"
						styleClass="link">
						<h:outputText value="Evaluation Result" styleClass="link"
							rendered="#{!studentAssignmentInfo.evaluationReport}" />
						<h:outputText value="Evaluation Result" styleClass="link_hover"
							rendered="#{studentAssignmentInfo.evaluationReport}" />
					</h:commandLink>

					<h:dataTable value="#{studentAssignmentInfo.tools}" var="tool"
						width="100%" rendered="#{!empty studentAssignmentInfo.reports}"
						cellpadding="0" cellspacing="0">
						<h:column>
							<af:spacer height="20" />
							<h:outputText value="#{tool.name} Reports"
								styleClass="menu_title" />
							<h:dataTable value="#{studentAssignmentInfo.reports}"
								var="report" binding="#{studentAssignmentInfo.reportsTable}"
								width="100%" cellpadding="0" cellspacing="0">
								<h:column>
									<h:commandLink rendered="#{tool.name == report.tool}"
										action="#{studentAssignmentInfo.selectReportView}"
										styleClass="link">
										<h:outputText value="#{report.name}" styleClass="link"
											rendered="#{studentAssignmentInfo.report.name != report.name}" />
										<h:outputText value="#{report.name}" styleClass="link_hover"
											rendered="#{studentAssignmentInfo.report.name == report.name}" />
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
						<h:commandLink
							action="#{studentAssignmentInfo.send}" styleClass="link">
							<h:outputText value="Submit Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/execute.png" />
						<h:commandLink
							onclick="document.getElementById('hidepage').style.visibility = 'visible';"
							action="#{studentAssignmentInfo.execute}" styleClass="link">
							<h:outputText value="Execute Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/evaluation.png" />
						<h:commandLink
							onclick="document.getElementById('hidepage').style.visibility = 'visible';"
							action="#{studentAssignmentInfo.evaluate}" styleClass="link">
							<h:outputText value="Evaluate Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<htm:div
					style="width: 595px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText
						value="#{studentAssignmentInfo.title} Program &gt; #{studentAssignmentInfo.report.name}"
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