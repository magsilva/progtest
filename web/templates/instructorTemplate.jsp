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

		<f:loadBundle basename="messages" var="msg" />

		<htm:center>

			<h:form>

				<h:panelGrid columns="2" style="width: 800px" columnClasses="menu">
					<htm:div style="width:100%">
						<af:spacer height="10" />
						<!-- <af:image source="../images/progtest.gif" /> -->
					</htm:div>
					<htm:div align="right" style="width:100%">
						<af:spacer height="10" />
						<h:outputText value="#{login.userName}"
							styleClass="topmenu_username" />
						<af:spacer width="5" />
						<h:outputText value="|" />
						<af:spacer width="5" />
						<h:commandLink action="instructorProfile"
							styleClass="topmenu_link">
							<h:outputText value="Edit Profile" styleClass="topmenu_link" />
						</h:commandLink>
						<af:spacer width="5" />
						<h:outputText value="|" />
						<af:spacer width="5" />
						<h:commandLink action="#{logoff.logoff}" styleClass="topmenu_link">
							<h:outputText value="Log Out" styleClass="topmenu_link" />
						</h:commandLink>
						<af:spacer height="10" />
					</htm:div>
				</h:panelGrid>

				<htm:div align="center" styleClass="orangebar">
					<htm:div align="left" style="width: 800px">
						<htm:table>
							<htm:tr style="height: 30px">
								<htm:td>
									<h:commandLink action="instructorCourses" styleClass="orangebar_link">
										<h:outputText value="Courses" styleClass="orangebar_link" />
									</h:commandLink>
								</htm:td>
								<htm:td style="color: #ffffff">
									<af:spacer width="10" />
									<h:outputText value="|" />
									<af:spacer width="10" />
								</htm:td>
								<htm:td>
									<h:commandLink action="instructorAssignments"
										styleClass="orangebar_link">
										<h:outputText value="Assignments"
											styleClass="orangebar_link" />
									</h:commandLink>
								</htm:td>
								<htm:td style="color: #ffffff">
									<af:spacer width="10" />
									<h:outputText value="|" />
									<af:spacer width="10" />
								</htm:td>
								<htm:td>
									<h:commandLink action="instructorStudents" styleClass="orangebar_link">
										<h:outputText value="Students" styleClass="orangebar_link" />
									</h:commandLink>
								</htm:td>
							</htm:tr>
						</htm:table>
					</htm:div>
				</htm:div>

			</h:form>

			<af:spacer height="10" />

			<tiles:insertAttribute name="content" flush="false" />

		</htm:center>
	</afh:body>
	</afh:html>
</f:view>