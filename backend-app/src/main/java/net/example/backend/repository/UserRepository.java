package net.example.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.example.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
