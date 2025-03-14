package cs.vapo.bringit.core.dao.participant;


import cs.vapo.bringit.core.dao.list.ListEntity;
import cs.vapo.bringit.core.dao.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "participant_reg")
public class ParticipantEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "list", nullable = false)
    private ListEntity list;

    @ManyToOne
    @JoinColumn(name = "participant", nullable = false)
    private UserEntity participant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ListEntity getList() {
        return list;
    }

    public void setList(ListEntity list) {
        this.list = list;
    }

    public UserEntity getParticipant() {
        return participant;
    }

    public void setParticipant(UserEntity participant) {
        this.participant = participant;
    }
}
