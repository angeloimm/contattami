package com.goinitaly.spring.svc.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.StringUtils;

import com.goinitaly.spring.svc.IMailSenderSvc;
import com.goinitaly.spring.web.dto.MailInfoContainer;

@Service
public class MailSenderImpl implements IMailSenderSvc
{
	private static final Logger log = LoggerFactory.getLogger(MailSenderImpl.class.getName());
	@Autowired
	private JavaMailSender mailSend;
	@Autowired
	private VelocityEngine velocityEngine;
	@Override
	public void sendMail(final MailInfoContainer mail) throws Exception
	{
		try
		{
			if( !StringUtils.hasText(mail.getMailServerHost()) )
			{
				throw new IllegalArgumentException("Mail server non valido: <"+mail.getMailServerHost()+">");
			}
			if( mail.getMailServerPort() <= 0 )
			{
				throw new IllegalArgumentException("Porta mail server non valida: <"+mail.getMailServerPort()+">");
			}
			if( !StringUtils.hasText(mail.getMailUsername()) )
			{
				throw new IllegalArgumentException("Username mail non valido: <"+mail.getMailUsername()+">");
			}
			if( !StringUtils.hasText(mail.getMailPassword()) )
			{
				throw new IllegalArgumentException("Mail password non valida: <"+mail.getMailPassword()+">");
			}
			((JavaMailSenderImpl)mailSend).setHost(mail.getMailServerHost());
			((JavaMailSenderImpl)mailSend).setPort(mail.getMailServerPort());
			((JavaMailSenderImpl)mailSend).setUsername(mail.getMailUsername());
			((JavaMailSenderImpl)mailSend).setPassword(mail.getMailPassword());
			MimeMessagePreparator preparator = new MimeMessagePreparator()
			{
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception
				{
					
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	                message.setTo(mail.getTo());
	                message.setCc(mail.getFrom());
	                message.setFrom(mail.getFrom());
	                if( StringUtils.hasText(mail.getSubject()) )
	                {
	                
	                	message.setSubject(mail.getSubject());
	                }
	                Map<String, Object> model = new HashMap<String, Object>(1);
	                model.put("dto", mail);
	                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "com/goinitaly/mail/template/mail.vm","UTF-8", model);
	                message.setText(text, true);
				}
			};
			mailSend.send(preparator);
			
		} catch (Exception e)
		{
			String message = "Errore nell'invio della mail; "+e.getMessage();
			log.error(message, e);
			throw e;
		}

	}

}
