package br.univille.coredacs2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.coredacs2022.entity.HealthPlan;

@Repository
public interface HealthPlanRepository extends JpaRepository<HealthPlan, Long> {}
