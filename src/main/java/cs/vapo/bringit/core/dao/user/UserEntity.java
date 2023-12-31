package cs.vapo.bringit.core.dao.user;

import cs.vapo.bringit.core.dao.list.ListEntity;
import cs.vapo.bringit.core.dao.participant.ParticipantEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "password_salt")
    private String passwordSalt;

    @OneToMany(mappedBy = "owner")
    private List<ListEntity> lists;

    @OneToMany(mappedBy = "participant")
    private List<ParticipantEntity> participantLists;


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

    public List<ListEntity> getLists() {
        return lists;
    }

    public void setLists(List<ListEntity> lists) {
        this.lists = lists;
    }

    public List<ParticipantEntity> getParticipantLists() {
        return participantLists;
    }

    public void setParticipantLists(List<ParticipantEntity> participantLists) {
        this.participantLists = participantLists;
    }
}
