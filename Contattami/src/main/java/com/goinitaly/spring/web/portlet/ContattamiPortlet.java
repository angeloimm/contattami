package com.goinitaly.spring.web.portlet;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goinitaly.spring.svc.IMailSenderSvc;
import com.goinitaly.spring.web.dto.BaseAjaxResponseDto;
import com.goinitaly.spring.web.dto.MailFormDto;
import com.goinitaly.spring.web.dto.MailInfoContainer;
import com.goinitaly.spring.web.util.DateUtil;

@Controller
@RequestMapping(value="VIEW")
public class ContattamiPortlet
{
	private static final Logger logger = LoggerFactory.getLogger(ContattamiPortlet.class.getName());
	@Autowired
	private IMailSenderSvc mailSdr;
	private String mailServerHost;
	private String mailServerPort;
	private String mailServerUsername;
	private String mailServerPassword;
	private String mailTo;
	private String mailSubject;
	@RequestMapping
	public String renderContattami(RenderRequest renderRequest, Model model)
	{
		initializeMailService(renderRequest.getPreferences());
		return "contattami";
	}
	private void initializeMailService(PortletPreferences pp)
	{
		if( logger.isInfoEnabled() )
		{
			logger.info("Setting defaul values for mail service");
		}
		mailServerHost = pp.getValue("mailServerHost", null);
		mailServerPort = pp.getValue("mailServerPort", null);
		mailServerUsername = pp.getValue("mailServerUsername", null);
		mailServerPassword = pp.getValue("mailServerPassword", null);
		mailTo = pp.getValue("mailTo", null);
		mailSubject = pp.getValue("mailSubject", null);
	}
	@ResourceMapping("sendMail")
	public void sendMail( ResourceRequest rr, ResourceResponse rs )
	{
		BaseAjaxResponseDto bard = new BaseAjaxResponseDto();
		ObjectMapper om = new ObjectMapper();
		try
		{
			
			MailInfoContainer mic = new MailInfoContainer();
			mic.setMailServerHost(mailServerHost);
			mic.setMailServerPort(Integer.parseInt(mailServerPort));
			mic.setMailPassword(mailServerPassword);
			mic.setMailUsername(mailServerUsername);
			mic.setTo(mailTo);
			MailFormDto mfd = om.readValue(rr.getPortletInputStream(), MailFormDto.class);
			mic.setBirthDate(DateUtil.fromLongToString(mfd.getBirthDate()));
			mic.setFrom(mfd.getMailAddress());
			mic.setIndipendentExperiences(mfd.getIndependentExperiences());
			mic.setInterestedTrip(mfd.getInterestedTrips());
			mic.setNameSurname(mfd.getNameSurname());
			mic.setNationality(mfd.getNationality());
			mic.setOccupation(mfd.getOccupation());
			mic.setQuestions(mfd.getQuestions());
			mic.setSubject(mailSubject);
			mic.setTo(mailTo);
			mic.setWhereHeardUs(mfd.getWhereHeardUs());
			this.mailSdr.sendMail(mic);
			String message = "Invio mail avvenuto con successo";
			bard.setOperationMessage(message);
			bard.setOperationStatusCode(HttpStatus.OK.value());
			
		} catch (Exception e)
		{
			String message = "Errore durante l'invio della mail; "+e.getMessage();
			logger.error(message, e);
			bard.setOperationMessage(message);
			bard.setOperationStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		finally
		{
			try
			{
				JsonGenerator generator = om.getFactory().createGenerator(rs.getPortletOutputStream());
				om.writeValue(generator, bard);
			} catch (Exception e2)
			{
				String message = "Errore nella scrittura del JSON di risposta; "+e2.getMessage();
				logger.error(message, e2);
			}
		}
	}
}
