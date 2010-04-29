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

					<h:outputText value="Cursos" styleClass="menu_title" />

					<af:spacer height="15" />

					<htm:table>
						<htm:tr>
							<htm:td>
								<h:commandLink
									action="#{studentAllAssignments.selectAllCourses}"
									styleClass="link">
									<h:outputText value="Todos os cursos" styleClass="link"
										rendered="#{studentAllAssignments.activedCourse != null}" />
									<h:outputText value="Todos os cursos" styleClass="link_hover"
										rendered="#{studentAllAssignments.activedCourse == null}" />
								</h:commandLink>
							</htm:td>
						</htm:tr>
					</htm:table>

					<h:dataTable value="#{studentAllAssignments.courses}" var="course"
						binding="#{studentAllAssignments.coursesTable}" width="100%">
						<h:column>
							<af:spacer height="10" />
							<h:commandLink action="#{studentAllAssignments.selectCourse}"
								styleClass="link">
								<h:outputText value="#{course.name}" styleClass="link"
									rendered="#{course.name != studentAllAssignments.activedCourse}" />
								<h:outputText value="#{course.name}" styleClass="link_hover"
									rendered="#{course.name == studentAllAssignments.activedCourse}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>

				</htm:div>

				<af:spacer width="15" />

				<htm:div style="width: 615px;">

					<af:spacer height="20" />

					<h:outputText value="Todos Trabalhos" styleClass="title" />

					<af:spacer height="30" />

					<h:dataTable value="#{studentAllAssignments.evaluations}"
						var="evaluation"
						binding="#{studentAllAssignments.evaluationsTable}" width="100%"
						rendered="#{!empty studentAllAssignments.evaluations}">
						<h:column>
							<htm:table styleClass="grid">
								<htm:tr styleClass="tableHeader">
									<htm:td>
										<h:outputText value="#{evaluation.assignment.title}" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="10" />
										<h:outputText value="#{evaluation.assignment.description}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="5" />
										<h:outputText value="Data de entrega: " styleClass="label" />
										<h:outputText value="#{evaluation.assignment.endDate}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr>
									<htm:td>
										<af:spacer height="5" />
										<h:outputText value="Situa��o: " styleClass="label" />
										<h:outputText value="Enviado"
											rendered="#{evaluation.submissionDate != null}" />
										<h:outputText value="Pendente"
											rendered="#{evaluation.submissionDate == null}" />
										<af:spacer height="5" />
									</htm:td>
								</htm:tr>
								<htm:tr align="right">
									<htm:td>
										<h:commandButton value="Enviar"
											action="#{studentAllAssignments.submitAssignment}"
											rendered="#{evaluation.submissionDate == null}" />
										<af:spacer width="5" />
										<h:commandButton value="Visualizar"
											action="#{studentAllAssignments.assignmentInfo}" />
									</htm:td>
								</htm:tr>
							</htm:table>
							<af:spacer height="20" />
						</h:column>
					</h:dataTable>

					<htm:table rendered="#{empty studentAllAssignments.evaluations}">
						<htm:tr>
							<htm:td>
								<h:outputText value="N�o h� trabalhos pendentes." />
							</htm:td>
						</htm:tr>
					</htm:table>

				</htm:div>

			</h:panelGrid>

		</h:form>

	</f:subview>
</jsp:root>