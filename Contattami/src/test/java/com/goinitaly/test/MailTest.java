package com.goinitaly.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goinitaly.spring.svc.IMailSenderSvc;
import com.goinitaly.spring.web.dto.MailInfoContainer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:WebContent/WEB-INF/spring/ctxs/contattami-ctx.xml"})
public class MailTest
{
	private Logger logger = LoggerFactory.getLogger(MailTest.class.getName());
	@Autowired
	private IMailSenderSvc mailSdr;
	@Test
	public void sendMailTest()
	{
		try
		{
			MailInfoContainer mail = new MailInfoContainer();
			mail.setBirthDate("22/03/1974");
			mail.setFrom("angeloimm@gmail.com");
			mail.setTo("info@goinitaly.com");
			mail.setNameSurname("Angelo Immediata");
			mail.setIndipendentExperiences("Nessuna");
			mail.setInterestedTrip("Badia");
			mail.setMailPassword("baBa113It!#");
			mail.setMailServerHost("authsmtp.goinitaly.com");
			mail.setMailServerPort(25);
			mail.setMailUsername("info@goinitaly.com");
			mail.setNationality("Italian");
			mail.setOccupation("Test occ");
			mail.setQuestions("Che si fa?");
			mail.setWhereHeardUs("fonti....");
			mail.setSubject("Questo è un test");
			mailSdr.sendMail(mail);
		} catch (Exception e)
		{
			logger.error("Errore", e);
		}
	}
}
