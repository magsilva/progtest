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

			<h:panelGrid columns="3" style="width: 800px" columnClasses="menu">

				<htm:div style="width: 170px;">

					<af:spacer height="25" />

					<h:outputText value="Steps" styleClass="menu_title" />

					<af:spacer height="15" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 1: Programming Language"
									styleClass="link"
									rendered="#{instructorCreateAssignment.step != 1}" />
								<h:outputText value="Step 1: Programming Language"
									styleClass="link_hover"
									rendered="#{instructorCreateAssignment.step == 1}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 2: Oracle Assignment"
									styleClass="link"
									rendered="#{instructorCreateAssignment.step != 2}" />
								<h:outputText value="Step 2: Oracle Assignment"
									styleClass="link_hover"
									rendered="#{instructorCreateAssignment.step == 2}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 3: Assignment Properties"
									styleClass="link"
									rendered="#{instructorCreateAssignment.step != 3}" />
								<h:outputText value="Step 3: Assignment Properties"
									styleClass="link_hover"
									rendered="#{instructorCreateAssignment.step == 3}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 4: Test Criteria" styleClass="link"
									rendered="#{instructorCreateAssignment.step != 4}" />
								<h:outputText value="Step 4: Test Criteria"
									styleClass="link_hover"
									rendered="#{instructorCreateAssignment.step == 4}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Step 5: Evaluation Weigths"
									styleClass="link"
									rendered="#{instructorCreateAssignment.step != 5}" />
								<h:outputText value="Step 5: Evaluation Weigths"
									styleClass="link_hover"
									rendered="#{instructorCreateAssignment.step == 5}" />
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
					</htm:table>

				</htm:div>
				<af:spacer width="30" />

				<htm:div style="width: 600px;"
					rendered="#{instructorCreateAssignment.step == 1}">

					<af:spacer height="20" />

					<h:outputText value="Add New Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 1 - Choice one of the programming languages below." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2"
						rendered="#{!empty instructorCreateAssignment.languages}">
						<h:outputText value="Programming languages*:" />
						<h:selectOneMenu value="#{instructorCreateAssignment.language}">
							<t:selectItems value="#{instructorCreateAssignment.languages}"
								var="l" itemLabel="#{l}" itemValue="#{l}" />
						</h:selectOneMenu>
					</h:panelGrid>

					<h:outputText value="Any languages avaible!"
						rendered="#{empty instructorCreateAssignment.languages}" />

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Back" disabled="true" />
					<h:commandButton value="Next"
						action="#{instructorCreateAssignment.goToStep2}" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{instructorCreateAssignment.step == 2}">

					<af:spacer height="20" />

					<h:outputText value="Add New Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 2 - Upload an oracle assignment or choice one from the ProgTest's oracle assignments base." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:selectOneRadio value="#{instructorCreateAssignment.upload}"
						onchange="goToStep2()"
						valueChangeListener="#{instructorCreateAssignment.change}">
						<f:selectItem itemValue="true"
							itemLabel="Upload Oracle Assignment" />
						<f:selectItem itemValue="false"
							itemLabel="Use ProgTest's Oracle Assignment" />
					</h:selectOneRadio>

					<af:spacer height="25" />

					<h:panelGrid columns="2"
						rendered="#{instructorCreateAssignment.upload}">
						<h:outputText value="Upload Assignment:" />
						<t:inputFileUpload
							value="#{instructorCreateAssignment.uploadedFile}" storage="file" />
					</h:panelGrid>

					<af:spacer height="25" />

					<h:panelGrid columns="2"
						rendered="#{!empty instructorCreateAssignment.oracles}">
						<h:outputText value="ProgTest's Oracle Assignment: "
							rendered="#{!instructorCreateAssignment.upload}" />
						<h:selectOneMenu value="#{instructorCreateAssignment.oracle}"
							rendered="#{!instructorCreateAssignment.upload}">
							<t:selectItems value="#{instructorCreateAssignment.oracles}"
								var="o" itemLabel="#{o.title}" itemValue="#{o.idCode}" />
						</h:selectOneMenu>
					</h:panelGrid>

					<h:outputText value="Any ProgTest's oracle assignment avaible!"
						rendered="#{empty instructorCreateAssignment.oracles}" />

					<af:spacer height="25" />

					<h:commandButton value="Cancel"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorCreateAssignment.backToStep1}" />
					<h:commandButton value="Next"
						action="#{instructorCreateAssignment.goToStep3}" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{instructorCreateAssignment.step == 3}">

					<af:spacer height="20" />

					<h:outputText value="Add New Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Step 3 - Enter the assignment properties." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Name*:" />
						<h:inputText value="#{instructorCreateAssignment.title}" />
						<h:outputText value="Description*:" />
						<h:inputTextarea value="#{instructorCreateAssignment.description}" />
						<h:outputText value="Start Date*:" />
						<t:inputDate value="#{instructorCreateAssignment.startDate}"
							popupCalendar="true" />
						<h:outputText value="Deadline*:" />
						<t:inputDate value="#{instructorCreateAssignment.endDate}"
							popupCalendar="true" />
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorCreateAssignment.backToStep2}" />
					<h:commandButton value="Next"
						action="#{instructorCreateAssignment.goToStep4}" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{instructorCreateAssignment.step == 4}">

					<af:spacer height="20" />

					<h:outputText value="Add New Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 4 - Select the testing criteria to be considered." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:outputText value="Any criterion avaible!"
						rendered="#{empty instructorCreateAssignment.criteria}" />

					<h:selectManyCheckbox
						value="#{instructorCreateAssignment.selectedCriteria}"
						layout="pageDirection"
						rendered="#{!empty instructorCreateAssignment.criteria}">
						<t:selectItems value="#{instructorCreateAssignment.criteria}"
							var="c2" itemLabel="#{c2.tool.name}/#{c2.name}"
							itemValue="#{c2.tool.idCode}/#{c2.idCode}" />
					</h:selectManyCheckbox>

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorCreateAssignment.backToStep3}" />
					<h:commandButton value="Next"
						action="#{instructorCreateAssignment.goToStep5}" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{instructorCreateAssignment.step == 5}">

					<af:spacer height="20" />

					<h:outputText value="Add New Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 5 - Define the weights for the criteria in the evaluations." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:dataTable value="#{instructorCreateAssignment.requisites}"
						var="requisite"
						binding="#{instructorCreateAssignment.requisitesTable}"
						rendered="#{!empty instructorCreateAssignment.requisites}">
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

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorCreateAssignment.backToStep4}" />
					<h:commandButton value="Finalize"
						action="#{instructorCreateAssignment.conclude}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>