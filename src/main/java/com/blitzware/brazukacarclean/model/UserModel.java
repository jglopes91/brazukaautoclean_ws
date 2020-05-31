package com.blitzware.brazukacarclean.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_USER")
@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserModel {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	private LoginModel login;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 10, max = 11)
	@Column(name = "STR_PHONE_NUMBER", unique = true)
	private String phoneNumber;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 11, max = 11)
	@Column(name = "STR_CPF", unique = true)
	private String cpf;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
	@Column(name = "DT_BIRTHDATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
	private AddressModel address;
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<CarModel> cars;
}