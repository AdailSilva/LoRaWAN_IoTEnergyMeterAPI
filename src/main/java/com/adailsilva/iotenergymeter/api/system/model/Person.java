package com.adailsilva.iotenergymeter.api.system.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Entity(name = "Person")
@Table(name = "system_people")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "address", "active" })
public class Person implements Serializable {

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
	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Getter
	@Setter
	// @NotNull
	@Embedded
	@JsonProperty("address")
	private Address address; // Do not use the equals and hashCode functions here.

	@Getter
	@Setter
	@NotNull
	// @Size(min = 1, max = 1)
	@Column(name = "active")
	@JsonProperty("active")
	private Boolean active;

	@Transient // For Hibernate Ignore ownership.
	@JsonIgnore
	public boolean isInactive() {
		return !this.active;
	}

//	@Getter
//	@Setter
//	@NotNull
//	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
//	@JsonProperty("registry")
//	private Registry registry;

	public Person() {
		super();
	}

	public Person(Long id, String name, Address address, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.active = active;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", active=" + active + "]";
	}

}
