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

			<af:spacer height="30" />

			<h:outputText value="Adicionar Alunos" styleClass="title" />

			<af:spacer height="20" />

			<h:outputText
				value="Dica: Se o aluno que deseja adicionar n�o estiver na lista abaixo, voc� dever� registra-lo." />

			<af:spacer height="20" />

			<h:outputText
				value="Selecione os alunos que deseja adicionar ao curso."
				rendered="#{!empty instructorAddStudents.students}" />

			<af:spacer height="20"
				rendered="#{!empty instructorAddStudents.students}" />

			<h:selectManyCheckbox
				value="#{instructorAddStudents.selectedStudents}"
				layout="pageDirection"
				rendered="#{!empty instructorAddStudents.students}">
				<f:selectItems value="#{instructorAddStudents.students}" />
			</h:selectManyCheckbox>

			<h:outputText value="Nenhum aluno encontrado."
				rendered="#{empty instructorAddStudents.students}" />

			<af:spacer height="30" />

			<h:commandButton value="Cancelar"
				action="#{instructorAddStudents.cancel}" />
			<h:commandButton value="Finalizar"
				action="#{instructorAddStudents.add}"
				rendered="#{!empty instructorAddStudents.students}" />

		</h:form>

	</f:subview>
</jsp:root>