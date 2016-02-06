/**
 * Created by Evgeny on 06.02.2016.
 */
public class Mark {
    private long studentId;
    private long pairId;
    private byte mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;

        Mark mark1 = (Mark) o;

        if (getStudentId() != mark1.getStudentId()) return false;
        if (getPairId() != mark1.getPairId()) return false;
        return getMark() == mark1.getMark();

    }

    @Override
    public int hashCode() {
        int result = (int) (getStudentId() ^ (getStudentId() >>> 32));
        result = 31 * result + (int) (getPairId() ^ (getPairId() >>> 32));
        result = 31 * result + (int) getMark();
        return result;
    }

    public long getStudentId() {

        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getPairId() {
        return pairId;
    }

    public void setPairId(long pairId) {
        this.pairId = pairId;
    }

    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }
}
