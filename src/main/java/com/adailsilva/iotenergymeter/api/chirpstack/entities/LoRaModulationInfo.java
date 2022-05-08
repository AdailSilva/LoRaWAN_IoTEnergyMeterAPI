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
@Entity(name = "LoraModulationInfo")
@Table(name = "cs_lora_modulation_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "bandwidth", "spreadingFactor", "codeRate", "polarizationInversion"/* , "txInfo" */ })
public class LoRaModulationInfo implements Serializable {

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
	// @Size(min = 1, max = 3)
	@Column(name = "bandwidth")
	@JsonProperty("bandwidth")
	private Long bandwidth;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 2)
	@Column(name = "spreading_factor")
	@JsonProperty("spreadingFactor")
	private Long spreadingFactor;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 3)
	@Column(name = "code_rate")
	@JsonProperty("codeRate")
	private String codeRate;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "polarization_inversion")
	@JsonProperty("polarizationInversion")
	private Boolean polarizationInversion;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cs_tx_info_id")
	@JsonIgnore
	// @JsonProperty("txInfo")
	private TxInfo txInfo;

//	@JsonManagedReference
	public TxInfo getTxInfo() {
		return txInfo;
	}

	public LoRaModulationInfo() {
	}

	public LoRaModulationInfo(Long id, Long bandwidth, Long spreadingFactor, String codeRate,
			Boolean polarizationInversion, TxInfo txInfo) {
		super();
		this.id = id;
		this.bandwidth = bandwidth;
		this.spreadingFactor = spreadingFactor;
		this.codeRate = codeRate;
		this.polarizationInversion = polarizationInversion;
		this.txInfo = txInfo;
	}

	@Override
	public String toString() {
		return "LoRaModulationInfo [id=" + id + ", bandwidth=" + bandwidth + ", spreadingFactor=" + spreadingFactor
				+ ", codeRate=" + codeRate + ", polarizationInversion=" + polarizationInversion + ", txInfo=" + txInfo
				+ "]";
	}

}
