package com.coremedia.coredining.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import com.coremedia.springframework.beans.RequiredPropertyNotSetException;

/*
 * Copyright (c) 2013 CoreMedia AG, Hamburg. All rights reserved.
 */

public class JdbcArticleDAO implements ArticleDAO, InitializingBean {
    private final static Log log = LogFactory.getLog(JdbcArticleDAO.class);

    private transient Connection connection = null;

    private String url;
    private String driver;
    private String login;
    private String password;
    

    public Map<String, String> get(String identifier) {
        
        Map<String, String> article = new HashMap<String, String>();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = getConnection().prepareStatement(
                    "select * from externalrecipes where id = ?");
            stmt.setInt(1, Integer.parseInt(identifier));
            rs = stmt.executeQuery();
            if (rs.next()) {
                String title = rs.getString(2);
                String keywords = rs.getString(3);
                String text = rs.getString(4);
                int modTime = rs.getInt(5);

                article.put("title", title);
                article.put("keywords", keywords);
                article.put("text", text);
                article.put("modtime", String.valueOf(modTime));
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    try {
                        if (rs != null) {
                            stmt.close();
                        }
                    } catch (SQLException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }
        return article;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                DriverManager.registerDriver((java.sql.Driver) Class.forName(
                        getDriver()).newInstance());
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(getUrl(), getLogin(), getPassword());
        }
        return connection;
    }

    public void afterPropertiesSet() throws Exception {
        RequiredPropertyNotSetException.ifNull("url", getUrl());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    public void setLogin(String login) {
	  this.login = login;
	}

    public String getLogin() {
	  return login;
	}
    
    public void setPassword(String password) {
	  this.password = password;
	}
    
    public String getPassword() {
	  return password;
	}
}

