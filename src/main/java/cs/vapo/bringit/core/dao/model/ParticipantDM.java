package cs.vapo.bringit.core.dao.model;

import cs.vapo.bringit.core.dao.user.UserEntity;

public class ParticipantDM {

    private String id;

    private String list;

    private UserEntity participant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public UserEntity getParticipant() {
        return participant;
    }

    public void setParticipant(UserEntity participant) {
        this.participant = participant;
    }
}
