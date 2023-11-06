package com.pavanati.portfolio.domain.repository;

import com.pavanati.portfolio.domain.enums.ProjetoStatus;
import com.pavanati.portfolio.domain.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    @Query("select count(*) > 0 from Projeto p where p.id = :id and p.status not in (:status)")
    public Boolean existsByIdAndStatus(@Param("id") Long id, @Param("status") ProjetoStatus ...status);

}
