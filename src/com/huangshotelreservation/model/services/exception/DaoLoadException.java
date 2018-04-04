/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huangshotelreservation.model.services.exception;

/**
 *
 * @author JayHu
 */
 public class DaoLoadException extends Exception {
     
     
    public DaoLoadException(final String inMessage,final 
                Throwable inNestedException){
        super(inMessage,inNestedException);
    }
    
}
