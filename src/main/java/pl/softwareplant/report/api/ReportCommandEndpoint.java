package pl.softwareplant.report.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.softwareplant.report.api.dto.ReportCriteriaDto;

@RequestMapping(value = "/report")
public interface ReportCommandEndpoint {

    @PutMapping
    void generateReport(@RequestBody ReportCriteriaDto reportCriteriaDto);

    @DeleteMapping
    void deleteReport();
}
