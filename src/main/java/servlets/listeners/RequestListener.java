package servlets.listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class RequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("Request Destroyed");
    }

    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("Request Created");
    }
}
