package springboot.login.bean;

import javax.persistence.*;

@Entity
@Table(name = "record")
public class Record {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    //    与身份证照片是否一致
    @Column(name = "ismatch")
    private int ismatch;

    //    是否在嫌疑人库中匹配到嫌疑人
    @Column(name = "suspect")
    private int suspect;

    //    记录日期
    @Column(name = "date")
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getisMatch() {
        return ismatch;
    }

    public void setisMatch(int ismatch) {
        this.ismatch = ismatch;
    }

    public int getSuspect() {
        return suspect;
    }

    public void setSuspect(int suspect) {
        this.suspect = suspect;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}