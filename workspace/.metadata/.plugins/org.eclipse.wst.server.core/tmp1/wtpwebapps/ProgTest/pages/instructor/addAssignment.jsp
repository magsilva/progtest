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
								<h:commandLink
									action="#{instructorAddAssignment.backToStep1}"
									styleClass="link">
									<h:outputText value="Passo 1: Selecionar Trabalho Oráculo"
										styleClass="link"
										rendered="#{instructorAddAssignment.step != 1}" />
									<h:outputText value="Passo 1: Selecionar Trabalho Oráculo"
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
									<h:outputText value="Passo 2: Informações sobre o Trabalho"
										styleClass="link"
										rendered="#{instructorAddAssignment.step != 2}" />
									<h:outputText value="Passo 2: Informações sobre o Trabalho"
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

					<h:outputText value="Adicionar Novo Trabalho" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText
						value="Passo 1 - Escolha uma das implementações abaixo." />

					<af:spacer height="20" />

					<h:outputText
						value="Dica: Você também pode criar seu prórpio trabalho, submento para ele sua própria implementação de referência. Para isto, escolha a opção 'Criar Novo Trabalho' no menu lateral." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Implementação*:" />
						<h:selectOneMenu value="#{instructorAddAssignment.oracle}">
							<f:selectItems value="#{instructorAddAssignment.oracles}" />
						</h:selectOneMenu>
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandButton value="Cancelar"
						action="#{instructorAddAssignment.cancel}" />
					<h:commandButton value="Próximo"
						action="#{instructorAddAssignment.goToStep2}" />

				</htm:div>

				<htm:div style="width: 600px;"
					rendered="#{instructorAddAssignment.step == 2}">

					<af:spacer height="20" />

					<h:outputText value="Adicionar Novo Trabalho" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Passo 2a - Informe os dados do novo trabalho." />

					<af:spacer height="20" />

					<h:messages styleClass="message" />

					<h:panelGrid columns="2">
						<h:outputText value="Nome*:" />
						<h:inputText value="#{instructorAddAssignment.title}" />
						<h:outputText value="Descrição*:" />
						<h:inputTextarea value="#{instructorAddAssignment.description}" />
						<h:outputText value="Data Início*:" />
						<t:inputDate value="#{instructorAddAssignment.startDate}"
							popupCalendar="true" />
						<h:outputText value="Data Término*:" />
						<t:inputDate value="#{instructorAddAssignment.endDate}"
							popupCalendar="true" />
					</h:panelGrid>

					<af:spacer height="20" />

					<h:commandLink
						action="#{instructorAddAssignment.turnOnAdvancedOptions}"
						styleClass="link"
						rendered="#{!instructorAddAssignment.advancedOptions}">
						<h:outputText value="Opções Avançadas" styleClass="link" />
					</h:commandLink>

					<h:commandLink
						action="#{instructorAddAssignment.turnOffAdvancedOptions}"
						styleClass="link"
						rendered="#{instructorAddAssignment.advancedOptions}">
						<h:outputText value="Opções Básicas" styleClass="link" />
					</h:commandLink>

					<af:spacer height="20"
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<h:outputText value="Passo 2b - Pesos"
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<af:spacer height="20"
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<h:outputText
						value="Com as opções abaixo é possível regular o quão rigorosa será a avaliação. Atribuindo pesos maiores a critérios mais fracos como, por exemplo, o critério Todos-Nós resultará em uma avaliação menos rigorosa. Por outro lado, atribuindo pesos maiores para critérios mais fortes como, por exemplo, Todos-Potenciais-Usos, resultará em uma avaliação mais rigorosa."
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<af:spacer height="20"
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<h:panelGrid columns="2"
						rendered="#{instructorAddAssignment.advancedOptions}">
						<h:outputText value="Critérios" styleClass="label" />
						<h:outputText value="Pesos" styleClass="label" />
						<h:outputText value="Funcional*:" />
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
						<h:outputText value="Todos-Nós*:" />
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
						<h:outputText value="Todos-Arcos*:" />
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
						<h:outputText value="Todos-Usos*:" />
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
						<h:outputText value="Todos-Potenciais-Usos*:" />
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

					<h:outputText
						value="Nas opções abaixo, pesos maiores nas execuções Pal-Tal e Pal-Tinst farão com que a qualidade dos programas submetidos pelos alunos tenham uma maior influência no resultado da avaliação. Da mesma forma, peso maior na execução Pinst-Tal fará com que a qualidade dos casos de teste tenham maior influência no resultado da avaliação."
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<af:spacer height="20"
						rendered="#{instructorAddAssignment.advancedOptions}" />

					<h:panelGrid columns="2"
						rendered="#{instructorAddAssignment.advancedOptions}">
						<h:outputText value="Execuções" styleClass="label" />
						<h:outputText value="Pesos" styleClass="label" />
						<h:outputText
							value="Programa do Aluno com Casos de Teste do Aluno (PAL-TAL)*:" />
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
							value="Programa do Instrutor com Casos de Teste do Aluno (PINST-TAL)*:" />
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
							value="Programa do Aluno com Casos de Teste do Instrutor (PAL-TINST)*:" />
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
					
					<h:outputText
						value="Atenção: Ao finalizar a operação, o processamento do trabalho poderá demorar alguns segundos." styleClass="message" />

					<af:spacer height="20" />

					<h:commandButton value="Cancelar"
						action="#{instructorAddAssignment.cancel}" />
					<h:commandButton value="Voltar"
						action="#{instructorAddAssignment.backToStep1}" />
					<h:commandButton value="Finalizar"
						action="#{instructorAddAssignment.conclude}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>