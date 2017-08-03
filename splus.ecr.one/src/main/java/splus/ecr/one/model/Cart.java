package splus.ecr.one.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
//@Data
@Table(name = "CART")
public class Cart implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ID")
	private Long id;
	
	/*@Column(name = "PORT_SOURCE")
	private String PortSource;
	
	@Column(name = "PORT_DESTINATION")
	private String PortDestination;*/

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company borrower;
	

	
	@Column(name = "REQUEST_DATE")
	private Timestamp requestDate;
	
	@Column(name = "RELEASE_DATE")
	private Timestamp releaseDate;
	

	@ManyToOne
	@JoinColumn(name = "PORT_ID")
	private Port destinationPort;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CART_CONTAINER", joinColumns = { @JoinColumn(name = "CART_ID") }, inverseJoinColumns = { @JoinColumn(name = "CONTAINER_ID") })
	private Set<Container> containers;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Company getBorrower() {
		return borrower;
	}


	public void setBorrower(Company borrower) {
		this.borrower = borrower;
	}


	public Timestamp getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}


	public Timestamp getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Port getDestinationPort() {
		return destinationPort;
	}


	public void setDestinationPort(Port destinationPort) {
		this.destinationPort = destinationPort;
	}


	public Set<Container> getContainers() {
		return containers;
	}


	public void setContainers(Set<Container> containers) {
		this.containers = containers;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", borrower=" + borrower + ", requestDate=" + requestDate + ", releaseDate="
				+ releaseDate + ", destinationPort=" + destinationPort + ", containers=" + containers + "]";
	}
	

	
	
}
