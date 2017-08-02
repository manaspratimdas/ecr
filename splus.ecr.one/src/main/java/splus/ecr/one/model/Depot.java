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
@Table(name="DEPOT")
public class Depot {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="DEPOT_ID")
	private long id;
	
	@Column(name="DEPOT_NAME")
	private String depotName;
	
	
	@Column(name="DEPOT_CODE")
	private String depotCode;


	@ManyToOne
	@JoinColumn(name = "PORT_ID")
	private Port port;

	/**
	 * @return the depotName
	 */
	public String getDepotName() {
		return depotName;
	}


	/**
	 * @param depotName the depotName to set
	 */
	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}


	/**
	 * @return the depotCode
	 */
	public String getDepotCode() {
		return depotCode;
	}


	/**
	 * @param depotCode the depotCode to set
	 */
	public void setDepotCode(String depotCode) {
		this.depotCode = depotCode;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the port
	 */
	public Port getPort() {
		return port;
	}


	/**
	 * @param port the port to set
	 */
	public void setPort(Port port) {
		this.port = port;
	}


	@Override
	public String toString() {
		return "Depot [id=" + id + ", depotName=" + depotName + ", depotCode=" + depotCode + ", port=" + port + "]";
	}
	

	
	

	
}
