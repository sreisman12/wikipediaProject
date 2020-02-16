package com.viome.dao;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public interface IWikiDAO<Resource> {
    public List<Resource> getResources(Map<String,String> searchParams);
    public Resource getResourceById(String id) throws SQLException;

}
