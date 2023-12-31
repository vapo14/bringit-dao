package cs.vapo.bringit.core.dao.model;

import java.util.List;

public class UserDM {

    private String id;

    private String username;

    private String email;

    private String password;

    private String passwordSalt;

    private List<ListDM> lists;

    private List<ParticipantDM> participantLists;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public List<ListDM> getLists() {
        return lists;
    }

    public void setLists(List<ListDM> lists) {
        this.lists = lists;
    }

    public List<ParticipantDM> getParticipantLists() {
        return participantLists;
    }

    public void setParticipantLists(List<ParticipantDM> participantLists) {
        this.participantLists = participantLists;
    }
}
