/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat;

import dat.obj.User;

/**
 *
 * @author Kenneth Craig
 */
public class UserProfile {
    private User    user;
    
    public UserProfile(User user) {
        this.user = user;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        user.setUsername(username);
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return user.getUserType();
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        user.setUserType(userType);
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        user.setPassword(password);
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return user.getMajor();
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        user.setMajor(major);
    }

    /**
     * @return the year
     */
    public String getYear() {
        return user.getMajor();
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        user.setYear(year);
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return user.getEmailAddress();
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        user.setEmailAddress(emailAddress);
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return user.getDepartment();
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        user.setDepartment(department);
    }
}
