@Getter
@Setter
@EqualsAndHashCode
public class ExecutedReportDTO {

    private String name;
    private String path;
    private String lastExecutedOn;
    private String lastExecutedBy;
    private String lastStatus;
    private Integer sizeInBytes;
    private Long avgExecutionSeconds;
    private Long avgExecutionMinutes;
    private Long notUsedSinceDays;
    private Long numOfExecutionsInPeriod;

    @Builder
    private ExecutedReportDTO(String name, String path,
                           String lastExecutedOn, String lastExecutedBy,
                           String lastStatus, Integer sizeInBytes,
                           Long avgExecutionSeconds, Long avgExecutionMinutes,
                           Long notUsedSinceDays, Long numOfExecutionsInPeriod) {
        this.name = name;
        this.path = path;
        this.lastExecutedOn = lastExecutedOn;
        this.lastExecutedBy = lastExecutedBy;
        this.lastStatus = lastStatus;
        this.sizeInBytes = sizeInBytes;
        this.avgExecutionSeconds = avgExecutionSeconds;
        this.avgExecutionMinutes = avgExecutionMinutes;
        this.notUsedSinceDays = notUsedSinceDays;
        this.numOfExecutionsInPeriod = numOfExecutionsInPeriod;
    }
}