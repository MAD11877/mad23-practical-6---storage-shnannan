package sg.edu.np.mad.week2project;

public class User {
    String name;
    String description;
    boolean followed;
    int id;
    public User(String userName, String userDescription, boolean userFollowed) {
        this.name = userName;
        this.description = userDescription;
        this.followed = userFollowed;
    }
    public User() {
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
