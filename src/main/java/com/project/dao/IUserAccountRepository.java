package com.project.dao;

import com.project.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface IUserAccountRepository extends CrudRepository<UserAccount, Long> {

    public UserAccount findUserAccountByUserName(String login);
}
