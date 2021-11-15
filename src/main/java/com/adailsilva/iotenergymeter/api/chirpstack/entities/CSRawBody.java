package com.adailsilva.iotenergymeter.api.chirpstack.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity(name = "CSRawBody")
@Table(name = "cs_raw_bodies")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "applicationID", "applicationName", "deviceName", "devEUI", "fCnt", "tags", "gatewayID",
		"rxInfo", "txInfo", "margin", "externalPowerSource", "batteryLevelUnavailable", "batteryLevel", "adr", "dr",
		"type", "error", "acknowledged", "fPort", "data", "objectJSON", "confirmedUplink", "devAddr" })
public class CSRawBody implements Serializable {

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
	@Column(name = "application_id")
	@JsonProperty("applicationID")
	private String applicationID;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "application_name")
	@JsonProperty("applicationName")
	private String applicationName;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "device_name")
	@JsonProperty("deviceName")
	private String deviceName;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "dev_eui")
	@JsonProperty("devEUI")
	private String devEUI;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 5)
	@Column(name = "f_cnt")
	@JsonProperty("fCnt")
	private Long fCnt;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(mappedBy = "cSRawBody", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonProperty("tags")
	private Tags tags;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "gateway_id")
	@JsonProperty("gatewayID")
	private String gatewayID;

	// @Getter
	@Setter
	// @NotNull
	@OneToMany(mappedBy = "cSRawBody", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonProperty("rxInfo")
	private List<RxInfo> rxInfo = null;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(mappedBy = "cSRawBody", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonProperty("txInfo")
	private TxInfo txInfo;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 3)
	@Column(name = "margin")
	@JsonProperty("margin")
	private Long margin;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "external_power_source")
	@JsonProperty("externalPowerSource")
	private Boolean externalPowerSource;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "battery_level_unavailable")
	@JsonProperty("batteryLevelUnavailable")
	private Boolean batteryLevelUnavailable;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 3)
	@Column(name = "battery_level")
	@JsonProperty("batteryLevel")
	private Long batteryLevel;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "adr")
	@JsonProperty("adr")
	private Boolean adr;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "dr")
	@JsonProperty("dr")
	private Long dr;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 50)
	@Column(name = "type")
	@JsonProperty("type")
	private String type;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 50)
	@Column(name = "error")
	@JsonProperty("error")
	private String error;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "acknowledged")
	@JsonProperty("acknowledged")
	private Boolean acknowledged;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 3)
	@Column(name = "f_port")
	@JsonProperty("fPort")
	private Long fPort;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 200)
	@Column(name = "data")
	@JsonProperty("data")
	private String data;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 500)
	@Column(name = "object_json")
	@JsonProperty("objectJSON")
	private String objectJSON;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "confirmed_uplink")
	@JsonProperty("confirmedUplink")
	private Boolean confirmedUplink;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 20)
	@Column(name = "dev_addr")
	@JsonProperty("devAddr")
	private String devAddr;

//	@JsonBackReference
	public List<RxInfo> getRxInfo() {
		return rxInfo;
	}

//	@JsonBackReference
	public TxInfo getTxInfo() {
		return txInfo;
	}

//	@JsonBackReference
	public Tags getTags() {
		return tags;
	}

	public CSRawBody() {
	}

	public CSRawBody(Long id, @NotNull @Size(min = 1, max = 30) String applicationID,
			@NotNull @Size(min = 1, max = 30) String applicationName,
			@NotNull @Size(min = 1, max = 30) String deviceName, @NotNull @Size(min = 1, max = 30) String devEUI,
			Long fCnt, Tags tags, @NotNull @Size(min = 1, max = 30) String gatewayID, List<RxInfo> rxInfo,
			TxInfo txInfo, Long margin, Boolean externalPowerSource, Boolean batteryLevelUnavailable, Long batteryLevel,
			Boolean adr, Long dr, String type, String error, Boolean acknowledged, Long fPort,
			@Size(min = 1, max = 200) String data, @Size(min = 1, max = 500) String objectJSON, Boolean confirmedUplink,
			@Size(min = 1, max = 20) String devAddr) {
		super();
		this.id = id;
		this.applicationID = applicationID;
		this.applicationName = applicationName;
		this.deviceName = deviceName;
		this.devEUI = devEUI;
		this.fCnt = fCnt;
		this.tags = tags;
		this.gatewayID = gatewayID;
		this.rxInfo = rxInfo;
		this.txInfo = txInfo;
		this.margin = margin;
		this.externalPowerSource = externalPowerSource;
		this.batteryLevelUnavailable = batteryLevelUnavailable;
		this.batteryLevel = batteryLevel;
		this.adr = adr;
		this.dr = dr;
		this.type = type;
		this.error = error;
		this.acknowledged = acknowledged;
		this.fPort = fPort;
		this.data = data;
		this.objectJSON = objectJSON;
		this.confirmedUplink = confirmedUplink;
		this.devAddr = devAddr;
	}

	@Override
	public String toString() {
		return "CSRawBody [id=" + id + ", applicationID=" + applicationID + ", applicationName=" + applicationName
				+ ", deviceName=" + deviceName + ", devEUI=" + devEUI + ", fCnt=" + fCnt + ", tags=" + tags
				+ ", gatewayID=" + gatewayID + ", rxInfo=" + rxInfo + ", txInfo=" + txInfo + ", margin=" + margin
				+ ", externalPowerSource=" + externalPowerSource + ", batteryLevelUnavailable="
				+ batteryLevelUnavailable + ", batteryLevel=" + batteryLevel + ", adr=" + adr + ", dr=" + dr + ", type="
				+ type + ", error=" + error + ", acknowledged=" + acknowledged + ", fPort=" + fPort + ", data=" + data
				+ ", objectJSON=" + objectJSON + ", confirmedUplink=" + confirmedUplink + ", devAddr=" + devAddr + "]";
	}

}
