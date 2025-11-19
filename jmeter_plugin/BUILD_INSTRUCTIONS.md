# Build and Installation Instructions

## Prerequisites

1. **Java Development Kit (JDK) 8 or higher**
   ```bash
   java -version
   ```

2. **Apache Maven 3.x**
   ```bash
   mvn -version
   ```

3. **Apache JMeter 5.x**
   - Download from: https://jmeter.apache.org/download_jmeter.cgi

## Build Steps

### 1. Navigate to Plugin Directory

```bash
cd jmeter_plugin
```

### 2. Build the Plugin

```bash
mvn clean package
```

This will:
- Compile all Java source files
- Run tests (if any)
- Package everything into a JAR file
- Create `target/auto-report-plugin-1.0.0.jar`

### 3. Verify Build

Check that the JAR was created:

```bash
ls -lh target/auto-report-plugin-1.0.0.jar
```

## Installation

### Windows

```cmd
copy target\auto-report-plugin-1.0.0.jar %JMETER_HOME%\lib\ext\
```

Or manually:
1. Navigate to `target` folder
2. Copy `auto-report-plugin-1.0.0.jar`
3. Paste into JMeter's `lib\ext` directory (e.g., `C:\apache-jmeter-5.6.2\lib\ext\`)

### Linux/Mac

```bash
cp target/auto-report-plugin-1.0.0.jar $JMETER_HOME/lib/ext/
```

## Verification

### 1. Start JMeter

```bash
jmeter
```

### 2. Verify Plugin is Loaded

1. Create a new Test Plan
2. Right-click on Test Plan
3. Add → Listener → Backend Listener
4. Click on "Backend Listener implementation" dropdown
5. Look for `com.performance.jmeter.AutoReportBackendListener`

If you see it, the plugin is successfully installed!

## Configuration

### Basic Configuration

1. Add Backend Listener to your test plan
2. Select `com.performance.jmeter.AutoReportBackendListener`
3. Configure parameters:

```
outputDirectory: C:/Reports
reportName: My_Performance_Test
generatePDF: true
generateExcel: true
projectName: My Application
testEnvironment: Production
testerName: Your Name
```

### Test the Plugin

1. Create a simple test plan with HTTP samplers
2. Add the Backend Listener with above configuration
3. Run the test
4. Check the output directory for generated reports

## Troubleshooting

### Build Fails

**Issue**: Maven dependencies not downloading

**Solution**:
```bash
mvn clean install -U
```

**Issue**: Java version mismatch

**Solution**: Ensure JDK 8+ is installed and JAVA_HOME is set correctly

### Plugin Not Appearing

**Issue**: Plugin not visible in JMeter

**Solutions**:
1. Verify JAR is in correct location (`lib/ext`)
2. Restart JMeter completely
3. Check JMeter logs: `jmeter.log` in JMeter's `bin` directory
4. Verify JAR is not corrupted:
   ```bash
   jar tf target/auto-report-plugin-1.0.0.jar
   ```

### Reports Not Generated

**Issue**: No reports created after test

**Solutions**:
1. Check JMeter console for errors
2. Verify output directory exists and is writable
3. Check JMeter log file for exceptions
4. Ensure test completed successfully (not stopped mid-execution)

### Permission Errors

**Issue**: Cannot write to output directory

**Solution**:
- Windows: Run JMeter as Administrator
- Linux/Mac: Check directory permissions
  ```bash
  chmod 755 /path/to/reports
  ```

## Development

### Project Structure

```
jmeter_plugin/
├── pom.xml                                    # Maven configuration
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── performance/
│                   └── jmeter/
│                       ├── AutoReportBackendListener.java
│                       ├── TestMetrics.java
│                       ├── TestReportData.java
│                       ├── PDFReportGenerator.java
│                       └── ExcelReportGenerator.java
└── README.md
```

### Making Changes

1. Modify source files as needed
2. Rebuild:
   ```bash
   mvn clean package
   ```
3. Reinstall JAR to JMeter
4. Restart JMeter
5. Test changes

### Adding Dependencies

Edit `pom.xml` and add dependency:

```xml
<dependency>
    <groupId>group.id</groupId>
    <artifactId>artifact-id</artifactId>
    <version>version</version>
</dependency>
```

Then rebuild.

## Next Steps

1. **Customize Reports**: Modify generator classes to match your report format
2. **Add Charts**: Integrate JFreeChart for graphical reports
3. **Email Integration**: Add email notification feature
4. **Database Storage**: Store results in database for historical analysis

## Support

For issues:
1. Check JMeter logs
2. Review Maven build output
3. Verify all dependencies are available
4. Test with simple JMeter test plan first
