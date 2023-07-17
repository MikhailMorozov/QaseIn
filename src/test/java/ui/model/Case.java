package ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Case {
    private String title;
    private String status;
    private String suite;
    private String severity;
    private String priority;
    private String type;
    private String layer;
    private String isFlaky;
    private String behavior;
    private String automationStatus;

}
