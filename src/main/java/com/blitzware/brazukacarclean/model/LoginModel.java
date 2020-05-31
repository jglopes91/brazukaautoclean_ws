package com.blitzware.brazukacarclean.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_LOGIN")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	@Email
	@Column(name = "STR_EMAIL", unique = true)
	private String email;
	@Lob
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "STR_PASSWORD")
	private String password;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.MERGE)
	private RoleModel role;
	@JsonIgnore
	@Column(name = "IS_ENABLED")
	private Boolean isEnable = true;
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_CREATED_AT")
	private Date createdAt = new Date();

	public void setPassword(String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password);
	}
}
