package com.learning;

import com.learning.servlets.HelloServelet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

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
        // here the addContext is having 2 parameters
        // contextPath: where application will be available , empty means http://localhost:8080
        // if the context path is having "hello" then it means application is available at this http://localhost:8080/hello
        // docBase : telling tomcat that all the files will be available at this path
        // tomcat will look for all the files like html , jsp and servlet in this location
        Context context= tomcat.addContext("",new File(".").getAbsolutePath());
        // simple meaning if you are holding a party contextPath is the invite shared
        // and docBase is the address where party is hosted
        // if invite is send and address is missing now one will show up right..
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
