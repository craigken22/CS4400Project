/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.obj;

/**
 *
 * @author Kenneth Craig
 */
public class Course {
    private String  courseNum,
                    courseName,
                    instructor,
                    designation,
                    categories;
    private int     estNumStudents;
    
    public Course (
                    String courseNum,
                    String courseName,
                    String instructor,
                    String designation,
                    String categories,
                    int estNumStudents
                  ) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.instructor = instructor;
        this.designation = designation;
        this.categories = categories;
        this.estNumStudents = estNumStudents;
    }

    /**
     * @return the courseNum
     */
    public String getCourseNum() {
        return courseNum;
    }

    /**
     * @param courseNum the courseNum to set
     */
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the categories
     */
    public String getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(String categories) {
        this.categories = categories;
    }

    /**
     * @return the estNumStudents
     */
    public int getEstNumStudents() {
        return estNumStudents;
    }

    /**
     * @param estNumStudents the estNumStudents to set
     */
    public void setEstNumStudents(int estNumStudents) {
        this.estNumStudents = estNumStudents;
    }
}
