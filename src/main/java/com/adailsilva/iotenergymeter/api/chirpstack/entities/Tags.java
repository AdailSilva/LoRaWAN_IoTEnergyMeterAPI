package com.adailsilva.iotenergymeter.api.chirpstack.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Tags")
@Table(name = "cs_tags")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "company", "device" /* , "cSRawBody" */ })
public class Tags implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "company")
	@JsonProperty("company")
	private String company;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "device")
	@JsonProperty("device")
	private String device;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cs_raw_bodies_id")
	@JsonIgnore
	// @JsonProperty("cSRawBody")
	private CSRawBody cSRawBody;

//	@JsonManagedReference
	public CSRawBody getCSRawBody() {
		return cSRawBody;
	}

	public Tags() {
	}

	public Tags(Long id, String company, String device, CSRawBody cSRawBody) {
		super();
		this.id = id;
		this.company = company;
		this.device = device;
		this.cSRawBody = cSRawBody;
	}

	@Override
	public String toString() {
		return "Tags [id=" + id + ", company=" + company + ", device=" + device + ", cSRawBody=" + cSRawBody + "]";
	}

}
