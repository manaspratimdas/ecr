package splus.ecr.one.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.CommunicationObject;
import splus.ecr.one.model.Container;
import splus.ecr.one.model.ContainerMapData;
import splus.ecr.one.model.Country;
import splus.ecr.one.model.Port;
import splus.ecr.one.model.Region;
import splus.ecr.one.repository.EcrContainerRepository;
import splus.ecr.one.repository.EcrCountryRepository;
import splus.ecr.one.repository.EcrPortRepository;
import splus.ecr.one.repository.EcrRegionRepository;
import splus.ecr.one.service.EcrContainerService;
import splus.ecr.one.service.EcrPortService;
import splus.ecr.one.specification.ContainerSpecificationBuilder;

@Service
public class EcrContainerServiceImpl implements EcrContainerService{

	@Autowired
	EcrContainerRepository ecrContainerRepository;

	@Autowired
	EcrPortRepository ecrPortRepository;

	@Autowired
	EcrPortService ecrPortService;

	@Autowired
	EcrCountryRepository ecrCountryRepository;

	@Autowired
	EcrRegionRepository ecrRegionRepository;

	public List<Container> getContainers() {

		System.out.println("in container service");
		List<Container> lstContainer=ecrContainerRepository.findAll();

		for(int i=0;i<lstContainer.size();i++){
			System.out.println("container  ->>>"+lstContainer.get(i));
		}


		return lstContainer;
	}

	public Container getContainerById(Long id) {

		System.out.println("in service  getContainerById");
		return ecrContainerRepository.findOne(id);
	}

	public Container getContainer(Long id) {

		return ecrContainerRepository.findById(id);
	}

	public List<Container> getContainersByCompanyId(Long companyId) {

		List<Container> containers = ecrContainerRepository.findByCompanyId(companyId);

		for (Iterator<Container> iterator = containers.iterator(); iterator.hasNext();) {
			Container container = iterator.next();
			if (!container.isRecordStatus()) {
				iterator.remove();
			}
		}

		return containers;
	}
	/*
	 * added by dbangar
	 * 
	 */
	public List<Container> getLenderContainersByCompanyId(Long companyId) {

		List<Container> containers = ecrContainerRepository.findByCompanyId(companyId);
		List<Container> lendercontainers = new ArrayList<Container>();

		for (Iterator<Container> iterator = containers.iterator(); iterator.hasNext();) {
			Container container = iterator.next();

			if (!"".equals(container.getStatus())) {
				if("R".equals(container.getStatus())){

					lendercontainers.add(container);

				}
				iterator.remove();
			}
		}

		return lendercontainers;
	}
	/*
	 * added by dbangar
	 * 
	 */
	public List<Container> getBorrowerContainersByCompanyId(Long companyId) {

		List<Container> containers = ecrContainerRepository.findByCompanyId(companyId);
		List<Container> lendercontainers = new ArrayList<Container>();

		for (Iterator<Container> iterator = containers.iterator(); iterator.hasNext();) {

			Container container = iterator.next();

			if (!"".equals(container.getStatus())) {

				if("B".equals(container.getStatus())){

					lendercontainers.add(container);

				}
				iterator.remove();
			}
		}

		return lendercontainers;
	}

	public List<Container> saveOrUpdateContainers(List<Container> containers) {
		containers.get(0).setRecordStatus(true);
		ecrContainerRepository.save(containers);


		return getContainersByCompanyId(containers.get(0).getCompany().getId());
	}
	/*
	 * added by tanya
	 */
	public Container saveOrUpdateContainer(Container container) {

		ecrContainerRepository.save(container);
		return container;
	}

	public List<Container> delete(Container container) {
		container = ecrContainerRepository.findById(container.getId());
		container.setRecordStatus(false);
		ecrContainerRepository.save(container);
		return getContainersByCompanyId(container.getCompany().getId());
	}

