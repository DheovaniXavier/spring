package br.univille.coredacs2022.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.coredacs2022.entity.HealthPlan;

@Repository
public interface HealthPlanRepository extends JpaRepository<HealthPlan, Long> {

    List<HealthPlan> findByNameIgnoreCaseContaining(@Param("name") String name);

}
