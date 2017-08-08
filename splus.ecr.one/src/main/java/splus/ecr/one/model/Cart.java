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
	
	@Column(name = "PORT_SOURCE")
	private String PortSource;
	
	@Column(name = "PORT_DESTINATION")
	private String PortDestination;

	
	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;
	
	
	@Column(name = "STATUS")
	private int status;
	
	
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

	@Column(name = "REQUISITION_NO")
	private long requisitionNo;
	
	@Column(name = "REQUESTED_QUANTITY")
	private long requestedQuantity;
	
	@Column(name = "PICKUP_DATE")
	private Date pickUpDate;
	
	@Column(name = "NOTE")
	private String note;

	
	/**
 * @return the status
 */
public int getStatus() {
	return status;
}


/**
 * @param status the status to set
 */
public void setStatus(int status) {
	this.status = status;
}


	/**
 * @return the portSource
 */
public String getPortSource() {
	return PortSource;
}


/**
 * @param portSource the portSource to set
 */
public void setPortSource(String portSource) {
	PortSource = portSource;
}


/**
 * @return the portDestination
 */
public String getPortDestination() {
	return PortDestination;
}


/**
 * @param portDestination the portDestination to set
 */
public void setPortDestination(String portDestination) {
	PortDestination = portDestination;
}


/**
 * @return the requisitionNo
 */
public long getRequisitionNo() {
	return requisitionNo;
}


/**
 * @param requisitionNo the requisitionNo to set
 */
public void setRequisitionNo(long requisitionNo) {
	this.requisitionNo = requisitionNo;
}


/**
 * @return the requestedQuantity
 */
public long getRequestedQuantity() {
	return requestedQuantity;
}


/**
 * @param requestedQuantity the requestedQuantity to set
 */
public void setRequestedQuantity(long requestedQuantity) {
	this.requestedQuantity = requestedQuantity;
}


/**
 * @return the pickUpDate
 */
public Date getPickUpDate() {
	return pickUpDate;
}


/**
 * @param pickUpDate the pickUpDate to set
 */
public void setPickUpDate(Date pickUpDate) {
	this.pickUpDate = pickUpDate;
}


/**
 * @return the note
 */
public String getNote() {
	return note;
}


/**
 * @param note the note to set
 */
public void setNote(String note) {
	this.note = note;
}


	public Company getBorrower() {
		return company;
	}


	public void setBorrower(Company borrower) {
		this.company = borrower;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [id=" + id + ", PortSource=" + PortSource + ", PortDestination=" + PortDestination + ", borrower="
				+ company + ", status=" + status + ", requestDate=" + requestDate + ", releaseDate=" + releaseDate
				+ ", destinationPort=" + destinationPort + ", containers=" + containers + ", requisitionNo="
				+ requisitionNo + ", requestedQuantity=" + requestedQuantity + ", pickUpDate=" + pickUpDate + ", note="
				+ note + "]";
	}
	

	
	
}
