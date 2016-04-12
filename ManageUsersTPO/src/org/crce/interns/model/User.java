package org.crce.interns.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="job_schema.applicant_company")
/*@SecondaryTables({
	@SecondaryTable(name = "job_schema.company", pkJoinColumns = @PrimaryKeyJoinColumn(name = "company_id") ),
	@SecondaryTable(name = "user_schema.userdetails", pkJoinColumns = @PrimaryKeyJoinColumn(name = "username") )
	})
*/public class User implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 7820053866158129013L;
	
	@Id
	@Column(name="username")
	private String username;
	
	@Id
	@Column(name="company_id")
	private String company_id;

	@Column(name="company_name")
	private String company;
	
	//private String user_password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
		/*
		 * database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://localhost:3306/intellex
database.user=root
database.password=
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.hbm2ddl.auto=update
hibernate.show_sql=true
		 */

}
