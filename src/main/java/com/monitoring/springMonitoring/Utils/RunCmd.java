package com.monitoring.springMonitoring.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunCmd {

    /**
     * Print complete IP address info using the command ipconfig /all
     */
    public void printIPInfo() {
        Runtime rt = Runtime.getRuntime();
        String[] commandAndArguments = {"ipconfig","/all"};
        try {
            Process p = rt.exec(commandAndArguments);
            String response = readProcessOutput(p);
            System.out.println(response);


        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads the response from the command. Please note that this works only
     * if the process returns immediately.
     * @param p
     * @return
     * @throws Exception
     */
    public String readProcessOutput(Process p) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String response = "";
        String line;
        while ((line = reader.readLine()) != null) {

            System.out.println("line :"+line);
            response += line+"\r\n";
        }
        reader.close();
        return response;
    }


}
