package com.viome.dao.impl;

import com.viome.dao.IWikiDAO;
import com.viome.dao.WikiPageRowMapper;
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
public class DaoImpl implements IWikiDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<WikiPage> getResources(Map<String,String> searchParams) throws SQLException {

        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM page WHERE ");
        boolean shouldReverse = false;

        /**
         * Constructing 'LIKE' search based on parameters passed in request
         * By default this function will return all matching resources
         */
        List<String> params = new ArrayList<>();
        System.out.println("searchParams contains key reverse: " + searchParams.containsKey("reverse"));
        if(searchParams.containsKey("reverse")){
            shouldReverse = Boolean.getBoolean(searchParams.get("reverse"));
        }

        searchParams.keySet().forEach(key -> {
            if(!key.equalsIgnoreCase("reverse")){
                params.add(key + " LIKE '%" + searchParams.get(key) + "%'");
            }
        });

        Iterator<String> iter = params.iterator();
        while(iter.hasNext()){
            query.append(iter.next());
            if(iter.hasNext()){
                query.append(" AND ");
            }
        }
        query.append(";");
        List<WikiPage> searchResults = jdbcTemplate.query(query.toString(), new WikiPageRowMapper());
        if(shouldReverse){
            searchResults.forEach(wikiPage -> {
                wikiPage.setContent(reverse(wikiPage.getContent()));
            });
        }

        return searchResults;
    }

    @Override
    public WikiPage getResourceById(String id) throws SQLException {
        String query = "SELECT * FROM page WHERE ID = ?";
        WikiPage wikiPage = jdbcTemplate.queryForObject(query, new Object[] {id}, new WikiPageRowMapper());

        System.out.println("Retrieved wikiPage: " + wikiPage.toString());
        return wikiPage;
    }

    private String reverse(String content){
        StringBuilder builder = new StringBuilder(content);
        System.out.println("Reversing string: " + content);
        String reversed = builder.reverse().toString();
        System.out.println("Reversed stiring: " + reversed);
        return reversed;
    }
}
