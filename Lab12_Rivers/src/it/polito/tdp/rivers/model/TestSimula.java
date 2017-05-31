package it.polito.tdp.rivers.model;

public class TestSimula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();
		Simulator s = new Simulator(model.getRivers().get(2),0.5);
		System.out.println(s.run());

	}

}
