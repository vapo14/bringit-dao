package cs.vapo.bringit.core.dao.model;


import cs.vapo.bringit.core.dao.user.UserEntity;

import java.util.List;

public class ListDM {

    private String id;

    private UserEntity owner;

    private String title;

    private List<ParticipantDM> participants;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ParticipantDM> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDM> participants) {
        this.participants = participants;
    }
}
