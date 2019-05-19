public Page<ItemEntity> findMostExecutedReportsInRecent
                            (Period period, Pageable pageable) {
    List<ItemEntity> mostExecutedReports = queryFactory
            .selectFrom(itemEntity)
            .innerJoin(itemEntity.executionLogEntities, executionLogEntity)
            .where(isReport().and(executedInTheLast(period)))
            .groupBy(itemEntity.id, itemEntity.name, 
                     itemEntity.type, itemEntity.path)
            .orderBy(itemEntity.count().desc()).fetch();

    return DataUtils.generateItemEntityPageFromItemEntityList
                        (mostExecutedReports, pageable);
}
