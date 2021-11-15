package com.adailsilva.iotenergymeter.api.thethingsnetwork.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "Gateway")
@Table(name = "ttn_gateways")
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "id", "gtwID", "timestamp", "time", "channel", "rssi", "snr", "rfChain", "latitude", "longitude",
//		"altitude", "metadata" })
@JsonPropertyOrder({ "id", "gtw_id", "timestamp", "time", "channel", "rssi", "snr", "rf_chain", "latitude", "longitude",
		"altitude"/* , "ttn_metadata_id" */ })
public class Gateway implements Serializable {

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
	@Size(min = 1, max = 20)
	@Column(name = "gtw_id")
	// @JsonProperty("gtwID")
	@JsonProperty("gtw_id")
	private String gtwID;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 10)
	@Column(name = "timestamp")
	@JsonProperty("timestamp")
	private Long timestamp;

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
	// @Size(min = 1, max = 2)
	@Column(name = "channel")
	@JsonProperty("channel")
	private Long channel;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 3)
	@Column(name = "rssi")
	@JsonProperty("rssi")
	private Long rssi;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "snr")
	@JsonProperty("snr")
	private Long snr;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "rf_chain")
	// @JsonProperty("rfChain")
	@JsonProperty("rf_chain")
	private Long rfChain;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "latitude")
	@JsonProperty("latitude")
	private Double latitude;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "longitude")
	@JsonProperty("longitude")
	private Double longitude;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 3)
	@Column(name = "altitude")
	@JsonProperty("altitude")
	private Long altitude;

	// @Getter
	@Setter
	// @NotNull
	@ManyToOne /* (cascade = CascadeType.REMOVE) */
	@JoinColumn(name = "ttn_metadata_id")
	@JsonIgnore
	// @JsonProperty("ttn_metadata_id")
	private Metadata metadata;

//	@JsonManagedReference
	public Metadata getMetadata() {
		return metadata;
	}

	public Gateway() {
	}

	public Gateway(Long id, String gtwID, Long timestamp, String time, Long channel, Long rssi, Long snr, Long rfChain,
			Double latitude, Double longitude, Long altitude, Metadata metadata) {
		super();
		this.id = id;
		this.gtwID = gtwID;
		this.timestamp = timestamp;
		this.time = time;
		this.channel = channel;
		this.rssi = rssi;
		this.snr = snr;
		this.rfChain = rfChain;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "Gateway [id=" + id + ", gtwID=" + gtwID + ", timestamp=" + timestamp + ", time=" + time + ", channel="
				+ channel + ", rssi=" + rssi + ", snr=" + snr + ", rfChain=" + rfChain + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", altitude=" + altitude + ", metadata=" + metadata + "]";
	}

}
