/**
 * Created by Evgeny on 06.02.2016.
 */
public class UserRole {
    private String username;
    private long roleId;

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (getRoleId() != userRole.getRoleId()) return false;
        return !(getUsername() != null ? !getUsername().equals(userRole.getUsername()) : userRole.getUsername() != null);

    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (int) (getRoleId() ^ (getRoleId() >>> 32));
        return result;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
