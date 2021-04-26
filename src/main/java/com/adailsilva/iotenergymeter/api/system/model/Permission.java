package com.adailsilva.iotenergymeter.api.system.model;

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
@Entity(name = "Permission")
@Table(name = "system_permissions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "description", "active" })
public class Permission implements Serializable {

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
	@Column(name = "description")
	@JsonProperty("description")
	private String description;

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
	// @ManyToMany(mappedBy = "permissions")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "system_user_permission", joinColumns = @JoinColumn(name = "system_permission_id"), inverseJoinColumns = @JoinColumn(name = "system_user_id"))
	@JsonIgnore
	private List<User> users;

	public Permission() {
		super();
	}

	public Permission(Long id, @NotNull @Size(min = 1, max = 50) String description, @NotNull Boolean active,
			List<User> users) {
		super();
		this.id = id;
		this.description = description;
		this.active = active;
		this.users = users;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", description=" + description + ", active=" + active + ", users=" + users
				+ "]";
	}

}
