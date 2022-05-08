package com.adailsilva.iotenergymeter.api.thethingsstack.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "id", "end_device_ids", "correlation_ids", "received_at", "uplink_message" })
@Generated("adailsilva")
public class TheThingsStack implements Serializable {

	private final static long serialVersionUID = 4467379478320334347L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("end_device_ids")
	private EndDeviceIds endDeviceIds;

	@JsonProperty("correlation_ids")
	private List<String> correlationIds = new ArrayList<String>();

	@JsonProperty("received_at")
	private String receivedAt;

	@JsonProperty("uplink_message")
	private UplinkMessage uplinkMessage;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public TheThingsStack() {
	}

	/**
	 * 
	 * @param id
	 * @param endDeviceIds
	 * @param correlationIds
	 * @param receivedAt
	 * @param uplinkMessage
	 */
	public TheThingsStack(Long id, EndDeviceIds endDeviceIds, List<String> correlationIds, String receivedAt,
			UplinkMessage uplinkMessage) {
		super();
		this.id = id;
		this.endDeviceIds = endDeviceIds;
		this.correlationIds = correlationIds;
		this.receivedAt = receivedAt;
		this.uplinkMessage = uplinkMessage;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	public TheThingsStack withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("end_device_ids")
	public EndDeviceIds getEndDeviceIds() {
		return endDeviceIds;
	}

	@JsonProperty("end_device_ids")
	public void setEndDeviceIds(EndDeviceIds endDeviceIds) {
		this.endDeviceIds = endDeviceIds;
	}

	public TheThingsStack withEndDeviceIds(EndDeviceIds endDeviceIds) {
		this.endDeviceIds = endDeviceIds;
		return this;
	}

	@JsonProperty("correlation_ids")
	public List<String> getCorrelationIds() {
		return correlationIds;
	}

	@JsonProperty("correlation_ids")
	public void setCorrelationIds(List<String> correlationIds) {
		this.correlationIds = correlationIds;
	}

	public TheThingsStack withCorrelationIds(List<String> correlationIds) {
		this.correlationIds = correlationIds;
		return this;
	}

	@JsonProperty("received_at")
	public String getReceivedAt() {
		return receivedAt;
	}

	@JsonProperty("received_at")
	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}

	public TheThingsStack withReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
		return this;
	}

	@JsonProperty("uplink_message")
	public UplinkMessage getUplinkMessage() {
		return uplinkMessage;
	}

	@JsonProperty("uplink_message")
	public void setUplinkMessage(UplinkMessage uplinkMessage) {
		this.uplinkMessage = uplinkMessage;
	}

	public TheThingsStack withUplinkMessage(UplinkMessage uplinkMessage) {
		this.uplinkMessage = uplinkMessage;
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

	public TheThingsStack withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(TheThingsStack.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("endDeviceIds");
		sb.append('=');
		sb.append(((this.endDeviceIds == null) ? "<null>" : this.endDeviceIds));
		sb.append(',');
		sb.append("correlationIds");
		sb.append('=');
		sb.append(((this.correlationIds == null) ? "<null>" : this.correlationIds));
		sb.append(',');
		sb.append("receivedAt");
		sb.append('=');
		sb.append(((this.receivedAt == null) ? "<null>" : this.receivedAt));
		sb.append(',');
		sb.append("uplinkMessage");
		sb.append('=');
		sb.append(((this.uplinkMessage == null) ? "<null>" : this.uplinkMessage));
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
		TheThingsStack other = (TheThingsStack) obj;
		return Objects.equals(id, other.id);
	}

}
