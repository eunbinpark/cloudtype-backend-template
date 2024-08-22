package io.cloudtype.waitlist.repository;

import io.cloudtype.waitlist.dto.DrugDto;
import io.cloudtype.waitlist.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {
    @Query(value = "SELECT i.ingredient_eng AS ingredient, d.tkiddi_kor AS ddi, i.ingredient_efficacy AS efficacy " +
            "FROM Connect c " +
            "JOIN Drug_Drug_Interaction d ON c.tkiddi_id = d.tkiddi_id " +
            "JOIN TKI t ON c.tki_id = t.tki_id " +
            "JOIN Ingredient i ON c.ingredient_id = i.ingredient_id " +
            "JOIN Brandname b ON i.ingredient_id = b.ingredient_id " +
            "WHERE t.tki_eng = :tki " +
            "AND b.brandname = :drug", nativeQuery = true)
    DrugDto searchDrug(@Param("tki") String tki, @Param("drug") String drug);
}
