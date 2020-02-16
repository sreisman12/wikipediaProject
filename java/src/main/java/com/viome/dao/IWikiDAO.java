package com.viome.dao;

import org.omg.CORBA.NameValuePair;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface IWikiDAO<Resource> {
    public List<Resource> getResources(List<NameValuePair> searchParams);
    public Resource getResourceById(String id) throws SQLException;

}
