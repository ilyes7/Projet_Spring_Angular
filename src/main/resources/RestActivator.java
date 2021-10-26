package rest.utilities;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("rest")
public class RestActivator extends Application {
	public RestActivator() { 
		super();
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8089");
		beanConfig.setBasePath("Gestion-Magasin-Stock/rest");
		beanConfig.setResourcePackage("rest.ressources");
		beanConfig.setScan(true);
		}

}
