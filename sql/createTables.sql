CREATE TABLE LKP_USER_TYPES
(
   user_type VARCHAR(16) NOT NULL,
   PRIMARY KEY (user_type)
)

CREATE TABLE LKP_YEARS
(
   year VARCHAR(16) NOT NULL,
   PRIMARY KEY (year)
)

CREATE TABLE LKP_DEPARTMENTS
(
   department VARCHAR(128) NOT NULL,
   PRIMARY KEY (department)
)

CREATE TABLE LKP_MAJORS
(
   major      VARCHAR(8) NOT NULL,
   department VARCHAR(128) NOT NULL,
   PRIMARY KEY (major),
   FOREIGN KEY (department) REFERENCES LKP_DEPARTMENTS(department)
)

CREATE TABLE LKP_DEPARTMENT_RESTRICTIONS
(
   dept_restriction VARCHAR(128) NOT NULL,
   PRIMARY KEY (department_restriction)
)

CREATE TABLE LKP_MAJOR_RESTRICTIONS
(
   major_restriction VARCHAR(128) NOT NULL,
   PRIMARY KEY (major_restriction)
)

CREATE TABLE LKP_YEAR_RESTRICTIONS
(
   year_restriction VARCHAR(128) NOT NULL,
   PRIMARY KEY (year_restriction)
)

CREATE TABLE LKP_INSTRUCTORS
(
   instructor VARCHAR(64) NOT NULL,
   PRIMARY KEY (instructor)
)

CREATE TABLE LKP_DESIGNATIONS
(
   designation VARCHAR(64) NOT NULL,
   PRIMARY KEY (designation)
)

CREATE TABLE LKP_STATUSES
(
   status VARCHAR(16) NOT NULL,
   PRIMARY KEY (status)
)

CREATE TABLE LKP_CATEGORIES
(
   category VARCHAR(64) NOT NULL,
   PRIMARY KEY (category)
)

CREATE TABLE STD_USERS
(
   username      VARCHAR(32) NOT NULL,
   password      VARCHAR(32) NOT NULL,
   user_type     VARCHAR(16) NOT NULL,
   major         VARCHAR(8) NULL,
   year          VARCHAR(16) NOT NULL,
   email_address VARCHAR(128) NOT NULL,
   PRIMARY KEY (username),
   FOREIGN KEY (user_type) REFERENCES LKP_USER_TYPES(user_type),
   FOREIGN KEY (major) REFERENCES LKP_MAJORS(major),
   FOREIGN KEY (year) REFERENCES LKP_YEARS(year),
   UNIQUE (email_address)
)

CREATE TABLE STD_PROJECTS
(
   project_name           VARCHAR(64) NOT NULL,
   advisor                VARCHAR(64) NOT NULL,
   advisor_email          VARCHAR(128) NOT NULL,
   description            VARCHAR(512) NOT NULL,
   designation            VARCHAR(64) NOT NULL,
   major_restriction      VARCHAR(128) NOT NULL,
   year_restriction       VARCHAR(128) NOT NULL,
   dept_restriction       VARCHAR(128) NOT NULL,
   est_num_students       INT NOT NULL,
   PRIMARY KEY (project_name),
   FOREIGN KEY (designation) REFERENCES LKP_DESIGNATION(designation),
   FOREIGN KEY (major_restriction) REFERENCES LKP_MAJOR_RESTRICTIONS(major_restriction),
   FOREIGN KEY (year_restriction) REFERENCES LKP_YEAR_RESTRICTIONS(year_restriction),
   FOREIGN KEY (department_restriction) REFERENCES LKP_DEPARTMENT_RESTRICTIONS(department_restriction)
)

CREATE TABLE STD_COURSES
(
   course_num             VARCHAR(8) NOT NULL,
   course_name            VARCHAR(64) NOT NULL,
   instructor             VARCHAR(64) NOT NULL,
   designation            VARCHAR(64) NOT NULL,
   est_num_students       INT NOT NULL,
   PRIMARY KEY (course_num),
   FOREIGN KEY (instructor) REFERENCES LKP_INSTRUCTORS(instructor),
   FOREIGN KEY (designation) REFERENCES LKP_DESIGNATION(designation)
)

//Every application requires one user and one project.
CREATE TABLE BRG_APPLICATIONS
(
   username      VARCHAR(32) NOT NULL,
   project_name  VARCHAR(64) NOT NULL,
   status        VARCHAR(16) NOT NULL,
   PRIMARY KEY (username, project_name),
   FOREIGN KEY (username) REFERENCES STD_USERS(username),
   FOREIGN KEY (project_name) REFERENCES STD_PROJECTS(project_name),
   FOREIGN KEY (status) REFERENCES LKP_STATUSES(status)
)

//Table that allows multiple categories for each project.
CREATE TABLE BRG_PROJECTS_TO_CATEGORIES
(
   project_name  VARCHAR(64) NOT NULL,
   category      VARCHAR(64) NOT NULL,
   PRIMARY KEY (project_name, category),
   FOREIGN KEY (project_name) REFERENCES STD_PROJECTS(project_name),
   FOREIGN KEY (category) REFERENCES LKP_CATEGORIES(category)
)

//Table that allows multiple categories for each course.
CREATE TABLE BRG_COURSES_TO_CATEGORIES
(
   course_num    VARCHAR(8) NOT NULL,
   category      VARCHAR(64) NOT NULL,
   PRIMARY KEY (course_num, category),
   FOREIGN KEY (course_num) REFERENCES STD_COURSES(course_num),
   FOREIGN KEY (category) REFERENCES LKP_CATEGORIES(category)
)