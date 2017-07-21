package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.Container;

public interface EcrContainerService {

	List<Container> getContainers();
	
	Container getContainer(Long id);
	
	Container getContainerById(Long id);
}
