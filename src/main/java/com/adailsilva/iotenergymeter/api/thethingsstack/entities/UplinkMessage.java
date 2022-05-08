package com.adailsilva.iotenergymeter.api.thethingsstack.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "id", "session_key_id", "f_port", "f_cnt", "frm_payload", "rx_metadata", "settings", "received_at",
		"consumed_airtime", "network_ids" })
@Generated("adailsilva")
public class UplinkMessage implements Serializable {

	private final static long serialVersionUID = -7322034818633849120L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("session_key_id")
	private String sessionKeyId;

	@JsonProperty("f_port")
	private long fPort;

	@JsonProperty("f_cnt")
	private long fCnt;

	@JsonProperty("frm_payload")
	private String frmPayload;

	@JsonProperty("rx_metadata")
	private List<RxMetadatum> rxMetadata = new ArrayList<RxMetadatum>();

	@JsonProperty("settings")
	private Settings settings;

	@JsonProperty("received_at")
	private String receivedAt;

	@JsonProperty("consumed_airtime")
	private String consumedAirtime;

	@JsonProperty("network_ids")
	private NetworkIds networkIds;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public UplinkMessage() {
	}

	/**
	 * 
	 * @param id
	 * @param sessionKeyId
	 * @param fPort
	 * @param fCnt
	 * @param frmPayload
	 * @param rxMetadata
	 * @param settings
	 * @param receivedAt
	 * @param consumedAirtime
	 * @param networkIds
	 */
	public UplinkMessage(Long id, String sessionKeyId, long fPort, long fCnt, String frmPayload,
			List<RxMetadatum> rxMetadata, Settings settings, String receivedAt, String consumedAirtime,
			NetworkIds networkIds) {
		super();
		this.id = id;
		this.sessionKeyId = sessionKeyId;
		this.fPort = fPort;
		this.fCnt = fCnt;
		this.frmPayload = frmPayload;
		this.rxMetadata = rxMetadata;
		this.settings = settings;
		this.receivedAt = receivedAt;
		this.consumedAirtime = consumedAirtime;
		this.networkIds = networkIds;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	public UplinkMessage withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("session_key_id")
	public String getSessionKeyId() {
		return sessionKeyId;
	}

	@JsonProperty("session_key_id")
	public void setSessionKeyId(String sessionKeyId) {
		this.sessionKeyId = sessionKeyId;
	}

	public UplinkMessage withSessionKeyId(String sessionKeyId) {
		this.sessionKeyId = sessionKeyId;
		return this;
	}

	@JsonProperty("f_port")
	public long getfPort() {
		return fPort;
	}

	@JsonProperty("f_port")
	public void setfPort(long fPort) {
		this.fPort = fPort;
	}

	public UplinkMessage withfPort(long fPort) {
		this.fPort = fPort;
		return this;
	}

	@JsonProperty("f_cnt")
	public long getfCnt() {
		return fCnt;
	}

	@JsonProperty("f_cnt")
	public void setfCnt(long fCnt) {
		this.fCnt = fCnt;
	}

	public UplinkMessage withfCnt(long fCnt) {
		this.fCnt = fCnt;
		return this;
	}

	@JsonProperty("frm_payload")
	public String getFrmPayload() {
		return frmPayload;
	}

	@JsonProperty("frm_payload")
	public void setFrmPayload(String frmPayload) {
		this.frmPayload = frmPayload;
	}

	public UplinkMessage withFrmPayload(String frmPayload) {
		this.frmPayload = frmPayload;
		return this;
	}

	@JsonProperty("rx_metadata")
	public List<RxMetadatum> getRxMetadata() {
		return rxMetadata;
	}

	@JsonProperty("rx_metadata")
	public void setRxMetadata(List<RxMetadatum> rxMetadata) {
		this.rxMetadata = rxMetadata;
	}

	public UplinkMessage withRxMetadata(List<RxMetadatum> rxMetadata) {
		this.rxMetadata = rxMetadata;
		return this;
	}

	@JsonProperty("settings")
	public Settings getSettings() {
		return settings;
	}

	@JsonProperty("settings")
	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public UplinkMessage withSettings(Settings settings) {
		this.settings = settings;
		return this;
	}

	@JsonProperty("received_at")
	public String getReceivedAt() {
		return receivedAt;
	}

	@JsonProperty("received_at")
	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}

	public UplinkMessage withReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
		return this;
	}

	@JsonProperty("consumed_airtime")
	public String getConsumedAirtime() {
		return consumedAirtime;
	}

	@JsonProperty("consumed_airtime")
	public void setConsumedAirtime(String consumedAirtime) {
		this.consumedAirtime = consumedAirtime;
	}

	public UplinkMessage withConsumedAirtime(String consumedAirtime) {
		this.consumedAirtime = consumedAirtime;
		return this;
	}

	@JsonProperty("network_ids")
	public NetworkIds getNetworkIds() {
		return networkIds;
	}

	@JsonProperty("network_ids")
	public void setNetworkIds(NetworkIds networkIds) {
		this.networkIds = networkIds;
	}

	public UplinkMessage withNetworkIds(NetworkIds networkIds) {
		this.networkIds = networkIds;
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

	public UplinkMessage withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(UplinkMessage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("sessionKeyId");
		sb.append('=');
		sb.append(((this.sessionKeyId == null) ? "<null>" : this.sessionKeyId));
		sb.append(',');
		sb.append("fPort");
		sb.append('=');
		sb.append(this.fPort);
		sb.append(',');
		sb.append("fCnt");
		sb.append('=');
		sb.append(this.fCnt);
		sb.append(',');
		sb.append("frmPayload");
		sb.append('=');
		sb.append(((this.frmPayload == null) ? "<null>" : this.frmPayload));
		sb.append(',');
		sb.append("rxMetadata");
		sb.append('=');
		sb.append(((this.rxMetadata == null) ? "<null>" : this.rxMetadata));
		sb.append(',');
		sb.append("settings");
		sb.append('=');
		sb.append(((this.settings == null) ? "<null>" : this.settings));
		sb.append(',');
		sb.append("receivedAt");
		sb.append('=');
		sb.append(((this.receivedAt == null) ? "<null>" : this.receivedAt));
		sb.append(',');
		sb.append("consumedAirtime");
		sb.append('=');
		sb.append(((this.consumedAirtime == null) ? "<null>" : this.consumedAirtime));
		sb.append(',');
		sb.append("networkIds");
		sb.append('=');
		sb.append(((this.networkIds == null) ? "<null>" : this.networkIds));
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
		UplinkMessage other = (UplinkMessage) obj;
		return Objects.equals(id, other.id);
	}

}
