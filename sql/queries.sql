--Get user from USERS table, for a specific username and password.
--Uses both username and password despite the username being the key,
--because we want to select nothing if the password is wrong.
--Joins in the MAJORS table to get the user's department.
SELECT	u.username,
		u.password,
		u.user_type,
		u.major,
		m.department,
		u.year,
		u.email_address
	FROM STD_USERS u
		JOIN LKP_MAJORS m ON u.major = m.major
	WHERE u.username = '' AND u.password = ''

SELECT major
     FROM LKP_MAJORS
     WHERE department = dept

SELECT category
     FROM LKP_CATEGORIES;

SELECT year
     FROM LKP_YEARS;

SELECT designation
     FROM LKP_DESIGNATIONS;

SELECT username,
         project_name,
         status
     FROM BRG_APPLICATIONS;

INSERT INTO STD_USERS
				(username, user_type, password, major, year, email_address)
		VALUES
				('', '', '', '', '', '');

INSERT INTO STD_PROJECTS
				(project_name, advisor, description, designation, major_restriction,
						year_restriction, dept_restriction, est_num_students)
				VALUES
						('', '', '', '', '', '', '', '');

INSERT INTO STD_COURSES
				(course_num, course_name, instructor, designation, est_num_students)
				VALUES
						('', '', '', '', '');

--Check if the email_address is already in the database
SELECT email_address
		FROM STD_USERS u
		WHERE u.email_address = '';

-- Update logged in users
UPDATE STD_USERS
		SET major = '', year = ''
		WHERE username = '';

--Select user's APPLICATIONS
SELECT appl_date,
		project_name,
		status
		FROM BRG_APPLICATIONS
		WHERE username = '';

-- Search database on main page
SELECT u.course_name
		FROM STD_COURSES u
			JOIN BRG_COURSES_TO_CATEGORIES c ON u.course_num = c.course_num
		WHERE u.course_name = '' AND u.designation = '' AND c.category = '';

-- Search database on main page
SELECT u.project_name
		FROM STD_PROJECTS p
			JOIN BRG_PROJECTS_TO_CATEGORIES c ON p.project_name = c.project_name
		WHERE u.project_name = '' AND u.designation = '' AND
			u.major_restriction = '' AND u.year_restriction = '' AND c.category = '';

-- View Projects of interest
SELECT p.project_name,
		p.description,
		p.designation,
		c.category,
		p.major_restriction,
		p.year_restriction,
		p.est_num_students
		FROM STD_PROJECTS p
			JOIN BRG_PROJECTS_TO_CATEGORIES c ON p.project_name = c.project_name
		WHERE p.project_name = '';

-- View Courses of interest
SELECT p.course_num,
		p.course_name,
		p.instructor,
		p.designation,
		c.category,
		p.est_num_students
		FROM STD_COURSES p
			JOIN BRG_COURSES_TO_CATEGORIES c ON p.course_num = c.course_num
		WHERE p.project_name = '';
