package com.adailsilva.iotenergymeter.api.system.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Registry")
@Table(name = "system_registries")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "description", "maturitieDate", "paymentDate", "registryValue", "observation",
		"registryType", "category", "person" })
public class Registry implements Serializable {

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
	@Size(min = 3, max = 50)
	@Column(name = "description")
	@JsonProperty("description")
	private String description;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "maturitie_date")
	@JsonProperty("maturitieDate")
	@JsonFormat(pattern =  "dd-MM-yyyy")
	private LocalDate maturitieDate;

	@Getter
	@Setter
	// @NotNull
	// @Size(min = 0, max = 0)
	@Column(name = "payment_date")
	@JsonProperty("paymentDate")
	@JsonFormat(pattern =  "dd-MM-yyyy")
	private LocalDate paymentDate;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 10)
	@Column(name = "registry_value")
	@JsonProperty("registryValue")
	private BigDecimal registryValue;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "observation")
	@JsonProperty("observation")
	private String observation;

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 10)
	@Enumerated(EnumType.STRING) // There are two types ORDINAL and STRING, Ordinal is the position of the ENUM.
	@Column(name = "registry_type")
	@JsonProperty("registryType")
	private RegistryType registryType;

	@Getter
	@Setter
	@NotNull
	@ManyToOne
	@JoinColumn(name = "system_category_id")
	@JsonProperty("category")
	private Category category;

	@Getter
	@Setter
	@NotNull
	@ManyToOne
	@JoinColumn(name = "system_person_id")
	@JsonProperty("person")
	private Person person;

	public Registry() {
		super();
	}

	public Registry(Long id, String description, LocalDate maturitieDate, LocalDate paymentDate,
			BigDecimal registryValue, String observation, RegistryType registryType, Category category, Person person) {
		super();
		this.id = id;
		this.description = description;
		this.maturitieDate = maturitieDate;
		this.paymentDate = paymentDate;
		this.registryValue = registryValue;
		this.observation = observation;
		this.registryType = registryType;
		this.category = category;
		this.person = person;
	}

	@Override
	public String toString() {
		return "Registry [id=" + id + ", description=" + description + ", maturitieDate=" + maturitieDate
				+ ", paymentDate=" + paymentDate + ", registryValue=" + registryValue + ", observation=" + observation
				+ ", registryType=" + registryType + ", category=" + category + ", person=" + person + "]";
	}

}
