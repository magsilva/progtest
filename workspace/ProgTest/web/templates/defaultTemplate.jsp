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
		<htm:title>
			<tiles:getAsString name="title" />
		</htm:title>
		<htm:link rel="stylesheet" type="text/css"
			href="#{facesContext.externalContext.requestContextPath}/css/styles.css" />
	</afh:head>
	<afh:body styleClass="body">

		<f:loadBundle basename="resources.Messages" var="msg" />

		<htm:center>

			<h:form>

				<h:panelGrid columns="2" style="width: 800px" columnClasses="menu">
					<htm:div style="width:100%">
						<af:spacer height="10" />
						<!-- <af:image source="../images/progtest.gif" /> -->
					</htm:div>
					<htm:div align="right" style="width:100%">
						<af:spacer height="10" />
						<h:commandLink action="login" styleClass="topmenu_link">
							<h:outputText value="Login" styleClass="topmenu_link" />
						</h:commandLink>
						<af:spacer width="5" />
						<h:outputText value="|" />
						<af:spacer width="5" />
						<h:commandLink action="register" styleClass="topmenu_link">
							<h:outputText value="Sign Up" styleClass="topmenu_link" />
						</h:commandLink>
						<af:spacer height="10" />
					</htm:div>
				</h:panelGrid>

			</h:form>

			<htm:div align="center" styleClass="orangebar" />

			<af:spacer height="10" />

			<tiles:insertAttribute name="content" flush="false" />

			<af:spacer height="80" />

			<htm:div align="center" styleClass="orangebar" />

		</htm:center>
	</afh:body>
	</afh:html>
</f:view>