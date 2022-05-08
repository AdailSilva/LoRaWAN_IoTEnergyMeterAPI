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
@JsonPropertyOrder({ "id", "data_rate", "coding_rate", "frequency", "timestamp", "time" })
@Generated("adailsilva")
public class Settings implements Serializable {

	private final static long serialVersionUID = 8883245211129228283L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("data_rate")
	private DataRate dataRate;

	@JsonProperty("coding_rate")
	private String codingRate;

	@JsonProperty("frequency")
	private String frequency;

	@JsonProperty("timestamp")
	private long timestamp;

	@JsonProperty("time")
	private String time;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Settings() {
	}

	/**
	 * @param id
	 * @param dataRate
	 * @param codingRate
	 * @param frequency
	 * @param timestamp
	 * @param time
	 */
	public Settings(Long id, DataRate dataRate, String codingRate, String frequency, long timestamp, String time) {
		super();
		this.id = id;
		this.dataRate = dataRate;
		this.codingRate = codingRate;
		this.frequency = frequency;
		this.timestamp = timestamp;
		this.time = time;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	public Settings withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("data_rate")
	public DataRate getDataRate() {
		return dataRate;
	}

	@JsonProperty("data_rate")
	public void setDataRate(DataRate dataRate) {
		this.dataRate = dataRate;
	}

	public Settings withDataRate(DataRate dataRate) {
		this.dataRate = dataRate;
		return this;
	}

	@JsonProperty("coding_rate")
	public String getCodingRate() {
		return codingRate;
	}

	@JsonProperty("coding_rate")
	public void setCodingRate(String codingRate) {
		this.codingRate = codingRate;
	}

	public Settings withCodingRate(String codingRate) {
		this.codingRate = codingRate;
		return this;
	}

	@JsonProperty("frequency")
	public String getFrequency() {
		return frequency;
	}

	@JsonProperty("frequency")
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Settings withFrequency(String frequency) {
		this.frequency = frequency;
		return this;
	}

	@JsonProperty("timestamp")
	public long getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Settings withTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	@JsonProperty("time")
	public String getTime() {
		return time;
	}

	@JsonProperty("time")
	public void setTime(String time) {
		this.time = time;
	}

	public Settings withTime(String time) {
		this.time = time;
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

	public Settings withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Settings.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("dataRate");
		sb.append('=');
		sb.append(((this.dataRate == null) ? "<null>" : this.dataRate));
		sb.append(',');
		sb.append("codingRate");
		sb.append('=');
		sb.append(((this.codingRate == null) ? "<null>" : this.codingRate));
		sb.append(',');
		sb.append("frequency");
		sb.append('=');
		sb.append(((this.frequency == null) ? "<null>" : this.frequency));
		sb.append(',');
		sb.append("timestamp");
		sb.append('=');
		sb.append(this.timestamp);
		sb.append(',');
		sb.append("time");
		sb.append('=');
		sb.append(((this.time == null) ? "<null>" : this.time));
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
		Settings other = (Settings) obj;
		return Objects.equals(id, other.id);
	}

}
