package com.trisor.user.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trisor.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
