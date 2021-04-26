package com.adailsilva.iotenergymeter.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adailsilva.iotenergymeter.api.event.ResourceCreatedEvent;

@Component
public class ResourceCreatedListener implements ApplicationListener<ResourceCreatedEvent> {

	private void addHeaderLocation(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Long id) {

//		System.out.println(httpServletRequest.getMethod());

		if (httpServletRequest.getMethod().contains("POST")) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
			httpServletResponse.setHeader("Location", uri.toASCIIString());
		}

		if (httpServletRequest.getMethod().contains("PUT")) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand(id).toUri();
			httpServletResponse.setHeader("Location", uri.toASCIIString());
		}

	}

	@Override
	public void onApplicationEvent(ResourceCreatedEvent resourceCreatedEvent) {
		HttpServletRequest httpServletRequest = resourceCreatedEvent.getHttpServletRequest();
		HttpServletResponse httpServletResponse = resourceCreatedEvent.getHttpServletResponse();
		Long id = resourceCreatedEvent.getId();
		addHeaderLocation(httpServletRequest, httpServletResponse, id);
	}

}
