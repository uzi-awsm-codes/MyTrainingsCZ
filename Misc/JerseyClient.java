import java.util.List;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.*;
import com.webservice.model.Person;

public class JerseyClient {

    public static void main(String[] args) {
        Client client = Client.create();
       
        WebResource resource = client.resource("http://localhost:8080/RestWebService/person/1/get");
        System.out.println("Response as string");
         //Get response as String
        String string = resource
            .accept(MediaType.APPLICATION_XML)
                .get(String.class);
        System.out.println(string);

        System.out.println("Response as object");
        // Get response as Object 
        Person person = resource
            .accept(MediaType.APPLICATION_XML)
                .get(Person.class);
        System.out.println(person);
        
        resource = client.resource("http://localhost:8080/RestWebService/person/add");
        String input = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
        		"<person>\r\n" + 
        		"<age>25</age>\r\n" + 
        		"<id>3</id>\r\n" + 
        		"<name>abc</name>\r\n" + 
        		"</person>";

        ClientResponse response = resource.type("application/xml")
           .post(ClientResponse.class, input);


        System.out.println("Display all the person objects");
        resource = client.resource("http://localhost:8080/RestWebService/person");

        List<Person> persons = resource.path("getAll")
            .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Person>>(){});
        for(Person p:persons)
        {
        	System.out.println(p);
        }
       
    }

}
