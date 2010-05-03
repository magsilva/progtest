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
								<h:commandLink
									action="#{instructorAddAssignment.backToStep1}"
									styleClass="link">
									<h:outputText value="Step 1: Oracle Assignment"
										styleClass="link"
										rendered="#{instructorAddAssignment.step != 1}" />
									<h:outputText value="Step 1: Oracle Assignment"
										styleClass="link_hover"
										rendered="#{instructorAddAssignment.step == 1}" />
								</h:commandLink>
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{instructorAddAssignment.goToStep2}"
									styleClass="link">
									<h:outputText value="Step 2: Assignment Properties"
										styleClass="link"
										rendered="#{instructorAddAssignment.step != 2}" />
									<h:outputText value="Step 2: Assignment Properties"
										styleClass="link_hover"
										rendered="#{instructorAddAssignment.step == 2}" />
								</h:commandLink>
								<af:spacer height="10" />
							</htm:td>
						</htm:tr>
					</htm:table>

				</htm:div>
				<af:spacer width="30" />

				<htm:div style="width: 600px;"
					rendered="#{instructorAddAssignment.step == 1}">

					<af:spacer height="20" />

					<h:outputText value="Add New Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Step 1 - Choice one of the implementations below." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Implementation*:" />
						<h:selectOneMenu value="#{instructorAddAssignment.oracle}">
							<f:selectItems value="#{instructorAddAssignment.oracles}" />
						</h:selectOneMenu>
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorAddAssignment.cancel}" />
					<h:commandButton value="Next"
						action="#{instructorAddAssignment.goToStep2}" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{instructorAddAssignment.step == 2}">

					<af:spacer height="20" />

					<h:outputText value="Add New Assignment" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Step 2 - Enter the assignment properties." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Name*:" />
						<h:inputText value="#{instructorAddAssignment.title}" />
						<h:outputText value="Description*:" />
						<h:inputTextarea value="#{instructorAddAssignment.description}" />
						<h:outputText value="Start Date*:" />
						<t:inputDate value="#{instructorAddAssignment.startDate}"
							popupCalendar="true" />
						<h:outputText value="Deadline*:" />
						<t:inputDate value="#{instructorAddAssignment.endDate}"
							popupCalendar="true" />
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandLink
						action="#{instructorAddAssignment.turnOnAdvancedOptions}"
						styleClass="link"
						rendered="#{!instructorAddAssignment.advancedOptions}">
						<h:outputText value="Advanced Options" styleClass="link" />
					</h:commandLink>

					<h:commandLink
						action="#{instructorAddAssignment.turnOffAdvancedOptions}"
						styleClass="link"
						rendered="#{instructorAddAssignment.advancedOptions}">
						<h:outputText value="Basic Options" styleClass="link" />
					</h:commandLink>

					<af:spacer height="20"
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<h:outputText value="Step 2.1 - Weights"
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<af:spacer height="20"
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<h:panelGrid columns="2"
						rendered="#{instructorAddAssignment.advancedOptions}">
						<h:outputText value="Criteria" styleClass="label" />
						<h:outputText value="Weights" styleClass="label" />
						<h:outputText value="Functional*:" />
						<h:selectOneMenu
							value="#{instructorAddAssignment.weightFunctional}">
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
							value="#{instructorAddAssignment.weightAllNodes}">
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
							value="#{instructorAddAssignment.weightAllEdges}">
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
							value="#{instructorAddAssignment.weightAllUses}">
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
							value="#{instructorAddAssignment.weightAllPotUses}">
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
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<h:panelGrid columns="2"
						rendered="#{instructorAddAssignment.advancedOptions}">
						<h:outputText value="Executions" styleClass="label" />
						<h:outputText value="Weights" styleClass="label" />
						<h:outputText
							value="Student's program with the student's test set (Ps-Ts)*:" />
						<h:selectOneMenu
							value="#{instructorAddAssignment.weightPalTal}">
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
							value="Instructor's program with the student's test set (Pi-Ts)*:" />
						<h:selectOneMenu
							value="#{instructorAddAssignment.weightPinstTal}">
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
							value="Student's program with the instructor's test set (Ps-Ti)*:" />
						<h:selectOneMenu
							value="#{instructorAddAssignment.weightPalTinst}">
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

					<af:spacer height="20" />

					<h:commandButton value="Cancel"
						action="#{instructorAddAssignment.cancel}" />
					<h:commandButton value="Back"
						action="#{instructorAddAssignment.backToStep1}" />
					<h:commandButton value="Finalize"
						action="#{instructorAddAssignment.conclude}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>