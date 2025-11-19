# Deployment Guide - Enhanced Report Features

## 🚀 Deployment Steps

This guide walks you through deploying the enhanced JMeter Report Generator with sky blue theme, charts, and error highlighting.

---

## 📋 Pre-Deployment Checklist

### Prerequisites:
- [ ] Python 3.8+ installed
- [ ] Java 8+ installed (for Java plugin)
- [ ] Maven 3.x installed (for building Java plugin)
- [ ] JMeter 5.x installed (for plugin integration)
- [ ] All dependencies installed (`pip install -r requirements.txt`)
- [ ] Testing completed successfully
- [ ] Documentation reviewed

---

## 🐍 Python Deployment

### Step 1: Verify Dependencies
```bash
# Check Python version
python --version

# Install/upgrade dependencies
pip install --upgrade reportlab openpyxl python-docx pandas
```

### Step 2: Test Installation
```bash
# Run a quick test
python jmeter_report_generator_enhanced.py test_data/sample_results.jtl

# Verify output
dir test_reports
```

### Step 3: Deploy to Production Location
```bash
# Option A: Copy to central location
copy jmeter_report_generator_enhanced.py C:\Tools\JMeter\Scripts\

# Option B: Add to PATH
# Add script directory to system PATH

# Option C: Create standalone executable (see STANDALONE_EXECUTABLE_GUIDE.md)
pyinstaller --onefile jmeter_report_generator_enhanced.py
```

### Step 4: Create Shortcuts
```bash
# Windows: Create batch file
echo @echo off > generate_report.bat
echo python C:\Tools\JMeter\Scripts\jmeter_report_generator_enhanced.py %* >> generate_report.bat

# Linux/Mac: Create shell script
echo '#!/bin/bash' > generate_report.sh
echo 'python3 /opt/jmeter/scripts/jmeter_report_generator_enhanced.py "$@"' >> generate_report.sh
chmod +x generate_report.sh
```

---

## ☕ Java Plugin Deployment

### Step 1: Build the Plugin
```bash
cd jmeter_plugin
mvn clean package
```

**Expected Output:**
```
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 30.123 s
[INFO] Finished at: 2025-11-19T14:30:00+00:00
[INFO] ------------------------------------------------------------------------
```

### Step 2: Locate the JAR
```bash
# JAR file location
dir target\auto-report-plugin-1.0.0.jar
```

### Step 3: Install to JMeter
```bash
# Windows
copy target\auto-report-plugin-1.0.0.jar %JMETER_HOME%\lib\ext\

# Linux/Mac
cp target/auto-report-plugin-1.0.0.jar $JMETER_HOME/lib/ext/
```

### Step 4: Verify Installation
```bash
# Restart JMeter
jmeter

# Check for plugin in:
# Options > Backend Listener > Implementation
# Should see: com.performance.jmeter.AutoReportBackendListener
```

### Step 5: Configure Backend Listener
1. Add Backend Listener to test plan
2. Select implementation: `com.performance.jmeter.AutoReportBackendListener`
3. Configure parameters:
   - `projectName`: Your project name
   - `environment`: Test/Prod/etc
   - `testerName`: Your name
   - `outputDir`: Report output directory

---

## 🖥️ GUI Application Deployment

### Step 1: Test GUI
```bash
python jmeter_report_generator_gui.py
```

### Step 2: Create Desktop Shortcut
```bash
# Windows: Create shortcut
# Right-click Desktop > New > Shortcut
# Target: python.exe "C:\path\to\jmeter_report_generator_gui.py"
# Icon: Choose custom icon

# Or use batch file
echo @echo off > JMeter_Report_Generator.bat
echo cd /d "%~dp0" >> JMeter_Report_Generator.bat
echo python jmeter_report_generator_gui.py >> JMeter_Report_Generator.bat
```

### Step 3: Create Standalone Executable (Optional)
```bash
# Install PyInstaller
pip install pyinstaller

# Create executable
pyinstaller --onefile --windowed --name "JMeter Report Generator" jmeter_report_generator_gui.py

# Executable location
dir dist\JMeter Report Generator.exe
```

---

