# JMeter Auto Report Generator Plugin

Automatically generates PDF and Excel performance test reports after JMeter test execution.

## Features

- **Automatic Report Generation**: Reports are generated automatically when test completes
- **PDF Reports**: Professional PDF reports with test summary and detailed results
- **Excel Reports**: Multi-sheet Excel workbooks with comprehensive analysis
- **Real-time Metrics**: Collects metrics during test execution
- **Configurable**: Customize report name, output directory, and content

## Installation

### Build the Plugin

```bash
cd jmeter_plugin
mvn clean package
```

This creates `auto-report-plugin-1.0.0.jar` in the `target` directory.

### Install in JMeter

1. Copy the JAR file to JMeter's `lib/ext` directory:
   ```
   cp target/auto-report-plugin-1.0.0.jar $JMETER_HOME/lib/ext/
   ```

2. Restart JMeter

## Usage

### Add Backend Listener to Test Plan

1. Right-click on Test Plan → Add → Listener → Backend Listener
2. Select `com.performance.jmeter.AutoReportBackendListener` from the dropdown
3. Configure parameters:

| Parameter | Description | Default |
|-----------|-------------|---------|
| outputDirectory | Directory where reports will be saved | ${__P(user.dir)}/reports |
| reportName | Base name for report files | Performance_Test_Report |
| generatePDF | Generate PDF report (true/false) | true |
| generateExcel | Generate Excel report (true/false) | true |
| projectName | Project name for report header | BIE Performance Test |
| testEnvironment | Test environment (Dev/QA/Prod) | Production |
| testerName | Name of tester | Performance Tester |

### Example Configuration

```
outputDirectory: C:/Reports
reportName: BIE_Performance_Test
generatePDF: true
generateExcel: true
projectName: BIE Application
testEnvironment: Production
testerName: Prasanth Kumar
```

### Run Test

Execute your JMeter test normally:

```bash
jmeter -n -t test_plan.jmx -l results.jtl
```

Reports will be automatically generated in the specified output directory with timestamp:
- `BIE_Performance_Test_2025-04-10_143022.pdf`
- `BIE_Performance_Test_2025-04-10_143022.xlsx`

## Report Contents

### PDF Report

1. **Test Information**
   - Project name, environment, tester
   - Test start/end time and duration

2. **Executive Summary**
   - Total samples and errors
   - Overall error rate
   - Average response time
   - Test status (PASS/FAIL)

3. **Detailed Transaction Results**
   - Per-transaction metrics
   - Response time statistics (min, max, avg, percentiles)
   - Error rates and throughput

### Excel Report

**Sheet 1: Summary**
- Test information
- Executive summary
- Overall test status

**Sheet 2: Detailed Results**
- Complete transaction metrics
- Response time percentiles (90th, 95th, 99th)
- Throughput calculations

**Sheet 3: Transaction Analysis**
- Success rates per transaction
- Performance analysis
- Pass/Fail status per transaction

## Metrics Collected

- **Sample Count**: Total number of requests
- **Error Count**: Number of failed requests
- **Error Percentage**: Failure rate
- **Response Times**: Min, Max, Average
- **Percentiles**: 90th, 95th, 99th percentile response times
- **Throughput**: Requests per second

## Requirements

- JMeter 5.x or higher
- Java 8 or higher
- Maven 3.x (for building)

## Dependencies

- Apache JMeter Core
- Apache POI (Excel generation)
- iText (PDF generation)

## Troubleshooting

### Plugin Not Appearing in JMeter

- Ensure JAR is in `$JMETER_HOME/lib/ext/`
- Restart JMeter completely
- Check JMeter logs for errors

### Reports Not Generated

- Check JMeter console for error messages
- Verify output directory exists and is writable
- Ensure test completed successfully

### Permission Errors

- Verify write permissions on output directory
- Run JMeter with appropriate user permissions

## Advanced Usage

### Custom Report Templates

Modify `PDFReportGenerator.java` or `ExcelReportGenerator.java` to customize report layout and content.

### Integration with CI/CD

```bash
# Jenkins/GitLab CI example
jmeter -n -t test_plan.jmx -l results.jtl
# Reports automatically generated in configured directory
# Archive reports as build artifacts
```

## License

This plugin is provided as-is for performance testing purposes.

## Support

For issues or questions, refer to the source code documentation or JMeter community forums.
