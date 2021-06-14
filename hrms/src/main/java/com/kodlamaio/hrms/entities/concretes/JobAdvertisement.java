package com.kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPosition", "city"}) 

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "appeal_expiration_date")
	private String appealExpirationDate;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "min_salary")
	private Double minSalary;

	@Column(name = "max_salary")
	private Double maxSalary;
	
	@Column(name = "number_of_open_position")
	private int numberOfOpenPosition;

}
