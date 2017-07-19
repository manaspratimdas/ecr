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
@Table(name="PORT")
public class Port {

	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="PORT_ID")
    private Long id;
	
	
	@Column(name="ISO_PORT_NAME")
	private String isoPortName;
	
	@Column(name="ISO_PORT_CODE")
	private String isoPortCode;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;
	
	
	@Column(name="LONGITUDE")
	private String longitude;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	/*@OneToMany(mappedBy="port")
	private List<Container> containers;*/
	
	
}
