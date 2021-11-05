package com.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	
	public void takeSeats(){
		System.out.println("Theaudienceistakingtheirseats.");
		}
	
		public void turnOffCellPhones(){
		System.out.println("Theaudienceisturningofftheircellphones");
		}
		
		public void applaud(){
		System.out.println("CLAPCLAPCLAPCLAPCLAP");
		}
		
		public void demandRefund(){
		System.out.println("Boo!Wewantourmoneyback!");
		}
		
		
		//Around advise
		public void watchPerformance(ProceedingJoinPoint joinpoint) {
			
			try{
				//Before section
				System.out.println("The audience is taking their seats.");
				System.out.println("The audience is turning off their cellphones");
				long start=System.currentTimeMillis();
				
				joinpoint.proceed();//Передача управления в метод бизнес логики (proceed to advised method)
				
				//After section
				long end=System.currentTimeMillis(); 
				System.out.println("CLAP CLAP CLAP CLAP CLAP");
				System.out.println("The performance took "+(end-start)
				+ " milliseconds.");
			}
			catch (Throwable t) {
				System.out.println("Boo!We want our money back!");
			}
		}

}
