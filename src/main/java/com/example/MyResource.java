package com.example;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;

import com.example.dao.SimpleModelDAO;
import com.example.model.SimpleModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
    	SimpleModelDAO s = new SimpleModelDAO();
    	List<SimpleModel> r = s.getResults();
    	
    	System.out.println("Size : " + r.size()+"\n\n\n");
    	
    	
    	String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
}
