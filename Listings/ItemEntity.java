@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "Catalog")
@Immutable
public class ItemEntity {

    @Id
    @Column(name = "ItemID")
    private UUID id;

    private String name;
    private String path;
    private Integer type;

    @OneToMany(mappedBy = "itemEntity", cascade = CascadeType.MERGE)
    private Set<ExecutionLogEntity> executionLogEntities = new HashSet<>();

    @OneToMany(mappedBy = "itemEntity", cascade = CascadeType.MERGE)
    private Set<DataSourceEntity> dataSourceEntities = new HashSet<>();

    public ItemEntity() {
    }

    public ItemEntity(UUID id, String name, String path, Integer type) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.type = type;
    }

    public void addExecutionLogEntity(ExecutionLogEntity executionLogEntity) {
        this.executionLogEntities.add(executionLogEntity);
        executionLogEntity.setItemEntity(this);
    }

    public void addDataSourceEntity(DataSourceEntity dataSourceEntity) {
        this.dataSourceEntities.add(dataSourceEntity);
        dataSourceEntity.setItemEntity(this);
    }
}