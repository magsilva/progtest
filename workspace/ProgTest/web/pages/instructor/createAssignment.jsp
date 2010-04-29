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

					<h:outputText value="Passos" styleClass="menu_title" />

					<af:spacer height="15" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{instructorCreateAssignment.backToStep1}"
									styleClass="link">
									<h:outputText value="Passo 1: Informa��es sobre o Trabalho"
										styleClass="link"
										rendered="#{instructorCreateAssignment.step != 1}" />
									<h:outputText value="Passo 1: Informa��es sobre o Trabalho"
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
									<h:outputText value="Passo 2: Upload do Trabalho Or�culo" styleClass="link"
										rendered="#{instructorCreateAssignment.step != 2}" />
									<h:outputText value="Passo 2: Upload do Trabalho Or�culo" styleClass="link_hover"
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

					<h:outputText value="Criar Novo Trabalho" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Dica: Voc� tamb�m pode adicionar ao curso um trabalho pronto dispon�vel pela ProgTest. Para isto, escolha a op��o 'Adicionar Trabalho' no menu lateral." />

					<af:spacer height="20" />

					<h:outputText value="Passo 1a - Informe os dados do novo trabalho." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Nome*:" />
						<h:inputText value="#{instructorCreateAssignment.title}" />
						<h:outputText value="Descri��o*:" />
						<h:inputTextarea value="#{instructorCreateAssignment.description}" />
						<h:outputText value="Data In�cio*:" />
						<t:inputDate value="#{instructorCreateAssignment.startDate}"
							popupCalendar="true" />
						<h:outputText value="Data T�rmino*:" />
						<t:inputDate value="#{instructorCreateAssignment.endDate}"
							popupCalendar="true" />
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandLink
						action="#{instructorCreateAssignment.turnOnAdvancedOptions}"
						styleClass="link"
						rendered="#{!instructorCreateAssignment.advancedOptions}">
						<h:outputText value="Op��es Avan�adas" styleClass="link" />
					</h:commandLink>

					<h:commandLink
						action="#{instructorCreateAssignment.turnOffAdvancedOptions}"
						styleClass="link"
						rendered="#{instructorCreateAssignment.advancedOptions}">
						<h:outputText value="Op��es B�sicas" styleClass="link" />
					</h:commandLink>

					<af:spacer height="20"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<h:outputText value="Passo 1b - Pesos"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<af:spacer height="20"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<h:outputText
						value="Com as op��es abaixo � poss�vel regular o qu�o rigorosa ser� a avalia��o. Atribuindo pesos maiores a crit�rios mais fracos como, por exemplo, o crit�rio Todos-N�s resultar� em uma avalia��o menos rigorosa. Por outro lado, atribuindo pesos maiores para crit�rios mais fortes como, por exemplo, Todos-Potenciais-Usos, resultar� em uma avalia��o mais rigorosa."
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<af:spacer height="20"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<h:panelGrid columns="2"
						rendered="#{instructorCreateAssignment.advancedOptions}">
						<h:outputText value="Crit�rios" styleClass="label" />
						<h:outputText value="Pesos" styleClass="label" />
						<h:outputText value="Funcional*:" />
						<h:selectOneMenu
							value="#{instructorAddAssigment.weightFunctional}">
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
						<h:outputText value="Todos-Arcos*:" />
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
						<h:outputText value="Todos-Usos*:" />
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
						<h:outputText value="Todos-Potenciais-Usos*:" />
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

					<h:outputText
						value="Nas op��es abaixo, pesos maiores nas execu��es Pal-Tal e Pal-Tinst far�o com que a qualidade dos programas submetidos pelos alunos tenham uma maior influ�ncia no resultado da avalia��o. Da mesma forma, peso maior na execu��o Pinst-Tal far� com que a qualidade dos casos de teste tenham maior influ�ncia no resultado da avalia��o."
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<af:spacer height="20"
						rendered="#{instructorCreateAssignment.advancedOptions}" />

					<h:panelGrid columns="2"
						rendered="#{instructorCreateAssignment.advancedOptions}">
						<h:outputText value="Execu��es" styleClass="label" />
						<h:outputText value="Pesos" styleClass="label" />
						<h:outputText
							value="Programa do Aluno com Casos de Teste do Aluno (PAL-TAL)*:" />
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
							value="Programa do Instrutor com Casos de Teste do Aluno (PINST-TAL)*:" />
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
							value="Programa do Aluno com Casos de Teste do Instrutor (PAL-TINST)*:" />
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

					<h:commandButton value="Cancelar"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Pr�ximo"
						action="#{instructorCreateAssignment.goToStep2}" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{instructorCreateAssignment.step == 2}">

					<af:spacer height="20" />

					<h:outputText value="Criar Novo Trabalho" styleClass="title" />
					
					<af:spacer height="20" />

					<h:outputText
						value="Passo 2 - Indique um arquivo .jar com o c�digo-fonte (arquivos .java) do programa e do conjunto de de teste a ser utilizado como refer�ncia na avalia��o." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Arquivo*:" />
						<t:inputFileUpload value="#{instructorCreateAssignment.file}"
							storage="file" />
					</h:panelGrid>

					<af:spacer height="20" />
					
					<h:outputText
						value="Aten��o: O processamento do trabalho poder� demorar alguns segundos." styleClass="message" />

					<af:spacer height="20" />

					<h:commandButton value="Cancelar"
						action="#{instructorCreateAssignment.cancel}" />
					<h:commandButton value="Voltar"
						action="#{instructorCreateAssignment.backToStep1}" />
					<h:commandButton value="Finalizar"
						action="#{instructorCreateAssignment.conclude}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>