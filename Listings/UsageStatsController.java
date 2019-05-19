@Controller
@RequestMapping("/usage-stats")
public class UsageStatsController {

    private UsageStatisticsService usageStatisticsService;

    @Autowired
    public UsageStatsController(UsageStatisticsService usageStatisticsService) {
        this.usageStatisticsService = usageStatisticsService;
    }

    // Andere Controller-Methoden ausgelassen

    @GetMapping("/most-used-reports-table-fragment")
    public String mostUsedTableFragment(Pageable pageable, Model model) {
        Page<ExecutedReport> mostUsedReports = usageStatisticsService
            .getMostUsedReports(pageable);

        model.addAttribute("mostUsedReports", mostUsedReports);

        return "fragments/tables/most_used_reports_pageable_table";
    }
}