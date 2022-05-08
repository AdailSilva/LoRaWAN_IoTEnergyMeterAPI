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
@JsonPropertyOrder({ "id", "lora" })
@Generated("adailsilva")
public class DataRate implements Serializable {

	private final static long serialVersionUID = -1442482465223251471L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("lora")
	private Lora lora;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DataRate() {
	}

	/**
	 * 
	 * @param id
	 * @param lora
	 */
	public DataRate(Long id, Lora lora) {
		super();
		this.id = id;
		this.lora = lora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DataRate withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("lora")
	public Lora getLora() {
		return lora;
	}

	@JsonProperty("lora")
	public void setLora(Lora lora) {
		this.lora = lora;
	}

	public DataRate withLora(Lora lora) {
		this.lora = lora;
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

	public DataRate withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(DataRate.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("lora");
		sb.append('=');
		sb.append(((this.lora == null) ? "<null>" : this.lora));
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
		DataRate other = (DataRate) obj;
		return Objects.equals(id, other.id);
	}

}
