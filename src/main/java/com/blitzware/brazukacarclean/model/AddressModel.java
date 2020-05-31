package com.blitzware.brazukacarclean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ADDRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "STR_STREET_NAME")
	private String streetName;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "STR_CITY")
	private String cityName;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 8, max = 8)
	@Column(name = "STR_ZIP_CODE")
	private String zipCode;
	@NotNull
	@Column(name = "INT_NUMBER")
	private Integer number;
	@Column(name = "STR_COMPLEMENT")
	private String complement;
	@Column(name = "DBL_LATITUDE")
	private Double latitude;
	@Column(name = "DBL_LONGITUDE")
	private Double longitude;
}
