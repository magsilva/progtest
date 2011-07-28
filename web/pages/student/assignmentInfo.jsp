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

					<af:spacer height="10" />

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
								<af:spacer height="5" />
								<h:commandLink
									action="#{studentAssignmentInfo.selectResultView}"
									styleClass="link">
									<h:outputText value="Evaluation Result" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 2}" />
									<h:outputText value="Evaluation Result" styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 2}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="40" />

					<h:outputText value="Reports" styleClass="menu_title"
						rendered="#{!empty studentAssignmentInfo.reports}" />

					<h:dataTable value="#{studentAssignmentInfo.reports}" var="report"
						binding="#{studentAssignmentInfo.reportsTable}" width="100%"
						rendered="#{!empty studentAssignmentInfo.reports}">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{studentAssignmentInfo.selectReportView}"
								styleClass="link">
								<h:outputText value="#{report.tool}/#{report.name}"
									styleClass="link"
									rendered="#{report.name != studentAssignmentInfo.activedReport}" />
								<h:outputText value="#{report.tool}/#{report.name}"
									styleClass="link_hover"
									rendered="#{report.name == studentAssignmentInfo.activedReport}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

					<af:spacer height="40" />

					<h:outputText value="Action" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2" rendered="#{studentAssignmentInfo.downloadable != null}">
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
							<h:outputText value="Submit Again"
								styleClass="topmenu_link" />
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

				<htm:div style="width: 600px;"
					rendered="#{studentAssignmentInfo.viewId == 2}">

					<af:spacer height="25" />

					<h:outputText value="Evaluation Result" styleClass="title" />

					<af:spacer height="25" />

					<h:outputText value="General Coverages" styleClass="subtitle" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.generalCoverages.records}"
						var="record" headerClass="tableHeader"
						binding="#{studentAssignmentInfo.generalCoveragesTable}"
						rowClasses="tableRow" width="100%">
						<h:column
							rendered="#{studentAssignmentInfo.generalCoverages.header.column1 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.generalCoverages.header.column1}" />
							</f:facet>
							<h:outputText value="#{record.column1}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.generalCoverages.header.column2 != null}">
							<f:facet name="header">
								<h:outputText value="P_Inst - T_Inst" />
							</f:facet>
							<h:outputText value="#{record.column2}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.generalCoverages.header.column3 != null}">
							<f:facet name="header">
								<h:outputText value="P_St - T_St" />
							</f:facet>
							<h:outputText value="#{record.column3}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.generalCoverages.header.column4 != null}">
							<f:facet name="header">
								<h:outputText value="P_Inst - T_St" />
							</f:facet>
							<h:outputText value="#{record.column4}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.generalCoverages.header.column5 != null}">
							<f:facet name="header">
								<h:outputText value="P_St - T_Inst" />
							</f:facet>
							<h:outputText value="#{record.column5}" />
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText value="Total Coverages" styleClass="subtitle" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.totalCoverages.records}"
						var="record2" headerClass="tableHeader"
						binding="#{studentAssignmentInfo.totalCoveragesTable}"
						rowClasses="tableRow" width="100%">
						<h:column
							rendered="#{studentAssignmentInfo.totalCoverages.header.column1 != null}">
							<f:facet name="header">
								<h:outputText value="Executions" />
							</f:facet>
							<h:outputText value="#{record2.column1}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.totalCoverages.header.column2 != null}">
							<f:facet name="header">
								<h:outputText value="Coverage" />
							</f:facet>
							<h:outputText value="#{record2.column2}" />
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<htm:center>
						<h:outputText
							value="Suggested Grade: #{studentAssignmentInfo.grade}"
							styleClass="subtitle" />
					</htm:center>

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{studentAssignmentInfo.viewId == 3}">

					<af:spacer height="20" />

					<h:outputText value="#{studentAssignmentInfo.xmlReport.name}"
						styleClass="title" />

					<h:dataTable value="#{studentAssignmentInfo.xmlReport.records}"
						var="record" headerClass="tableHeader"
						binding="#{studentAssignmentInfo.recordsTable}"
						rowClasses="tableRow" width="100%">
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column1 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column1}" />
							</f:facet>
							<h:outputText value="#{record.column1}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column2 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column2}" />
							</f:facet>
							<h:outputText value="#{record.column2}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column3 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column3}" />
							</f:facet>
							<h:outputText value="#{record.column3}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column4 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column4}" />
							</f:facet>
							<h:outputText value="#{record.column4}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column5 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column5}" />
							</f:facet>
							<h:outputText value="#{record.column5}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column6 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column6}" />
							</f:facet>
							<h:outputText value="#{record.column6}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column7 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column7}" />
							</f:facet>
							<h:outputText value="#{record.column7}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column8 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column8}" />
							</f:facet>
							<h:outputText value="#{record.column8}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column9 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column9}" />
							</f:facet>
							<h:outputText value="#{record.column9}" />
						</h:column>
						<h:column
							rendered="#{studentAssignmentInfo.xmlReport.header.column10 != null}">
							<f:facet name="header">
								<h:outputText
									value="#{studentAssignmentInfo.xmlReport.header.column10}" />
							</f:facet>
							<h:outputText value="#{record.column10}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{studentAssignmentInfo.viewId == 4}">

					<af:spacer height="25" />

					<h:outputText
						value="#{studentAssignmentInfo.txtReport.tool}/#{studentAssignmentInfo.txtReport.name}"
						styleClass="title" />

					<af:spacer height="25" />

					

					<h:dataTable value="#{studentAssignmentInfo.txtReport.content}" var="lines">
						<h:column rendered="#{!empty studentAssignmentInfo.txtReport.content}">
							<h:outputText value="#{lines}" />
						</h:column>
					</h:dataTable>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>