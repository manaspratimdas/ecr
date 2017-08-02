package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.CommunicationObject;
import splus.ecr.one.model.Container;

public interface EcrContainerService {

	List<Container> getContainers();
	
	Container getContainer(Long id);
	
	Container getContainerById(Long id);

	List<Container> getContainersByCompanyId(Long companyId);

	List<Container> saveOrUpdateContainers(List<Container> containers);

	void delete(Container container);
	
	public CommunicationObject getContainersByCountry(String id);

	List<Container> getAvailableContainers(String type, String country, String port, String company);
}
