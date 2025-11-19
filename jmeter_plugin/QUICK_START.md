# Quick Start Guide - JMeter Auto Report Plugin

Get up and running in 5 minutes!

## Step 1: Build the Plugin (2 minutes)

```bash
cd jmeter_plugin
mvn clean package
```

**Expected Output**: `BUILD SUCCESS` and `target/auto-report-plugin-1.0.0.jar` created

## Step 2: Install in JMeter (1 minute)

### Windows
```cmd
copy target\auto-report-plugin-1.0.0.jar %JMETER_HOME%\lib\ext\
```

### Linux/Mac
```bash
cp target/auto-report-plugin-1.0.0.jar $JMETER_HOME/lib/ext/
```

**Note**: Replace `%JMETER_HOME%` with your JMeter installation path (e.g., `C:\apache-jmeter-5.6.2`)

## Step 3: Configure in JMeter (2 minutes)

### Option A: Use Sample Test Plan

1. Open JMeter
2. File → Open → Select `sample_test_plan.jmx`
3. Update the HTTP Sampler domain to your test URL
4. Run the test

### Option B: Add to Existing Test Plan

1. Open your existing test plan in JMeter
2. Right-click on Test Plan
3. Add → Listener → Backend Listener
4. In "Backend Listener implementation" dropdown, select:
   ```
   com.performance.jmeter.AutoReportBackendListener
   ```
5. Configure parameters (or use defaults):
   - **outputDirectory**: Where reports will be saved (default: `./reports`)
   - **reportName**: Base name for reports (default: `Performance_Test_Report`)
   - **generatePDF**: true
   - **generateExcel**: true
   - **projectName**: Your project name
   - **testEnvironment**: Dev/QA/Prod
   - **testerName**: Your name

## Step 4: Run Test and Get Reports

### GUI Mode (for testing)
1. Click the green "Start" button
2. Wait for test to complete
3. Check the output directory for reports

### Command Line Mode (recommended)
```bash
jmeter -n -t your_test_plan.jmx -l results.jtl
```

## Expected Results

After test completion, you'll find in the output directory:

```
reports/
├── BIE_Performance_Test_Report_2025-04-10_143022.pdf
└── BIE_Performance_Test_Report_2025-04-10_143022.xlsx
```

### PDF Report Contains:
- Test information (project, environment, tester, dates)
- Executive summary (total samples, errors, response times)
- Detailed transaction results table
- Pass/Fail status

### Excel Report Contains:
- **Summary Sheet**: Test info and executive summary
- **Detailed Results Sheet**: Complete metrics per transaction
- **Transaction Analysis Sheet**: Success rates and status

## Verification Checklist

✅ JAR file copied to `$JMETER_HOME/lib/ext/`  
✅ JMeter restarted after installing plugin  
✅ Backend Listener added to test plan  
✅ `com.performance.jmeter.AutoReportBackendListener` selected  
✅ Output directory configured and writable  
✅ Test executed successfully  
✅ Reports generated in output directory  

## Common Issues & Quick Fixes

### Plugin Not Showing in Dropdown

**Problem**: Can't find `AutoReportBackendListener` in dropdown

**Fix**:
1. Verify JAR is in `lib/ext` directory
2. Completely close and restart JMeter
3. Check JMeter log for errors

### No Reports Generated

**Problem**: Test runs but no reports created

**Fix**:
1. Check JMeter console for error messages
2. Verify output directory exists: `mkdir reports`
3. Check write permissions on output directory
4. Ensure test completed (not stopped mid-execution)

### Build Fails

**Problem**: Maven build fails

**Fix**:
```bash
# Update dependencies
mvn clean install -U

# Verify Java version
java -version  # Should be 8 or higher
```

## Example Configuration

### Minimal Configuration (Use Defaults)
```
Backend Listener Implementation: com.performance.jmeter.AutoReportBackendListener
(Leave all parameters as default)
```

### Custom Configuration
```
outputDirectory: C:/PerformanceReports
reportName: MyApp_LoadTest
generatePDF: true
generateExcel: true
projectName: My Application
testEnvironment: Production
testerName: Prasanth Kumar
```

## Next Steps

1. **Customize Reports**: Edit `PDFReportGenerator.java` or `ExcelReportGenerator.java`
2. **Add to CI/CD**: Integrate with Jenkins/GitLab CI
3. **Schedule Tests**: Use JMeter with cron/Task Scheduler
4. **Compare Results**: Keep historical reports for trend analysis

## Sample Command Line Usage

### Basic Test
```bash
jmeter -n -t test_plan.jmx -l results.jtl
```

### With Custom Properties
```bash
jmeter -n -t test_plan.jmx -l results.jtl \
  -JoutputDirectory=/custom/path \
  -JreportName=CustomReport \
  -JprojectName="My Project"
```

### CI/CD Integration (Jenkins)
```bash
#!/bin/bash
# Run JMeter test
jmeter -n -t ${WORKSPACE}/test_plan.jmx -l results.jtl

# Reports auto-generated in configured directory
# Archive as build artifacts
cp reports/*.pdf ${WORKSPACE}/
cp reports/*.xlsx ${WORKSPACE}/
```

## Support

- **Documentation**: See `README.md` for detailed information
- **Build Issues**: See `BUILD_INSTRUCTIONS.md`
- **JMeter Logs**: Check `$JMETER_HOME/bin/jmeter.log`

## Success!

If you see PDF and Excel reports in your output directory, you're all set! 🎉

The plugin will now automatically generate reports every time you run your JMeter tests.
