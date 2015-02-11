package colin.core.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/12/24.
 */
@Entity
@Table(name = "aticleentity")
public class AticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aticleId", unique = true, nullable = false)
    private int aticleId;
    private String title;
    private String subhead;
    private String digest;
    private String content;
    private String crtime;
    private String cruser;
    private String urlSource;
    private String category;

    public int getAticleId() {
        return aticleId;
    }

    public void setAticleId(int aticleId) {
        this.aticleId = aticleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCrtime() {
        return crtime;
    }

    public void setCrtime(String crtime) {
        this.crtime = crtime;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getUrlSource() {
        return urlSource;
    }

    public void setUrlSource(String urlSource) {
        this.urlSource = urlSource;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
