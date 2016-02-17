package entity;

/**
 * Created by Evgeny on 06.02.2016.
 */
public class Role {
    private long roleId;
    private String name;

    public long getRoleId() {
        return roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (getRoleId() != role.getRoleId()) return false;
        return !(getName() != null ? !getName().equals(role.getName()) : role.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getRoleId() ^ (getRoleId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
