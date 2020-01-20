<%-- 
    Document   : categorias
    Created on : 20-ene-2020, 9:41:16
    Author     : Alumno_2DAW
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Categoria"%>
<%@page import="modelo.Bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Bd bd=new Bd();
    List<Categoria>listaCategoria=bd.getListaCategoria();
    String resultado="[";
    for(int i=0;i<listaCategoria.size();i++){
        Categoria cate=listaCategoria.get(i);
        int idCategoria=cate.getIdCategoria();
        String categoria=cate.getCategoria();
        resultado+="{codigoCategoria:"+idCategoria+",nombreCategoria:"+categoria+"}";
        if(i!=listaCategoria.size()-1){
            resultado+=",";
        }
    }
    resultado+="]";

    out.print(resultado);
%>
