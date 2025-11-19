# Quick Guide - New Features

## 🎯 What's New?

### 1. Company Logo
**Where**: GUI → "Company Logo (Optional)" field  
**How**: Click "Browse..." and select your logo (PNG, JPG, etc.)  
**Result**: Logo appears at top-left of PDF and Excel reports

### 2. Report Prepared By
**Where**: GUI → "Report Prepared By" field  
**How**: Enter the name of person preparing the report  
**Result**: Shows separately from "Tested By" in reports

### 3. Response Times in Seconds
**What Changed**: All response times now show in seconds (not milliseconds)  
**Format**: `X.XXX` seconds (e.g., `1.234` instead of `1234`)  
**Where**: All tables showing Avg, Min, Max, 90% response times

### 4. Transaction Name Word Wrap
**What**: Long transaction names automatically wrap in PDF tables  
**Benefit**: No more cut-off transaction names  
**Where**: PDF detailed results and error analysis tables

### 5. Transactions Per Second (TPS) Chart
**What**: New chart showing throughput for each transaction  
**Where**: 
- PDF: After Response Time chart
- Excel: Charts & Analysis sheet
**Color**: Green bars

### 6. Active Threads Over Time Chart
**What**: Line chart showing thread activity during test  
**Where**: 
- PDF: After TPS chart
- Excel: Charts & Analysis sheet
**Color**: Blue line

### 7. Error Codes in Error Analysis
**What**: Shows HTTP response codes that caused errors  
**Format**: `500(5), 404(2)` means 5 errors with code 500, 2 with code 404  
**Where**: Error Analysis section in both PDF and Excel

---

## 📊 Updated Report Layout

### PDF Report Order:
1. Cover Page (with logo if provided)
2. Test Information
3. Executive Summary
4. **Response Time Chart**
5. **TPS Chart** ⭐ NEW
6. **Active Threads Chart** ⭐ NEW
7. Detailed Results (times in seconds, word-wrapped names)
8. Performance Analysis
9. Error Analysis (with error codes)
10. Recommendations

### Excel Sheets:
1. **Summary** (with logo if provided)
2. **Detailed Results** (times in seconds, word-wrapped)
3. **Charts & Analysis** (includes TPS section and error codes)

---

## 🎨 GUI Layout

```
┌─────────────────────────────────────────┐
│  Prasanth TRepo - JMeter Report Gen    │
├─────────────────────────────────────────┤
│  Input JTL/CSV File:     [Browse...]    │
│  Output Directory:       [Browse...]    │
│                                         │
│  ─── Report Details ───                │
│  Project Name:           [________]     │
│  Environment:            [________]     │
│  Tested By:              [________]     │
│  Report Prepared By:     [________] ⭐  │
│  Company Logo:           [Browse...] ⭐ │
│                                         │
│  Report Formats:                        │
│  ☑ Generate PDF Report                 │
│  ☑ Generate Excel Report                │
│                                         │
│  [Generate] [Clear] [Open] [Exit]      │
│                                         │
│  ─── Log Output ───                    │
│  [Log messages appear here...]          │
└─────────────────────────────────────────┘
```

---

## 💡 Tips

### Logo Best Practices:
- Use PNG or JPG format
- Recommended size: 300x150 pixels
- Transparent background works best
- Logo will be resized to fit

### Response Time Display:
- **Old**: `1234 ms`
- **New**: `1.234 s`
- Easier to read and compare
- Industry standard format

### Error Codes:
- Helps identify specific issues
- Common codes:
  - `500` = Server Error
  - `404` = Not Found
  - `503` = Service Unavailable
  - `200` = Success (shouldn't appear in errors)

### Transaction Names:
- Long names now wrap automatically
- No need to shorten transaction names
- Full names visible in reports

---

## 🚀 Quick Start

1. **Launch GUI**:
   ```bash
   python prasanth_trepo_gui_standalone.py
   ```

2. **Fill Required Fields**:
   - Select JTL file
   - Enter project details
   - Enter tested by name

3. **Optional Fields**:
   - Add prepared by name (if different from tester)
   - Add company logo for branding

4. **Generate Reports**:
   - Click "Generate Reports"
   - Check log for progress
   - Open output folder to view reports

---

## 📋 Checklist for Complete Report

- [ ] JTL/CSV file selected
- [ ] Project name entered
- [ ] Environment specified
- [ ] Tested by name entered
- [ ] Prepared by name entered (optional but recommended)
- [ ] Company logo selected (optional but professional)
- [ ] Output directory confirmed
- [ ] Report formats selected (PDF and/or Excel)

---

## ❓ FAQ

**Q: What if I don't have a logo?**  
A: Leave it blank - reports will generate without logo

**Q: Can prepared by be same as tested by?**  
A: Yes, it will default to tester name if left blank

**Q: Why are response times in seconds now?**  
A: Seconds are more readable and industry standard (1.5s vs 1500ms)

**Q: Will old reports still work?**  
A: Yes, all changes are backward compatible

**Q: What if my JTL doesn't have error codes?**  
A: Error analysis will show "N/A" for error codes

**Q: Can I see thread activity for specific transactions?**  
A: Thread chart shows overall activity across all transactions

---

## 🎉 Benefits Summary

| Feature | Benefit |
|---------|---------|
| Logo | Professional branding |
| Prepared By | Clear attribution |
| Seconds | Better readability |
| Word Wrap | No cut-off names |
| TPS Chart | Throughput insights |
| Threads Chart | Load visualization |
| Error Codes | Better debugging |

---

**All features are now live and ready to use!** 🚀
