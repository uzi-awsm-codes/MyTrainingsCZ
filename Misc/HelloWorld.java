
package com.webservice;

import javax.jws.WebMethod;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService(name = "HelloWorld", targetNamespace = "http://webservice.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorld {

	@WebMethod

	public String getHelloWorldAsString(String str);

}
