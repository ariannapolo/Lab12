package it.polito.tdp.rivers.model;

import java.util.PriorityQueue;

public class Simulator {

	private River r;
	private double k;
	private double Q;
	private double fMed;
	private final int SEC_IN_DAY = 3600*24;
	
	private double c;
	
	private int giorniFail;
	private double cMedia;
	
	private PriorityQueue<Flow> queue;
	
	public Simulator(River r, double k) {
		super();
		this.r = r;
		this.k = k;
		this.fMed = r.getFMedio();
		this.Q = this.k*fMed*SEC_IN_DAY;
		this.queue = new PriorityQueue<>();
		this.c = Q/2.0;
	}


	public String run(){
		System.out.println("Start: "+c);
		double cSum = 0;
		String result = "";
		int cnt = 0;
		queue.addAll(r.getFlows());
		while(!queue.isEmpty()){
			cnt++;
			Flow f = queue.poll();
			double fIn = f.getFlow();
			double fOut;
			if(Math.random()<0.95){
				fOut = 0.8*fMed;
			}else{
				fOut = 8*fMed;
			}
			
			c += (fIn-fOut)*this.SEC_IN_DAY;
			System.out.println("step: "+cnt+" fIn: "+fIn+" fOut: "+fOut+" C: "+c);
			if(c<0){
				//non sufficiente
				c = 0;
				this.giorniFail++;
			}
			
			if(c>Q){
				//troppo
				c = Q;
			}
			System.out.println("dopo if C: "+c);
			
			result += "Data: "+f.getDay()+" Acqua nel bacino: "+c+"\n";	
			cSum += c;
			
		}
		
		cMedia = cSum/r.getFlows().size();
		return result;
		
		
	}
	
	public int getGiorniFail(){
		return giorniFail;
	}
	public double getCMedia(){
		return cMedia;
	}
	
}
