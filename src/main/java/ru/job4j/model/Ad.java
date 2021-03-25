package ru.job4j.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String desc;
    private String brand;
    private String type;
    private String pic;
    private boolean sold;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User user;

    public Ad() {
    }

    public Ad(long id, String desc, String brand, String type, String pic, boolean sold, Date created, User user) {
        this.id = id;
        this.desc = desc;
        this.brand = brand;
        this.type = type;
        this.pic = pic;
        this.sold = sold;
        this.created = created;
        this.user = user;
    }

    public static Ad of(String desc, String brand, String type) {
        Ad ad = new Ad();
        ad.setDesc(desc);
        ad.setBrand(brand);
        ad.setType(type);
        ad.setDate(new Date(System.currentTimeMillis()));
        return ad;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Date getСreated() {
        return created;
    }

    public void setDate(Date created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", pic='" + pic + '\'' +
                ", sold=" + sold +
                ", created=" + created +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return id == ad.id &&
                sold == ad.sold &&
                Objects.equals(desc, ad.desc) &&
                Objects.equals(brand, ad.brand) &&
                Objects.equals(type, ad.type) &&
                Objects.equals(pic, ad.pic) &&
                Objects.equals(created, ad.created) &&
                Objects.equals(user, ad.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, brand, type, pic, sold, created, user);
    }
}
