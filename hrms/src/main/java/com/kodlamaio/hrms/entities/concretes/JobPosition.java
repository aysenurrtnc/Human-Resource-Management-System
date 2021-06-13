package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity // JobPosition bir Entity'dir.
@Table(name = "job_positions") // veritabanında bu class'ın karşılıgı job_positions tablosudur.
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // veritabanında karşılıgı olan kolonun adı
	private int id;

	@Column(name = "position")
	private String position;

	

}
