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

(SELECT 'Please Select')
UNION
(SELECT major
     FROM LKP_MAJORS
     WHERE department = dept);

(SELECT 'Please Select')
UNION
(SELECT category
     FROM LKP_CATEGORIES);

(SELECT 'Please Select')
UNION
(SELECT year
     FROM LKP_YEARS;
	 ORDER BY ordinal ASC)

(SELECT 'Please Select')
UNION
(SELECT designation
     FROM LKP_DESIGNATIONS);

(SELECT 'No Requirement')
UNION
(SELECT major_restriction
     FROM LKP_MAJOR_RESTRICTIONS);
	 
(SELECT 'No Requirement')
UNION
(SELECT year_restriction
     FROM LKP_YEAR_RESTRICTIONS);

	 
(SELECT 'No Requirement')
UNION
(SELECT dept_restriction
     FROM LKP_DEPARTMENT_RESTRICTIONS);


SELECT username,
         project_name,
         status
     FROM BRG_APPLICATIONS;

--Register a user.
INSERT INTO STD_USERS
				(username, user_type, password, major, year, email_address)
		VALUES
				('', '', '', '', '', '');

--Add a project.
INSERT INTO STD_PROJECTS
				(project_name, advisor, advisor_email, description, designation, major_restriction,
						year_restriction, dept_restriction, est_num_students)
				VALUES
						('', '', '', '', '', '', '', '', '');
						
INSERT INTO BRG_PROJECTS_TO_CATEGORIES
				(project_name, category)
				VALUES
				('', '')

--Add a course.
INSERT INTO STD_COURSES
				(course_num, course_name, instructor, designation, est_num_students)
				VALUES
						('', '', '', '', '');
						
INSERT INTO BRG_COURSES_TO_CATEGORIES
				(course_num, category)
				VALUES
				('', '')

--Apply for a project.
INSERT INTO BRG_APPLICATIONS
				(username, project_name, status, appl_date)
				VALUES
						('', '', 'Pending', CURDATE());

--Check if the email_address is already in the database
SELECT email_address
		FROM STD_USERS u
		WHERE u.email_address = '';

-- Update logged in users
UPDATE STD_USERS
		SET major = '', year = ''
		WHERE username = '';

--Select user's APPLICATIONS
SELECT 	DATE_FORMAT(appl_date, %Y/%m/%d),
		project_name,
		status
		FROM BRG_APPLICATIONS
		WHERE username = '';

-- Search database on main page
(SELECT u.course_name, 'Course'
		FROM STD_COURSES u
			JOIN BRG_COURSES_TO_CATEGORIES c ON u.course_num = c.course_num
		WHERE u.course_name = '' AND u.designation = '' AND c.category = '')
UNION
(SELECT u.project_name, 'Project'
		FROM STD_PROJECTS p
			JOIN BRG_PROJECTS_TO_CATEGORIES c ON p.project_name = c.project_name
		WHERE u.project_name = '' AND u.designation = '' AND
			u.major_restriction = '' AND u.year_restriction = '' AND c.category = '')

-- View Projects of interest
SELECT p.project_name,
		p.advisor,
		p.advisor_email,
		p.description,
		p.designation,
		c.category,
		p.major_restriction,
		p.year_restriction,
		p.dept_restriction
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
		WHERE p.course_num = '';

-- Admin's view of all APPLICATIONS
SELECT a.project_name,
		u.major,
		u.year,
		a.status
		FROM BRG_APPLICATIONS a
			JOIN STD_USERS u on a.username = u.username;

-- Accept Application
UPDATE BRG_APPLICATIONS
		SET status = 'Accepted'
		WHERE username = '' AND project_name = '';
		
-- Reject Application
UPDATE BRG_APPLICATIONS
		SET status = 'Rejected'
		WHERE username = '' AND project_name = '';

--Popular Projects Report
SELECT project_name,
		COUNT(username)
	FROM BRG_APPLICATIONS
	GROUP BY project_name
	ORDER BY COUNT(username) DESC

--Applications Report
--Get Total Applications
SELECT COUNT(username)
	FROM BRG_APPLICATIONS

--Get Total Accepted Applications
SELECT COUNT(username)
	FROM BRG_APPLICATIONS
	WHERE status = 'Accepted'
	
--Table data
 SELECT a.project_name, 
		COUNT( a.username ) AS total_apps,
		CONCAT((
				(SELECT COUNT( b.username )
					FROM BRG_APPLICATIONS b
					WHERE b.project_name = a.project_name
					AND b.status = 'Accepted'
				) / (
				SELECT COUNT( b.username )
				FROM BRG_APPLICATIONS b
				WHERE b.project_name = a.project_name
				)
			   ) * 100 , '%') AS accept_rate,
			  m.mjr AS top_major
	FROM BRG_APPLICATIONS a
		JOIN (SELECT c.project_name AS pname,
					u.major AS mjr,
					COUNT( u.major )
				FROM BRG_APPLICATIONS c
					JOIN STD_USERS u ON c.username = u.username
					GROUP BY pname, mjr
					ORDER BY mjr DESC
					LIMIT 3
			 ) m ON m.pname = a.project_name
	GROUP BY a.project_name, accept_rate, top_major
	ORDER BY COUNT( a.username ) DESC