package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.Container;

public interface EcrContainerService {

	List<Container> getContainers();
	
	Container getContainer(Long id);
	
	Container getContainerById(Long id);

	List<Container> getContainersByCompanyId(Long companyId);

	List<Container> saveOrUpdateContainers(List<Container> containers);
}
