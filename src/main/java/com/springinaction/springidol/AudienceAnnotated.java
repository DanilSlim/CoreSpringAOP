package com.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AudienceAnnotated {
	
	@Pointcut("execution(* com.springinaction.springidol.Performer.perform(..))")//Define pointcat
	public void performance() {
	}
	
	@Before("performance()")//Before performance
	public void takeSeats(){
		System.out.println("The audience is taking their seats.Annotated");
		}
	
	@Before(value = "performance()")//Before performance
	public void turnOffCellPhones(){
		System.out.println("The audience is turning off their cellphones.Annoteted");
		}
	
	@AfterReturning(value="performance()")//After performance
	public void applaud(){
		System.out.println("CLAP CLAP CLAP CLAP CLAP.Annteted");
		}
	
	@AfterThrowing("performance()")//After bad performance
	public void demandRefund(){
		System.out.println("Boo!Wewantourmoneyback!");
		}
	
	@Around(value = "performance()")
	public void watchPerformance(ProceedingJoinPoint joinpoint){
		try {
		System.out.println("The audience is taking their seats.AnnotetedAround");
		System.out.println("The audience is turning off their cellphones.AnnotetedAround");
		
		long start=System.currentTimeMillis();
		
		joinpoint.proceed();

		long end=System.currentTimeMillis();
		System.out.println("CLAP CLAP CLAP CLAP CLAP.AnnotetedAround");
		System.out.println("The performance took "+(end-start)+ " milliseconds.AnnotetedAround");
		} catch(Throwable t){
		System.out.println("Boo!Wewantourmoneyback!");
		}
	}

}
