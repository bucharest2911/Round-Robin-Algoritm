/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobinweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author carlo
 */
public class Conexion {
     
/**
 *
 * @author carlo
 */

    private String consulta;
    private String url;
    private String password;
    private String usuario;
    private String driver;
    private Connection dato;
    private PreparedStatement valor;
    private ResultSet r;
    public Conexion(){
        consulta="";
        driver="";
        url="";
        password="";
        usuario="";
        dato=dato;
        valor=valor;
        r=r;
    }

    public PreparedStatement getValor() {
        return valor;
    }

    public void setValor(PreparedStatement valor) {
        this.valor = valor;
    }

    public ResultSet getR() {
        return r;
    }

    public void setR(ResultSet r) {
        this.r = r;
    }

    public Connection getDato() {
        return dato;
    }

    public void setDato(Connection dato) {
        this.dato = dato;
    }
    
    

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    
    public void setConsulta(String dato){
        consulta=dato;
    }
    public String getConsulta(){
        return consulta;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

}
