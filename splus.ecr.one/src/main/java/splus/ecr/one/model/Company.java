package splus.ecr.one.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "COMPANY")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_ID")
	private Long id;

	@Column(name = "Name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	
	/*@OneToMany(mappedBy="company")
	private List<User> users;
	
	@OneToMany(mappedBy="borrower")
	private List<Cart> carts;
	
	@OneToMany(mappedBy="company")
	private List<Container> containers;*/
	
	
}
