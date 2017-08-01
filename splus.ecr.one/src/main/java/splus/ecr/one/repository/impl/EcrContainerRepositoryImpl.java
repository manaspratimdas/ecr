package splus.ecr.one.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import splus.ecr.one.model.CommunicationObject;
import splus.ecr.one.model.Container;
import splus.ecr.one.repository.EcrContainerRepository;

public class EcrContainerRepositoryImpl implements EcrContainerRepository {
	
	@PersistenceContext
    EntityManager entitymanager;


	public void deleteAllInBatch() {
		
	}

	public void deleteInBatch(Iterable<Container> arg0) {
		
	}

	public List<Container> findAll(Sort arg0) {
		return null;
	}

	public List<Container> findAll(Iterable<Long> arg0) {
		return null;
	}

	public <S extends Container> List<S> findAll(Example<S> arg0) {
		return null;
	}

	public <S extends Container> List<S> findAll(Example<S> arg0, Sort arg1) {
		return null;
	}

	public void flush() {
		
	}

	public Container getOne(Long arg0) {
		return null;
	}

	public <S extends Container> List<S> save(Iterable<S> arg0) {
		return null;
	}

	public <S extends Container> S saveAndFlush(S arg0) {
		return null;
	}

	public Page<Container> findAll(Pageable arg0) {
		return null;
	}

	public long count() {
		return 0;
	}

	public void delete(Long arg0) {
		
	}

	public void delete(Iterable<? extends Container> arg0) {
		
	}

	public void deleteAll() {
		
	}

	public boolean exists(Long arg0) {
		return false;
	}

	public <S extends Container> S save(S arg0) {
		return null;
	}

	public <S extends Container> long count(Example<S> arg0) {
		return 0;
	}

	public <S extends Container> boolean exists(Example<S> arg0) {
		return false;
	}

	public <S extends Container> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		return null;
	}

	public <S extends Container> S findOne(Example<S> arg0) {
		return null;
	}

	public List<Container> findAll() {
		return null;
	}

	public Container findById(Long id) {
		return null;
	}

	public Container findOne(Long id) {
		return null;
	}

	public List<Container> findByCompanyId(Long companyId) {
		return null;
	}

	public void delete(Container container) {
		
	}

	@SuppressWarnings("unchecked")
	public CommunicationObject getContainersByCountry(String id) {
		CommunicationObject communicationObject = new CommunicationObject();
		
		//Query query = entitymanager.createQuery("SELECT p.id AS port1, pc.isoCountryCode, pc.name FROM Port p INNER JOIN p.country pc where p.country = pc.id");
		
		Query query = entitymanager.createNativeQuery("select totalContainer, countryCode, countryName, company from (select count(t2.containerid) as totalContainer, t1.ISO_COUNTRY_CODE as countryCode, t1.ISO_LOCAL_NAME as countryName, t2.company as company from (SELECT port.port_id as port1, country.ISO_COUNTRY_CODE, country.ISO_LOCAL_NAME FROM port join country on port.country_id = country.country_id) as t1 join (select container_id as containerid, port_id as port2, company_id as company from container) as t2 on t1.port1 = t2.port2 group by iso_country_code) as t3 where t3.company= 1");
				
				//entitymanager.createNativeQuery("SELECT port.port_id as port1, country.ISO_COUNTRY_CODE, country.ISO_LOCAL_NAME FROM port join country on port.country_id = country.country_id");
				
				
				//entitymanager.createNativeQuery("select totalContainer, countryCode, countryName, company from (select count(t2.containerid) as totalContainer, t1.ISO_COUNTRY_CODE as countryCode, t1.ISO_LOCAL_NAME as countryName, t2.company as company from (SELECT port.port_id as port1, country.ISO_COUNTRY_CODE, country.ISO_LOCAL_NAME FROM port join country on port.country_id = country.country_id) as t1 join (select container_id as containerid, port_id as port2, company_id as company from container) as t2 on t1.port1 = t2.port2 group by iso_country_code) as t3 where t3.company= :companyId");
		//GROUP BY isoCountryCode
		
		
		
		//Query query = entitymanager.createQuery("SELECT totalContainer, countryCode, countryName, company FROM (SELECT count(t2.containerid) AS totalContainer, t1.isoCountryCode AS countryCode, t1.name AS countryName, t2.company AS company FROM (SELECT Port.id AS port1, Country.isoCountryCode, Country.name FROM Port JOIN Country ON Port.country_id = Country.country_id) AS t1 JOIN (SELECT id AS containerid, port AS port2, company AS company FROM Container) AS t2 ON t1.port1 = t2.port2 GROUP BY isoCountryCode) AS t3 WHERE t3.Company.id=:companyId");
		
		//query.setParameter("companyId", id);
		System.out.println(query.getResultList().size());
		//query.setHint(QueryHints.RESULT_TYPE, ResultType.Map);
		List results = query.getResultList();
		List data = new ArrayList<Map<String,Object>>();
		for(Object object : results){
			Object[] objects = (Object[]) object;
			//List result = (List) object;
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("totalContainer", objects[0]);
			map.put("countryCode", objects[1]);
			map.put("countryName", objects[2]);
			map.put("company", objects[3]);
			data.add(map);
		}
		communicationObject.setListOfMap(data);
		return communicationObject;
	}

}
