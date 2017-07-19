package splus.ecr.one.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="REGION")
public class Region {

	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="REGION_ID")
    private Long id;
	
	@Column(name="NAME")
	private String name;
	
	
	@Column(name="REGION_CODE")
	private String regionCode;
	
	
	/*@OneToMany(mappedBy="region")
	private List<Country> contries;*/
	
	
}
