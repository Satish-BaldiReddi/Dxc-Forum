package com.dxc.forum.entity;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "consultancyquestion")
public class ConsultancyQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ques_id")
	private Long id;
//	@GenericGenerator(name = "ticket_number", strategy = "com.dxc.forum.entity.TicketNumber")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private String ticketNumber;
	@Column(name = "question_title")
	private String title;
	@Column(name = "question_body")
	private String body;
	@CreationTimestamp
	@Column(name = "created_date")
    private Timestamp createdDate;
	
	//One To Many Mapping with Answer Entity
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnore
	private List<ConsultancyAnswer> answer =  new ArrayList<>();
	
	//Default Constructor
	public ConsultancyQuestion() {
		super();
	}

	public ConsultancyQuestion(Long id, String title, String body, Timestamp createdDate,
			List<ConsultancyAnswer> answer, String ticketNumber) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.createdDate = createdDate;
		this.answer = answer;
//		this.ticketNumber = ticketNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public List<ConsultancyAnswer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<ConsultancyAnswer> answer) {
		this.answer = answer;
	}

//	public String getTicketNumber() {
//		return ticketNumber;
//	}
//
//	public void setTicketNumber(String ticketNumber) {
//		this.ticketNumber = ticketNumber;
//	}	
}
