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

		<h:form enctype="multipart/form-data">

			<htm:div style="width: 800px; text-align: left">

				<af:spacer height="20" />

				<af:spacer width="5" />

				<h:commandLink action="#{instructorEditAssignment.cancel}"
					styleClass="topmenu_link">
					<h:outputText value="&lt;&lt; Back to Assignment"
						styleClass="topmenu_link" />
				</h:commandLink>

			</htm:div>

			<h:panelGrid columns="2" style="width: 800px" columnClasses="menu">

				<htm:div
					style="width: 150px; padding-left: 10px; padding-right: 20px; border-right: 1px solid #CCCCCC; border-left: 1px solid #CCCCCC; min-height: 400px;">

					<af:spacer height="25" />

					<h:outputText value="Steps" styleClass="menu_title" />

					<af:spacer height="15" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 1: Programming Language"
									styleClass="link"
									rendered="#{instructorEditAssignment.step != 1}" />
								<h:outputText value="Step 1: Programming Language"
									styleClass="link_hover"
									rendered="#{instructorEditAssignment.step == 1}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 2: Oracle Assignment"
									styleClass="link"
									rendered="#{instructorEditAssignment.step != 2}" />
								<h:outputText value="Step 2: Oracle Assignment"
									styleClass="link_hover"
									rendered="#{instructorEditAssignment.step == 2}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 3: Assignment Properties"
									styleClass="link"
									rendered="#{instructorEditAssignment.step != 3}" />
								<h:outputText value="Step 3: Assignment Properties"
									styleClass="link_hover"
									rendered="#{instructorEditAssignment.step == 3}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 4: Test Criteria" styleClass="link"
									rendered="#{instructorEditAssignment.step != 4}" />
								<h:outputText value="Step 4: Test Criteria"
									styleClass="link_hover"
									rendered="#{instructorEditAssignment.step == 4}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 5: Evaluation Options"
									styleClass="link"
									rendered="#{instructorEditAssignment.step != 5}" />
								<h:outputText value="Step 5: Evaluation Options"
									styleClass="link_hover"
									rendered="#{instructorEditAssignment.step == 5}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
					</htm:table>

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorEditAssignment.step == 1}">

					<af:spacer height="25" />

					<h:outputText value="Edit Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 1 - Choice one of the programming languages below." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2"
						rendered="#{!empty instructorEditAssignment.languages}">
						<h:outputText value="Programming languages*:" />
						<h:selectOneMenu value="#{instructorEditAssignment.language}">
							<t:selectItems value="#{instructorEditAssignment.languages}"
								var="l" itemLabel="#{l}" itemValue="#{l}" />
						</h:selectOneMenu>
					</h:panelGrid>

					<h:outputText value="Any languages avaible!"
						rendered="#{empty instructorEditAssignment.languages}" />

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorEditAssignment.cancel}" />
					<h:commandButton value="Back" disabled="true" />
					<h:commandButton value="Next"
						action="#{instructorEditAssignment.goToStep2}" />

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorEditAssignment.step == 2}">

					<af:spacer height="25" />

					<h:outputText value="Edit Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 2 - Upload an oracle assignment or choice one from the ProgTest's oracle assignments base." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />
					
					<h:selectOneRadio value="#{instructorEditAssignment.current}"
						onchange="submit()"
						valueChangeListener="#{instructorEditAssignment.change}">
						<f:selectItem itemValue="true"
							itemLabel="Keep Current Oracle" />
						<f:selectItem itemValue="false"
							itemLabel="Change Oracle" />
					</h:selectOneRadio>
					
					<af:spacer height="15px"/>
					
					<h:panelGrid columns="2"
						rendered="#{instructorEditAssignment.current and instructorEditAssignment.downloadable != null}">
						<af:image source="/images/download.png" />
						<h:outputLink value="#{instructorAssignment.downloadable}"
							styleClass="link">
							<h:outputText value="Download Current Oracle" styleClass="topmenu_link" />
						</h:outputLink>
					</h:panelGrid>

					<h:selectOneRadio value="#{instructorEditAssignment.upload}"
						onchange="submit()"
						valueChangeListener="#{instructorEditAssignment.change}"
						rendered="#{!instructorEditAssignment.current}">
						<f:selectItem itemValue="true"
							itemLabel="Upload Oracle Assignment" />
						<f:selectItem itemValue="false"
							itemLabel="Use ProgTest's Oracle Assignment" />
					</h:selectOneRadio>

					<af:spacer height="25" />

					<h:panelGrid columns="2"
						rendered="#{instructorEditAssignment.upload and !instructorEditAssignment.current}">
						<h:outputText value="Upload Assignment:" />
						<t:inputFileUpload
							value="#{instructorEditAssignment.uploadedFile}" storage="file" />
					</h:panelGrid>

					<af:spacer height="25" />

					<h:panelGrid columns="2"
						rendered="#{!empty instructorEditAssignment.oracles and !instructorEditAssignment.current}">
						<h:outputText value="ProgTest's Oracle Assignment: "
							rendered="#{!instructorEditAssignment.upload}" />
						<h:selectOneMenu value="#{instructorEditAssignment.oracle}"
							rendered="#{!instructorEditAssignment.upload}">
							<t:selectItems value="#{instructorEditAssignment.oracles}"
								var="o" itemLabel="#{o.title}" itemValue="#{o.idCode}" />
						</h:selectOneMenu>
					</h:panelGrid>

					<h:outputText value="Any ProgTest's oracle assignment avaible!"
						rendered="#{empty instructorEditAssignment.oracles and !instructorEditAssignment.upload and !instructorEditAssignment.current}" />

					<af:spacer height="30" />

					<h:commandButton value="Cancel"
						action="#{instructorEditAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorEditAssignment.backToStep1}" />
					<h:commandButton value="Next"
						action="#{instructorEditAssignment.goToStep3}" />

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorEditAssignment.step == 3}">

					<af:spacer height="25" />

					<h:outputText value="Edit Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Step 3 - Enter the assignment properties." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Name*:" />
						<h:inputText value="#{instructorEditAssignment.title}" />
						<h:outputText value="Description*:" />
						<h:inputTextarea value="#{instructorEditAssignment.description}" />
						<h:outputText value="Start Date*:" />
						<t:inputDate value="#{instructorEditAssignment.startDate}"
							popupCalendar="true" />
						<h:outputText value="Deadline*:" />
						<t:inputDate value="#{instructorEditAssignment.endDate}"
							popupCalendar="true" />
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorEditAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorEditAssignment.backToStep2}" />
					<h:commandButton value="Next"
						action="#{instructorEditAssignment.goToStep4}" />

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorEditAssignment.step == 4}">

					<af:spacer height="25" />

					<h:outputText value="Edit Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 4 - Select the testing criteria to be considered." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:outputText value="Any criterion avaible!"
						rendered="#{empty instructorEditAssignment.criteria}" />

					<h:outputText value="Criteria"
						rendered="#{!empty instructorEditAssignment.criteria}"
						styleClass="subtitle" />

					<h:selectManyCheckbox onchange="submit()"
						valueChangeListener="#{instructorEditAssignment.changeCriteria}"
						value="#{instructorEditAssignment.selectedCriteria}"
						layout="pageDirection"
						rendered="#{!empty instructorEditAssignment.criteria}">
						<t:selectItems value="#{instructorEditAssignment.criteria}"
							var="c2" itemLabel="#{c2.tool.name}/#{c2.name}"
							itemValue="#{c2.tool.idCode}/#{c2.idCode}" />
					</h:selectManyCheckbox>

					<af:spacer height="20" />

					<h:outputText value="Mutant Operators"
						rendered="#{!empty instructorEditAssignment.operators}"
						styleClass="subtitle" />

					<h:selectManyCheckbox id="required"
						value="#{instructorEditAssignment.selectedRequiredOperators}"
						layout="pageDirection"
						rendered="#{!empty instructorEditAssignment.requiredOperators}"
						disabled="true">
						<t:selectItems
							value="#{instructorEditAssignment.requiredOperators}"
							var="requiredOperator"
							itemLabel="#{requiredOperator.criterion.tool.name}/#{requiredOperator.name}"
							itemValue="#{requiredOperator.criterion.tool.idCode}/#{requiredOperator.criterion.idCode}/#{requiredOperator.idCode}" />
					</h:selectManyCheckbox>
					<h:selectManyCheckbox id="unrequired"
						value="#{instructorEditAssignment.selectedOperators}"
						layout="pageDirection"
						rendered="#{!empty instructorEditAssignment.operators}">
						<t:selectItems value="#{instructorEditAssignment.operators}"
							var="operator"
							itemLabel="#{operator.criterion.tool.name}/#{operator.name}"
							itemValue="#{operator.criterion.tool.idCode}/#{operator.criterion.idCode}/#{operator.idCode}" />
					</h:selectManyCheckbox>

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorEditAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorEditAssignment.backToStep3}" />
					<h:commandButton value="Next"
						action="#{instructorEditAssignment.goToStep5}" />

				</htm:div>

				<htm:div
					style="width: 585px; padding-left: 20px; border-left: 1px solid #CCCCCC; border-right: 1px solid #CCCCCC;  min-height: 400px;"
					rendered="#{instructorEditAssignment.step == 5}">

					<af:spacer height="25" />

					<h:outputText value="Edit Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 5.1 - Define the evaluation weights for each criteria." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:dataTable value="#{instructorEditAssignment.requisites}"
						var="requisite"
						rendered="#{!empty instructorEditAssignment.requisites}">
						<h:column>
							<h:outputText
								value="#{requisite.criterion.tool.name}/#{requisite.criterion.name}: " />
						</h:column>
						<h:column>
							<h:selectOneMenu value="#{requisite.weight}">
								<f:selectItem itemValue="1" />
								<f:selectItem itemValue="2" />
								<f:selectItem itemValue="3" />
								<f:selectItem itemValue="4" />
								<f:selectItem itemValue="5" />
								<f:selectItem itemValue="6" />
								<f:selectItem itemValue="7" />
								<f:selectItem itemValue="8" />
								<f:selectItem itemValue="9" />
								<f:selectItem itemValue="10" />
							</h:selectOneMenu>
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText value="Step 5.2 - Define what should be evaluated." />

					<af:spacer height="20" />

					<h:outputText
						value="PSt-TSt = Student's Test against Student's Program" />
					<af:spacer height="5" />
					<h:outputText
						value="PInst-TSt = Student's Test against Instructor's Program" />
					<af:spacer height="5" />
					<h:outputText
						value="PSt-TInst = Instructor's Test against Student's Program" />

					<af:spacer height="20" />

					<h:dataTable value="#{instructorEditAssignment.requisites}"
						var="requisite2" rowClasses="tableRow" headerClass="tableHeader"
						width="96%"
						rendered="#{!empty instructorEditAssignment.requisites}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Criteria" />
							</f:facet>
							<h:outputText
								value="#{requisite2.criterion.tool.name}/#{requisite2.criterion.name}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="PSt-TSt" />
							</f:facet>
							<h:selectBooleanCheckbox value="#{requisite2.pstsRequired}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="PInst-TSt" />
							</f:facet>
							<h:selectBooleanCheckbox value="#{requisite2.pitsRequired}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="PSt-TInst" />
							</f:facet>
							<h:selectBooleanCheckbox value="#{requisite2.pstiRequired}" />
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText
						value="Step 5.3 - Define the evaluation weights for each combination." />

					<af:spacer height="20" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:outputText
									value="Student's Tests against Student's Program (PSt-TSt): " />
							</htm:td>
							<htm:td>
								<h:selectOneMenu value="#{instructorEditAssignment.pstsWeight}">
									<f:selectItem itemValue="1" />
									<f:selectItem itemValue="2" />
									<f:selectItem itemValue="3" />
									<f:selectItem itemValue="4" />
									<f:selectItem itemValue="5" />
									<f:selectItem itemValue="6" />
									<f:selectItem itemValue="7" />
									<f:selectItem itemValue="8" />
									<f:selectItem itemValue="9" />
									<f:selectItem itemValue="10" />
								</h:selectOneMenu>
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText
									value="Instructor's Tests against Student's Program (PInst-TSt): " />
							</htm:td>
							<htm:td>
								<h:selectOneMenu value="#{instructorEditAssignment.pitsWeight}">
									<f:selectItem itemValue="1" />
									<f:selectItem itemValue="2" />
									<f:selectItem itemValue="3" />
									<f:selectItem itemValue="4" />
									<f:selectItem itemValue="5" />
									<f:selectItem itemValue="6" />
									<f:selectItem itemValue="7" />
									<f:selectItem itemValue="8" />
									<f:selectItem itemValue="9" />
									<f:selectItem itemValue="10" />
								</h:selectOneMenu>
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText
									value="Student's Tests against Instructor's Program (PSt-TInst): " />
							</htm:td>
							<htm:td>
								<h:selectOneMenu value="#{instructorEditAssignment.pstiWeight}">
									<f:selectItem itemValue="1" />
									<f:selectItem itemValue="2" />
									<f:selectItem itemValue="3" />
									<f:selectItem itemValue="4" />
									<f:selectItem itemValue="5" />
									<f:selectItem itemValue="6" />
									<f:selectItem itemValue="7" />
									<f:selectItem itemValue="8" />
									<f:selectItem itemValue="9" />
									<f:selectItem itemValue="10" />
								</h:selectOneMenu>
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="30" />

					<h:outputText
						value="Step 5.4 - Define which reports should be visible for students." />

					<af:spacer height="20" />

					<h:selectBooleanCheckbox
						value="#{instructorEditAssignment.pstsVisible}" />
					<h:outputText value="Turn PSt-TSt reports visible for students." />

					<af:spacer height="5" />

					<h:selectBooleanCheckbox
						value="#{instructorEditAssignment.pitsVisible}" />
					<h:outputText value="Turn PInst-TSt reports visible for students." />

					<af:spacer height="5" />

					<h:selectBooleanCheckbox
						value="#{instructorEditAssignment.pstiVisible}" />
					<h:outputText value="Turn PSt-TInst reports visible for students." />

					<af:spacer height="30" />

					<h:outputText value="Step 5.5 - Define the execution timeout." />

					<af:spacer height="20" />

					<h:outputText value="Timeout: " />
					<h:selectOneMenu value="#{instructorEditAssignment.timeout}">
						<f:selectItem itemValue="30" />
						<f:selectItem itemValue="60" />
						<f:selectItem itemValue="90" />
						<f:selectItem itemValue="120" />
						<f:selectItem itemValue="150" />
						<f:selectItem itemValue="180" />
						<f:selectItem itemValue="210" />
						<f:selectItem itemValue="240" />
						<f:selectItem itemValue="270" />
						<f:selectItem itemValue="300" />
					</h:selectOneMenu>
					<h:outputText value=" segundos." />

					<af:spacer height="30" />

					<h:outputText value="Step 5.6 - Define the minimum coverage required." />

					<af:spacer height="20" />

					<h:outputText value="Minimum Coverage: " />
					<h:selectOneMenu value="#{instructorEditAssignment.minimumCoverage}">
						<f:selectItem itemValue="50" />
						<f:selectItem itemValue="75" />
					</h:selectOneMenu>
					<h:outputText value="%" />

					<af:spacer height="30" />

					<h:commandButton value="Cancel"
						action="#{instructorEditAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorEditAssignment.backToStep4}" />
					<h:commandButton value="Finalize"
						onclick="document.getElementById('hidepage').style.visibility = 'visible';"
						action="#{instructorEditAssignment.conclude}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>