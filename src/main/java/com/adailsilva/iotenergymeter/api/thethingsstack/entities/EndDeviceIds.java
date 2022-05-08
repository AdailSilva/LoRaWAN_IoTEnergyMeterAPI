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
@JsonPropertyOrder({ "id", "device_id", "application_ids", "dev_eui", "join_eui", "dev_addr" })
@Generated("adailsilva")
public class EndDeviceIds implements Serializable {

	private final static long serialVersionUID = 7024592191141510399L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("device_id")
	private String deviceId;

	@JsonProperty("application_ids")
	private ApplicationIds applicationIds;

	@JsonProperty("dev_eui")
	private String devEui;

	@JsonProperty("join_eui")
	private String joinEui;

	@JsonProperty("dev_addr")
	private String devAddr;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public EndDeviceIds() {
	}

	/**
	 * 
	 * @param id
	 * @param deviceId
	 * @param applicationIds
	 * @param devEui
	 * @param joinEui
	 * @param devAddr
	 */
	public EndDeviceIds(Long id, String deviceId, ApplicationIds applicationIds, String devEui, String joinEui,
			String devAddr) {
		super();
		this.id = id;
		this.deviceId = deviceId;
		this.applicationIds = applicationIds;
		this.devEui = devEui;
		this.joinEui = joinEui;
		this.devAddr = devAddr;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	public EndDeviceIds withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("device_id")
	public String getDeviceId() {
		return deviceId;
	}

	@JsonProperty("device_id")
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public EndDeviceIds withDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	@JsonProperty("application_ids")
	public ApplicationIds getApplicationIds() {
		return applicationIds;
	}

	@JsonProperty("application_ids")
	public void setApplicationIds(ApplicationIds applicationIds) {
		this.applicationIds = applicationIds;
	}

	public EndDeviceIds withApplicationIds(ApplicationIds applicationIds) {
		this.applicationIds = applicationIds;
		return this;
	}

	@JsonProperty("dev_eui")
	public String getDevEui() {
		return devEui;
	}

	@JsonProperty("dev_eui")
	public void setDevEui(String devEui) {
		this.devEui = devEui;
	}

	public EndDeviceIds withDevEui(String devEui) {
		this.devEui = devEui;
		return this;
	}

	@JsonProperty("join_eui")
	public String getJoinEui() {
		return joinEui;
	}

	@JsonProperty("join_eui")
	public void setJoinEui(String joinEui) {
		this.joinEui = joinEui;
	}

	public EndDeviceIds withJoinEui(String joinEui) {
		this.joinEui = joinEui;
		return this;
	}

	@JsonProperty("dev_addr")
	public String getDevAddr() {
		return devAddr;
	}

	@JsonProperty("dev_addr")
	public void setDevAddr(String devAddr) {
		this.devAddr = devAddr;
	}

	public EndDeviceIds withDevAddr(String devAddr) {
		this.devAddr = devAddr;
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

	public EndDeviceIds withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(EndDeviceIds.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("deviceId");
		sb.append('=');
		sb.append(((this.deviceId == null) ? "<null>" : this.deviceId));
		sb.append(',');
		sb.append("applicationIds");
		sb.append('=');
		sb.append(((this.applicationIds == null) ? "<null>" : this.applicationIds));
		sb.append(',');
		sb.append("devEui");
		sb.append('=');
		sb.append(((this.devEui == null) ? "<null>" : this.devEui));
		sb.append(',');
		sb.append("joinEui");
		sb.append('=');
		sb.append(((this.joinEui == null) ? "<null>" : this.joinEui));
		sb.append(',');
		sb.append("devAddr");
		sb.append('=');
		sb.append(((this.devAddr == null) ? "<null>" : this.devAddr));
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
		EndDeviceIds other = (EndDeviceIds) obj;
		return Objects.equals(id, other.id);
	}

}
