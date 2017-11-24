package com.google.devrel.training.conference.domain;

import java.util.Date;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.common.base.Preconditions;
import com.google.devrel.training.conference.form.SessionForm;
import com.google.devrel.training.conference.form.SessionForm.TypeOfSession;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
@Cache
public class Session{
	@Id
    private long id;
	@Parent
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
	private Key<Conference> conferenceKey;
	private String sessionName;
	private String highlights;
	@Index
	private String speaker;
	private int duration;
	@Index
	private TypeOfSession typeOfSession;
	private Date date;
	@Index
	private String startTime;
	
	private Session() {}
	
	public Session(final long id, Key<Conference> conferenceKey, final SessionForm sessionForm) {
		Preconditions.checkNotNull(sessionForm.getSessionName(), "Session name is required");
		Preconditions.checkNotNull(sessionForm.getStartTime(), "Start time is required");
		this.id = id;
		this.conferenceKey = conferenceKey;
		this.sessionName = sessionForm.getSessionName();
		this.highlights = sessionForm.getHighlights();
		this.speaker = sessionForm.getSpeaker();
		this.duration = sessionForm.getDuration();
		this.typeOfSession = sessionForm.getTypeOfSession();
		Date date = sessionForm.getDate();
		this.date = date == null ? null : new Date(date.getTime());
		this.startTime = sessionForm.getStartTime();
	}
	

	public long getId() {
		return id;
	}

	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
	public Key<Conference> getConferenceKey() {
		return Key.create(conferenceKey.getParent(), Conference.class, conferenceKey.getId());
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
	
}