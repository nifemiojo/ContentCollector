package com.project.services;

import com.project.dao.IUserAccountRepository;
import com.project.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    IUserAccountRepository userAccountRepository;

    public UserAccount save(UserAccount user) {
        return  userAccountRepository.save(user);
    }

    public UserAccount findUserAccountByUserName(String login){
        return userAccountRepository.findUserAccountByUserName(login);
    }
}
