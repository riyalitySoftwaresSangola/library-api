package com.library.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.Entity.UserEntity;
import com.library.model.UserResponceDto;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
	
	
	@Query("SELECT new com.library.model.UserResponceDto(u.username, u.role) FROM UserEntity u WHERE u.username = :username AND u.passwoard = :passwoard")
	java.util.Optional<UserResponceDto> findRoleByUsernameAndPassword(@Param("username") String username, @Param("passwoard") String password);



	UserResponceDto findByUsername(String username);

	 boolean existsByUsername(String username);
	    boolean existsByRole(String role);

	

	
	

	

}
