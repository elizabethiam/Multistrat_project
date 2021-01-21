package net.example.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.example.backend.model.Intern;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {

}
