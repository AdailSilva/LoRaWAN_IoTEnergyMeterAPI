package com.adailsilva.iotenergymeter.api.thethingsnetwork.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Entity(name = "Metadata")
@Table(name = "ttn_metadata")
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "id", "time", "frequency", "modulation", "dataRate", "codingRate", "gateways", "tTNRawBody" })
@JsonPropertyOrder({ "id", "time", "frequency", "modulation", "data_rate", "coding_rate",
		"gateways"/*
					 * , "ttn_raw_bodies_id"
					 */ })
public class Metadata implements Serializable {

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
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "time")
	@JsonProperty("time")
	private String time;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "frequency")
	@JsonProperty("frequency")
	private Double frequency;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 4)
	@Column(name = "modulation")
	@JsonProperty("modulation")
	private String modulation;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 9)
	@Column(name = "data_rate")
	// @JsonProperty("dataRate")
	@JsonProperty("data_rate")
	private String dataRate;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 3)
	@Column(name = "coding_rate")
	// @JsonProperty("codingRate")
	@JsonProperty("coding_rate")
	private String codingRate;

	// @Getter
	@Setter
	// @NotNull
	@OneToMany(mappedBy = "metadata", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = false)
	@JsonProperty("gateways")
	private List<Gateway> gateways = null;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ttn_raw_bodies_id")
	@JsonIgnore
	// @JsonProperty("tTNRawBody")
	// @JsonProperty("ttn_raw_bodies_id")
	private TTNRawBody tTNRawBody;

//	@JsonBackReference
	public List<Gateway> getGateways() {
		return gateways;
	}

//	@JsonManagedReference
	public TTNRawBody gettTNRawBody() {
		return tTNRawBody;
	}

	public Metadata() {
	}

	public Metadata(Long id, String time, Double frequency, String modulation, String dataRate, String codingRate,
			List<Gateway> gateways, TTNRawBody tTNRawBody) {
		super();
		this.id = id;
		this.time = time;
		this.frequency = frequency;
		this.modulation = modulation;
		this.dataRate = dataRate;
		this.codingRate = codingRate;
		this.gateways = gateways;
		this.tTNRawBody = tTNRawBody;
	}

	@Override
	public String toString() {
		return "Metadata [id=" + id + ", time=" + time + ", frequency=" + frequency + ", modulation=" + modulation
				+ ", dataRate=" + dataRate + ", codingRate=" + codingRate + ", gateways=" + gateways + ", tTNRawBody="
				+ tTNRawBody + "]";
	}

}
