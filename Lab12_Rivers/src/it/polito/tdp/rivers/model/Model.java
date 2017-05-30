package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	private List<River> rivers;
	private List<Flow> flows;
	
	public Model(){
		rivers = new ArrayList<>();
		flows = new ArrayList<>();
	}
	
	public List<River> getRivers(){
		RiversDAO dao = new RiversDAO();
		if(rivers.size()==0){
			rivers = dao.getAllRivers();
		}
		return rivers;
	}
	public List<Flow> getFlow(){
		RiversDAO dao = new RiversDAO();
		if(flows.size()==0){
			flows = dao.getAllFlows(rivers);
		}
		return flows;
	}
	
	public LocalDate getFirstFlowDate(River r){
		this.getFlow();
		RiversDAO dao = new RiversDAO();
		return dao.getFirstFlowDate(r);
		
	}
	public LocalDate getLastFlowDate(River r){
		this.getFlow();
		RiversDAO dao = new RiversDAO();
		return dao.getLastFlowDate(r);
		
	}

}
