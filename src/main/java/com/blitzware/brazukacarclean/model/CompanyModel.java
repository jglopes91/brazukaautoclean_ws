package com.blitzware.brazukacarclean.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_COMPANY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	private LoginModel login;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "STR_FANTASY_NAME")
	private String fantasyName;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "STR_CNPJ", unique = true)
	private String cnpj;
	@OneToOne(cascade = CascadeType.PERSIST)
	private AddressModel address;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "STR_CONTACT_NUMBER")
	private String contactNumber;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<ServiceItemModel> services;
	@Lob
	@Column(name = "B64_LOGO")
	private String logo;
}
