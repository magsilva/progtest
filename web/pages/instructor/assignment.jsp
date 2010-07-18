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
									<h:outputText value="Assignment Properties"
										styleClass="link"
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
								<h:commandLink
									action="#{instructorAssignment.selectGradesView}"
									styleClass="link">
									<h:outputText value="Grades" styleClass="link"
										rendered="#{instructorAssignment.viewId != 1}" />
									<h:outputText value="Grades"
										styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 1}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="30" />

					<h:outputText value="Reports" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{instructorAssignment.selectFunctionalTestView}"
									styleClass="link">
									<h:outputText value="Functional Test" styleClass="link"
										rendered="#{instructorAssignment.viewId != 2}" />
									<h:outputText value="Functional Test" styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 2}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{instructorAssignment.selectRequiredElementsView}"
									styleClass="link">
									<h:outputText value="Required Elements" styleClass="link"
										rendered="#{instructorAssignment.viewId != 3}" />
									<h:outputText value="Required Elements"
										styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 3}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{instructorAssignment.selectClassCoverageView}"
									styleClass="link">
									<h:outputText value="Class Coverage" styleClass="link"
										rendered="#{instructorAssignment.viewId != 4}" />
									<h:outputText value="Class Coverage"
										styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 4}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{instructorAssignment.selectMethodCoverageView}"
									styleClass="link">
									<h:outputText value="Method Coverage" styleClass="link"
										rendered="#{instructorAssignment.viewId != 5}" />
									<h:outputText value="Method Coverage"
										styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 5}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{instructorAssignment.selectCriterionCoverageView}"
									styleClass="link">
									<h:outputText value="Criterion Coverage" styleClass="link"
										rendered="#{instructorAssignment.viewId != 6}" />
									<h:outputText value="Criterion Coverage"
										styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 6}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{instructorAssignment.selectCoveredAndUncoveredView}"
									styleClass="link">
									<h:outputText value="Covered and Uncovered Elements"
										styleClass="link"
										rendered="#{instructorAssignment.viewId != 7}" />
									<h:outputText value="Covered and Uncovered Elements"
										styleClass="link_hover"
										rendered="#{instructorAssignment.viewId == 7}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

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

					<h:outputText value="Assignment Properties"
						styleClass="title" />

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

					<h:dataTable value="#{instructorAssignment.evaluations}" var="evaluation"
						binding="#{instructorAssignment.evaluationsTable}" width="100%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty instructorAssignment.evaluations}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Student" />
							</f:facet>
							<h:outputText value="#{evaluation.student.userName}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Name" />
							</f:facet>
							<h:outputText value="#{evaluation.student.name}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Grade" />
							</f:facet>
							<h:outputText value="#{evaluation.score}" />
						</h:column>
					</h:dataTable>

					<h:outputText value="No students in the course."
						rendered="#{empty instructorAssignment.evaluations}" />

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 2}">

					<af:spacer height="20" />

					<h:outputText value="Functional Test" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{instructorAssignment.funcionalCoverageReport}"
						var="funcionalCoverageReport"
						binding="#{instructorAssignment.funcionalCoverageTable}"
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

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 3}">

					<af:spacer height="20" />

					<h:outputText value="Required Elements" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{instructorAssignment.requiredElementsReport}"
						var="requiredElementsReport"
						binding="#{instructorAssignment.requiredElementTable}"
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

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 4}">

					<af:spacer height="20" />

					<h:outputText value="Class Coverage" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{instructorAssignment.classCoverageReport}"
						var="classCoverageReport"
						binding="#{instructorAssignment.classCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Class" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.clazz}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="All-nodes" />
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

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 5}">

					<af:spacer height="20" />

					<h:outputText value="Method Coverage" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{instructorAssignment.methodCoverageReport}"
						var="methodCoverageReport"
						binding="#{instructorAssignment.methodCoverageTable}"
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

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 6}">

					<af:spacer height="20" />

					<h:outputText value="Criterion Coverage" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{instructorAssignment.criterionCoverageReport}"
						var="criterionCoverageReport"
						binding="#{instructorAssignment.criterionCoverageTable}"
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

				<htm:div style="width: 570px;"
					rendered="#{instructorAssignment.viewId == 7}">

					<af:spacer height="20" />

					<h:outputText value="Covered and Uncovered Elements"
						styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{instructorAssignment.coveredAndUncoveredReport}"
						var="coveredAndUncoveredReport"
						binding="#{instructorAssignment.coveredAndUncoveredTable}"
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