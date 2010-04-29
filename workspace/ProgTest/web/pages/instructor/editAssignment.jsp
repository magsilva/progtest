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

				<h:outputText value="Editar Trabalho" styleClass="title" />

				<af:spacer height="20" />

				<h:outputText value="Altere os dados desejados." />

				<af:spacer height="20" />

				<h:messages styleClass="message" />

				<h:panelGrid columns="2">
					<h:outputText value="Nome*:" />
					<h:inputText value="#{instructorEditAssignment.title}" />
					<h:outputText value="Descri��o*:" />
					<h:inputTextarea value="#{instructorEditAssignment.description}" />
					<h:outputText value="Data In�cio*:" />
					<t:inputDate value="#{instructorEditAssignment.startDate}"
						popupCalendar="true" />
					<h:outputText value="Data T�rmino*:" />
					<t:inputDate value="#{instructorEditAssignment.endDate}"
						popupCalendar="true" />
				</h:panelGrid>

				<af:spacer height="20" />

				<h:commandLink
					action="#{instructorEditAssignment.turnOnAdvancedOptions}"
					styleClass="link"
					rendered="#{!instructorEditAssignment.advancedOptions}">
					<h:outputText value="Op��es Avan�adas" styleClass="link" />
				</h:commandLink>

				<h:commandLink
					action="#{instructorEditAssignment.turnOffAdvancedOptions}"
					styleClass="link"
					rendered="#{instructorEditAssignment.advancedOptions}">
					<h:outputText value="Op��es B�sicas" styleClass="link" />
				</h:commandLink>

				<af:spacer height="20"
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<h:outputText value="Pesos"
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<af:spacer height="20"
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<h:outputText
					value="Com as op��es abaixo � poss�vel regular o qu�o rigorosa ser� a avalia��o. Atribuindo pesos maiores a crit�rios mais fracos como, por exemplo, o crit�rio Todos-N�s resultar� em uma avalia��o menos rigorosa. Por outro lado, atribuindo pesos maiores para crit�rios mais fortes como, por exemplo, Todos-Potenciais-Usos, resultar� em uma avalia��o mais rigorosa."
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<af:spacer height="20"
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<h:panelGrid columns="2"
					rendered="#{instructorEditAssignment.advancedOptions}">
					<h:outputText value="Crit�rios" styleClass="label" />
					<h:outputText value="Pesos" styleClass="label" />
					<h:outputText value="Funcional*:" />
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
					<h:outputText value="Todos-N�s*:" />
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
					<h:outputText value="Todos-Arcos*:" />
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
					<h:outputText value="Todos-Usos*:" />
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
					<h:outputText value="Todos-Potenciais-Usos*:" />
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

				<h:outputText
					value="Nas op��es abaixo, pesos maiores nas execu��es Pal-Tal e Pal-Tinst far�o com que a qualidade dos programas submetidos pelos alunos tenham uma maior influ�ncia no resultado da avalia��o. Da mesma forma, peso maior na execu��o Pinst-Tal far� com que a qualidade dos casos de teste tenham maior influ�ncia no resultado da avalia��o."
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<af:spacer height="20"
					rendered="#{instructorEditAssignment.advancedOptions}" />

				<h:panelGrid columns="2"
					rendered="#{instructorEditAssignment.advancedOptions}">
					<h:outputText value="Execu��es" styleClass="label" />
					<h:outputText value="Pesos" styleClass="label" />
					<h:outputText
						value="Programa do Aluno com Casos de Teste do Aluno (PAL-TAL)*:" />
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
						value="Programa do Instrutor com Casos de Teste do Aluno (PINST-TAL)*:" />
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
						value="Programa do Aluno com Casos de Teste do Instrutor (PAL-TINST)*:" />
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

				<h:commandButton value="Cancelar"
					action="#{instructorEditAssignment.cancel}" />
				<h:commandButton value="Salvar"
					action="#{instructorEditAssignment.edit}" />

			</htm:div>

		</h:form>

	</f:subview>
</jsp:root>