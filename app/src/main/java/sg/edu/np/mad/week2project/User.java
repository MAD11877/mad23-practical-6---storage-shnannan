package sg.edu.np.mad.week2project;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String description;
    boolean followed;
    int id;

    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}
