package com.adailsilva.iotenergymeter.api.system.entities;

import java.io.Serializable;

import javax.persistence.Column;
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
@Entity(name = "CustomHeader")
@Table(name = "system_custom_headers_http")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "header", "value", "login", "password", "active" })
public class CustomHeaderHttp implements Serializable {

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
	@Column(name = "header")
	@JsonProperty("header")
	private String header;

	@Getter
	@Setter
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "value")
	@JsonProperty("value")
	private String value;

	@Getter
	@Setter
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "login")
	@JsonProperty("login")
	private String login;

	@Getter
	@Setter
	@NotNull
	@Size(min = 3, max = 60)
	@Column(name = "password")
	@JsonProperty("password")
	private String password;

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

	public CustomHeaderHttp() {
		super();
	}

	public CustomHeaderHttp(Long id, @NotNull @Size(min = 3, max = 50) String header,
			@NotNull @Size(min = 3, max = 50) String value, @NotNull @Size(min = 3, max = 50) String login,
			@NotNull @Size(min = 3, max = 60) String password, @NotNull Boolean active) {
		super();
		this.id = id;
		this.header = header;
		this.value = value;
		this.login = login;
		this.password = password;
		this.active = active;
	}

	@Override
	public String toString() {
		return "CustomHeaderHttp [id=" + id + ", header=" + header + ", value=" + value + ", login=" + login
				+ ", password=" + password + ", active=" + active + "]";
	}

}
