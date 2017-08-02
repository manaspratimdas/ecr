package splus.ecr.one.model;

import java.util.List;
import java.util.Map;

public class CommunicationObject {
	
	private String string;
	
	private Integer integer;
	
	private Long longg;
	
	private Double doublee;
	
	private List list;
	
	private Map map;
	
	private List<List> listOfList;
	
	private List<Map> listOfMap;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public Long getLongg() {
		return longg;
	}

	public void setLongg(Long longg) {
		this.longg = longg;
	}

	public Double getDoublee() {
		return doublee;
	}

	public void setDoublee(Double doublee) {
		this.doublee = doublee;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List<List> getListOfList() {
		return listOfList;
	}

	public void setListOfList(List<List> listOfList) {
		this.listOfList = listOfList;
	}

	public List<Map> getListOfMap() {
		return listOfMap;
	}

	public void setListOfMap(List<Map> listOfMap) {
		this.listOfMap = listOfMap;
	}


}
