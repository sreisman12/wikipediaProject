package com.viome.dao.impl;

import com.viome.dao.IWikiDAO;
import com.viome.model.Resource;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;
import java.util.Map;

@Service
public class DaoImpl implements IWikiDAO<Resource> {

    String url = "jdbc:mysql://localhost:3306/wiki?useSSL=false";
    String user = "root";
    String password = "root";
    Connection conn = null;




    public DaoImpl() throws SQLException {
       //conn = DriverManager.getConnection(url, user, password);
    }

    @Override
    public List<Resource> getResources(Map<String,String> searchParams) {
        return null;
    }

    @Override
    public Resource getResourceById(String id) throws SQLException {

        String query = "SELECT id, title FROM page WHERE id=" + id +";";
        System.out.println("Sending query: " + query);
        Statement statement = conn.createStatement();
        ResultSet results = statement.executeQuery(query);
        System.out.println("Retrieved results: " + results);
        return null;
    }
}
