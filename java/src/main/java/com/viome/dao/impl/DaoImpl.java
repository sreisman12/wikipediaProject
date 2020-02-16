package com.viome.dao.impl;

import com.viome.dao.IWikiDAO;
import com.viome.dao.WikiPageRowMapper;
import com.viome.model.Resource;
import com.viome.model.WikiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class DaoImpl implements IWikiDAO<Resource> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Resource> getResources(Map<String,String> searchParams) throws SQLException {

        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM page WHERE ");

        List<String> params = new ArrayList<>();

        searchParams.keySet().forEach(key -> {
            params.add(key + " LIKE '%" + searchParams.get(key) + "%'");
        });

        Iterator<String> iter = params.iterator();
        while(iter.hasNext()){
            query.append(iter.next());
            if(iter.hasNext()){
                query.append(" AND ");
            }
        }

        query.append(";");

        List<Resource> searchResults = jdbcTemplate.query(query.toString(), new WikiPageRowMapper());

        System.out.println("Retrieved: " + searchResults);
        return searchResults;
    }

    @Override
    public Resource getResourceById(String id) throws SQLException {
        String query = "SELECT * FROM page WHERE ID = ?";
        Resource wikiPage = jdbcTemplate.queryForObject(query, new Object[] {id}, new WikiPageRowMapper());

        System.out.println("Retrieved wikiPage: " + wikiPage.toString());
        return wikiPage;
    }
}
