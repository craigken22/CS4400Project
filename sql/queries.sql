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

SELECT username,
         project_name,
         status
     FROM BRG_APPLICATIONS;

INSERT INTO STD_USERS
				(username, user_type, password, major, year, email_address)
		VALUES
				('', '', '', '', '', '')

INSERT INTO STD_PROJECTS
				(project_name, advisor, description, designation, major_restriction,
						year_restriction, dept_restriction, est_num_students)
				VALUES
						('', '', '', '', '', '', '', '')

INSERT INTO STD_COURSES
				(course_num, course_name, instructor, designation, est_num_students)
				VALUES
						('', '', '', '', '')

--Check if the email_address is already in the database
SELECT email_address
		FROM STD_USERS u
		WHERE u.email_address = ''

-- Update logged in users year
UPDATE STD_USERS
		SET year = ''
		WHERE username = ''

-- Update logged in users major
UPDATE STD_USERS
		SET major = ''
		WHERE username = ''
