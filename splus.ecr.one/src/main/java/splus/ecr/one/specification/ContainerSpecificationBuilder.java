package splus.ecr.one.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import splus.ecr.one.model.Container;

public class ContainerSpecificationBuilder {

	
	private final List<SearchCriteria> params;
	
	public ContainerSpecificationBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
	
	public ContainerSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
	
	
	
	public Specification<Container> build() {
        if (params.size() == 0) {
            return null;
        }
        
        List<Specification<Container>> specs = new ArrayList<Specification<Container>>();
        for (SearchCriteria param : params) {
            specs.add(new ContainerSpecification(param));
        }
 
        Specification<Container> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }
	
	
	public Specification<Container> buildOr() {
        if (params.size() == 0) {
            return null;
        }
        
        List<Specification<Container>> specs = new ArrayList<Specification<Container>>();
        for (SearchCriteria param : params) {
            specs.add(new ContainerSpecification(param));
        }
 
        Specification<Container> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).or(specs.get(i));
        }
        return result;
    }
        
}
