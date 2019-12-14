package springboot.login.bean;

import javax.persistence.*;

@Entity
@Table(name = "Suspect")
public class Suspect {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    //    危险等级，low-与身份证照片不一致，high-嫌疑人库匹配记录
    @Column(name = "dangerLevel")
    private String dangerLevel;
    //    嫌疑人编号ID
    @Column(name = "SuspiciousID")
    private String SuspiciousID;
    //    记录日期
    @Column(name = "date")
    private String date;
    //    户籍地
    @Column(name = "local")
    private String local;
    //      家属电话
    @Column(name = "tel")
    private String tel;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }




}
