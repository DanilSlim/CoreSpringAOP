package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppAOP {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
		
		Performer performer=(Performer) context.getBean("duke");
		
		performer.perform();
		
		Thinker volunteer=(Thinker) context.getBean("volunteer");
		
		volunteer.thinkOfSomething("Think about AOP Spring");

	}

}
