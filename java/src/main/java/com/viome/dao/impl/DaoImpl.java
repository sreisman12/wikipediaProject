package com.viome.dao.impl;

import com.viome.dao.IWikiDAO;
import com.viome.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class DaoImpl implements IWikiDAO<Resource> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//
//    String url = "jdbc:mysql://localhost:3306/wiki?useSSL=false";
//    String user = "root";
//    String password = "root";
//    Connection conn = null;


//    public DaoImpl() throws SQLException {
//       conn = DriverManager.getConnection(url, user, password);
//    }

    @Override
    public List<Resource> getResources(Map<String,String> searchParams) throws SQLException {
//        StringBuilder query = new StringBuilder();
//        query.append("SELECT * FROM page WHERE ");
//        searchParams.keySet().forEach(key -> {
//            query.append(key.toString() + " = " + searchParams.get(key));
//        });
//        query.append(";");
//        System.out.println("Sending query: " + query);
//        Statement statement = conn.createStatement();
//        ResultSet results = statement.executeQuery(query.toString());
//
//        while(results.next()){
//            System.out.println("title = " + results.getString("title"));
//        }


        return null;
    }

    @Override
    public Resource getResourceById(String id) throws SQLException {

//        String query = "SELECT id, title FROM page WHERE id=" + id +";";
//        System.out.println("Sending query: " + query);
//        Statement statement = conn.createStatement();
//        ResultSet results = statement.executeQuery(query);
//
//        String title ="";
//        int pageId = 1;
//
//        while(results.next()){
//            title  = results.getString("title");
//            pageId = results.getInt("id");
//        }
//        System.out.println("Retrieved title: " + title);
//        System.out.println("Retrieved id: " + pageId);
        SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
        String title = namedParameterJdbcTemplate.queryForObject("SELECT title FROM page WHERE id = :id", params, String.class);

        System.out.println("Got title: " + title);
        return new Resource<>(Integer.parseInt(id), title);
    }
}
