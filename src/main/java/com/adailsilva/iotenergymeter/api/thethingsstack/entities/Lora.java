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
@JsonPropertyOrder({ "id", "bandwidth", "spreading_factor" })
@Generated("adailsilva")
public class Lora implements Serializable {

	private final static long serialVersionUID = -1776013019911666806L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("bandwidth")
	private long bandwidth;

	@JsonProperty("spreading_factor")
	private long spreadingFactor;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Lora() {
	}

	/**
	 * 
	 * @param id
	 * @param bandwidth
	 * @param spreadingFactor
	 */
	public Lora(Long id, long bandwidth, long spreadingFactor) {
		super();
		this.id = id;
		this.bandwidth = bandwidth;
		this.spreadingFactor = spreadingFactor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lora withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("bandwidth")
	public long getBandwidth() {
		return bandwidth;
	}

	@JsonProperty("bandwidth")
	public void setBandwidth(long bandwidth) {
		this.bandwidth = bandwidth;
	}

	public Lora withBandwidth(long bandwidth) {
		this.bandwidth = bandwidth;
		return this;
	}

	@JsonProperty("spreading_factor")
	public long getSpreadingFactor() {
		return spreadingFactor;
	}

	@JsonProperty("spreading_factor")
	public void setSpreadingFactor(long spreadingFactor) {
		this.spreadingFactor = spreadingFactor;
	}

	public Lora withSpreadingFactor(long spreadingFactor) {
		this.spreadingFactor = spreadingFactor;
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

	public Lora withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Lora.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("bandwidth");
		sb.append('=');
		sb.append(this.bandwidth);
		sb.append(',');
		sb.append("spreadingFactor");
		sb.append('=');
		sb.append(this.spreadingFactor);
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
		Lora other = (Lora) obj;
		return Objects.equals(id, other.id);
	}

}
