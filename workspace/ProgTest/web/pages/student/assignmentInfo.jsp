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

					<h:outputText value="Trabalho" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectDefaultView}"
									styleClass="link">
									<h:outputText value="Informa��es sobre o Trabalho"
										styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 0}" />
									<h:outputText value="Informa��es sobre o Trabalho"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 0}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Resultado da Avalia��o" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="25" />

					<h:outputText value="Relat�rios" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:outputText value="Teste Funcional" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Elementos Requeridos" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Cobertura por Classe" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Cobertura por M�todo" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Cobertura por Crit�rio" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:outputText value="Elementos Cobertos e N�o Cobertos" />
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="30" />

					<h:outputText value="A��es" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/upload.png" />
						<h:commandLink action="#{studentAssignmentInfo.send}"
							styleClass="link">
							<h:outputText value="Enviar Trabalho" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<htm:div style="width: 170px;"
					rendered="#{studentAssignmentInfo.viewId != 0}">

					<af:spacer height="25" />

					<h:outputText value="Trabalho" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink action="#{studentAssignmentInfo.selectAboutView}"
									styleClass="link">
									<h:outputText value="Informa��es sobre o Trabalho"
										styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 1}" />
									<h:outputText value="Informa��es sobre o Trabalho"
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
									<h:outputText value="Resultado da Avalia��o" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 2}" />
									<h:outputText value="Resultado da Avalia��o"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 2}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="25" />

					<h:outputText value="Relat�rios" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAssignmentInfo.selectFunctionalTestView}"
									styleClass="link">
									<h:outputText value="Teste Funcional" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 3}" />
									<h:outputText value="Teste Funcional" styleClass="link_hover"
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
									<h:outputText value="Elementos Requeridos" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 4}" />
									<h:outputText value="Elementos Requeridos"
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
									<h:outputText value="Cobertura por Classe" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 5}" />
									<h:outputText value="Cobertura por Classe"
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
									<h:outputText value="Cobertura por M�todo" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 6}" />
									<h:outputText value="Cobertura por M�todo"
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
									<h:outputText value="Cobertura por Crit�rio" styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 7}" />
									<h:outputText value="Cobertura por Crit�rio"
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
									<h:outputText value="Elementos Cobertos e N�o Cobertos"
										styleClass="link"
										rendered="#{studentAssignmentInfo.viewId != 8}" />
									<h:outputText value="Elementos Cobertos e N�o Cobertos"
										styleClass="link_hover"
										rendered="#{studentAssignmentInfo.viewId == 8}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="30" />

					<h:outputText value="A��es" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/upload.png" />
						<h:commandLink action="#{studentAssignmentInfo.send}"
							styleClass="link">
							<h:outputText value="Enviar Trabalho Novamente" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<af:image source="/images/add.png" />
						<h:commandLink action="#{studentAssignmentInfo.add}"
							styleClass="link">
							<h:outputText value="Adicionar Casos de Teste" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="15" />

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 0}">

					<af:spacer height="20" />

					<h:outputText value="Informa��es sobre o Trabalho"
						styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="T�tulo: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.title}" />

					<af:spacer height="10" />

					<h:outputText value="Descri��o: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.description}" />

					<af:spacer height="10" />

					<h:outputText value="In�cio: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.startDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="T�rmino: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.endDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 1}">

					<af:spacer height="20" />

					<h:outputText value="Informa��es sobre o Trabalho"
						styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="T�tulo: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.title}" />

					<af:spacer height="10" />

					<h:outputText value="Descri��o: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.description}" />

					<af:spacer height="10" />

					<h:outputText value="In�cio: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.startDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="T�rmino: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.endDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="Enviado em: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.submissionDate}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<af:spacer height="10" />

					<h:outputText value="Nota: " styleClass="label" />
					<h:outputText value="#{studentAssignmentInfo.score}" />

					<af:spacer height="10" />

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 2}">

					<af:spacer height="20" />

					<h:outputText value="Resultado da Avalia��o" styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Cobertura Geral" styleClass="subtitle" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentAssignmentInfo.generalCoverageReport}"
						var="generalCoverageReport"
						binding="#{studentAssignmentInfo.generalCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.criterion}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Cobertura Pinst-Tinst" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.pinstTinst}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Cobertura Pal-Tal" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.palTal}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Cobertura Pinst-Tal" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.pinstTal}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Cobertura Pal-Tinst" />
							</f:facet>
							<h:outputText value="#{generalCoverageReport.palTinst}" />
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText value="Cobertura Total" styleClass="subtitle" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentAssignmentInfo.totalCoverageReport}"
						var="totalCoverageReport"
						binding="#{studentAssignmentInfo.totalCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Execu��es" />
							</f:facet>
							<h:outputText value="#{totalCoverageReport.execution}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Cobertura" />
							</f:facet>
							<h:outputText value="#{totalCoverageReport.coverage}" />
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<h:outputText value="Resultado da Avalia��o" styleClass="subtitle" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.resultAvaliationReport}"
						var="resultAvaliationReport"
						binding="#{studentAssignmentInfo.resultAvaliationTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Avalia��es" />
							</f:facet>
							<h:outputText value="#{resultAvaliationReport.element}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Pontos Obtidos" />
							</f:facet>
							<h:outputText value="#{resultAvaliationReport.value}" />
						</h:column>
					</h:dataTable>

					<af:spacer height="30" />

					<htm:center>
						<h:outputText
							value="Nota Sugerida: #{studentAssignmentInfo.score}"
							styleClass="subtitle" />
					</htm:center>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 3}">

					<af:spacer height="20" />

					<h:outputText value="Teste Funcional" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.funcionalCoverageReport}"
						var="funcionalCoverageReport"
						binding="#{studentAssignmentInfo.funcionalCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Testes" />
							</f:facet>
							<h:outputText value="#{funcionalCoverageReport.tests}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Erros" />
							</f:facet>
							<h:outputText value="#{funcionalCoverageReport.errors}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Falhas" />
							</f:facet>
							<h:outputText value="#{funcionalCoverageReport.failures}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Cobertura" />
							</f:facet>
							<h:outputText value="#{funcionalCoverageReport.coverage}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 4}">

					<af:spacer height="20" />

					<h:outputText value="Elementos Requeridos" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.requiredElementsReport}"
						var="requiredElementsReport"
						binding="#{studentAssignmentInfo.requiredElementTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="M�todo" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.method}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-N�s" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.allNodes}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Arcos" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.allEdges}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Usos" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.allUses}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Potenciais-Usos" />
							</f:facet>
							<h:outputText value="#{requiredElementsReport.allPotUses}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 5}">

					<af:spacer height="20" />

					<h:outputText value="Cobertura por Classe" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentAssignmentInfo.classCoverageReport}"
						var="classCoverageReport"
						binding="#{studentAssignmentInfo.classCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Classe" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.clazz}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-N�s" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.allNodes}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Arcos" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.allEdges}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Usos" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.allUses}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Potenciais-Usos" />
							</f:facet>
							<h:outputText value="#{classCoverageReport.allPotUses}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 6}">

					<af:spacer height="20" />

					<h:outputText value="Cobertura por M�todo" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{studentAssignmentInfo.methodCoverageReport}"
						var="methodCoverageReport"
						binding="#{studentAssignmentInfo.methodCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="M�todo" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.method}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-N�s" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.allNodes}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Arcos" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.allEdges}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Usos" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.allUses}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio Todos-Potenciais-Usos" />
							</f:facet>
							<h:outputText value="#{methodCoverageReport.allPotUses}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 7}">

					<af:spacer height="20" />

					<h:outputText value="Cobertura por Crit�rio" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.criterionCoverageReport}"
						var="criterionCoverageReport"
						binding="#{studentAssignmentInfo.criterionCoverageTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio" />
							</f:facet>
							<h:outputText value="#{criterionCoverageReport.criterion}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="N�mero de Elementos" />
							</f:facet>
							<h:outputText value="#{criterionCoverageReport.numberOfElements}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Numero de Elementos Cobertos" />
							</f:facet>
							<h:outputText
								value="#{criterionCoverageReport.numberOfCoveredElements}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Porcentagem" />
							</f:facet>
							<h:outputText value="#{criterionCoverageReport.percentage}" />
						</h:column>
					</h:dataTable>

				</htm:div>

				<htm:div style="width: 615px;"
					rendered="#{studentAssignmentInfo.viewId == 8}">

					<af:spacer height="20" />

					<h:outputText value="Elementos Cobertor e N�o Cobertos"
						styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable
						value="#{studentAssignmentInfo.coveredAndUncoveredReport}"
						var="coveredAndUncoveredReport"
						binding="#{studentAssignmentInfo.coveredAndUncoveredTable}"
						headerClass="tableHeader" rowClasses="tableRow" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="M�todo" />
							</f:facet>
							<h:outputText value="#{coveredAndUncoveredReport.method}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Crit�rio" />
							</f:facet>
							<h:outputText value="#{coveredAndUncoveredReport.criterion}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Elementos Cobertos" />
							</f:facet>
							<h:outputText
								value="#{coveredAndUncoveredReport.coveredElements}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Elementos N�o Cobertos" />
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