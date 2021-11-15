package com.adailsilva.iotenergymeter.api.system.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Entity(name = "User")
@Table(name = "system_users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "email", "password", "active" })
public class User implements Serializable {

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
	@Size(min = 1, max = 50)
	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "email") // TODO: Change this parameter entirely by login.
	@JsonProperty("email")
	private String email;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 60)
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

	@Getter
	@Setter
	// @NotNull
	// @ManyToMany(mappedBy = "users")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "system_user_permission", joinColumns = @JoinColumn(name = "system_user_id"), inverseJoinColumns = @JoinColumn(name = "system_permission_id"))
	@JsonIgnore
	private List<Permission> permissions;

	public User() {
		super();
	}

	public User(Long id, @NotNull @Size(min = 1, max = 50) String name, @NotNull @Size(min = 1, max = 50) String email,
			@NotNull @Size(min = 1, max = 60) String password, @NotNull Boolean active, List<Permission> permissions) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", active="
				+ active + ", permissions=" + permissions + "]";
	}

}
