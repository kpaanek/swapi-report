package pl.softwareplant.report.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.softwareplant.report.domain.ReportCriteriaRepository;
import pl.softwareplant.report.domain.model.ReportCriteria;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportCommandService {

    private final ReportCriteriaRepository reportCriteriaRepository;

    void generateReport(ReportCriteria reportCriteria) {
        reportCriteriaRepository.deleteAll();
        reportCriteriaRepository.save(reportCriteria);
    }

    void deleteReport() {
        reportCriteriaRepository.deleteAll();
    }
}
