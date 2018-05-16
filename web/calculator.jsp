<%@page import="controllers.DBController"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="model.Payroll"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="controllers.TaxablePayController"%>
<%@page import="controllers.ParserController"%>

<%-- Set the content type header with the JSP directive --%>
<%@ page contentType="application/json" pageEncoding="UTF-8" %>

<%-- Set Error Page --%>
<%@ page errorPage="error-page.jsp" %>

<%-- Our Parameters and Methods --%> 
<%! String prefix;%>
<%! int code;%>
<%! double totalTaxablePay; %>
<%! double TaxDue; %>
<%! Payroll p;%>
<%!void parseTaxCode(String taxCode) {
        ParserController p = new ParserController(taxCode);
        prefix = p.getPrefixCode();
        code = Integer.parseInt(p.getNumber());
    }%>
<%!void processTax(HttpServletRequest request) {
        TaxablePayController calculator = new TaxablePayController(prefix, code, request.getParameter("payFrequency"), request.getParameter("payPeriod"), request.getParameter("totalPayForPeriod"), request.getParameter("totalPayToDate"));
        totalTaxablePay = calculator.getTaxablePay();
        TaxDue = calculator.getTaxDue();
    }%>
 
<%!void validate(HttpServletRequest request) throws Exception{
    
        // you can get an enumeratable list of parameter keys by using request.getParameterNames() 
        Enumeration en = request.getParameterNames();

        ArrayList array = new ArrayList();
        Map<String, String> parameters = new HashMap<String, String>();

        // enumerate through the keys and extract the values from the keys! 
        while (en.hasMoreElements()) {
            String parameterName = (String) en.nextElement();
            String parameterValue = request.getParameter(parameterName);         
            parameters.put(parameterName, parameterValue);
        }
        if (parameters.isEmpty() || parameters.get("payFrequency")== null || parameters.get("payPeriod")== null
                || parameters.get("totalPayForPeriod")== null || parameters.get("totalPayToDate")== null
                || parameters.get("taxCode")== null) {
            throw new Exception();
        }
    }%>


<%-- Set the content disposition header (Should be showed as Web page)--%>
<%
    response.setContentType("application/json");
    response.setHeader("Content-Disposition", "inline");
%>



<%
    //validate the request
    validate(request);
    // write the begin of object
    out.print("{");
    // you can get an enumeratable list of parameter keys by using request.getParameterNames() 
    Enumeration en = request.getParameterNames();

    // enumerate through the keys and extract the values from the keys! 
    while (en.hasMoreElements()) {
        String parameterName = (String) en.nextElement();
        String parameterValue = request.getParameter(parameterName);
        out.print("\"" + parameterName + "\":\"" + parameterValue + "\",");
    }
    parseTaxCode(request.getParameter("taxCode"));
    out.print("\"prefix\":\"" + prefix + "\",\"code\":\"" + code + "\",");
    processTax(request);
    out.print("\"totalTaxablePay\":\"" + totalTaxablePay + "\",\"TaxDue\":\"" + TaxDue + "\"");

    // write the begin of object
    out.print("}");
    
    //insert this payroll to db
    p=new Payroll();
    p.setCreated_on(new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
    p.setEmployerName(request.getParameter("employerName"));
    p.setPayFrequency(request.getParameter("payFrequency"));
    
    p.setPayPeriod(Integer.parseInt(request.getParameter("payPeriod")));
    p.setEmployeeName(request.getParameter("employeeName"));
    p.setTotalPayForPeriod(Float.parseFloat(request.getParameter("totalPayForPeriod")));
    p.setTaxCode(request.getParameter("taxCode"));
    p.setTotalPayToDate(Float.parseFloat(request.getParameter("totalPayToDate")));
    p.setTotalTaxablePay((float)totalTaxablePay);
    p.setTaxDue((float)TaxDue);
    
DBController controller = new DBController();
controller.insert_payroll(p);

%>



