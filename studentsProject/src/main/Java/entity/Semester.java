package entity;

import java.util.List;

/**
 * Created by Evgeny on 06.02.2016.
 */
public class Semester {
    private long semesterId;
    private String name;
    private long duration;
    private List<Discipline> disciplineList;

    public long getSemesterId() {
        return semesterId;
    }

    public Semester(long semesterId, String name, List<Discipline> disciplineList, long duration) {
        this.semesterId = semesterId;
        this.name = name;
        this.disciplineList = disciplineList;
        this.duration = duration;
    }

    public Semester(String name, long duration, List<Discipline> disciplineList) {
        this.name = name;
        this.duration = duration;
        this.disciplineList = disciplineList;
    }

    public void setSemesterId(long semesterId) {
        this.semesterId = semesterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Semester)) return false;

        Semester semester = (Semester) o;

        if (getSemesterId() != semester.getSemesterId()) return false;
        if (getDuration() != semester.getDuration()) return false;
        if (getName() != null ? !getName().equals(semester.getName()) : semester.getName() != null) return false;
        return !(getDisciplineList() != null ? !getDisciplineList().equals(semester.getDisciplineList()) : semester.getDisciplineList() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getSemesterId() ^ (getSemesterId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (int) (getDuration() ^ (getDuration() >>> 32));
        result = 31 * result + (getDisciplineList() != null ? getDisciplineList().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Semester() {
    }



}
