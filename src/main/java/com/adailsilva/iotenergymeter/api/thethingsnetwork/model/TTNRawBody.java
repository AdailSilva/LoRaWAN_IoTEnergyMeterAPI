package com.adailsilva.iotenergymeter.api.thethingsnetwork.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TTNRawBodies")
@Table(name = "ttn_raw_bodies")
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "id", "appID", "devID", "hardwareSerial", "port", "counter", "payloadRaw", "payloadFields",
//		"metadata", "downlinkURL" })
@JsonPropertyOrder({ "id", "app_id", "dev_id", "hardware_serial", "port", "counter", "payload_raw", "payload_fields",
		"metadata", "downlink_url" })
public class TTNRawBody implements Serializable {

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
	@Size(min = 1, max = 36)
	@Column(name = "app_id")
	// @JsonProperty("appID")
	@JsonProperty("app_id")
	private String appID;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 36)
	@Column(name = "dev_id")
	// @JsonProperty("devID")
	@JsonProperty("dev_id")
	private String devID;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 16)
	@Column(name = "hardware_serial")
	// @JsonProperty("hardwareSerial")
	@JsonProperty("hardware_serial")
	private String hardwareSerial;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 3)
	@Column(name = "port")
	@JsonProperty("port")
	private Long port;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 50)
	@Column(name = "counter")
	@JsonProperty("counter")
	private Long counter;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "payload_raw")
	// @JsonProperty("payloadRaw")
	@JsonProperty("payload_raw")
	private String payloadRaw;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(mappedBy = "tTNRawBody", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
	// @JsonProperty("payloadFields")
	@JsonProperty("payload_fields")
	private PayloadFields payloadFields;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(mappedBy = "tTNRawBody", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonProperty("metadata")
	private Metadata metadata;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "downlink_url")
	// @JsonProperty("downlinkURL")
	@JsonProperty("downlink_url")
	private String downlinkURL;

//	@JsonBackReference
	public PayloadFields getPayloadFields() {
		return payloadFields;
	}

//	@JsonBackReference
	public Metadata getMetadata() {
		return metadata;
	}

	public TTNRawBody() {
	}

	public TTNRawBody(Long id, String appID, String devID, String hardwareSerial, Long port, Long counter,
			String payloadRaw, PayloadFields payloadFields, Metadata metadata, String downlinkURL) {
		super();
		this.id = id;
		this.appID = appID;
		this.devID = devID;
		this.hardwareSerial = hardwareSerial;
		this.port = port;
		this.counter = counter;
		this.payloadRaw = payloadRaw;
		this.payloadFields = payloadFields;
		this.metadata = metadata;
		this.downlinkURL = downlinkURL;
	}

	@Override
	public String toString() {
		return "TTNRawBody [id=" + id + ", appID=" + appID + ", devID=" + devID + ", hardwareSerial=" + hardwareSerial
				+ ", port=" + port + ", counter=" + counter + ", payloadRaw=" + payloadRaw + ", payloadFields="
				+ payloadFields + ", metadata=" + metadata + ", downlinkURL=" + downlinkURL + "]";
	}

}
