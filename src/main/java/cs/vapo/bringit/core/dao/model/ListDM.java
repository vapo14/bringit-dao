package cs.vapo.bringit.core.dao.model;

import java.time.LocalDate;
import java.util.List;

public class ListDM {

    private long id;

    private String publicId;

    private UserDM owner;

    private String title;

    private LocalDate eventDate;

    private int itemCount;

    private List<ParticipantDM> participants;

    private List<ItemDM> items;

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

    public UserDM getOwner() {
        return owner;
    }

    public void setOwner(UserDM owner) {
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

    public List<ItemDM> getItems() {
        return items;
    }

    public void setItems(List<ItemDM> items) {
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
