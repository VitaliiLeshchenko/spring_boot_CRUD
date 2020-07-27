package vitalii.leshchenko.spring_boot_CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitalii.leshchenko.spring_boot_CRUD.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
