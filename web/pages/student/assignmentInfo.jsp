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
									<h:outputText value="Assignment Properties"
										styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 0}" />
									<h:outputText value="Assignment Properties"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 0}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Evaluation Result" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="25" />

					<h:outputText value="Reports" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:outputText value="Functional Test" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Required Elements" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Class Coverage" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Method Coverage" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Criterion Coverage" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Covered and Uncovered Elements" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="30" />

					<h:outputText value="Action" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/upload.png" />
						<h:commandLink action="#{studentAssignmentInfo.send}"
							styleClass="link">
							<h:outputText value="Send Assignment" styleClass="topmenu_link" />
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
									<h:outputText value="Assignment Properties"
										styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 1}" />
									<h:outputText value="Assignment Properties"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 1}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectResultAvaliationView}"
									styleClass="link">
									<h:outputText value="Evaluation Result" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 2}" />
									<h:outputText value="Evaluation Result"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 2}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="25" />

					<h:outputText value="Reports" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectFunctionalTestView}"
									styleClass="link">
									<h:outputText value="Functional Test" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 3}" />
									<h:outputText value="Functional Test" styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 3}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectRequiredElementsView}"
									styleClass="link">
									<h:outputText value="Required Elements" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 4}" />
									<h:outputText value="Required Elements"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 4}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectClassCoverageView}"
									styleClass="link">
									<h:outputText value="Class Coverage" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 5}" />
									<h:outputText value="Class Coverage"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 5}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectMethodCoverageView}"
									styleClass="link">
									<h:outputText value="Method Coverage" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 6}" />
									<h:outputText value="Method Coverage"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 6}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectCriterionCoverageView}"
									styleClass="link">
									<h:outputText value="Criterion Coverage" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 7}" />
									<h:outputText value="Criterion Coverage"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 7}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectCoveredAndUncoveredView}"
									styleClass="link">
									<h:outputText value="Covered and Uncovered Elements"
										styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 8}" />
									<h:outputText value="Covered and Uncovered Elements"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 8}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="30" />

					<h:outputText value="Action" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/upload.png" />
						<h:commandLink action="#{studentAssignmentInfo.send}"
							styleClass="link">
							<h:outputText value="Send Assignment Again" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/add.png" />
						<h:commandLink action="#{studentAssignmentInfo.add}"
							styleClass="link">
							<h:outputText value="Add test Cases" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="15" />

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 0}">

					<af:spacer height="20" />

					<h:outputText value="Assignment Properties"
						styleClass="title" />

					<af:spacer height="20" />

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

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 1}">

					<af:spacer height="20" />

					<h:outputText value="Assignment Properties"
						styleClass="title" />

					<af:spacer height="20" />

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

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 2}">

					<af:spacer height="20" />

					<h:outputText value="Evaluation Result" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="General Coverage" styleClass="subtitle" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentAssignmentInfo.generalCoverageReport}"
						var="generalCoverageReport"
						binding="#{studentAssignmentInfo.generalCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Criterion" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.criterion}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="P_Inst-T_Inst Coverage" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.pinstTinst}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="P_St-T_St Coverage" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.palTal}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="P_Inst-T_St Coverage" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.pinstTal}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="P_St-T_Inst Coverage" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.palTinst}" />
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText value="Total Coverage" styleClass="subtitle" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentAssignmentInfo.totalCoverageReport}"
						var="totalCoverageReport"
						binding="#{studentAssignmentInfo.totalCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Executions" />
							</f:facet>
							<h:outputText value="#{totalCoverageReport.execution}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Coverage" />
							</f:facet>
							<h:outputText value="#{totalCoverageReport.coverage}" />
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<htm:center>
						<h:outputText
							value="Suggested Grade: #{studentAssignmentInfo.score}"
							styleClass="subtitle" />
					</htm:center>
					
					<af:spacer height="30" />

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 3}">

					<af:spacer height="20" />

					<h:outputText value="Functional Test" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.funcionalCoverageReport}"
						var="funcionalCoverageReport"
						binding="#{studentAssignmentInfo.funcionalCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Tests" />
							</f:facet>
							<h:outputText value="#{funcionalCoverageReport.tests}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Errors" />
							</f:facet>
							<h:outputText value="#{funcionalCoverageReport.errors}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Failures" />
							</f:facet>
							<h:outputText value="#{funcionalCoverageReport.failures}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Coverage" />
							</f:facet>
							<h:outputText value="#{funcionalCoverageReport.coverage}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 4}">

					<af:spacer height="20" />

					<h:outputText value="Required Elements" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.requiredElementsReport}"
						var="requiredElementsReport"
						binding="#{studentAssignmentInfo.requiredElementTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Method" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.method}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Nodes" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.allNodes}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Edges" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.allEdges}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Uses" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.allUses}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Pot-Uses" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.allPotUses}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 5}">

					<af:spacer height="20" />

					<h:outputText value="Class Coverage" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentAssignmentInfo.classCoverageReport}"
						var="classCoverageReport"
						binding="#{studentAssignmentInfo.classCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Class" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.clazz}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Nodes" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.allNodes}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Edges" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.allEdges}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Uses" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.allUses}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Pot-Uses" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.allPotUses}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 6}">

					<af:spacer height="20" />

					<h:outputText value="Method Coverage" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentAssignmentInfo.methodCoverageReport}"
						var="methodCoverageReport"
						binding="#{studentAssignmentInfo.methodCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Method" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.method}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Nodes" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.allNodes}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Edges" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.allEdges}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Uses" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.allUses}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-Pot-Uses" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.allPotUses}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 7}">

					<af:spacer height="20" />

					<h:outputText value="Criterion Coverage" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.criterionCoverageReport}"
						var="criterionCoverageReport"
						binding="#{studentAssignmentInfo.criterionCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Criterion" />
							</f:facet>
							<h:outputText value="#{criterionCoverageReport.criterion}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Number of Elements" />
							</f:facet>
							<h:outputText value="#{criterionCoverageReport.numberOfElements}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Number of Covered Elements" />
							</f:facet>
							<h:outputText
								value="#{criterionCoverageReport.numberOfCoveredElements}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Percentage" />
							</f:facet>
							<h:outputText value="#{criterionCoverageReport.percentage}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 8}">

					<af:spacer height="20" />

					<h:outputText value="Covered and Uncovered Elements"
						styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.coveredAndUncoveredReport}"
						var="coveredAndUncoveredReport"
						binding="#{studentAssignmentInfo.coveredAndUncoveredTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Method" />
							</f:facet>
							<h:outputText value="#{coveredAndUncoveredReport.method}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Criterion" />
							</f:facet>
							<h:outputText value="#{coveredAndUncoveredReport.criterion}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Covered Elements" />
							</f:facet>
							<h:outputText
								value="#{coveredAndUncoveredReport.coveredElements}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Uncovered Elements" />
							</f:facet>
							<h:outputText
								value="#{coveredAndUncoveredReport.uncoveredElements}" />
						</h:column>
					</h:dataTable>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>