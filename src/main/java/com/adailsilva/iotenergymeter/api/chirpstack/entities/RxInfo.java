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
import javax.persistence.ManyToOne;
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
@Entity(name = "RxInfo")
@Table(name = "cs_rx_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "gatewayID", "time", "timeSinceGPSEpoch", "rssi", "loRaSNR", "channel", "rfChain", "board",
		"antenna", "location", "fineTimestampType", "context", "uplinkID", "crcStatus"/* , "cSRawBody" */ })
public class RxInfo implements Serializable {

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
	@Column(name = "gateway_id")
	@JsonProperty("gatewayID")
	private String gatewayID;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "time")
	@JsonProperty("time")
	private String time;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 30)
	@Column(name = "time_since_gps_epoch")
	@JsonProperty("timeSinceGPSEpoch")
	private String timeSinceGPSEpoch;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 5)
	@Column(name = "rssi")
	@JsonProperty("rssi")
	private Long rssi;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "lora_snr")
	@JsonProperty("loRaSNR")
	private Double loRaSNR;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 2)
	@Column(name = "channel")
	@JsonProperty("channel")
	private Long channel;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "rf_chain")
	@JsonProperty("rfChain")
	private Long rfChain;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "board")
	@JsonProperty("board")
	private Long board;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "antenna")
	@JsonProperty("antenna")
	private Long antenna;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(mappedBy = "rxInfo", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonProperty("location")
	private Location location;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "fine_timestamp_type")
	@JsonProperty("fineTimestampType")
	private String fineTimestampType;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "context")
	@JsonProperty("context")
	private String context;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "uplink_id")
	@JsonProperty("uplinkID")
	private String uplinkID;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "crc_status")
	@JsonProperty("crcStatus")
	private String crcStatus;

	// @Getter
	@Setter
	// @NotNull
	@ManyToOne /* (cascade = CascadeType.REMOVE) */
	@JoinColumn(name = "cs_raw_bodies_id")
	@JsonIgnore
	// @JsonProperty("cSRawBody")
	private CSRawBody cSRawBody;

//	@JsonBackReference
	public Location getLocation() {
		return location;
	}

//	@JsonManagedReference
	public CSRawBody getcSRawBody() {
		return cSRawBody;
	}

	public RxInfo() {
	}

	public RxInfo(Long id, String gatewayID, String time, String timeSinceGPSEpoch, Long rssi, Double loRaSNR,
			Long channel, Long rfChain, Long board, Long antenna, Location location, String fineTimestampType,
			String context, String uplinkID, String crcStatus, CSRawBody cSRawBody) {
		super();
		this.id = id;
		this.gatewayID = gatewayID;
		this.time = time;
		this.timeSinceGPSEpoch = timeSinceGPSEpoch;
		this.rssi = rssi;
		this.loRaSNR = loRaSNR;
		this.channel = channel;
		this.rfChain = rfChain;
		this.board = board;
		this.antenna = antenna;
		this.location = location;
		this.fineTimestampType = fineTimestampType;
		this.context = context;
		this.uplinkID = uplinkID;
		this.crcStatus = crcStatus;
		this.cSRawBody = cSRawBody;
	}

	@Override
	public String toString() {
		return "RxInfo [id=" + id + ", gatewayID=" + gatewayID + ", time=" + time + ", timeSinceGPSEpoch="
				+ timeSinceGPSEpoch + ", rssi=" + rssi + ", loRaSNR=" + loRaSNR + ", channel=" + channel + ", rfChain="
				+ rfChain + ", board=" + board + ", antenna=" + antenna + ", location=" + location
				+ ", fineTimestampType=" + fineTimestampType + ", context=" + context + ", uplinkID=" + uplinkID
				+ ", crcStatus=" + crcStatus + ", cSRawBody=" + cSRawBody + "]";
	}

}
