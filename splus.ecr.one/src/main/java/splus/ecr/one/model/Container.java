package splus.ecr.one.model;

import java.util.List;

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
@Data
@Table(name="CONTAINER")
public class Container {

	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="CONTAINER_ID")
    private Long id;
	
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Code")
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
	
//	@Column(name="CONDITION")
//	private String condition;
	
	@Column(name="STATUS")	
	private String status;
	
	//@ManyToOne
   // @JoinColumn(name = "CART_ID")
	//private Cart cart;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONTAINER_CART", joinColumns = { @JoinColumn(name = "CONTAINER_ID") }, inverseJoinColumns = { @JoinColumn(name = "CART_ID") })
	private List<Cart> carts;*/

	
	

	
	
}
