package cs.vapo.bringit.core.dao.list;

import cs.vapo.bringit.core.dao.participant.ParticipantEntity;
import cs.vapo.bringit.core.dao.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "BRINGIT_CORE_LIST")
public class ListEntity {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    private UserEntity owner;

    @Column(name = "list_title")
    private String title;

    @OneToMany
    @JoinColumn(name = "list")
    private List<ParticipantEntity> participants;

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

    public List<ParticipantEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantEntity> participantEntities) {
        this.participants = participantEntities;
    }
}
