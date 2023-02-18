package com.webtelemedapp.webtelemedapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTmRepository extends CrudRepository<UserTm,Long> {
   List <UserTm> findByType(int type);

    UserTm findByEmailAndLozinka(String email, String lozinka);




}