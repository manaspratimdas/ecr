package splus.ecr.one.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CONTAINERTYPE")
public class ContainerType {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "CONTAINERTYPE_ID")
    private Long id;
	
	@Column(name = "SIZE")
	private String size;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy="containerType")
	private List<Container> containers;

}
