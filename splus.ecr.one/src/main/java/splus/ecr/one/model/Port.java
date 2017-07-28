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
	

	/*@OneToMany
	@JoinColumn(name="DEPOT_ID")
	private String depotID;
	*/
	/*@OneToMany(mappedBy="port")
	private List<Container> containers;*/
	
	/**
	 * @return the depotID
	 */
/*	public String getDepotID() {
		return depotID;
	}*/

	/**
	 * @param depotID the depotID to set
	 */
	/*public void setDepotID(String depotID) {
		this.depotID = depotID;
	}*/

	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the isoPortName
	 */
	public String getIsoPortName() {
		return isoPortName;
	}

	/**
	 * @param isoPortName the isoPortName to set
	 */
	public void setIsoPortName(String isoPortName) {
		this.isoPortName = isoPortName;
	}

	/**
	 * @return the isoPortCode
	 */
	public String getIsoPortCode() {
		return isoPortCode;
	}

	/**
	 * @param isoPortCode the isoPortCode to set
	 */
	public void setIsoPortCode(String isoPortCode) {
		this.isoPortCode = isoPortCode;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Port [ id=" + id + ", isoPortName=" + isoPortName + ", isoPortCode="
				+ isoPortCode + ", country=" + country + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	

}
