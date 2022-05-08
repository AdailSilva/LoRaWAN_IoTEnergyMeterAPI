package com.adailsilva.iotenergymeter.api.chirpstack.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity(name = "TxInfo")
@Table(name = "cs_tx_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "gatewayID", "frequency", "power", "modulation", "loRaModulationInfo", "board", "antenna",
		"timing", "immediatelyTimingInfo", "context" /* , "cSRawBody" */ })
public class TxInfo implements Serializable {

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
	@Size(min = 1, max = 30)
	@Column(name = "gateway_id")
	@JsonProperty("gatewayID")
	private String gatewayID;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 9)
	@Column(name = "frequency")
	@JsonProperty("frequency")
	private Long frequency;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 2)
	@Column(name = "power")
	@JsonProperty("power")
	private int power;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 4)
	@Column(name = "modulation")
	@JsonProperty("modulation")
	private String modulation;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 2)
	@Column(name = "board")
	@JsonProperty("board")
	private int board;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 2)
	@Column(name = "antenna")
	@JsonProperty("antenna")
	private int antenna;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 11)
	@Column(name = "timing")
	@JsonProperty("timing")
	private String timing;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(mappedBy = "txInfo", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonProperty("immediatelyTimingInfo")
	private ImmediatelyTimingInfo immediatelyTimingInfo;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 30)
	@Column(name = "context")
	@JsonProperty("context")
	private String context;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(mappedBy = "txInfo", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonProperty("loRaModulationInfo")
	private LoRaModulationInfo loRaModulationInfo;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cs_raw_bodies_id")
	@JsonIgnore
	// @JsonProperty("cSRawBody")
	private CSRawBody cSRawBody;

//	@JsonBackReference
	public ImmediatelyTimingInfo getImmediatelyTimingInfo() {
		return immediatelyTimingInfo;
	}

//	@JsonBackReference
	public LoRaModulationInfo getLoRaModulationInfo() {
		return loRaModulationInfo;
	}

//	@JsonManagedReference
	public CSRawBody getcSRawBody() {
		return cSRawBody;
	}

	public TxInfo() {
	}

	public TxInfo(Long id, @Size(min = 1, max = 30) String gatewayID, @NotNull Long frequency, int power,
			@NotNull @Size(min = 1, max = 4) String modulation, int board, int antenna,
			@Size(min = 1, max = 11) String timing, ImmediatelyTimingInfo immediatelyTimingInfo,
			@Size(min = 1, max = 30) String context, LoRaModulationInfo loRaModulationInfo, CSRawBody cSRawBody) {
		super();
		this.id = id;
		this.gatewayID = gatewayID;
		this.frequency = frequency;
		this.power = power;
		this.modulation = modulation;
		this.board = board;
		this.antenna = antenna;
		this.timing = timing;
		this.immediatelyTimingInfo = immediatelyTimingInfo;
		this.context = context;
		this.loRaModulationInfo = loRaModulationInfo;
		this.cSRawBody = cSRawBody;
	}

	@Override
	public String toString() {
		return "TxInfo [id=" + id + ", gatewayID=" + gatewayID + ", frequency=" + frequency + ", power=" + power
				+ ", modulation=" + modulation + ", board=" + board + ", antenna=" + antenna + ", timing=" + timing
				+ ", immediatelyTimingInfo=" + immediatelyTimingInfo + ", context=" + context + ", loRaModulationInfo="
				+ loRaModulationInfo + ", cSRawBody=" + cSRawBody + "]";
	}

}