	public List<ContainerMapData> getContainersByCountry(String id) {
		List<Port> ports = ecrPortRepository.findAll();
		Map<Long, List<Long>> countryPortMap = new HashMap<Long, List<Long>>();
		for(Port port : ports){
			if(countryPortMap.keySet().contains(port.getCountry().getId())){
				countryPortMap.get(port.getCountry().getId()).add(port.getId());
			}else{
				List<Long> portIds = new ArrayList<Long>();
				portIds.add(port.getId());
				countryPortMap.put(port.getCountry().getId(), portIds);
			}
		}
		Map<Country, Long> containerGroupByCountry = new HashMap<Country, Long>();
		for(Long countryId : countryPortMap.keySet()){
			System.out.println(countryPortMap.get(countryId));
			long containerSize = 0;
			for(Long portId : countryPortMap.get(countryId)){
				List<Container> containers = ecrContainerRepository.findByPortId(portId);
				for(Container container : containers){
					if(Long.valueOf(id).equals(container.getCompany().getId())){
						containerSize++;
					}
				}
				
			}
			//containerSize = ecrContainerRepository.findAll(countryPortMap.get(countryId)).size();
			Country country = ecrCountryRepository.findOne(countryId);
			containerGroupByCountry.put(country, containerSize);
		}

		CommunicationObject communicationObject = new CommunicationObject();
		communicationObject.setMap(containerGroupByCountry);

		//title: 'India', id: 'IN', color: layoutColors.primary, customData: '1 244', groupId: '1'
		List<ContainerMapData> containerMapDatas = new ArrayList<ContainerMapData>();
		List<Country> countries = ecrCountryRepository.findAll();
		for(Country country : containerGroupByCountry.keySet()){
			ContainerMapData containerMapData = new ContainerMapData();
			containerMapData.setColor("layoutColors.primary");
			containerMapData.setGroupId("1");
			containerMapData.setTitle(country.getIsoLocalName());
			containerMapData.setId(country.getIsoCountryCode());
			containerMapData.setCustomData(String.valueOf(containerGroupByCountry.get(country)));
			JSONObject jsonObject = new JSONObject();
			jsonObject.append("title", country.getName()).append("id", country.getIsoCountryCode()).append("color", "layoutColors.primary").append("customData", containerGroupByCountry.get(country)).append("groupId", "1");
			containerMapDatas.add(containerMapData);
			countries.remove(country);
		}

		for(Country country : countries){
			ContainerMapData containerMapData = new ContainerMapData();
			containerMapData.setColor("layoutColors.primary");
			containerMapData.setGroupId("1");
			containerMapData.setTitle(country.getIsoLocalName());
			containerMapData.setId(country.getIsoCountryCode());
			containerMapData.setCustomData("0");
			JSONObject jsonObject = new JSONObject();
			jsonObject.append("title", country.getName()).append("id", country.getIsoCountryCode()).append("color", "layoutColors.primary").append("customData", containerGroupByCountry.get(country)).append("groupId", "1");
			containerMapDatas.add(containerMapData);
		}
		return containerMapDatas;
	}

	public List<Container>  getAvailableContainers(String type, String country, String port, String company) {

		System.out.println("containers in service "+type+",  "+country+" ,  "+port+", "+company);

		ContainerSpecificationBuilder builder=new ContainerSpecificationBuilder();

		builder.with("status", ":", "A");

		builder.with("recordStatus", ":", true);

		if(port!=null && !port.equals("null")){
			builder.with("port", ":",Long.parseLong(port));
		}
		if(type!=null &&! type.equals("null")){
			builder.with("containerType", ":",Long.parseLong(type));
		}
		if(company!=null &&! company.equals("null")){
			builder.with("company", ":",Long.parseLong(company));
		}



		Specification<Container> spec = builder.build();

		List<Container> results =ecrContainerRepository.findAll(Specifications.where(spec));

		/*builder=new ContainerSpecificationBuilder();

		if(country!=null &&! country.equals("null")){
			List<Port> portsByCountry=ecrPortRepository.findByCountryId(Long.parseLong(country));
			System.out.println(portsByCountry);

				for(Port p : portsByCountry){
					//builder.with("port", ":",p.getId());

					System.out.println("Port >>>>> "+port);
						builder.with("port", ":",p.getId());

				}
				Specification<Container> spec1 = builder.buildOr();
				List<Container> results1 =ecrContainerRepository.findAll(Specifications.where(spec1));
				results.addAll(results1);
			}

		 */





		System.out.println("result "+results);

		return results;

	}

	public List<Port> getAllPorts(long countryid){
		List<Port> availablePort=null;
		if(!"".equals(countryid)){
			System.out.println("in port service");
			availablePort=ecrPortService.getAvailablePorts(countryid);
			return availablePort;
		}else{
			System.out.println("no ports available with country id:"+countryid);
		}
		return availablePort;
	}

