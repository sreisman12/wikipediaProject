package com.viome.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IWikiDAO<Resource> {
    public List<Resource> getResources(Map<String,String> searchParams) throws SQLException;
    public Resource getResourceById(String id) throws SQLException;

}
