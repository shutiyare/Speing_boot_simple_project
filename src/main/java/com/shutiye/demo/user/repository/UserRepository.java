package com.shutiye.demo.user.repository;

import com.shutiye.demo.user.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User,Long>{
    Optional<User> findByUsername(String username);
}
