package com.learn.entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name="eclass_270423")
public class EClass {

	 @Id
	    @GeneratedValue
	    @Column(name="eclass_id")
	    private Integer id;
	    
	    @Column(name="eclass_name")
	    private String name;
	    
	    @Column(name="eclass_section")
	    private Integer section;

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

		public Integer getSection() {
			return section;
		}

		public void setSection(Integer section) {
			this.section = section;
		}
	    
	    
	
	
}
