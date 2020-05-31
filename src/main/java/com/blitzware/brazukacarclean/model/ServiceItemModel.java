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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceItemModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "STR_ITEM")
	private String item;
	@NotNull
	@Column(name = "VLR_PRICE_ITEM", precision = 2, length = 10)
	private Double value;
	@Column(name = "IS_VISIBLE")
	private Boolean isVisible = true;
}
