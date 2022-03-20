package com.jpa.test.repos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, UUID>{
	/*
	No code needs to be written over here for simple CRUD operations.
	CrudRepository will handle all CRUD operations for User type on its own.
	userRepo.save(<Entity>) -> For creating the record
	userRepo.saveAll(Iterable<Entity>) -> For creating multiple records
	userRepo.findAll()      -> For selecting all records
	userRepo.findById(<Id>) -> For findingById
	userRepo.delete(<Entity>) -> For deleting the record
	userRepo.deleteById(<Id>) -> For deleting the record by Id
	
	
	if you want to write derived/custom queries then you just need to declare
	the custom function for the query and Spring boot will automatically provide
	implementation of that.
	For example:
	- If you want to select data on basis of name, then you can declare a method
	  public User findByName(String name){}
	- For more such method conventions: 
	  https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	
	If you want to write queries then you can write them using @Query annotation
	
	*/
	@Query(value="select * from user WHERE id = ?1", nativeQuery=true)
	public Optional<User> findById(UUID id);
	
//	public Optional<User> findById(UUID id);
	public List<User> findByName(String name);
	
}
