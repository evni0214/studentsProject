package entity;

/**
 * Created by Evgeny on 06.02.2016.
 */
public class DisciplineList {
    private long pairId;
    private String semesterName;
    private String disciplineName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisciplineList)) return false;

        DisciplineList that = (DisciplineList) o;

        if (getPairId() != that.getPairId()) return false;
        if (getSemesterName() != null ? !getSemesterName().equals(that.getSemesterName()) : that.getSemesterName() != null)
            return false;
        return !(getDisciplineName() != null ? !getDisciplineName().equals(that.getDisciplineName()) : that.getDisciplineName() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getPairId() ^ (getPairId() >>> 32));
        result = 31 * result + (getSemesterName() != null ? getSemesterName().hashCode() : 0);
        result = 31 * result + (getDisciplineName() != null ? getDisciplineName().hashCode() : 0);
        return result;
    }

    public long getPairId() {

        return pairId;
    }

    public void setPairId(long pairId) {
        this.pairId = pairId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }
}
