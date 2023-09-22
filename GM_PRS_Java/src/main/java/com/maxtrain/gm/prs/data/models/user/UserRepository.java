package com.maxtrain.gm.prs.data.models.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
	Optional<User> findUserByUsernameAndPassword(String Username, String Password);
}
