package com.blitzware.brazukacarclean.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.blitzware.brazukacarclean.enums.EnumTypeOfService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SERVICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.MERGE)
	private CarModel car;
	@OneToOne(cascade = CascadeType.MERGE)
	private UserModel user;
	@OneToOne(cascade = CascadeType.MERGE)
	private CompanyModel company;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "ENUM_CLEAN_DELIVERY_TYPE")
	private EnumTypeOfService typeOfDelivery;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT")
	private Date createdAt = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FINISHED_AT")
	private Date finishedAt;
	@OneToMany
	private List<ServiceItemModel> services;
}
