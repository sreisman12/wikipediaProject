package com.viome.dao.impl;

import com.viome.dao.IWikiDAO;
import com.viome.model.Resource;
import org.omg.CORBA.NameValuePair;

import java.sql.*;
import java.util.List;

public class DaoImpl implements IWikiDAO<Resource> {

    String url = "jdbc:mysql://localhost:3306/wiki?useSSL=false";
    String user = "root";
    String password = "root";
    Connection conn = null;




    public DaoImpl() throws SQLException {
       conn = DriverManager.getConnection(url, user, password);
    }

    @Override
    public List<Resource> getResources(List<NameValuePair> searchParams) {
        return null;
    }

    @Override
    public Resource getResourceById(String id) throws SQLException {

        String query = "SELECT FROM page WHERE id=" + id;
        Statement statement = conn.createStatement();
        ResultSet results = statement.executeQuery(query);
        System.out.println("Retrieved results: " + results);
        return null;
    }
}