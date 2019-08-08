package com.example.demo.Controller;

import com.example.demo.Service.EmailService;
import com.example.demo.Service.SMSService;
import com.example.demo.Service.TemporaryUserService;
import com.example.demo.Entity.TemporaryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Random;

@RestController
@RequestMapping("temporary user")
public class TwoFactorServiceController {

    @Autowired
    TemporaryUserService temporaryUserService;

    @Autowired
    EmailService emailService;

    @Autowired
    SMSService smsService;

    @PostMapping("/email")
    public TemporaryUsers sendEmail(@RequestBody TemporaryUsers u) throws MessagingException {
       String twoFACODE=String.valueOf(new Random().nextInt(9999)+1000);
       TemporaryUsers u1= temporaryUserService.save(u);
        emailService.sendEmail(u1.getEmail(),twoFACODE);
        temporaryUserService.update2FA(u1.getUser_id(),twoFACODE);
        return u1;
    }

    @PostMapping("/mobile")
    public TemporaryUsers sendMobile(@RequestBody TemporaryUsers u){
        String twoFACODE=String.valueOf(new Random().nextInt(9999)+1000);
        TemporaryUsers u1= temporaryUserService.save(u);
        smsService.sendMobile(u1.getMobile_number(),twoFACODE);
        temporaryUserService.update2FA(u1.getUser_id(),twoFACODE);

        return u1;
    }

    @PostMapping("{user_id}/codes/{t2facode}")
    public ResponseEntity<Object> verify(@PathVariable("user_id") Integer id, @PathVariable("t2facode") Integer t2facode){
        TemporaryUsers u= temporaryUserService.findById(id);
        Long s=(System.currentTimeMillis()/1000);
       // boolean isValid=daoService.checkCode(id,t2facode);
        temporaryUserService.delete();
        if(Integer.parseInt(u.getCode())==t2facode && s<=u.getExpire_time())
        return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);


    }

    @PostMapping
    public TemporaryUsers save(@RequestBody TemporaryUsers u){
        temporaryUserService.save(u);
        return u;
    }

}
