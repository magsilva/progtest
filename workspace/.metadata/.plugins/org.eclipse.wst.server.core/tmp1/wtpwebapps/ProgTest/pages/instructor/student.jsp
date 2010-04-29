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

					<h:outputText value="Aluno" styleClass="menu_title" />

					<af:spacer height="10" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{instructorStudent.selectAboutView}"
									styleClass="link">
									<h:outputText value="Informa��es sobre o Aluno"
										styleClass="link"
										rendered="#{instructorStudent.viewId != 0}" />
									<h:outputText value="Informa��es sobre o Aluno"
										styleClass="link_hover"
										rendered="#{instructorStudent.viewId == 0}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{instructorStudent.selectGradesView}"
									styleClass="link">
									<h:outputText value="Notas"
										styleClass="link"
										rendered="#{instructorStudent.viewId != 1}" />
									<h:outputText value="Notas"
										styleClass="link_hover"
										rendered="#{instructorStudent.viewId == 1}" />
								</h:commandLink>
								<af:spacer height="5" />
							</htm:td>
						</htm:tr>
					</htm:table>

					<af:spacer height="40" />

					<h:outputText value="A��es" styleClass="menu_title" />

					<af:spacer height="10" />

					<h:panelGrid columns="2">
						<af:image source="/images/remove.png" />
						<h:commandLink action="#{instructorStudent.remove}"
							styleClass="link">
							<h:outputText value="Remover Aluno" styleClass="topmenu_link" />
						</h:commandLink>
					</h:panelGrid>

				</htm:div>

				<af:spacer width="60" />

				<htm:div style="width: 570px;"
					rendered="#{instructorStudent.viewId == 0}">

					<af:spacer height="20" />

					<h:outputText value="Informa��es sobre o Aluno"
						styleClass="title" />

					<af:spacer height="20" />

					<h:outputText value="Nome de Usu�rio: " styleClass="label" />
					<h:outputText value="#{instructorStudent.userName}" />

					<af:spacer height="10" />

					<h:outputText value="Nome: " styleClass="label" />
					<h:outputText value="#{instructorStudent.name}" />

					<af:spacer height="10" />

					<h:outputText value="E-mail: " styleClass="label" />
					<h:outputText value="#{instructorStudent.email}" />

					<af:spacer height="10" />

				</htm:div>

				<htm:div style="width: 570px;"
					rendered="#{instructorStudent.viewId == 1}">

					<af:spacer height="20" />

					<h:outputText value="Notas" styleClass="title" />

					<af:spacer height="20" />

					<h:dataTable value="#{instructorStudent.evaluations}" var="evaluation"
						binding="#{instructorStudent.evaluationsTable}" width="100%"
						rowClasses="tableRow" headerClass="tableHeader"
						rendered="#{!empty instructorStudent.evaluations}">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Trabalho" />
							</f:facet>
							<h:outputText value="#{evaluation.assignment.title}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Nota" />
							</f:facet>
							<h:outputText value="#{evaluation.score}" />
						</h:column>
					</h:dataTable>

					<h:outputText value="N�o h� trabalhos no curso."
						rendered="#{empty instructorStudent.evaluations}" />

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>