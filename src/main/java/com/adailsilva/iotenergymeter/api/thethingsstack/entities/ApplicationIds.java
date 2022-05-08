package com.adailsilva.iotenergymeter.api.thethingsstack.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "application_id" })
@Generated("adailsilva")
public class ApplicationIds implements Serializable {

	private final static long serialVersionUID = 7051645347208148104L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("application_id")
	private String applicationId;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public ApplicationIds() {
	}

	/**
	 * 
	 * @param id
	 * @param applicationId
	 */
	public ApplicationIds(Long id, String applicationId) {
		super();
		this.id = id;
		this.applicationId = applicationId;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	public ApplicationIds withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("application_id")
	public String getApplicationId() {
		return applicationId;
	}

	@JsonProperty("application_id")
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public ApplicationIds withApplicationId(String applicationId) {
		this.applicationId = applicationId;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public ApplicationIds withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ApplicationIds.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("applicationId");
		sb.append('=');
		sb.append(((this.applicationId == null) ? "<null>" : this.applicationId));
		sb.append(',');
		sb.append("additionalProperties");
		sb.append('=');
		sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationIds other = (ApplicationIds) obj;
		return Objects.equals(id, other.id);
	}

}
