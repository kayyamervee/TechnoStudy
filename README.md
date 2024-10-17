# Agile Software Testing Project - TechnoStudy
### *This project is for educational purposes and is intended to help participants test their own skills.*

## Project Overview

### *This project focuses on automating tests for the Techno Study website using TestNG, a popular testing framework for Java. The aim is to ensure that various functionalities of the website work correctly while maintaining data integrity on the live environment.*

## Features Tested
#### The following user stories are tested in this project:

### US501_Dropdown Menu

* *Verify the presence of a dropdown menu under "Kurslar" or "Courses".*
* *Ensure all available courses are listed upon clicking the dropdown.*
* *Check that each course name is visible.*
* *Confirm redirection to the selected course page.*

### US502_Cross Campus

* *Verify the presence of a "Campus Girişi" or "Log in to Campus" option.*
* *Ensure clicking this option redirects to the Campus login page.*

### US503_Booking

* *Confirm the presence of an "Apply" button on the homepage.*
* *Verify redirection to the application form upon clicking "Apply".*
* *Ensure the form is easily fillable with required information.*
* *Validate that "test" is included in name and email fields, and country is set to "Andorra".*
* *Check for a confirmation message after submission.*

### US504_Submenu Courses

* *Verify the presence of a "Kurslar" or "Courses" submenu.*
* *Ensure a list of courses or submenus appears upon selection.*
* *Check that each course has a name and brief description.*
* *Validate redirection to the course page upon selection.*

### US505_Submenu Social Media

* *Confirm the presence of social media links in the footer.*
* *Verify visibility of each social media account name and/or icon.*
* *Ensure clicking on a link redirects to the corresponding social media page.*

### US506_Logo to Homepage

* *Ensure the Techno Study logo is present on every page.*
* *Validate redirection to the homepage upon clicking the logo.*

### US507_Course Details

* *Verify that each course has a "More Info" button in the "Kendi Kursunu Seç" section.*
* *Ensure redirection to the course detail page upon clicking the button.*
* *Check for the presence of the Techno Study logo on the course detail page.*

### US508_Terms Of Use

* *Confirm the presence of the "I have read and accept the terms" option in the contact form.*
* *Ensure clicking this option redirects to the "Terms of Use" page.*
* *Validate that the "Terms of Use" page is well-structured for readability.*

## Team6 Practice Project

- #### Domain:  [techno.study](https://techno.study/tr)

- #### Supported browsers: [Chrome](), [Edge](), [Firefox]()

## Technologies and Tools Used

#### *The basic technologies and tools to be used in this project include:*

- **Java** - Programming language
- **Selenium** - Web browser automation
- **TestNG** - Testing framework.
- **Apache POI** - Library for reading and writing Excel files
- **Git & GitHub** - Version control Systems 
- **JIRA & Zephyr-Squad** - Test management Tools
- **Page Object Model (POM)** - Test Automation Pattern


## Prerequisites

- **Java Development Kit (JDK):** Installed on your system for writing and compiling Java code.

- **IDE (Integrated Development Environment):** Choose IntelliJ IDEA for Java development.

- **Git:** Installed for version control, it is essential for managing your project's source code on GitHub.

- **Selenium WebDriver:** Become familiar with its usage and basic automation techniques.

- **TestNG:** Understand its annotations and how to write test cases using this framework.

- **Page Object Model (POM):** Understand and implement this pattern in your test automation framework.

- **JIRA & ZEPHYR Test Management Tool:** If using the system, ensure access to and understanding of test case creation, management, and defect reporting.


## Project Requirements

**1. Page Object Model (POM):** Utilize the POM design pattern for structuring the test cases.

**2. Parallel Testing:** Execute tests in parallel on multiple browsers (Chrome and Firefox).

**3. XML Configuration:** Run test cases from an XML file.

**4. Smoke and Regression Testing:** Separate XML files for smoke and regression test cases.

**5. Live Environment Considerations:** Use "test" in the name and email fields to facilitate data cleanup post-testing, and set the country to "Argentina".


## Contributors & Team Members

| Contributor                                               | Role                                  |User Stories    |
|-----------------------------------------------------------|---------------------------------------|----------------|
| [Merve Kaya](https://github.com/kayyamervee)              | Project Lead & QA Automation Engineer |  [503 - 504]   |
| [Sefa Kahraman](https://github.com/SefaKahramann)         | QA Automation Engineer                |  [501 - 506]   |
| [Ümmühan Teke](https://github.com/UmmuhanTeke)            | QA Automation Engineer                |  [505 - 507]   |
| [Songül Çam](https://github.com/songulcam)                | QA Automation Engineer                |  [502 - 508]   |

## License  

This project is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).
