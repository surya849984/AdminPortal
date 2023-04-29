package com.teacher.entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name="eteacher_270423")
public class ETeacher {

	 @Id
	    @GeneratedValue
	    @Column(name="eteacher_id")
	    private Integer id;
	    
	    @Column(name="eteaacher_name")
	    private String name;
	    
	    @Column(name="eteacher_email")
	    private String email;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	    

}
