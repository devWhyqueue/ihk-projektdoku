@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ExecutedReport extends Report {

	private LocalDateTime lastExecutedOn;
	private String lastExecutedBy;
	private String lastStatus;
	private Integer sizeInBytes;
	private Duration avgExecutionTime;
	// period depends on UNUSED_DEFINITION
	private Long numOfExecutionsInPeriod;

	@Builder
	private ExecutedReport(
				String name, String path,
				LocalDateTime lastExecutedOn,
				String lastExecutedBy,
				String lastStatus, Integer sizeInBytes,
				Duration avgExecutionTime,
				Long numOfExecutionsInPeriod) {
		super(name, path);
		this.lastExecutedOn = lastExecutedOn;
		this.lastExecutedBy = lastExecutedBy;
		this.lastStatus = lastStatus;
		this.sizeInBytes = sizeInBytes;
		this.avgExecutionTime = avgExecutionTime;
		this.numOfExecutionsInPeriod = numOfExecutionsInPeriod;
	}

	public Long getNotUsedSinceDays() {
		return ChronoUnit.DAYS
				.between(lastExecutedOn, LocalDateTime.now());
	}
}