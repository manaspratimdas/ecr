package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.Port;

public interface EcrPortService {
	List<Port> getAvailablePorts(long countryid);

}
