package splus.ecr.one.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
// @Data
@Table(name = "CONTAINER")
public class Container implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTAINER_ID")
	private Long id;

	@Column(name = "Code")
	private String code;

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "PORT_ID")
	private Port port;

	@ManyToOne
	@JoinColumn(name = "CONTAINERTYPE_ID")
	private ContainerType containerType;
	
	// @ManyToMany(mappedBy = "containers")
	// private Set<Cart> carts;

	/*
	 * @Column(name="SIZE_ID") private long sizeID;
	 */

	@Column(name = "CONTAINER_CONDITION")
	private String containerCondition;

	// @Column(name="CONDITION")
	// private String condition;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;
	
	@Column(name = "LAST_UPDATED_DATE")
	private Timestamp lastUpdateDate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Container [id=" + id + ", code=" + code + ", company=" + company + ", port=" + port + ", containerType="
				+ containerType + ", containerCondition=" + containerCondition + ", status=" + status + ", updatedDate="
				+ updatedDate + "]";
	}

	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	/*
	 * public String getName() { return name; }
	 * 
	 *//**
		 * @param name
		 *            the name to set
		 *//*
		 * public void setName(String name) { this.name = name; }
		 */

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the port
	 */
	public Port getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(Port port) {
		this.port = port;
	}

	/**
	 * @return the containerType
	 */
	public ContainerType getContainerType() {
		return containerType;
	}

	/**
	 * @param containerType
	 *            the containerType to set
	 */
	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the containerCondition
	 */
	public String getContainerCondition() {
		return containerCondition;
	}

	/**
	 * @param containerCondition
	 *            the containerCondition to set
	 */
	public void setContainerCondition(String containerCondition) {
		this.containerCondition = containerCondition;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	
	
	
	
	/*public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
*/
	

}
