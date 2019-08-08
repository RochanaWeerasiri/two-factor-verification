package com.example.demo.Service;

import com.example.demo.Exception.TemporaryUserNotFoundException;
import com.example.demo.Repository.TemporaryUserRepository;
import com.example.demo.Entity.TemporaryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TemporaryUserService {

    @Autowired
    TemporaryUserRepository temporaryUserRepository;

    @Transactional
    public void update2FA(Integer userid,String twofacode){
        Long s=(System.currentTimeMillis()/1000+120);
        temporaryUserRepository.update2FA(userid,twofacode,s);
    }

   /* public boolean checkCode(Integer id, Integer t2facode) {
        int dbCode=daoRepository.verify(id);
        if(dbCode==t2facode){
            return true;
        }
        else
        return false;

    }*/

    public TemporaryUsers save(TemporaryUsers u){
        temporaryUserRepository.save(u);
        return u;
    }

    public TemporaryUsers findById(Integer farmer_id){
        return temporaryUserRepository.findById(farmer_id).orElseThrow(()-> new TemporaryUserNotFoundException());
    }

    public void delete(){
        temporaryUserRepository.deleteAll();
    }

}
