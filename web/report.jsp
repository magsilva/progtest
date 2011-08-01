<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/trinidad" prefix="af"%>
<%@ taglib uri="http://myfaces.apache.org/trinidad/html" prefix="afh"%>
<%@ taglib uri="http://jsftutorials.net/htmLib" prefix="htm"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<f:view>
	<afh:html>
	<afh:head title="ProgTest">
		<htm:title>Title</htm:title>
		<htm:link rel="stylesheet" type="text/css"
			href="#{facesContext.externalContext.requestContextPath}/css/styles.css" />
	</afh:head>
	<afh:body styleClass="body">

		<htm:div style="width: 600px;">

			<h:outputText value="#{reportBean.report.name}" styleClass="title" />

			<af:spacer height="25" />

			<h:dataTable value="#{reportBean.report.sections}" var="section">
				<h:column>

					<h:outputText value="#{section.title}" styleClass="subtitle" />

					<af:spacer height="25" />

					<h:dataTable value="#{section.objects}" var="object">
						<h:column>

							<h:outputText value="#{object.textValue}"
								style="background: #{object.textColor}"
								rendered="#{object.type == 0}" />

							<h:dataTable value="#{object.rows}" var="row"
								headerClass="tableHeader" rowClasses="tableRow" width="100%"
								rendered="#{object.type == 1}">
								<h:column rendered="#{object.header.column1 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column1}" />
									</f:facet>
									<h:outputText value="#{row.column1}" />
								</h:column>
								<h:column rendered="#{object.header.column2 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column2}" />
									</f:facet>
									<h:outputText value="#{row.column2}" />
								</h:column>
								<h:column rendered="#{object.header.column3 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column3}" />
									</f:facet>
									<h:outputText value="#{row.column3}" />
								</h:column>
								<h:column rendered="#{object.header.column4 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column4}" />
									</f:facet>
									<h:outputText value="#{row.column4}" />
								</h:column>
								<h:column rendered="#{object.header.column5 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column5}" />
									</f:facet>
									<h:outputText value="#{row.column5}" />
								</h:column>
								<h:column rendered="#{object.header.column6 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column6}" />
									</f:facet>
									<h:outputText value="#{row.column6}" />
								</h:column>
								<h:column rendered="#{object.header.column7 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column7}" />
									</f:facet>
									<h:outputText value="#{row.column7}" />
								</h:column>
								<h:column rendered="#{object.header.column8 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column8}" />
									</f:facet>
									<h:outputText value="#{row.column8}" />
								</h:column>
								<h:column rendered="#{object.header.column9 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column9}" />
									</f:facet>
									<h:outputText value="#{row.column9}" />
								</h:column>
								<h:column rendered="#{object.header.column10 != null}">
									<f:facet name="header">
										<h:outputText value="#{object.header.column10}" />
									</f:facet>
									<h:outputText value="#{row.column10}" />
								</h:column>
							</h:dataTable>

						</h:column>
					</h:dataTable>

					<af:spacer height="25" />

				</h:column>
			</h:dataTable>

		</htm:div>

	</afh:body>
	</afh:html>
</f:view>