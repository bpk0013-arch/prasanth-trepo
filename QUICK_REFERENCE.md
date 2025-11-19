# Quick Reference Guide
## JMeter Automated Reporting System

### 🚀 Quick Commands

#### Python Report Generation
```bash
# Basic usage
python old-data-work/jmeter_report_generator.py results.jtl

# With custom details
python old-data-work/jmeter_report_generator.py results.jtl \
  --project "My Project" \
  --environment "Production" \
  --tester "Your Name" \
  --output-dir ./reports

# GUI Dashboard
python old-data-work/auto_report_dashboard_gui.py

# Manual Test Reports
python old-data-work/test_report_generator_full_with_saveas.py
```

#### Java Plugin Build
```bash
# Build plugin
cd jmeter_plugin
mvn clean package

# Install to JMeter
cp target/auto-report-plugin-1.0.0.jar $JMETER_HOME/lib/ext/

# Windows
copy target\auto-report-plugin-1.0.0.jar %JMETER_HOME%\lib\ext\
```

#### Generate Sample Reports
```bash
# Preview reports
cd old-data-work/jmeter_plugin/demo
python ReportPreviewGenerator.py

# Test with sample data
python old-data-work/jmeter_report_generator.py test_data/sample_results.jtl
```

### 📁 File Locations

| Component | Location |
|-----------|----------|
| Java Plugin Source | `jmeter_plugin/src/main/java/` |
| Python Scripts | `old-data-work/` |
| Sample Data | `test_data/sample_results.jtl` |
| Generated Reports | `test_reports/` |
| Documentation | `*.md` files in root |

### 🔧 Configuration

#### Python Script Parameters
```bash
--input_file      # JTL/CSV file path (required)
--project         # Project name (default: "BIE Performance Test")
--environment     # Test environment (default: "Test Environment")
--tester          # Tester name (default: "Prasanth Kumar Birupogu")
--output-dir      # Output directory (default: "reports")
--pdf             # Generate PDF (default: true)
--excel           # Generate Excel (default: true)
```

#### Java Plugin Parameters
```
outputDirectory     # Where reports are saved
reportName          # Base name for reports
generatePDF         # true/false
generateExcel       # true/false
projectName         # Project name
testEnvironment     # Environment name
testerName          # Tester name
```

### 📊 Report Types

| Format | Command | Output |
|--------|---------|--------|
| PDF | `--pdf` | Professional PDF with tables |
| Excel | `--excel` | Multi-sheet workbook |
| Word | GUI only | DOCX with screenshots |
| HTML | Dashboard GUI | Interactive charts |

### 🎯 Common Tasks

#### Task 1: Generate Reports from JMeter Test
```bash
# Run JMeter test
jmeter -n -t test_plan.jmx -l results.jtl

# Generate reports
python old-data-work/jmeter_report_generator.py results.jtl
```

#### Task 2: Create Interactive Dashboard
```bash
# Launch GUI
python old-data-work/auto_report_dashboard_gui.py

# Select JTL file
# View charts
# Export to PDF/DOCX
```

#### Task 3: Manual Test Reporting
```bash
# Launch manual test reporter
python old-data-work/test_report_generator_full_with_saveas.py

# Fetch from Mantis or use sample data
# Edit test results
# Generate reports
```

#### Task 4: Build and Install Java Plugin
```bash
# Build
cd jmeter_plugin
mvn clean package

# Install
cp target/auto-report-plugin-1.0.0.jar $JMETER_HOME/lib/ext/

# Restart JMeter
# Add Backend Listener to test plan
# Select: com.performance.jmeter.AutoReportBackendListener
```

### 🐛 Troubleshooting

#### Python Import Errors
```bash
# Install dependencies
pip install -r requirements.txt

# Verify installation
pip list | grep reportlab
pip list | grep openpyxl
```

#### Java Plugin Not Showing
```bash
# Verify JAR location
ls $JMETER_HOME/lib/ext/auto-report-plugin-1.0.0.jar

# Check JMeter logs
tail -f $JMETER_HOME/bin/jmeter.log

# Restart JMeter completely
```

#### Maven Build Fails
```bash
# Update dependencies
mvn clean install -U

# Verify Java version
java -version  # Should be 8+

# Check Maven version
mvn -version   # Should be 3.x
```

#### Reports Not Generated
```bash
# Check output directory exists
mkdir -p reports

# Verify file permissions
chmod 755 reports

# Check input file format
head -5 results.jtl
```

### 📚 Documentation Links

| Document | Purpose |
|----------|---------|
| [README.md](README.md) | Main project overview |
| [JMETER_WORK_ANALYSIS.md](JMETER_WORK_ANALYSIS.md) | Technical deep-dive |
| [GITHUB_SETUP.md](GITHUB_SETUP.md) | GitHub deployment guide |
| [jmeter_plugin/README.md](jmeter_plugin/README.md) | Java plugin docs |
| [jmeter_plugin/QUICK_START.md](jmeter_plugin/QUICK_START.md) | 5-minute setup |

### 🔑 Key Metrics

| Metric | Description |
|--------|-------------|
| Response Time | Min, Max, Avg, Percentiles (90, 95, 99) |
| Error Rate | Percentage of failed requests |
| Throughput | Requests per second |
| Sample Count | Total number of requests |
| Pass/Fail | Based on error threshold (< 1%) |

### 💡 Tips & Best Practices

1. **Always backup** your JTL files before processing
2. **Use descriptive names** for test plans and samplers
3. **Configure thresholds** based on your SLAs
4. **Archive reports** with timestamps for historical tracking
5. **Customize templates** to match your organization's branding
6. **Test with sample data** before running on production results
7. **Document your test scenarios** in the reports
8. **Share reports** with stakeholders promptly

### 🎨 Customization Examples

#### Change Report Colors (Python)
```python
# Edit old-data-work/jmeter_report_generator.py
colors.HexColor('#2C3E50')  # Change to your color
```

#### Modify PDF Layout (Java)
```java
// Edit jmeter_plugin/src/main/java/.../PDFReportGenerator.java
private static final Font TITLE_FONT = new Font(...);
```

#### Adjust Dashboard Theme (HTML)
```html
<!-- Edit old-data-work/jmeter-dashboard.html -->
<style>
  body { background: your-gradient; }
</style>
```

### 📞 Support

**Issues?** Check:
1. Documentation files
2. Sample data and examples
3. Error logs
4. GitHub issues (if repository is public)

**Contact**: Prasanth Kumar Birupogu

---

**Last Updated**: November 19, 2025
**Version**: 1.0.0
