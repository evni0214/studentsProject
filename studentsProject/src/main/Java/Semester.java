/**
 * Created by Evgeny on 06.02.2016.
 */
public class Semester {
    private String semesterName;
    private long duration;

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Semester)) return false;

        Semester semester = (Semester) o;

        if (getDuration() != semester.getDuration()) return false;
        return !(getSemesterName() != null ? !getSemesterName().equals(semester.getSemesterName()) : semester.getSemesterName() != null);

    }

    @Override
    public int hashCode() {
        int result = getSemesterName() != null ? getSemesterName().hashCode() : 0;
        result = 31 * result + (int) (getDuration() ^ (getDuration() >>> 32));
        return result;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
