package splus.ecr.one.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ADDRESS")
public class Address {

	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
    private Long id;
	
	@Column(name="ADDRESS_LINE_ONE")
	private String addressLineOne;
	
	@Column(name="STREET_NAME")
	private String streetName;
	
	@Column(name="CITY")
	private String city;
	
	
	@ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
	private Country country;
	
	@Column(name="ZIP")
	private String zip;
	
	
	

	
	
	
	
}
