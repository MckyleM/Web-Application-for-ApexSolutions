/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Presenter;
import com.mycompany.sen_projectmaven.Model.Client;
import com.mycompany.sen_projectmaven.Model.Contract_Manager;
import com.mycompany.sen_projectmaven.View.Voice;

/**
 *
 * @author mckyl
 */
public class Service {
    public int requestID;
    //private String username;
    public int clientID;
    private String clientname;
    public String issue;
    public String contracts;
    //public String contractStartDates;
    //public String contractEndDates;
    String query;
    public Service(){};
    public Service(Client client, int ContractID, Contract_Manager contract)
    {
    client = client.getClient(clientID);
    clientID = client.getClientID();
    clientname = client.getClientName();
    contracts = contract.getContractString(clientID);
    //contractStartDates = contract.;
    //contractEndDates = ContractEndDates;
    //username = Username;
    }
    public int getRequestID(){
        
        return requestID;
    } 
    //Used to get problem from user on website
    public String getClientContracts(){
        return contracts;
    }
    public void getIssue(String prob)
    {
        issue=prob;
    }
    public void makeCall()
    throws InterruptedException
    {

        String mynumber = "0636960174"; // replace with your own

        Voice voicent = new Voice();
        String reqId = voicent.callText(mynumber,
                    "message from "+ clientname, true);
        System.out.println("callText: " + reqId);
              

        reqId = voicent.callAudio(mynumber,
                    "C:/Users/mckyl/OneDrive/Documents/Belgium/Modules/SEN/Web-Application-for-ApexSolutions/StarWars3.wav",
                    false);
        System.out.println("callAudio: " + reqId);

        while (true) {
            Thread.currentThread().sleep(30000);
            String status = voicent.callStatus(reqId);
            if (status.length() > 0) {
                System.out.println(status);
                voicent.callRemove(reqId);
                break;
            }
        }

        voicent.callText(issue, reqId, true);
        System.out.println("Your call was forwarded and we are aware of the issue");
    }
    
}
