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
	
		<h:outputText value="teste" />

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

						</h:column>
					</h:dataTable>

					<af:spacer height="25" />

				</h:column>
			</h:dataTable>

		</htm:div>

	</afh:body>
	</afh:html>
</f:view>