	public Map<String, Long> getContainersByRegion(String id) {
		List<Port> ports = ecrPortRepository.findAll();
		Map<Long, List<Long>> countryPortMap = new HashMap<Long, List<Long>>();
		for(Port port : ports){
			if(countryPortMap.keySet().contains(port.getCountry().getId())){
				countryPortMap.get(port.getCountry().getId()).add(port.getId());
			}else{
				List<Long> portIds = new ArrayList<Long>();
				portIds.add(port.getId());
				countryPortMap.put(port.getCountry().getId(), portIds);
			}
		}
		Map<Country, Long> containerGroupByCountry = new HashMap<Country, Long>();
		for(Long countryId : countryPortMap.keySet()){
			long containerSize = ecrContainerRepository.findAll(countryPortMap.get(countryId)).size();
			Country country = ecrCountryRepository.findOne(countryId);
			containerGroupByCountry.put(country, containerSize);
		}

		CommunicationObject communicationObject = new CommunicationObject();
		communicationObject.setMap(containerGroupByCountry);

		//title: 'India', id: 'IN', color: layoutColors.primary, customData: '1 244', groupId: '1'
		List<ContainerMapData> containerMapDatas = new ArrayList<ContainerMapData>();
		List<Country> countries = ecrCountryRepository.findAll();
		List<Country> alreadyAddedCountries = new ArrayList<Country>();
		for(Country country : containerGroupByCountry.keySet()){
			ContainerMapData containerMapData = new ContainerMapData();
			containerMapData.setColor("layoutColors.primary");
			containerMapData.setGroupId("1");
			containerMapData.setTitle(country.getIsoLocalName());
			containerMapData.setId(country.getIsoCountryCode());
			containerMapData.setCustomData(String.valueOf(containerGroupByCountry.get(country)));
			containerMapData.setRegion(country.getRegion());
			JSONObject jsonObject = new JSONObject();
			jsonObject.append("title", country.getName()).append("id", country.getIsoCountryCode()).append("color", "layoutColors.primary").append("customData", containerGroupByCountry.get(country)).append("groupId", "1");
			containerMapDatas.add(containerMapData);
			alreadyAddedCountries.add(country);
		}

		for(Country country : countries){
			if(!alreadyAddedCountries.contains(country)){
				ContainerMapData containerMapData = new ContainerMapData();
				containerMapData.setColor("layoutColors.primary");
				containerMapData.setGroupId("1");
				containerMapData.setTitle(country.getIsoLocalName());
				containerMapData.setId(country.getIsoCountryCode());
				containerMapData.setCustomData("0");
				containerMapData.setRegion(country.getRegion());
				JSONObject jsonObject = new JSONObject();
				jsonObject.append("title", country.getName()).append("id", country.getIsoCountryCode()).append("color", "layoutColors.primary").append("customData", containerGroupByCountry.get(country)).append("groupId", "1");
				containerMapDatas.add(containerMapData);
			}
		}
		Map<String, Long> containerGroupByRegion = new HashMap<String, Long>();
		for(ContainerMapData containerMapData : containerMapDatas){
			if(containerGroupByRegion.keySet().contains(containerMapData.getRegion().getName())){
				containerGroupByRegion.put(containerMapData.getRegion().getName(), containerGroupByRegion.get(containerMapData.getRegion().getName()) + Long.valueOf(containerMapData.getCustomData()));
			}else{
				containerGroupByRegion.put(containerMapData.getRegion().getName(), Long.valueOf(containerMapData.getCustomData()));
			}
		}
		return containerGroupByRegion;
	}

	public Map<String, List<Float>> getContainersByPort(String companyId) {
		List<Container> containers = ecrContainerRepository.findByCompanyId(Long.parseLong(companyId));
		Map<String, List<Float>> containerGroupByPort = new HashMap<String, List<Float>>();
		for(Container container : containers){
			if(containerGroupByPort.keySet().contains(container.getPort().getIsoPortName())){
				float size = (float) (containerGroupByPort.get(container.getPort().getIsoPortName()).get(0)+1.0);
				containerGroupByPort.get(container.getPort().getIsoPortName()).set(0, size);
				containerGroupByPort.put(container.getPort().getIsoPortName(), containerGroupByPort.get(container.getPort().getIsoPortName()));
			}else{
				List<Float> countAndPercent = new ArrayList<Float>();
				countAndPercent.add((float) 1.0);
				containerGroupByPort.put(container.getPort().getIsoPortName(), countAndPercent);
			}
		}
		
		long portSize = containerGroupByPort.size();
		long totalContainers = containers.size();
		for(String port : containerGroupByPort.keySet()){
			float countOnPort = containerGroupByPort.get(port).get(0);
			float percent = countOnPort/totalContainers*100; 
			containerGroupByPort.get(port).add(percent);
		}
		
		containerGroupByPort.put("totalContainers", new ArrayList<Float>());
		containerGroupByPort.get("totalContainers").add((float) totalContainers);
		return containerGroupByPort;
	}

}
