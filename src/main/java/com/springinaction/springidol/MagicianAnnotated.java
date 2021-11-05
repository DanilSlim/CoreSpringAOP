package com.springinaction.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MagicianAnnotated implements MindReader {
	
	private String thoughts;

	//Declare parameterized pointcut
	@Pointcut("execution(* com.springinaction.springidol.Thinker.thinkOfSomething(String)) && args(thoughts)")
	public void thinking(String thoughts){
	}
	
	
	//Pass parameters into advice
	@Before(value = "thinking(thoughts)")
	@Override
	public void interceptThoughts(String thoughts) {
		System.out.println("Intercepting volunteer's thoughts Annotated");
		this.thoughts=thoughts;
		System.out.println("Volunteer thoughts is- "+ this.thoughts +" Annotated");
		
	}

	@Override
	public String getThoughts() {
		// TODO Auto-generated method stub
		return null;
	}

}
