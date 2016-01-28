<%@ page import="util.SqrtResolver" %>
<%
    String s = request.getParameter("number");
    double result = SqrtResolver.evaluate(Double.parseDouble(s));
%>
<%=result%>