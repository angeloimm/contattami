package com.goinitaly.spring.svc;

import com.goinitaly.spring.web.dto.MailInfoContainer;

public interface IMailSenderSvc
{
	public void sendMail(MailInfoContainer mail) throws Exception;
}
