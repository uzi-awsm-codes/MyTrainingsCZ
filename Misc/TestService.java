package com.webservice;

public class TestService {

	public static void main(String[] args) {

		HelloWorldImplService serviceImpl = new HelloWorldImplService();

		HelloWorld service = serviceImpl.getHelloWorldImplPort();
		System.out.println(service.getHelloWorldAsString("msg from client"));

	}

}
//From cmd prompt execute, wsimport -s . http://localhost:7780/ws/hello?wsdl - 
//to generate stub on the client side(copy the generate files to the client project)