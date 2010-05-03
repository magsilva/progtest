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

			<htm:div style="width: 800px;">

				<af:spacer height="30" />

				<h:outputText value="Edit Assignment" styleClass="title" />

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
					<h:outputText value="End Date*:" />
					<t:inputDate value="#{instructorEditAssignment.endDate}"
						popupCalendar="true" />
				</h:panelGrid>

				<af:spacer height="20" />

				<h:commandLink
					action="#{instructorEditAssignment.turnOnAdvancedOptions}"
					styleClass="link"
					rendered="#{!instructorEditAssignment.advancedOptions}">
					<h:outputText value="Advanced Options" styleClass="link" />
				</h:commandLink>

				<h:commandLink
					action="#{instructorEditAssignment.turnOffAdvancedOptions}"
					styleClass="link"
					rendered="#{instructorEditAssignment.advancedOptions}">
					<h:outputText value="Basic Options" styleClass="link" />
				</h:commandLink>

				<af:spacer height="20"
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<h:outputText value="Weights"
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<af:spacer height="20"
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<h:panelGrid columns="2"
					rendered="#{instructorEditAssignment.advancedOptions}">
					<h:outputText value="Critéria" styleClass="label" />
					<h:outputText value="Weights" styleClass="label" />
					<h:outputText value="Functional*:" />
					<h:selectOneMenu
						value="#{instructorEditAssignment.weightFunctional}">
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
					<h:selectOneMenu value="#{instructorEditAssignment.weightAllNodes}">
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
					<h:selectOneMenu value="#{instructorEditAssignment.weightAllEdges}">
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
					<h:selectOneMenu value="#{instructorEditAssignment.weightAllUses}">
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
						value="#{instructorEditAssignment.weightAllPotUses}">
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
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<h:panelGrid columns="2"
					rendered="#{instructorEditAssignment.advancedOptions}">
					<h:outputText value="Executions" styleClass="label" />
					<h:outputText value="Weights" styleClass="label" />
					<h:outputText
						value="Structor's program with the student's test set (Ps-Ts)*:" />
					<h:selectOneMenu value="#{instructorEditAssignment.weightPalTal}">
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
					<h:selectOneMenu value="#{instructorEditAssignment.weightPinstTal}">
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
					<h:selectOneMenu value="#{instructorEditAssignment.weightPalTinst}">
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
					action="#{instructorEditAssignment.cancel}" />
				<h:commandButton value="Save"
					action="#{instructorEditAssignment.edit}" />

			</htm:div>

		</h:form>

	</f:subview>
</jsp:root>