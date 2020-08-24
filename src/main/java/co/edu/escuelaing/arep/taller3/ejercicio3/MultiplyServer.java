/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.taller3.ejercicio3;

import java.net.*;
import java.io.*;
/**
 *
 * @author Juan.Ortiz
 */
public class MultiplyServer {

    public static void main(String[] args) throws IOException {
        
        SocketConnection sC = new SocketConnection();
        
        ServerSocket serverSocket = sC.getServerSocket();
        Socket clientSocket = sC.getClientSocket();


        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;
        Float outputLine;
        boolean isFinished=true;    
        while(isFinished){
            try{
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(
                    "Número Introducido:  " + inputLine
                    );
                    if (inputLine.equals("bye")) {
                        isFinished=false;
                        break;
                    }
                    DataProcessor dP = new DataProcessor();
                    Float ans =  dP.square(Float.parseFloat(inputLine));
                    outputLine = ans;
                    out.println(outputLine);

                    
                }
            }catch(Exception e){
                   //isFinished=false;
            }
        }
            out.close();

            in.close();
            clientSocket.close();

            serverSocket.close();
            
        
    }

}