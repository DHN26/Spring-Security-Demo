package io.vcti.springSecurityJpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.vcti.springSecurityJpa.entity.User1;

@Repository
public interface UserRepo extends JpaRepository<User1, Integer>{

	User1 findByUserName(String userName);

}
