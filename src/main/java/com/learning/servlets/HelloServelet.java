package com.learning.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class HelloServelet extends HttpServlet {
//as the request can have data which will be handled by special object here it is req
    // data we will send is handled by special object called res
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In servlet");
        //res object is any way going to client
        //so use getWriter method to make servlet understand about to want to write content to object and send it to client
        // Printer out= res.getWriter
        // out.println("content")
        // you can also attach html to the content but to make java understand that html is also attached
        // you have to use one method
        res.setContentType("text/html");
        // now attach html to it
        res.getWriter().println("<h2><b>Hello from servlet</b></h2>");
    }
}
