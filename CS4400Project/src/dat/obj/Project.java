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
public class Project {
    private String  projectName,
                    advisor,
                    advisorEmail,
                    description,
                    designation,
                    categories,
                    majorRestriction,
                    yearRestriction,
                    deptRestriction;
    private int     estNumStudents;
    
    public Project (
                    String projectName,
                    String advisor,
                    String advisorEmail,
                    String description,
                    String designation,
                    String categories,
                    String majorRestriction,
                    String yearRestriction,
                    String deptRestriction,
                    int estNumStudents
                   ) {
        this.projectName = projectName;
        this.advisor = advisor;
        this.advisorEmail = advisorEmail;
        this.description = description;
        this.designation = designation;
        this.categories = categories;
        this.majorRestriction = majorRestriction;
        this.yearRestriction = yearRestriction;
        this.deptRestriction = deptRestriction;
        this.estNumStudents = estNumStudents;
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

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the advisor
     */
    public String getAdvisor() {
        return advisor;
    }

    /**
     * @param advisor the advisor to set
     */
    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the majorRestriction
     */
    public String getMajorRestriction() {
        return majorRestriction;
    }

    /**
     * @param majorRestriction the majorRestriction to set
     */
    public void setMajorRestriction(String majorRestriction) {
        this.majorRestriction = majorRestriction;
    }

    /**
     * @return the yearRestriction
     */
    public String getYearRestriction() {
        return yearRestriction;
    }

    /**
     * @param yearRestriction the yearRestriction to set
     */
    public void setYearRestriction(String yearRestriction) {
        this.yearRestriction = yearRestriction;
    }

    /**
     * @return the deptRestriction
     */
    public String getDeptRestriction() {
        return deptRestriction;
    }

    /**
     * @param deptRestriction the deptRestriction to set
     */
    public void setDeptRestriction(String deptRestriction) {
        this.deptRestriction = deptRestriction;
    }

    /**
     * @return the requirements
     */
    public String getRequirements() {
        String req;
        if (deptRestriction != null) {
            req = deptRestriction;
        } else {
            req = "";
        }
        return req;
    }
    

    /**
     * @return the advisor's email address
     */
    public String getAdvisorEmail() {
        return advisorEmail;
    }

    /**
     * @param advisorEmail the advisorEmail to set
     */
    public void setAdvisorEmail(String advisorEmail) {
        this.advisorEmail = advisorEmail;
    }
}
