package com.google.devrel.training.conference.form;

import java.util.Date;

public class SessionForm {
	private String sessionName;
	private String highlights;
	private String speaker;
	private int duration;	
	private TypeOfSession typeOfSession;
	private Date date;
	private String startTime;
	
	private SessionForm() {}
	
	public SessionForm(String sessionName, String highlights,
			String speaker, int duration, TypeOfSession typeOfSession, Date date, String startTime) {
		this.sessionName = sessionName;
		this.highlights = highlights;
		this.speaker = speaker;
		this.duration = duration;
		this.typeOfSession = typeOfSession;
		this.date = date;
		this.startTime = startTime;
	}
	
	
	public String getSessionName() {
		return sessionName;
	}


	public String getHighlights() {
		return highlights;
	}


	public String getSpeaker() {
		return speaker;
	}


	public int getDuration() {
		return duration;
	}


	public TypeOfSession getTypeOfSession() {
		return typeOfSession;
	}


	public Date getDate() {
		return date;
	}


	public String getStartTime() {
		return startTime;
	}


	public static enum TypeOfSession {
        Workshop,
        Lecture,
        Training,
        Meeting,
        Exhibition
    }
}
