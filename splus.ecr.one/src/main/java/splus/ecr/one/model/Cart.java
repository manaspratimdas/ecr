package splus.ecr.one.model;

import java.sql.Date;
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
@Table(name = "CART")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ID")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company borrower;
	
//	@OneToMany(mappedBy="cart")
//	private L/st<Container> containers;

/*	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cart_container", catalog = "ecrone", joinColumns = {
			@JoinColumn(name = "CART_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "CONTAINER_ID",
					nullable = false, updatable = false) })
	private List<Container> containers;*/
	
	@Column(name = "REQUEST_DATE")
	private Date requestDate;
	
	@Column(name = "RELEASE_DATE")
	private Date releaseDate;
	

	@ManyToOne
	@JoinColumn(name = "PORT_ID")
	private Port destinationPort;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CART_CONTAINER", joinColumns = { @JoinColumn(name = "CART_ID") }, inverseJoinColumns = { @JoinColumn(name = "CONTAINER_ID") })
	private List<Container> containers;
	


	
	
	

}
