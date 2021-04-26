package com.adailsilva.iotenergymeter.api.thethingsnetwork.model;

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
@Entity(name = "PayloadFields")
@Table(name = "ttn_payload_fields")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "alarmPhaseA", "alarmPhaseB", "alarmPhaseC", "currentPhaseA", "currentPhaseB",
		"currentPhaseC", "energyPhaseA", "energyPhaseB", "energyPhaseC", "frequencyPhaseA", "frequencyPhaseB",
		"frequencyPhaseC", "powerFactorPhaseA", "powerFactorPhaseB", "powerFactorPhaseC", "powerPhaseA", "powerPhaseB",
		"powerPhaseC", "voltagePhaseA", "voltagePhaseB", "voltagePhaseC"/* , "tTNRawBody" */ })
public class PayloadFields implements Serializable {

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
	// @Size(min = 1, max = 1)
	@Column(name = "alarm_phase_a")
	@JsonProperty("alarmPhaseA")
	private Boolean alarmPhaseA;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "alarm_phase_b")
	@JsonProperty("alarmPhaseB")
	private Boolean alarmPhaseB;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "alarm_phase_c")
	@JsonProperty("alarmPhaseC")
	private Boolean alarmPhaseC;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "current_phase_a")
	@JsonProperty("currentPhaseA")
	private Double currentPhaseA;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "current_phase_b")
	@JsonProperty("currentPhaseB")
	private Double currentPhaseB;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "current_phase_c")
	@JsonProperty("currentPhaseC")
	private Double currentPhaseC;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "energy_phase_a")
	@JsonProperty("energyPhaseA")
	private Double energyPhaseA;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "energy_phase_b")
	@JsonProperty("energyPhaseB")
	private Double energyPhaseB;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "energy_phase_c")
	@JsonProperty("energyPhaseC")
	private Double energyPhaseC;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "frequency_phase_a")
	@JsonProperty("frequencyPhaseA")
	private Long frequencyPhaseA;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "frequency_phase_b")
	@JsonProperty("frequencyPhaseB")
	private Long frequencyPhaseB;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "frequency_phase_c")
	@JsonProperty("frequencyPhaseC")
	private Long frequencyPhaseC;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "power_factor_phase_a")
	@JsonProperty("powerFactorPhaseA")
	private Double powerFactorPhaseA;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "power_factor_phase_b")
	@JsonProperty("powerFactorPhaseB")
	private Double powerFactorPhaseB;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "power_factor_phase_c")
	@JsonProperty("powerFactorPhaseC")
	private Double powerFactorPhaseC;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "power_phase_a")
	@JsonProperty("powerPhaseA")
	private Double powerPhaseA;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "power_phase_b")
	@JsonProperty("powerPhaseB")
	private Double powerPhaseB;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "power_phase_c")
	@JsonProperty("powerPhaseC")
	private Double powerPhaseC;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "voltage_phase_a")
	@JsonProperty("voltagePhaseA")
	private Long voltagePhaseA;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "voltage_phase_b")
	@JsonProperty("voltagePhaseB")
	private Double voltagePhaseB;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "voltage_phase_c")
	@JsonProperty("voltagePhaseC")
	private Double voltagePhaseC;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ttn_raw_bodies_id")
	@JsonIgnore
	// @JsonProperty("tTNRawBody")
	private TTNRawBody tTNRawBody;

//	@JsonManagedReference
	public TTNRawBody gettTNRawBody() {
		return tTNRawBody;
	}

	public PayloadFields() {
	}

	public PayloadFields(Long id, Boolean alarmPhaseA, Boolean alarmPhaseB, Boolean alarmPhaseC, Double currentPhaseA,
			Double currentPhaseB, Double currentPhaseC, Double energyPhaseA, Double energyPhaseB, Double energyPhaseC,
			Long frequencyPhaseA, Long frequencyPhaseB, Long frequencyPhaseC, Double powerFactorPhaseA,
			Double powerFactorPhaseB, Double powerFactorPhaseC, Double powerPhaseA, Double powerPhaseB,
			Double powerPhaseC, Long voltagePhaseA, Double voltagePhaseB, Double voltagePhaseC, TTNRawBody tTNRawBody) {
		super();
		this.id = id;
		this.alarmPhaseA = alarmPhaseA;
		this.alarmPhaseB = alarmPhaseB;
		this.alarmPhaseC = alarmPhaseC;
		this.currentPhaseA = currentPhaseA;
		this.currentPhaseB = currentPhaseB;
		this.currentPhaseC = currentPhaseC;
		this.energyPhaseA = energyPhaseA;
		this.energyPhaseB = energyPhaseB;
		this.energyPhaseC = energyPhaseC;
		this.frequencyPhaseA = frequencyPhaseA;
		this.frequencyPhaseB = frequencyPhaseB;
		this.frequencyPhaseC = frequencyPhaseC;
		this.powerFactorPhaseA = powerFactorPhaseA;
		this.powerFactorPhaseB = powerFactorPhaseB;
		this.powerFactorPhaseC = powerFactorPhaseC;
		this.powerPhaseA = powerPhaseA;
		this.powerPhaseB = powerPhaseB;
		this.powerPhaseC = powerPhaseC;
		this.voltagePhaseA = voltagePhaseA;
		this.voltagePhaseB = voltagePhaseB;
		this.voltagePhaseC = voltagePhaseC;
		this.tTNRawBody = tTNRawBody;
	}

	@Override
	public String toString() {
		return "PayloadFields [id=" + id + ", alarmPhaseA=" + alarmPhaseA + ", alarmPhaseB=" + alarmPhaseB
				+ ", alarmPhaseC=" + alarmPhaseC + ", currentPhaseA=" + currentPhaseA + ", currentPhaseB="
				+ currentPhaseB + ", currentPhaseC=" + currentPhaseC + ", energyPhaseA=" + energyPhaseA
				+ ", energyPhaseB=" + energyPhaseB + ", energyPhaseC=" + energyPhaseC + ", frequencyPhaseA="
				+ frequencyPhaseA + ", frequencyPhaseB=" + frequencyPhaseB + ", frequencyPhaseC=" + frequencyPhaseC
				+ ", powerFactorPhaseA=" + powerFactorPhaseA + ", powerFactorPhaseB=" + powerFactorPhaseB
				+ ", powerFactorPhaseC=" + powerFactorPhaseC + ", powerPhaseA=" + powerPhaseA + ", powerPhaseB="
				+ powerPhaseB + ", powerPhaseC=" + powerPhaseC + ", voltagePhaseA=" + voltagePhaseA + ", voltagePhaseB="
				+ voltagePhaseB + ", voltagePhaseC=" + voltagePhaseC + ", tTNRawBody=" + tTNRawBody + "]";
	}

}
