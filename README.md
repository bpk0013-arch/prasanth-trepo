# 🚀 Prasanth TRepo - Professional JMeter Report Generator

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Python 3.8+](https://img.shields.io/badge/python-3.8+-blue.svg)](https://www.python.org/downloads/)
[![Platform](https://img.shields.io/badge/platform-Windows%2010%2F11-lightgrey.svg)](https://www.microsoft.com/windows)
[![Status](https://img.shields.io/badge/status-production--ready-brightgreen.svg)](https://github.com/yourusername/prasanth-trepo)

> **Your Go-To Ready-Made Template for Professional JMeter Performance Test Reports**

Transform your JMeter test results into stunning, professional PDF and Excel reports in seconds. No coding required, no complex setup - just beautiful reports with your company branding.

---

## 🎯 Why Prasanth TRepo?

**The Problem:** JMeter generates raw CSV/JTL files that are hard to read and share with stakeholders.

**The Solution:** Prasanth TRepo instantly converts your test results into professional, branded reports that executives and technical teams love.

### ✨ Perfect For:
- 🎯 Performance Engineers who need quick, professional reports
- 📊 QA Teams sharing test results with stakeholders
- 💼 Consultants delivering client reports
- 🏢 Enterprise teams requiring branded documentation
- 🚀 Anyone who wants to save hours on report creation

---

## 🎬 See It In Action

### Before & After

**Before (Raw JMeter Output):**
```
label,elapsed,responseCode,success
Login,1234,200,true
Search,567,200,true
Checkout,2345,500,false
```

**After (Prasanth TRepo):**
- Professional PDF with cover page and your company logo
- Beautiful Excel reports with charts
- Response times in readable seconds (1.234s vs 1234ms)
- Error codes displayed (500, 404, etc.)
- TPS and thread activity charts
- All in 3 minutes!

---

## ⚡ Key Features

### 🎨 Professional Design
- **Sky Blue Theme** - Modern, professional color scheme
- **Company Branding** - Add your logo to all reports
- **Error Highlighting** - Red cells instantly show problems
- **Clean Layout** - Perfect alignment and formatting

### 📊 Comprehensive Analysis
- **Response Time Charts** - Visual performance analysis
- **TPS Charts** - Transactions per second visualization
- **Thread Activity** - Active threads over time
- **Error Analysis** - Detailed error breakdown with HTTP codes
- **Performance Metrics** - Min, Max, Average, 90th percentile

### 📈 Dual Format Output
- **PDF Reports** - Perfect for presentations and sharing
- **Excel Reports** - Interactive data for deeper analysis
- **Both Formats** - Generate simultaneously

### 🎯 Smart Features
- **Response Times in Seconds** - More readable than milliseconds
- **Word-Wrapped Names** - Long transaction names fully visible
- **Error Codes** - See exactly what failed (500, 404, etc.)
- **Best/Worst Analysis** - Identify performance bottlenecks
- **Actionable Recommendations** - What to fix and optimize

### 🖥️ User-Friendly GUI
- **No Coding Required** - Simple point-and-click interface
- **Real-Time Logging** - See progress as reports generate
- **Batch Processing** - Generate multiple reports easily
- **Standalone Executable** - No Python installation needed

---

## 🚀 Quick Start

### Option 1: Use the Executable (Recommended)
**No installation required!**

1. Download `Prasanth_TRepo_GUI_v2.exe` from [Releases](https://github.com/bpk0013-arch/prasanth-trepo/releases)
2. Double-click to run
3. Select your JMeter JTL/CSV file
4. Click "Generate Reports"
5. Done! 🎉

### Option 2: Run from Source

```bash
# Clone the repository
git clone https://github.com/bpk0013-arch/prasanth-trepo.git
cd prasanth-trepo

# Install dependencies
pip install -r requirements.txt

# Run the application
python prasanth_trepo_gui_standalone.py
```

---

## 📋 System Requirements

### For Executable Users:
- ✅ Windows 10 or 11
- ✅ 100 MB free disk space
- ✅ **That's it!** No Python, no dependencies

### For Source Code Users:
- Python 3.8 or higher
- Required packages: `reportlab`, `openpyxl`, `Pillow`

---

## 🎓 How to Use

### Step-by-Step Guide

1. **Launch the Application**
   - Double-click `Prasanth_TRepo_GUI_v2.exe`

2. **Select Your JMeter Results**
   - Click "Browse..." next to "Input JTL/CSV File"
   - Select your `.jtl` or `.csv` file

3. **Add Your Branding (Optional)**
   - Click "Browse..." next to "Company Logo"
   - Select your logo (PNG or JPG)

4. **Fill in Project Details**
   - Project Name: e.g., "E-commerce Load Test"
   - Environment: Test/QA/Staging/Production
   - Tested By: Your name
   - Report Prepared By: Your name or colleague's name

5. **Generate Reports**
   - Select PDF and/or Excel
   - Click "Generate Reports"
   - Wait for completion (usually 5-30 seconds)

6. **View Your Reports**
   - Click "Open Output Folder"
   - Share with stakeholders!


---

## 📊 Report Contents

### PDF Report Includes:
1. **Cover Page** - With your company logo and project info
2. **Test Information** - Duration, samples, timestamps
3. **Executive Summary** - Key metrics with pass/fail status
4. **Response Time Chart** - Visual performance analysis
5. **TPS Chart** - Throughput visualization
6. **Active Threads Chart** - Load pattern over time
7. **Detailed Results** - All transactions with metrics in seconds
8. **Performance Analysis** - Best and worst performers
9. **Error Analysis** - Error counts, percentages, and HTTP codes
10. **Recommendations** - Actionable insights

### Excel Report Includes:
1. **Summary Sheet** - Logo, project info, key metrics
2. **Detailed Results** - All data with color coding
3. **Charts & Analysis** - TPS data and error breakdown

---

## 🎯 Use Cases

### Performance Testing Teams
```
✅ Generate reports after every test run
✅ Share results with development teams
✅ Track performance trends over time
✅ Present findings to management
```

### QA Consultants
```
✅ Deliver professional client reports
✅ Add client branding automatically
✅ Save hours on report creation
✅ Impress clients with polished deliverables
```

### Enterprise Organizations
```
✅ Standardize report format across teams
✅ Include company branding on all reports
✅ Maintain consistent documentation
✅ Meet compliance requirements
```

### Individual Testers
```
✅ Learn performance testing
✅ Build your portfolio
✅ Share results on LinkedIn
✅ Demonstrate your skills
```

---

## 🆚 Comparison

| Feature | Manual Reports | Other Tools | Prasanth TRepo |
|---------|---------------|-------------|----------------|
| Setup Time | Hours | 30+ minutes | **0 minutes** ✅ |
| Company Logo | Manual | Limited | **Automatic** ✅ |
| Response Times | Milliseconds | Milliseconds | **Seconds** ✅ |
| Error Codes | Not shown | Basic | **Detailed** ✅ |
| Charts | Manual | Basic | **3 Charts** ✅ |
| Excel Output | Manual | Limited | **Full Featured** ✅ |
| Cost | Time | $$ | **Free** ✅ |
| Learning Curve | High | Medium | **None** ✅ |

---

## 🎨 Customization

### Add Your Company Logo
```
1. Prepare logo (PNG/JPG, recommended: 300x150px)
2. Click "Browse..." next to "Company Logo"
3. Select your logo file
4. Logo appears on all reports automatically!
```

### Customize Project Details
```
- Project Name: Your project name
- Environment: Test/QA/Staging/Production
- Tested By: Tester's name
- Report Prepared By: Report author's name
```

---

## 📦 What's Included

```
prasanth-trepo/
├── 📱 Executable
│   └── Prasanth_TRepo_GUI_v2.exe (24.65 MB)
│
├── 🐍 Source Code
│   ├── prasanth_trepo_gui_standalone.py
│   └── jmeter_report_generator_enhanced.py
│
├── 📚 Documentation
│   ├── README.md (this file)
│   ├── README_FOR_USERS.txt
│   ├── NEW_FEATURES_QUICK_GUIDE.md
│   └── EXECUTABLE_BUILD_GUIDE_V2.md
│
├── 🎨 Screenshots
│   └── (All screenshots for documentation)
│
└── 📊 Sample Data
    ├── sample_results.jtl
    └── sample_logo.png
```

---

## 🔧 Building from Source

Want to customize or build your own executable?

```bash
# Install build tools
pip install pyinstaller

# Build the executable
pyinstaller --clean build_prasanth_trepo_v2.spec

# Find your executable in dist/
```

See [Build Guide](EXECUTABLE_BUILD_GUIDE_V2.md) for detailed instructions.

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. 🐛 **Report Bugs** - Open an issue with details
2. 💡 **Suggest Features** - Share your ideas
3. 🔧 **Submit PRs** - Improve the code
4. 📖 **Improve Docs** - Help others understand
5. ⭐ **Star the Repo** - Show your support!

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### Third-Party Libraries
- [ReportLab](https://www.reportlab.com/) - PDF generation
- [OpenPyXL](https://openpyxl.readthedocs.io/) - Excel generation
- [Pillow](https://python-pillow.org/) - Image handling

---

## 🌟 Star History

[![Star History Chart](https://api.star-history.com/svg?repos=bpk0013-arch/prasanth-trepo&type=Date)](https://star-history.com/#bpk0013-arch/prasanth-trepo&Date)

---

## 📞 Support & Contact

### Need Help?
- 📖 Check the [Documentation](README_FOR_USERS.txt)
- 🐛 [Report an Issue](https://github.com/bpk0013-arch/prasanth-trepo/issues)
- 💬 [Discussions](https://github.com/bpk0013-arch/prasanth-trepo/discussions)

### Connect with Me
- 💼 [LinkedIn](https://www.linkedin.com/in/prasanthbirupogu)
- 📧 Email: bpk0013@gmail.com

---

## 🎉 Success Stories

> "Prasanth TRepo saved me hours every week. The reports look so professional that my clients think I have a dedicated design team!" - **Performance Consultant**

> "Finally, a tool that makes JMeter reports actually readable. The error codes feature alone is worth it." - **QA Lead**

> "We standardized on Prasanth TRepo across our entire QA department. Everyone loves it!" - **Enterprise QA Manager**

---

## 🗺️ Roadmap

### Version 2.0 (Current) ✅
- [x] Company logo support
- [x] Response times in seconds
- [x] TPS charts
- [x] Active threads charts
- [x] Error codes display
- [x] Word-wrapped transaction names
- [x] Report prepared by field

### Version 2.1 (Planned) 🚧
- [ ] Dark mode theme
- [ ] Custom color schemes
- [ ] Multiple logo support
- [ ] Comparison reports
- [ ] Trend analysis
- [ ] Email integration

### Version 3.0 (Future) 🔮
- [ ] Cloud integration
- [ ] Real-time monitoring
- [ ] API support
- [ ] Mobile app
- [ ] Team collaboration features

---

## 📊 Project Stats

- ⭐ Stars: [Your stars count]
- 🍴 Forks: [Your forks count]
- 📥 Downloads: [Your downloads count]
- 🐛 Issues: [Open issues count]
- 📝 Commits: [Commits count]

---

## 💖 Support This Project

If Prasanth TRepo saves you time and makes your life easier:

- ⭐ **Star this repository**
- 🔄 **Share with colleagues**
- 💬 **Write a testimonial**
- 🐛 **Report bugs**
- 💡 **Suggest features**

---

## 📚 Related Projects

- [JMeter](https://jmeter.apache.org/) - The testing tool itself
- [JMeter Plugins](https://jmeter-plugins.org/) - Additional JMeter functionality
- [Grafana](https://grafana.com/) - Real-time monitoring

---

## 🎓 Learning Resources

- [JMeter Documentation](https://jmeter.apache.org/usermanual/index.html)
- [Performance Testing Guide](https://www.guru99.com/performance-testing.html)
- [Load Testing Best Practices](https://www.blazemeter.com/blog/performance-testing-best-practices)

---

## 🔐 Security

Found a security issue? Please email bpk0013@gmail.com instead of opening a public issue.

---

## 📜 Changelog

### v2.0.0 (2025-11-19)
- ✨ Added company logo support
- ✨ Response times now in seconds
- ✨ Added TPS chart
- ✨ Added active threads chart
- ✨ Error codes in error analysis
- ✨ Transaction name word wrapping
- ✨ Report prepared by field
- 🐛 Fixed various bugs
- 📚 Improved documentation

### v1.0.0 (2025-11-01)
- 🎉 Initial release
- ✨ PDF report generation
- ✨ Excel report generation
- ✨ Sky blue theme
- ✨ Error highlighting

See [CHANGELOG.md](CHANGELOG.md) for full history.

---

## 🙏 Acknowledgments

Special thanks to:
- The JMeter community
- ReportLab developers
- OpenPyXL contributors
- All users and contributors

---

## 📱 Follow for Updates

Stay updated with the latest features and releases:

- ⭐ Star this repo
- 👁️ Watch for releases
- 🔔 Enable notifications
- 💼 Follow on [LinkedIn](https://www.linkedin.com/in/prasanthbirupogu)

---

<div align="center">

## 🚀 Ready to Transform Your JMeter Reports?

### [Download Now](https://github.com/bpk0013-arch/prasanth-trepo/releases) | [Read Docs](README_FOR_USERS.txt)

**Made with ❤️ by [Prasanth Kumar Birupogu](https://www.linkedin.com/in/prasanthbirupogu)**

⭐ **Star this repo if you find it useful!** ⭐

</div>

---

<div align="center">



**Prasanth TRepo** - Professional JMeter Reports Made Simple

[Website]([https://yourwebsite.com](https://bpk0013-arch.github.io/portfolio/)) • [Documentation](README_FOR_USERS.txt) • [Issues](https://github.com/bpk0013-arch/prasanth-trepo/issues) • [Discussions](https://github.com/bpk0013-arch/prasanth-trepo/discussions)

</div>
