package rest;

import javax.ws.rs.*;
import org.glassfish.jersey.server.*;

@ApplicationPath("/services")
public class RESTServiceConfig extends ResourceConfig
{
    public RESTServiceConfig()
    {
        packages("rest","fun.model");
    }   
}
