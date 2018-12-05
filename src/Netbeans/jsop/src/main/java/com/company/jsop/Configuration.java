/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop;

/**
 *
 * @author jakob
 */
public class Configuration {
    private String uri = "bolt://localhost:7687";
    private String user = "neo4j";
    private String password = "root";

    public String getUri() {
        return uri;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
