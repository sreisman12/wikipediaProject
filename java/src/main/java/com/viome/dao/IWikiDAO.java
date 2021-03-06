package com.viome.dao;

import com.viome.model.WikiPage;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IWikiDAO {
    List<WikiPage> getResources(Map<String, String> searchParams) throws SQLException;
    WikiPage getResourceById(String id) throws SQLException;

}
