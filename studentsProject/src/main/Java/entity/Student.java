package entity;

import java.sql.Date;

/**
 * Created by Evgeny on 06.02.2016.
 */
public class Student {
    private long studentId;
    private String firstName;
    private String lastName;
    private String groupId;
    private Date startDate;
    private Boolean status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getStudentId() != student.getStudentId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(student.getFirstName()) : student.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(student.getLastName()) : student.getLastName() != null)
            return false;
        if (getGroupId() != null ? !getGroupId().equals(student.getGroupId()) : student.getGroupId() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(student.getStartDate()) : student.getStartDate() != null)
            return false;
        return !(getStatus() != null ? !getStatus().equals(student.getStatus()) : student.getStatus() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getStudentId() ^ (getStudentId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getGroupId() != null ? getGroupId().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
