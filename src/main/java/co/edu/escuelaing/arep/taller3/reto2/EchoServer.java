/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.taller3.reto2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Juan.Ortiz
 */
public interface EchoServer extends Remote{
    public String echo(String cadena) throws RemoteException;
    
}