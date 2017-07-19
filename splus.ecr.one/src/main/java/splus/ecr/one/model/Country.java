package splus.ecr.one.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="COUNTRY")
public class Country {

	
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COUNTRY_ID")
    private Long id;
	
	@Column(name="ISO_COUNTRY_NAME")
	private String name;
	
	@Column(name="ISO_COUNTRY_CODE")
	private String isoCountryCode;
	
	@Column(name="ISO_LOCAL_NAME")
	private String isoLocalName;
	
	@ManyToOne
	@JoinColumn(name = "REGION_ID")
	private Region region;
	
	
	/*@OneToMany(mappedBy="country")
	private List<Port> ports;
	
	@OneToMany(mappedBy="country")
	private List<Address> addresses;*/
	
	
}
