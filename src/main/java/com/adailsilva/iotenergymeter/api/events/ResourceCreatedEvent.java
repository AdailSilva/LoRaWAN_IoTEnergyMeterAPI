package com.adailsilva.iotenergymeter.api.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceCreatedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest httpServletRequest;

	private HttpServletResponse httpServletResponse;

	private Long id;

	public ResourceCreatedEvent(Object source, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Long id) {
		super(source);

		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
		this.id = id;
	}

}
