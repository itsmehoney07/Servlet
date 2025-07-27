package com.learning;

import com.learning.servlets.HelloServelet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {

        System.out.println( "Hello World!" );
        //tomcat server or web server is servlet container which means we can only run servlets inside it
        //if we were using external tomcat we can do all the configuration from web.xml file
        // and can use annotation like @WebServlet on the class name which will be used as a servlet
        // as we are using embedded tomcat we have to do the configuration here manually
        Tomcat tomcat = new Tomcat();
        //for servlet mapping we have to open the context
        Context context= tomcat.addContext("",null);
        Tomcat.addServlet(context, "HelloServelet",new HelloServelet());
        context.addServletMappingDecoded("/hello", "HelloServelet");

        //starting tomcat
        tomcat.start();
        System.out.println("Tomcat STarted");
        System.out.println("Port" + tomcat.getConnector().getPort());
        // telling tomcat to get Server and await for the request
        tomcat.getServer().await();

    }
}
