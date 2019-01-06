package pl.softwareplant.report.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "reportCriteria.withReport", attributeNodes = @NamedAttributeNode("report"))
@Entity
public class ReportCriteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "report_criteria_id")
    private long reportCriteriaId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns(value = {
            @JoinColumn(name = "character_id", referencedColumnName = "character_id"),
            @JoinColumn(name = "planet_id", referencedColumnName = "planet_id"),
            @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
    })
    private Report report;
    @Column(name = "character_phrase")
    private String characterPhrase;
    @Column(name = "planet_name")
    private String planetName;
}
