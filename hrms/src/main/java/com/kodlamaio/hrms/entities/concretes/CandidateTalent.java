package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates_talent")
@AllArgsConstructor
@NoArgsConstructor

public class CandidateTalent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="talent_name")
	private String talentName;
	
    @ManyToOne(targetEntity = CandidateCv.class)
    @JoinColumn(name="candidates_cv_id")
    @JsonIgnore
    private CandidateCv candidateCv;
    
	@ManyToOne
	@JoinColumn(name = "talents_id")
	private Talent talent;

}
