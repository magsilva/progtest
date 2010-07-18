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
								<h:commandLink action="#{instructorCreateAssignment.backToStep1}"
									styleClass="link">
									<h:outputText value="Step 1: Assignment Properties"
										styleClass="link"
										rendered="#{instructorCreateAssignment.step != 1}" />
									<h:outputText value="Step 1: Assignment Properties"
										styleClass="link_hover"
										rendered="#{instructorCreateAssignment.step == 1}" />
								</h:commandLink>
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{instructorCreateAssignment.goToStep2}"
									styleClass="link">
									<h:outputText value="Step 2: Oracle Assignment Upload" styleClass="link"
										rendered="#{instructorCreateAssignment.step != 2}" />
									<h:outputText value="Step 2: Oracle Assignment Upload" styleClass="link_hover"
										rendered="#{instructorCreateAssignment.step == 2}" />
								</h:commandLink>
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
					</htm:table>

				</htm:div>
				<af:spacer width="30" />

				<htm:div style="width: 600px;"
					rendered="#{instructorCreateAssignment.step == 1}">

					<af:spacer height="20" />

					<h:outputText value="Create New Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Step 1 - Enter the assignments properties." />

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
						<h:outputText value="End Date*:" />
						<t:inputDate value="#{instructorCreateAssignment.endDate}"
							popupCalendar="true" />
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandLink
						action="#{instructorCreateAssignment.turnOnAdvancedOptions}"
						styleClass="link"
						rendered="#{!instructorCreateAssignment.advancedOptions}">
						<h:outputText value="Advanced Options" styleClass="link" />
					</h:commandLink>

					<h:commandLink
						action="#{instructorCreateAssignment.turnOffAdvancedOptions}"
						styleClass="link"
						rendered="#{instructorCreateAssignment.advancedOptions}">
						<h:outputText value="Basic Options" styleClass="link" />
					</h:commandLink>

					<af:spacer height="20"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<h:outputText value="Step 1.1 - Weights"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<af:spacer height="20"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<h:panelGrid columns="2"
						rendered="#{instructorCreateAssignment.advancedOptions}">
						<h:outputText value="Criteria" styleClass="label" />
						<h:outputText value="Weights" styleClass="label" />
						<h:outputText value="Functional*:" />
						<h:selectOneMenu
							value="#{instructorCreateAssignment.weightFunctional}">
							<f:selectItem itemValue="0" />
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
						<h:outputText value="All-Nodes*:" />
						<h:selectOneMenu
							value="#{instructorCreateAssignment.weightAllNodes}">
							<f:selectItem itemValue="0" />
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
						<h:outputText value="All-Edges*:" />
						<h:selectOneMenu
							value="#{instructorCreateAssignment.weightAllEdges}">
							<f:selectItem itemValue="0" />
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
						<h:outputText value="All-Uses*:" />
						<h:selectOneMenu
							value="#{instructorCreateAssignment.weightAllUses}">
							<f:selectItem itemValue="0" />
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
						<h:outputText value="All-Pot-Uses*:" />
						<h:selectOneMenu
							value="#{instructorCreateAssignment.weightAllPotUses}">
							<f:selectItem itemValue="0" />
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
					</h:panelGrid>

					<af:spacer height="20"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<h:panelGrid columns="2"
						rendered="#{instructorCreateAssignment.advancedOptions}">
						<h:outputText value="Executions" styleClass="label" />
						<h:outputText value="Weights" styleClass="label" />
						<h:outputText
							value="Student's program with the student's test set (P_St-T_St)*:" />
						<h:selectOneMenu
							value="#{instructorCreateAssignment.weightPalTal}">
							<f:selectItem itemValue="0" />
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
						<h:outputText
							value="Instructor's program with the student's test set (P_Inst-T_St)*:" />
						<h:selectOneMenu
							value="#{instructorCreateAssignment.weightPinstTal}">
							<f:selectItem itemValue="0" />
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
						<h:outputText
							value="Student's program with the instructor's test set (P_St-T_Inst)*:" />
						<h:selectOneMenu
							value="#{instructorCreateAssignment.weightPalTinst}">
							<f:selectItem itemValue="0" />
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
					</h:panelGrid>

					<af:spacer height="30" />

					<h:commandButton value="Cancel"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Next"
						action="#{instructorCreateAssignment.goToStep2}" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{instructorCreateAssignment.step == 2}">

					<af:spacer height="20" />

					<h:outputText value="Create New Assignment" styleClass="title" />
					
					<af:spacer height="20" />

					<h:outputText
						value="Step 2 - Select a .jar file with the source code (.java files) of the program and test set." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="File*:" />
						<t:inputFileUpload value="#{instructorCreateAssignment.file}"
							storage="file" />
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorCreateAssignment.backToStep1}" />
					<h:commandButton value="Finalize"
						action="#{instructorCreateAssignment.conclude}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>