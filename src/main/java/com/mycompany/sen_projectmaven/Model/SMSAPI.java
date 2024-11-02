package com.mycompany.sen_projectmaven.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mckyl
 */
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.math.BigDecimal;
public class SMSAPI {
  // Find your Account Sid and Token at twilio.com/console
  public static final String ACCOUNT_SID = "ACb123b6f9ee87c0c30d1b9050e1b49525";
  public static final String AUTH_TOKEN = "[AUTH TOKEN]";//ADD THE AUTH TOKEN HERE
  public static void SendMessage(String txt,String number) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    //Default number: +18777804236
    Message message = Message.creator(
      new com.twilio.type.PhoneNumber(number),
"MG1c257122355d53f67637feea33a61398",
      txt)
    .create();
    System.out.println(message.getSid());
  }
}