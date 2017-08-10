package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.CommunicationObject;
import splus.ecr.one.model.Container;

public interface EcrContainerService {

	List<Container> getContainers();
	
	Container getContainer(Long id);
	
	Container getContainerById(Long id);

	List<Container> getContainersByCompanyId(Long companyId);
	//added by dbangar
	List<Container> getLenderContainersByCompanyId(Long companyId);
	List<Container> getBorrowerContainersByCompanyId(Long companyId);
	

	List<Container> saveOrUpdateContainers(List<Container> containers);
	//added by tanya
	Container saveOrUpdateContainer(Container container);

	public List<Container> delete(Container container);
	
	public CommunicationObject getContainersByCountry(String id);

	List<Container> getAvailableContainers(String type, String country, String port, String company);
}
