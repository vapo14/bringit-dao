package cs.vapo.bringit.core.dao.model;

public class UserForLoginDM extends UserDM {

    private String password;

    private String passwordSalt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
}
