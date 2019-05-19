@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemEntityRepositoryFindTest {

    @Autowired
    private ItemEntityRepository itemEntityRepository;

    // Andere Test-Methoden ausgelassen

    @Test
    public void testFindMostExecutedReportsInLastDayShouldReturnOneItemEntity() {
        ExecutionLogEntity executionLogEntity = ExecutionLogEntity.builder()
                .timeStart(LocalDateTime.now().minusMinutes(2))
                .timeEnd(LocalDateTime.now().minusMinutes(1)).build();
        ItemEntity itemEntity = new ItemEntity
                (UUID.randomUUID(), "Report1", "/Reports/Test/Report1", 2);
        itemEntity.addExecutionLogEntity(executionLogEntity);
        itemEntityRepository.save(itemEntity);

        Page<ItemEntity> mostExecutedReports = itemEntityRepository
                .findMostExecutedReportsInRecent
                        (Period.ofDays(1), PageRequest.of(0, 5));

        assertEquals(1, mostExecutedReports.getTotalElements());
    }
}