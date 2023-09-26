package cs.vapo.bringit.core.dao.model;

public class ItemDM {

    private String id;

    private String name;

    private String description;

    private int itemCount;

    private String image;

    private String assignee;

    private ListDM list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public ListDM getList() {
        return list;
    }

    public void setList(ListDM list) {
        this.list = list;
    }
}
