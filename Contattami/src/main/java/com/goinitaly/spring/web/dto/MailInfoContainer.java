package com.goinitaly.spring.web.dto;

public class MailInfoContainer
{
	private String from;
	private String to;
	private String nameSurname;
	private String birthDate;
	private String nationality;
	private String whereHeardUs;
	private String occupation;
	private String interestedTrip;
	private String indipendentExperiences;
	private String questions;
	private String mailServerHost;
	private int mailServerPort;
	private String mailUsername;
	private String mailPassword;
	private String subject;
	
	
	public String getNameSurname()
	{
		return nameSurname;
	}
	public void setNameSurname(String nameSurname)
	{
		this.nameSurname = nameSurname;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	public String getMailUsername()
	{
		return mailUsername;
	}
	public void setMailUsername(String mailUsername)
	{
		this.mailUsername = mailUsername;
	}
	public String getMailPassword()
	{
		return mailPassword;
	}
	public void setMailPassword(String mailPassword)
	{
		this.mailPassword = mailPassword;
	}
	public String getMailServerHost()
	{
		return mailServerHost;
	}
	public void setMailServerHost(String mailServerHost)
	{
		this.mailServerHost = mailServerHost;
	}
	public int getMailServerPort()
	{
		return mailServerPort;
	}
	public void setMailServerPort(int mailServerPort)
	{
		this.mailServerPort = mailServerPort;
	}
	public String getBirthDate()
	{
		return birthDate;
	}
	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}
	public String getFrom()
	{
		return from;
	}
	public void setFrom(String from)
	{
		this.from = from;
	}
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
	}

	public String getNationality()
	{
		return nationality;
	}
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}
	public String getWhereHeardUs()
	{
		return whereHeardUs;
	}
	public void setWhereHeardUs(String whereHeardUs)
	{
		this.whereHeardUs = whereHeardUs;
	}
	public String getOccupation()
	{
		return occupation;
	}
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}
	public String getInterestedTrip()
	{
		return interestedTrip;
	}
	public void setInterestedTrip(String interestedTrip)
	{
		this.interestedTrip = interestedTrip;
	}
	public String getIndipendentExperiences()
	{
		return indipendentExperiences;
	}
	public void setIndipendentExperiences(String indipendentExperiences)
	{
		this.indipendentExperiences = indipendentExperiences;
	}
	public String getQuestions()
	{
		return questions;
	}
	public void setQuestions(String questions)
	{
		this.questions = questions;
	}
	@Override
	public String toString()
	{
		return "MailInfoContainer [from=" + from + ", to=" + to + ", nameSurname=" + nameSurname + ", birthDate=" + birthDate + ", nationality=" + nationality + ", whereHeardUs=" + whereHeardUs
				+ ", occupation=" + occupation + ", interestedTrip=" + interestedTrip + ", indipendentExperiences=" + indipendentExperiences + ", questions=" + questions + ", subject=" + subject
				+ "]";
	}
}
