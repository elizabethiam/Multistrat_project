package net.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.example.backend.model.Angajat;

@Repository
public interface AngajatRepository extends JpaRepository<Angajat, Long>{

}
