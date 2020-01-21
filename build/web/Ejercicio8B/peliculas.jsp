<%-- 
    Document   : peliculas
    Created on : 21-ene-2020, 9:44:27
    Author     : Alumno_2DAW
--%>

<%@page import="modelo.Pelicula"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Bd"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<%
    int idVideoclub=Integer.parseInt(request.getParameter("idVideoclub"));
    int idCategoria=Integer.parseInt(request.getParameter("idCategoria"));
    Bd bd=new Bd();
    List<Pelicula>lista=bd.getPelicula(idVideoclub, idCategoria);
    String resultado="<categoria><tienda>";   
    for(int i=0;i<lista.size();i++){
        Pelicula pelicula=lista.get(i);
        int idPelicula=pelicula.getIdPelicula();
        String titulo=pelicula.getTitulo();
        resultado+="<codigo>"+idPelicula+"</codigo><pelicula>"+titulo+"</pelicula>";

    }
    resultado+="</tienda></categoria>";

    out.print(resultado);
%>
