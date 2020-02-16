package com.viome.dao;

import com.viome.model.Resource;
import com.viome.model.WikiPage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WikiPageRowMapper implements RowMapper<Resource> {
    @Override
    public WikiPage mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        WikiPage wikiPage = new WikiPage();

        wikiPage.setId(resultSet.getInt("id"));
        wikiPage.setTitle(resultSet.getString("title"));
        wikiPage.setLanguage(resultSet.getString("language"));
        wikiPage.setContent(resultSet.getString("body"));

        return wikiPage;
    }
}
