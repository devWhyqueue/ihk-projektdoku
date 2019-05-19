@Getter
@Setter
@EqualsAndHashCode
public class Report {

    private String name;
    private String path;

    public Report(String name, String path) {
        this.name = name;
        this.path = path;
    }
}