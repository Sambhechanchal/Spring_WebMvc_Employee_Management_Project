package com.nt.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="empProj")
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql="update emp_Proj set active_Status ='inactive' where empno =? and update_Count=? ")
@SQLRestriction("active_Status <> 'inactive'")
public class EmployeeEntity {
	
	@Id
	@SequenceGenerator(name="gen1" , sequenceName = "Emp_SEQ", initialValue = 101, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long empno;
	
	@Column(length=30)
	private String empName;
	
	@Column(length=30)
	private String addrs;
	
	@Column(length=30)
	private String desg;
	
	@Column(length=30)
	private Double salary;
	
	@CreationTimestamp
	@Column(updatable = false, insertable = true)
	private LocalDateTime creationTime;
	
	@UpdateTimestamp
	@Column(updatable = true, insertable = false)
	private LocalDateTime updatetionTime;

	@Version
	private Integer updateCount;
	
	@Column(length=30)
	private String createdBy;
	
	@Column(length = 30)
	private String updatedBy;
	
	@Column(length=10)
	private String activeStatus="active";
}
