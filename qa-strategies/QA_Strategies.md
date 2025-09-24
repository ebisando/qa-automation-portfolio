
# QA Methodologies & Strategies

## 1. QA Methodologies
- **Manual Testing**: Exploratory, Ad-hoc, Usability tests. Quick detection of issues in early stages.
- **Automated Testing**: Selenium, Playwright, REST-assured for regression, smoke, API, and performance tests.
- **Continuous Testing (DevOps)**: Integrated into CI/CD pipelines. Shift-left (early testing) and Shift-right (monitoring after release).

## 2. QA Strategies
- **Risk-Based Testing**: Focus on high-risk business and technical areas (e.g., payments, login).
- **Regression Testing**: Ensure existing functionality still works after changes.
- **Smoke / Sanity Testing**: Quick validation of build stability or specific functionality.
- **Performance & Load Testing**: Use JMeter, Locust to validate performance under stress.
- **CI/CD Integration**: Automated pipelines with Jenkins, GitHub Actions, GitLab CI.

## 3. Test Types
- **Functional Testing**: Validates that requirements are met. Black-box approach.
- **Regression Testing**: Re-run tests after changes to ensure no breaks in existing features.
- **Integration Testing**: Verifies interactions between modules/services (e.g., API ↔ DB ↔ UI).
- **Smoke Testing**: Ensures the build is stable enough for deeper testing (system boots, login works).
- **Sanity Testing**: Narrow scope, focused on newly added or modified functionality.
- **Performance / Load Testing**: Measures system behavior under stress or high load.

## 4. Best Practices
- **Shift-left mindset**: QA participates from requirement phase to prevent defects.
- **Test Pyramid**: Focus more on Unit (70%), API (20%), UI (10%) tests for efficiency.
- **Data Validation**: Ensure integrity at DB and pipeline level.
- **Balanced Approach**: Automate regression but keep exploratory/manual for usability.
- **Metrics / Reporting**: Track defect density, test coverage, automation pass rate.
