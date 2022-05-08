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
@JsonPropertyOrder({ "id", "gateway_ids", "time", "timestamp", "rssi", "channel_rssi", "snr", "uplink_token",
		"channel_index" })
@Generated("adailsilva")
public class RxMetadatum implements Serializable {

	private final static long serialVersionUID = 524336013638270318L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("gateway_ids")
	private GatewayIds gatewayIds;

	@JsonProperty("time")
	private String time;

	@JsonProperty("timestamp")
	private long timestamp;

	@JsonProperty("rssi")
	private long rssi;

	@JsonProperty("channel_rssi")
	private long channelRssi;

	@JsonProperty("snr")
	private double snr;

	@JsonProperty("uplink_token")
	private String uplinkToken;

	@JsonProperty("channel_index")
	private long channelIndex;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public RxMetadatum() {
	}

	/**
	 * 
	 * @param id
	 * @param gatewayIds
	 * @param time
	 * @param timestamp
	 * @param rssi
	 * @param channelRssi
	 * @param snr
	 * @param uplinkToken
	 * @param channelIndex
	 */
	public RxMetadatum(Long id, GatewayIds gatewayIds, String time, long timestamp, long rssi, long channelRssi,
			double snr, String uplinkToken, long channelIndex) {
		super();
		this.id = id;
		this.gatewayIds = gatewayIds;
		this.time = time;
		this.timestamp = timestamp;
		this.rssi = rssi;
		this.channelRssi = channelRssi;
		this.snr = snr;
		this.uplinkToken = uplinkToken;
		this.channelIndex = channelIndex;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	public RxMetadatum withId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("gateway_ids")
	public GatewayIds getGatewayIds() {
		return gatewayIds;
	}

	@JsonProperty("gateway_ids")
	public void setGatewayIds(GatewayIds gatewayIds) {
		this.gatewayIds = gatewayIds;
	}

	public RxMetadatum withGatewayIds(GatewayIds gatewayIds) {
		this.gatewayIds = gatewayIds;
		return this;
	}

	@JsonProperty("time")
	public String getTime() {
		return time;
	}

	@JsonProperty("time")
	public void setTime(String time) {
		this.time = time;
	}

	public RxMetadatum withTime(String time) {
		this.time = time;
		return this;
	}

	@JsonProperty("timestamp")
	public long getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public RxMetadatum withTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	@JsonProperty("rssi")
	public long getRssi() {
		return rssi;
	}

	@JsonProperty("rssi")
	public void setRssi(long rssi) {
		this.rssi = rssi;
	}

	public RxMetadatum withRssi(long rssi) {
		this.rssi = rssi;
		return this;
	}

	@JsonProperty("channel_rssi")
	public long getChannelRssi() {
		return channelRssi;
	}

	@JsonProperty("channel_rssi")
	public void setChannelRssi(long channelRssi) {
		this.channelRssi = channelRssi;
	}

	public RxMetadatum withChannelRssi(long channelRssi) {
		this.channelRssi = channelRssi;
		return this;
	}

	@JsonProperty("snr")
	public double getSnr() {
		return snr;
	}

	@JsonProperty("snr")
	public void setSnr(double snr) {
		this.snr = snr;
	}

	public RxMetadatum withSnr(double snr) {
		this.snr = snr;
		return this;
	}

	@JsonProperty("uplink_token")
	public String getUplinkToken() {
		return uplinkToken;
	}

	@JsonProperty("uplink_token")
	public void setUplinkToken(String uplinkToken) {
		this.uplinkToken = uplinkToken;
	}

	public RxMetadatum withUplinkToken(String uplinkToken) {
		this.uplinkToken = uplinkToken;
		return this;
	}

	@JsonProperty("channel_index")
	public long getChannelIndex() {
		return channelIndex;
	}

	@JsonProperty("channel_index")
	public void setChannelIndex(long channelIndex) {
		this.channelIndex = channelIndex;
	}

	public RxMetadatum withChannelIndex(long channelIndex) {
		this.channelIndex = channelIndex;
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

	public RxMetadatum withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RxMetadatum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("gatewayIds");
		sb.append('=');
		sb.append(((this.gatewayIds == null) ? "<null>" : this.gatewayIds));
		sb.append(',');
		sb.append("time");
		sb.append('=');
		sb.append(((this.time == null) ? "<null>" : this.time));
		sb.append(',');
		sb.append("timestamp");
		sb.append('=');
		sb.append(this.timestamp);
		sb.append(',');
		sb.append("rssi");
		sb.append('=');
		sb.append(this.rssi);
		sb.append(',');
		sb.append("channelRssi");
		sb.append('=');
		sb.append(this.channelRssi);
		sb.append(',');
		sb.append("snr");
		sb.append('=');
		sb.append(this.snr);
		sb.append(',');
		sb.append("uplinkToken");
		sb.append('=');
		sb.append(((this.uplinkToken == null) ? "<null>" : this.uplinkToken));
		sb.append(',');
		sb.append("channelIndex");
		sb.append('=');
		sb.append(this.channelIndex);
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
		RxMetadatum other = (RxMetadatum) obj;
		return Objects.equals(id, other.id);
	}

}
