<%-- 
    Document   : ErrorPage
    Created on : May 9, 2018, 10:16:16 PM
    Author     : muhammad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
An error has happened , read more at http://localhost:8080/Payroll/error.jsp 

<%-- 
    To print exceptions stack trace 
    right now I made a wrapper that hide that from the end user

    To rip this wrapper remove the comment bellow and disable request replace in onload callback of request in calculator.js (AJAX Section)
<%
    exception.printStackTrace(response.getWriter());
%>
--%>
