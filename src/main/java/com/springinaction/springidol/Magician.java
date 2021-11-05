package com.springinaction.springidol;

public class Magician implements MindReader {
	
	private String thoughts;

	@Override
	public void interceptThoughts(String thoughts) {
		
		System.out.println("Intercepting volunteer's thoughts");
		this.thoughts=thoughts;
		System.out.println("Volunteer thoughts is- "+ this.thoughts);

	}

	@Override
	public String getThoughts() {
		
		return thoughts;
	}

}
