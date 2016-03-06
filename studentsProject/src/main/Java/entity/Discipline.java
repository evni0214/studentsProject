package entity;

/**
 * Created by Evgeny on 06.02.2016.
 */
public class Discipline {
    private long disciplineId;
    private String name;

    public long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Discipline(long disciplineId, String name) {
        this.disciplineId = disciplineId;
        this.name = name;
    }

    public Discipline(String name) {
        this.name = name;
    }


    public Discipline(long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Discipline() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;

        Discipline that = (Discipline) o;

        if (getDisciplineId() != that.getDisciplineId()) return false;
        return !(getName() != null ? !getName().equals(that.getName()) : that.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getDisciplineId() ^ (getDisciplineId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
