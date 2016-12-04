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
	 