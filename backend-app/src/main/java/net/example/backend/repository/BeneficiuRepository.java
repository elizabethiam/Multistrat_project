package net.example.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.example.backend.model.Beneficiu;

@Repository
public interface BeneficiuRepository extends JpaRepository<Beneficiu, Long> {

}
