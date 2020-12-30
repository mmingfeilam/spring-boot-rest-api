package me.lam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.lam.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
