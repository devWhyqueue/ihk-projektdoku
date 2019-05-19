@Override
public Page<ExecutedReport> getMostUsedReports(Pageable pageable) {
    Page<ItemEntity> itemEntities = reportStatisticsService
            .getMostExecutedReportsIn
                (StatisticConstants.UNUSED_DEFINITION, pageable);

    return itemEntities
            .map(dataEntityToBusinessObjectMapper::convertToReport)
            .map(ExecutedReport.class::cast);
}