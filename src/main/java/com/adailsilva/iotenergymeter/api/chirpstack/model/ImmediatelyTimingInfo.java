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
@Entity(name = "ImmediatelyTimingInfo")
@Table(name = "cs_immediately_timing_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id" /* , "txInfo" */ })
public class ImmediatelyTimingInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;

	// @Getter
	@Setter
	// @NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cs_tx_info_id")
	@JsonIgnore
	// @JsonProperty("txInfo")
	private TxInfo txInfo;

//	@JsonManagedReference
	public TxInfo getTxInfo() {
		return txInfo;
	}

	public ImmediatelyTimingInfo() {
	}

	public ImmediatelyTimingInfo(Long id, TxInfo txInfo) {
		super();
		this.id = id;
		this.txInfo = txInfo;
	}

	@Override
	public String toString() {
		return "ImmediatelyTimingInfo [id=" + id + ", txInfo=" + txInfo + "]";
	}

}
