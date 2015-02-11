package colin.core.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/1/13.
 */
@Entity
@Table(name = "userentity")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String userPassword;
    @Column(name = "level")
    private int level;
    @Column(name = "enabled")
    private int enabled;

    public String getUsernamecn() {
        return usernamecn;
    }

    public void setUsernamecn(String usernamecn) {
        this.usernamecn = usernamecn;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "usernamecn")

    private String usernamecn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
