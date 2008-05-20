<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">

<%--
 * <p>Title: Egocentric Networks Web Client</p>
 * <p>Description: Subject Interview Client</p>
 * <p>Copyright: Copyright (c) 2002 - 2004 </p>
 * <p>Company: Endless Loop Software</p>
 * @author Peter Schoaff
 *
 *  $Id: ego_questions.jsp,v 1.4 2004/04/10 23:09:20 admin Exp $
 --%>

<%@ page import="java.util.*" %>
<%@ page import="org.jboss.logging.Logger" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>

<%
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.debug("enter");
%>

<layout:html locale="true" styleClass="FORM" key='global.title'>

	<html:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
	
	<layout:form action="/egoquestionsSubmit" styleClass="FORM" key="egoquestions.title">
	 
	 	<logic:iterate 	id="answer" 
	 							name="egoQuestionForm" 
	 							property="answers" 
	 							indexId="index"
	 							type="com.endlessloopsoftware.egonet.util.AnswerDataValue">
			<%@ include file="show_question.jsp" %>  
		</logic:iterate>
	 
	 	 <tr>&nbsp</tr>

		<layout:row>
			<layout:formActions>
				<layout:submit property="submit" value="Submit"/>   
				<layout:reset/>      
			</layout:formActions>
		 </layout:row>
		 
	</layout:form>

</layout:html>