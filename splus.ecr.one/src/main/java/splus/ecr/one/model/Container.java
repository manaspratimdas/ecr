package splus.ecr.one.model;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Data
@Table(name="CONTAINER")
public class Container implements Serializable{


	
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
     @Column(name="id")
    private Long id;
	
	
	@Column(name="NAME")
	private String name;
	
	/*@Column(name="Code")
	private String code;*/
	

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "PORT_ID")
	private Port port;
	
	@ManyToOne
	@JoinColumn(name = "CONTAINERTYPE_ID")
	private ContainerType containerType;
	
	/*@Column(name="SIZE_ID")
	private long sizeID;*/
	
	@Column(name="CONTAINER_CONDITION")
	 private String containerCondition;
	
//	@Column(name="CONDITION")
//	private String condition;
	

	@Column(name="STATUS")	
	private String status;


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
	 * @return the code
	 */
	/*public String getCode() {
		return code;
	}*/

	/**
	 * @param code the code to set
	 */
	/*public void setCode(String code) {
		this.code = code;
	}*/

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
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
	 * @param port the port to set
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
	 * @param containerType the containerType to set
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
	 * @param status the status to set
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
	 * @param containerCondition the containerCondition to set
	 */
	public void setContainerCondition(String containerCondition) {
		this.containerCondition = containerCondition;
	}

	
	//@ManyToOne
   // @JoinColumn(name = "CART_ID")
	//private Cart cart;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONTAINER_CART", joinColumns = { @JoinColumn(name = "CONTAINER_ID") }, inverseJoinColumns = { @JoinColumn(name = "CART_ID") })
	private List<Cart> carts;*/


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	 
	
}
