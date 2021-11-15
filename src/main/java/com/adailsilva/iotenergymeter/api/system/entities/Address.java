package com.adailsilva.iotenergymeter.api.system.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "publicPlace", "addressNumber", "complement", "neighborhood", "cep", "city", "state" })
public class Address {

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 50)
	@Column(name = "public_place")
	@JsonProperty("publicPlace")
	private String publicPlace;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 6)
	@Column(name = "address_number")
	@JsonProperty("addressNumber")
	private String addressNumber;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 100)
	@Column(name = "complement")
	@JsonProperty("complement")
	private String complement;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 30)
	@Column(name = "neighborhood")
	@JsonProperty("neighborhood")
	private String neighborhood;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 10)
	@Column(name = "cep")
	@JsonProperty("cep")
	private String cep;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 30)
	@Column(name = "city")
	@JsonProperty("city")
	private String city;

	@Getter
	@Setter
	// @NotNull
	@Size(min = 1, max = 30)
	@Column(name = "state")
	@JsonProperty("state")
	private String state;

	public Address() {
		super();
	}

	public Address(String publicPlace, String addressNumber, String complement, String neighborhood, String cep,
			String city, String state) {
		super();
		this.publicPlace = publicPlace;
		this.addressNumber = addressNumber;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.cep = cep;
		this.city = city;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [publicPlace=" + publicPlace + ", addressNumber=" + addressNumber + ", complement=" + complement
				+ ", neighborhood=" + neighborhood + ", cep=" + cep + ", city=" + city + ", state=" + state + "]";
	}

}
