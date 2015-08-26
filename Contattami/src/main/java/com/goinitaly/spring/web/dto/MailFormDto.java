package com.goinitaly.spring.web.dto;

import java.io.Serializable;

public class MailFormDto implements Serializable
{

	private static final long serialVersionUID = 407835079388663852L;
	private String nameSurname;
	private String mailAddress;
	private long birthDate;
	private String nationality;
	private String whereHeardUs;
	private String occupation;
	private String interestedTrips;
	private String independentExperiences;
	private String questions;
	public String getNameSurname()
	{
		return nameSurname;
	}
	public void setNameSurname(String nameSurname)
	{
		this.nameSurname = nameSurname;
	}
	public String getMailAddress()
	{
		return mailAddress;
	}
	public void setMailAddress(String mailAddress)
	{
		this.mailAddress = mailAddress;
	}
	public long getBirthDate()
	{
		return birthDate;
	}
	public void setBirthDate(long birthDate)
	{
		this.birthDate = birthDate;
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
	public String getInterestedTrips()
	{
		return interestedTrips;
	}
	public void setInterestedTrips(String interestedTrips)
	{
		this.interestedTrips = interestedTrips;
	}
	public String getIndependentExperiences()
	{
		return independentExperiences;
	}
	public void setIndependentExperiences(String independentExperiences)
	{
		this.independentExperiences = independentExperiences;
	}
	public String getQuestions()
	{
		return questions;
	}
	public void setQuestions(String questions)
	{
		this.questions = questions;
	}
}