## 🔄 CI/CD Integration

### Jenkins Integration

#### Step 1: Create Jenkins Job
```groovy
pipeline {
    agent any
    
    stages {
        stage('Run JMeter Test') {
            steps {
                bat 'jmeter -n -t test_plan.jmx -l results.jtl'
            }
        }
        
        stage('Generate Reports') {
            steps {
                bat 'python jmeter_report_generator_enhanced.py results.jtl'
            }
        }
        
        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'test_reports/*.pdf, test_reports/*.xlsx'
            }
        }
        
        stage('Publish Reports') {
            steps {
                publishHTML([
                    reportDir: 'test_reports',
                    reportFiles: '*.pdf',
                    reportName: 'Performance Test Reports'
                ])
            }
        }
    }
}
```

### GitLab CI Integration

#### Step 2: Create .gitlab-ci.yml
```yaml
stages:
  - test
  - report
  - publish

jmeter_test:
  stage: test
  script:
    - jmeter -n -t test_plan.jmx -l results.jtl
  artifacts:
    paths:
      - results.jtl

generate_reports:
  stage: report
  script:
    - python jmeter_report_generator_enhanced.py results.jtl
  artifacts:
    paths:
      - test_reports/

publish_reports:
  stage: publish
  script:
    - echo "Reports published"
  artifacts:
    reports:
      junit: test_reports/*.xml
```

### GitHub Actions Integration

#### Step 3: Create .github/workflows/jmeter.yml
```yaml
name: JMeter Performance Test

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  performance-test:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v2
    
    - name: Set up Python
      uses: actions/setup-python@v2
      with:
        python-version: '3.8'
    
    - name: Install dependencies
      run: |
        pip install -r requirements.txt
    
    - name: Run JMeter Test
      run: |
        jmeter -n -t test_plan.jmx -l results.jtl
    
    - name: Generate Reports
      run: |
        python jmeter_report_generator_enhanced.py results.jtl
    
    - name: Upload Reports
      uses: actions/upload-artifact@v2
      with:
        name: performance-reports
        path: test_reports/
```

---

## 📧 Email Integration

### Configure Email Notifications

#### Python Script with Email:
```python
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.base import MIMEBase
from email.mime.text import MIMEText
from email import encoders

def send_report_email(pdf_path, excel_path):
    # Email configuration
    sender = "your-email@company.com"
    recipients = ["stakeholder1@company.com", "stakeholder2@company.com"]
    subject = "Performance Test Report - " + datetime.now().strftime('%Y-%m-%d')
    
    # Create message
    msg = MIMEMultipart()
    msg['From'] = sender
    msg['To'] = ", ".join(recipients)
    msg['Subject'] = subject
    
    # Email body
    body = """
    Hi Team,
    
    Please find attached the latest performance test report.
    
    Key Highlights:
    - Sky blue themed professional reports
    - Error rows highlighted in red
    - Interactive charts included
    
    Best regards,
    Automated Report System
    """
    msg.attach(MIMEText(body, 'plain'))
    
    # Attach PDF
    with open(pdf_path, 'rb') as f:
        part = MIMEBase('application', 'octet-stream')
        part.set_payload(f.read())
        encoders.encode_base64(part)
        part.add_header('Content-Disposition', f'attachment; filename={os.path.basename(pdf_path)}')
        msg.attach(part)
    
    # Attach Excel
    with open(excel_path, 'rb') as f:
        part = MIMEBase('application', 'octet-stream')
        part.set_payload(f.read())
        encoders.encode_base64(part)
        part.add_header('Content-Disposition', f'attachment; filename={os.path.basename(excel_path)}')
        msg.attach(part)
    
    # Send email
    server = smtplib.SMTP('smtp.company.com', 587)
    server.starttls()
    server.login(sender, 'your-password')
    server.send_message(msg)
    server.quit()
```

---

## 🗂️ File Organization

