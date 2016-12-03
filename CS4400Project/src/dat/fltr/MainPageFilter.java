/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.fltr;

/**
 *
 * @author Kenneth Craig
 */
public class MainPageFilter {
    private String  title,
                    categories,
                    designation,
                    major,
                    year,
                    courseOrProject;
    
    public MainPageFilter () {
        
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the courseOrProject
     */
    public String getCourseOrProject() {
        return courseOrProject;
    }

    /**
     * @param courseOrProject the courseOrProject to set
     */
    public void setCourseOrProject(String courseOrProject) {
        this.courseOrProject = courseOrProject;
    }
}
