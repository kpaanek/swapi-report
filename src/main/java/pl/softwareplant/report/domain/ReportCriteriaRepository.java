package pl.softwareplant.report.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.softwareplant.report.domain.model.ReportCriteria;

@Repository
public interface ReportCriteriaRepository extends JpaRepository<ReportCriteria, Long> {

    @EntityGraph("reportCriteria.withReport")
    ReportCriteria findFirstBy();
}
