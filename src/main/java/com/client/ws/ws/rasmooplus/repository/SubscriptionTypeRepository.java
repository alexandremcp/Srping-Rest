package com.client.ws.ws.rasmooplus.repository;

import com.client.ws.ws.rasmooplus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
