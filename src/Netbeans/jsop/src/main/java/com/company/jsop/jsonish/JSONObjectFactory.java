/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

/**
 *
 * @author jakob
 */
public interface JSONObjectFactory {
    Object newMap();
    Object newString(String str);
    Object newNumber(double d);
    Object newArray();
    Object newFunction(String type, String src, String[] parameterNames);
}
