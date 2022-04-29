package com.training.ooc;
abstract class Vehiclee
{
	abstract public void start() ; //(wihout body)//declared
	
	abstract void stop() ;
	//concrete methods (with body) //defined
	void buy()
	{
		System.out.println("buying a vehicle");
	}
		
}
class Ccarr extends Vehiclee
{
	public void start()
	{
		System.out.println("start a car");
	}
	void stop()
	{
		System.out.println("stop a car");
	}
	}
class Bikke extends Vehiclee
{
	public void start()
	{
		System.out.println("start a bike");
	}
	void stop()
	{
		System.out.println("start a bike");
	}
	void ride()
	{
		System.out.println("riding a bike");
	}
}

		

public class AbstractDemo {

	public static void main(String[] args) {
	//Vehiclee v=new Vehiclee();
		Vehiclee v=new Ccarr();
		v.start();
		v.stop();
		v.buy();
		v=new Bikke();
		v.start();
		v.stop();
		v.buy();
		

	}

}




