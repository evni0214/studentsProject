/**
 * Created by Evgeny on 06.02.2016.
 */
public class Discipline {
    private String disciplineName;

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;

        Discipline that = (Discipline) o;

        return !(getDisciplineName() != null ? !getDisciplineName().equals(that.getDisciplineName()) : that.getDisciplineName() != null);

    }

    @Override
    public int hashCode() {
        return getDisciplineName() != null ? getDisciplineName().hashCode() : 0;
    }
}
