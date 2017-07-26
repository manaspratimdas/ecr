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
//@Data
@Table(name="COUNTRY")
public class Country {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COUNTRY_ID")
    private long id;
	
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
	
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isoCountryCode
	 */
	public String getIsoCountryCode() {
		return isoCountryCode;
	}

	/**
	 * @param isoCountryCode the isoCountryCode to set
	 */
	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}

	/**
	 * @return the isoLocalName
	 */
	public String getIsoLocalName() {
		return isoLocalName;
	}

	/**
	 * @param isoLocalName the isoLocalName to set
	 */
	public void setIsoLocalName(String isoLocalName) {
		this.isoLocalName = isoLocalName;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}


	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", isoCountryCode=" + isoCountryCode + ", isoLocalName="
				+ isoLocalName + ", region=" + region + "]";
	}
}
