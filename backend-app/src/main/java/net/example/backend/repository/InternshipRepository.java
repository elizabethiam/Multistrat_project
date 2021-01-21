package net.example.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.example.backend.model.Internship;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Long> {

}
