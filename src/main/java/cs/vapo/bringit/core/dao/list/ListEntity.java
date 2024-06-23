package cs.vapo.bringit.core.dao.list;

import cs.vapo.bringit.core.dao.item.ItemEntity;
import cs.vapo.bringit.core.dao.participant.ParticipantEntity;
import cs.vapo.bringit.core.dao.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bringit_core_list")
public class ListEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "public_id", nullable = false, unique = true)
    private String publicId;

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private UserEntity owner;

    @Column(name = "list_title")
    private String title;

    @Column(name = "event_ts")
    private LocalDate eventDate;

    @Column(name = "item_count")
    private int itemCount;

    @OneToMany
    @JoinColumn(name = "list")
    private List<ParticipantEntity> participants;

    @OneToMany(mappedBy = "list")
    private List<ItemEntity> items;

    /**
     * This method will populate the publicId field before creation
     */
    @PrePersist
    private void generatePublicId() {
        if (StringUtils.isBlank(this.publicId)) {
            this.publicId = UUID.randomUUID().toString();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
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

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
