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
@Data
@Table(name = "TB_CAR")
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "STR_MANUFACTORER")
	private String manufactorer;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "STR_MODEL")
	private String model;
	@NotNull
	@Column(name = "STR_YEAR")
	@Size(min = 4, max = 4)
	private String year;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 7, max = 7)
	@Column(name = "STR_PLATE")
	private String plate;
}
