<%-- 
    Document   : videoclub
    Created on : 21-ene-2020, 8:29:49
    Author     : Alumno_2DAW
--%>

<%@page import="modelo.Videoclub"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Bd"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<%
    int categoria=Integer.parseInt(request.getParameter("categoria"));
    Bd bd=new Bd();
    List<Videoclub>lista=bd.getVideoclub(categoria);
    String resultado="<tiendas>";
      
    for(int i=0;i<lista.size();i++){
        Videoclub videoclub=lista.get(i);
        int idVideoclub=videoclub.getIdVideclub();
        String nombre=videoclub.getNombre();
        resultado+="<tienda><codigo>"+idVideoclub+"</codigo><nombre>"+nombre+"</nombre></tienda>";

    }
    resultado+="</tiendas>";

    out.print(resultado);
%>
