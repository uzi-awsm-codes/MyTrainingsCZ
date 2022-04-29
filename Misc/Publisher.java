package com.webservice;

import javax.xml.ws.Endpoint;

//Endpoint publisher  
public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:7780/ws/hello", new HelloWorldImpl());
		System.out.println("service published");
	}
}
//http://localhost:7780/ws/hello?wsdl - to view the wsdl file created