### Recommended Directory Structure:
```
C:\JMeter\
├── apache-jmeter-5.6\          # JMeter installation
│   └── lib\
│       └── ext\
│           └── auto-report-plugin-1.0.0.jar
│
├── scripts\                     # Python scripts
│   ├── jmeter_report_generator_enhanced.py
│   ├── jmeter_report_generator_gui.py
│   └── requirements.txt
│
├── test_plans\                  # JMeter test plans
│   ├── api_test.jmx
│   └── load_test.jmx
│
├── test_data\                   # Test data files
│   └── sample_results.jtl
│
└── test_reports\                # Generated reports
    ├── 2025-11-19_Performance_Report.pdf
    └── 2025-11-19_Performance_Report.xlsx
```

---

## 🔐 Security Considerations

### 1. File Permissions
```bash
# Restrict access to reports directory
icacls test_reports /grant Users:(R)
icacls test_reports /grant Administrators:(F)
```

### 2. Sensitive Data
- Remove sensitive data from reports
- Sanitize transaction names
- Mask URLs if needed

### 3. Access Control
- Implement user authentication for GUI
- Restrict report access to authorized users
- Use secure file transfer for email

---

## 📊 Monitoring & Maintenance

### 1. Log Monitoring
```bash
# Create log directory
mkdir logs

# Configure logging in Python
import logging
logging.basicConfig(
    filename='logs/report_generator.log',
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s'
)
```

### 2. Disk Space Monitoring
```bash
# Monitor report directory size
dir test_reports /s

# Set up cleanup script
# Delete reports older than 30 days
forfiles /p test_reports /s /m *.* /d -30 /c "cmd /c del @path"
```

### 3. Performance Monitoring
- Track report generation time
- Monitor memory usage
- Log any errors or warnings

---

## 🔄 Update Procedure

### Updating Python Scripts:
```bash
# 1. Backup current version
copy jmeter_report_generator_enhanced.py jmeter_report_generator_enhanced.py.bak

# 2. Deploy new version
copy new_version\jmeter_report_generator_enhanced.py .

# 3. Test
python jmeter_report_generator_enhanced.py test_data/sample_results.jtl

# 4. If successful, remove backup
# If failed, restore backup
```

### Updating Java Plugin:
```bash
# 1. Stop JMeter
# 2. Backup current JAR
copy %JMETER_HOME%\lib\ext\auto-report-plugin-1.0.0.jar auto-report-plugin-1.0.0.jar.bak

# 3. Deploy new JAR
copy target\auto-report-plugin-1.1.0.jar %JMETER_HOME%\lib\ext\

# 4. Restart JMeter and test
```

---

## ✅ Post-Deployment Verification

### Checklist:
- [ ] Python script runs without errors
- [ ] Java plugin loads in JMeter
- [ ] GUI application launches correctly
- [ ] Reports generate with sky blue theme
- [ ] Error highlighting works
- [ ] Charts display correctly
- [ ] Email notifications work (if configured)
- [ ] CI/CD integration successful
- [ ] Documentation accessible
- [ ] Users trained

---

## 📞 Support & Troubleshooting

### Common Issues:

#### Issue 1: "Module not found" error
**Solution:**
```bash
pip install -r requirements.txt
```

#### Issue 2: Java plugin not visible in JMeter
**Solution:**
- Verify JAR is in lib/ext directory
- Restart JMeter
- Check JMeter logs for errors

#### Issue 3: Charts not displaying
**Solution:**
- Verify openpyxl version: `pip install --upgrade openpyxl`
- Check Excel version compatibility

#### Issue 4: Colors not showing correctly
**Solution:**
- Update reportlab: `pip install --upgrade reportlab`
- Verify PDF viewer supports colors

---

## 📝 Rollback Plan

### If Deployment Fails:

1. **Stop using new version**
2. **Restore backup:**
   ```bash
   copy jmeter_report_generator_enhanced.py.bak jmeter_report_generator_enhanced.py
   ```
3. **Notify users**
4. **Investigate issue**
5. **Fix and re-deploy**

---

## 🎯 Success Metrics

Track these metrics post-deployment:
- Number of reports generated per day
- Average report generation time
- Error rate in report generation
- User satisfaction score
- Time saved vs manual reporting

---

**Version:** 1.0  
**Created:** November 2025  
**Author:** Prasanth Kumar Birupogu
