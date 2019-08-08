package com.example.demo.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

    private static final String ACCOUNT_SID="ACbe5df643f80e1cf85b3b07aedb45615c";
    private static final String AUTH_ID="4d2f213d2e408e61a3483dd915227e24";

    static {
        Twilio.init(ACCOUNT_SID,AUTH_ID);
    }

    public boolean sendMobile(String mobile_id,String twoFACode){
       Message.creator(new PhoneNumber(mobile_id), new PhoneNumber("+12249359506"),"Your Two Factor Authentication is "+twoFACode).create();
        return true;
    }
}
