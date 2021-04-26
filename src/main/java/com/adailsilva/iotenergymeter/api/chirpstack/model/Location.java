package com.adailsilva.iotenergymeter.api.chirpstack.model;

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
@Entity(name = "Location")
@Table(name = "cs_locations")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "latitude", "longitude", "altitude", "source", "accuracy"/* , "rxInfo" */ })
public class Location implements Serializable {

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

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "source")
	@JsonProperty("source")
	private String source;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "accuracy")
	@JsonProperty("accuracy")
	private Long accuracy;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cs_rx_info_id")
	@JsonIgnore
	// @JsonProperty("rxInfo")
	private RxInfo rxInfo;

//	@JsonManagedReference
	public RxInfo getRxInfo() {
		return rxInfo;
	}

	public Location() {
	}

	public Location(Long id, Double latitude, Double longitude, Long altitude, String source, Long accuracy,
			RxInfo rxInfo) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.source = source;
		this.accuracy = accuracy;
		this.rxInfo = rxInfo;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", altitude=" + altitude
				+ ", source=" + source + ", accuracy=" + accuracy + ", rxInfo=" + rxInfo + "]";
	}

}
