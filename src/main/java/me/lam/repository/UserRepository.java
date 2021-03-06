package me.lam.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.lam.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
	@Query("SELECT u FROM User u WHERE u.status = 1")
	Collection<User> findAllActiveUsers();

	@Query(value = "SELECT * FROM Users u WHERE u.status = 1", nativeQuery = true)
	Collection<User> findAllActiveUsersNative();

	@Query(value = "SELECT u FROM User u")
	List<User> findAllUsers(Sort sort);

	// @Query(value = "SELECT u FROM User u ORDER BY id")
	// Page<User> findAllUsersWithPagination(Pageable pageable);
	//
	// @Query(value = "SELECT * FROM Users ORDER BY id", countQuery = "SELECT
	// count(*) FROM Users", nativeQuery = true)
	// Page<User> findAllUsersWithPaginationNative(Pageable pageable);

	@Query("SELECT u FROM User u WHERE u.status = ?1")
	User findUserByStatus(Integer status);
	
	@Query("SELECT u FROM User u WHERE u.id = ?1")
	User findUserById(Long id);

	@Query("SELECT u FROM User u WHERE u.status = ?1 and u.firstName = ?2")
	User findUserByStatusAndName(Integer status, String name);

	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	User findUserByUserName(String userName);

	@Query(value = "SELECT * FROM Users u WHERE u.status = ?1", nativeQuery = true)
	User findUserByStatusNative(Integer status);

	@Query("SELECT u FROM User u WHERE u.status = :status and u.firstName = :firstname")
	User findUserByStatusAndNameNamedParams(@Param("status") Integer status, @Param("firstname") String name);

	@Query("SELECT u FROM User u WHERE u.status = :status and u.firstName = :name")
	User findUserByUserStatusAndUserName(@Param("status") Integer userStatus, @Param("name") String userName);

	@Query(value = "SELECT * FROM Users u WHERE u.status = :status AND u.firstName =:name", nativeQuery = true)
	User findUserByStatusAndNameNamedParamsNative(@Param("status") Integer status, @Param("name") String name);

	@Query(value = "SELECT u FROM User u WHERE u.firstName IN :names")
	List<User> findUserByNameList(@Param("names") Collection<String> names);

	@Modifying
	@Query("update User u set u.status = :status where u.firstName = :name")
	int updateUserSetStatusForName(@Param("status") Integer status, @Param("name") String name);

	@Modifying
	@Query(value = "UPDATE Users u SET u.status = ? WHERE u.firstName = ?", nativeQuery = true)
	int updateUserSetStatusForNameNative(Integer status, String name);

	@Query(value = "INSERT INTO Users (name, age, email, status, active) VALUES(:name,:age,:email,:status,:active)", nativeQuery = true)
	@Modifying
	void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("email") String email,
			@Param("status") Integer status, @Param("active") boolean active);
}
