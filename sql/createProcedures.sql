//Selects the user record if login succeeded, empty result set if login failed.
DELIMITER //
CREATE PROCEDURE jpr_login_user(IN un VARCHAR(256), IN pw VARCHAR(256))
BEGIN
  SELECT username,
         user_type,
         major,
         year,
         email_address
     FROM BRG_USERS
     WHERE username = un
        AND password = pw;
END//
DELIMITER;

DELIMITER //
CREATE PROCEDURE jpr_get_users()
BEGIN
  SELECT username,
         project_name,
         status
     FROM BRG_APPLICATIONS;
END//
DELIMITER;

DELIMITER //
CREATE PROCEDURE jpr_get_applications()
BEGIN
  SELECT username,
         project_name,
         status
     FROM BRG_APPLICATIONS;
END//
DELIMITER;

//Lookup Table procedures.

DELIMITER //
CREATE PROCEDURE jpr_get_designations()
BEGIN
  SELECT designation
     FROM LKP_DESIGNATIONS;
END//
DELIMITER;

DELIMITER //
CREATE PROCEDURE jpr_get_years()
BEGIN
  SELECT year
     FROM LKP_YEARS;
END//
DELIMITER;

DELIMITER //
CREATE PROCEDURE jpr_get_categories()
BEGIN
  SELECT category
     FROM LKP_CATEGORIES;
END//
DELIMITER;

DELIMITER //
CREATE PROCEDURE jpr_get_majors(IN dept VARCHAR(256))
BEGIN
  SELECT major
     FROM LKP_MAJORS
     WHERE department = dept
END//
DELIMITER;

DELIMITER //
CREATE PROCEDURE jpr_get_coursesAndProjects(IN type VARCHAR(256), IN title VARCHAR(256), IN cat VARCHAR(256), IN des VARCHAR(256), IN maj VARCHAR(256), IN yr VARCHAR(256))
BEGIN
  DECLARE cats_filter VARCHAR(3000) DEFAULT '';
  DECLARE pipe_count INT DEFAULT 0;
  SET pipe_count = CHAR_LENGTH(cat) - CHAR_LENGTH(REPLACE(cat,'|',''))
  IF (pipe_count > 0)
  BEGIN
    WHILE (pipe_count > 0)
    BEGIN
      SET pipe_count = pipe_count - 1;
    END;
  END;
  ELSE
  BEGIN
    SET cats_filter = CONCAT(' AND category = ''', cat, '''');
  END;
  DECLARE filter VARCHAR(5000) DEFAULT '';
  IF (type = 'Project')
  BEGIN
    SET filter = CONCAT(filter, 'SELECT project_name, ''Project'' FROM STD_PROJECTS WHERE project_name LIKE ''%', title, '%''');
    IF ()
  SELECT major
     FROM LKP_MAJORS
     WHERE department = dept
  END;
  ELSE IF (type = 'Course')
  BEGIN
  SELECT course_name
     FROM STD_COURSES
     WHERE department = dept
  END;
  ELSE
  BEGIN
    SELECT major
       FROM LKP_MAJORS
       WHERE department = dept
    UNION
    SELECT 
       FROM LKP_MAJORS
       WHERE department = dept
  END;
END//
DELIMITER;