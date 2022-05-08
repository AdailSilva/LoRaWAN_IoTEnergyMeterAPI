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
@JsonPropertyOrder({ "id", "gateway_id", "eui" })
@Generated("adailsilva")
public class GatewayIds implements Serializable {

	private final static long serialVersionUID = -6748358689000222599L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("gateway_id")
	private String gatewayId;

	@JsonProperty("eui")
	private String eui;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public GatewayIds() {
	}

	/**
	 * 
	 * @param id
	 * @param eui
	 * @param gatewayId
	 */
	public GatewayIds(Long id, String gatewayId, String eui) {
		super();
		this.id = id;
		this.gatewayId = gatewayId;
		this.eui = eui;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GatewayIds withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("gateway_id")
	public String getGatewayId() {
		return gatewayId;
	}

	@JsonProperty("gateway_id")
	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}

	public GatewayIds withGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
		return this;
	}

	@JsonProperty("eui")
	public String getEui() {
		return eui;
	}

	@JsonProperty("eui")
	public void setEui(String eui) {
		this.eui = eui;
	}

	public GatewayIds withEui(String eui) {
		this.eui = eui;
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

	public GatewayIds withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(GatewayIds.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("gatewayId");
		sb.append('=');
		sb.append(((this.gatewayId == null) ? "<null>" : this.gatewayId));
		sb.append(',');
		sb.append("eui");
		sb.append('=');
		sb.append(((this.eui == null) ? "<null>" : this.eui));
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
		GatewayIds other = (GatewayIds) obj;
		return Objects.equals(id, other.id);
	}

}
