<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<portlet:resourceURL var="sendMail" escapeXml="false" id="sendMail" />
<input type="hidden" id="contattamiSendMailUrl" name="contattamiSendMailUrl" value="${sendMail}">
<form id="contattamiForm" action="#">
<table>
	<tr>
		<td>
			<strong><spring:message code="contattami.nameSurname" /></strong>
		</td>
		<td>
			<input type="text" id="contattamiNome" name="contattamiNome" required >
		</td>
		<td>
			<strong><spring:message code="contattami.mailAddress" /></strong>
		</td>
		<td>
			<input type="email" id="contattamiMailAddres" name="contattamiMailAddress" required >
		</td>
		<td>
			<strong><spring:message code="contattami.birthDate" /></strong>
		</td>
		<td>
			<input type="text" id="contattamiBirthDate" name="contattamiBirthDate" required >
		</td>
	</tr>
	<tr>		
		<td>
			<strong><spring:message code="contattami.nationality" /></strong>
		</td>
		<td>
			<input type="text" id="contattamiNationality" name="contattamiNationality" required >
		</td>
		<td>
			<strong><spring:message code="contattami.occupation" /></strong>
		</td>
		<td colspan="3">
			<input type="text" id="contattamiOccupation" name="contattamiOccupation">
		</td>
	</tr>   
	<tr>
		<td>
			<strong><spring:message code="contattami.whereHeardUs" /></strong>
		</td>
		<td>
			<textarea id="contattamiWhereHeardUs" name="contattamiWhereHeardUs" required ></textarea>
		</td>	
		<td>
			<strong><spring:message code="contattami.interestedTrips" /></strong>
		</td>
		<td colspan="3">
			<textarea id="contattamiInterestedTrips" name="contattamiInterestedTrips" required ></textarea>
		</td>
	</tr>
	<tr>
		<td>
			<strong><spring:message code="contattami.independentExperiences" /></strong>
		</td>
		<td>
			<textarea id="contattamiIndependentExp" name="contattamiIndependentExp"></textarea>
		</td>
		<td>
			<strong><spring:message code="contattami.questions" /></strong>
		</td>
		<td colspan="3">
			<textarea id="contattamiQuestions" name="contattamiQuestions"></textarea>
		</td>
	</tr>		   		    		 		  		    		   		    		
</table>
<div>
	<input type="submit" id="contattamiInviaMail" name="contattamiInviaMail" value='<spring:message code="contattami.sendMail"/>'>
	<input type="reset" id="contattamiReset" name="contattamiReset" value='<spring:message code="contattami.cancelSending"/>'>
</div>
</form>
<div id="sendMailResultDialog" title='<spring:message code="contattami.dialogTitle"/>'>
  <p id="contattamiMessageResult">
    
  </p>
</div>
<input type="hidden" id="contattamiSendingMailMessage" name="contattamiSendingMailMessage" value='<spring:message code="contattami.sendingMailMessage"/>'>
<input type="hidden" id="contattamiErrore" name="contattamiErrore" value='<spring:message code="contattami.mailError"/>'>
<input type="hidden" id="contattamiSuccesso" name="contattamiSuccesso" value='<spring:message code="contattami.mailSent"/>'>