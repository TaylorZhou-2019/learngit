package springboot.login.bean;

import javax.persistence.*;

@Entity
@Table(name = "DangerList")
public class DangerList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;
    //    危险等级，low-与身份证照片不一致，high-嫌疑人库匹配记录
    @Column(name = "dangerLevel")
    private String dangerLevel;
    //    嫌疑人编号ID
    @Column(name = "SuspiciousID")
    private String SuspiciousID;
    //    记录日期
    @Column(name = "date")
    private String date;
    //    是否已处理
    @Column(name = "settle")
    private String settle;

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

    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public String getSuspiciousID() {
        return SuspiciousID;
    }

    public void setSuspiciousID(String suspiciousID) {
        SuspiciousID = suspiciousID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSettle() {
        return settle;
    }

    public void setSettle(String settle) {
        this.settle = settle;
    }




}
