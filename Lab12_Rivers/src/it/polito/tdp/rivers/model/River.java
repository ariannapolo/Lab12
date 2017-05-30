package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;

public class River {

	private List<Flow> flows;
	private String name;
	private int id;
	

	public River(int id) {
		this.id = id;
		flows = new ArrayList<Flow>();
	}

	public River(int id, String name) {
		this.id = id;
		this.name = name;
		flows = new ArrayList<Flow>();
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	public List<Flow> getFlows() {
		if (flows == null)
			flows = new ArrayList<Flow>();
		return flows;
	}

	public void addFlow(Flow f){
		flows.add(f);
	} 
	@Override
	public String toString() {
		return name;
	}

	public int getNumMisurazioni(){
		return flows.size();
	}
	public double getFMedio(){
		double sum = 0;
		for(Flow f: flows){
			sum+= f.getFlow();
		}
		double media = sum/(double)flows.size();
		return media;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		River other = (River) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
