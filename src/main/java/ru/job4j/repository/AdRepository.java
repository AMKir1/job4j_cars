package ru.job4j.repository;

import ru.job4j.hibernate.Hibernate;
import ru.job4j.model.Ad;
import java.util.List;

public class AdRepository {

    Hibernate hb = new Hibernate();

    public List<Ad> lastDay() {
        return hb.get(s -> s.createQuery("From Ad a Where created >= current_date()")).list();
    }

    public List<Ad> withPic() {
        return hb.get(s -> s.createQuery("From Ad a Where pic != null")).list();
    }

    public List<Ad> byBrand(String brand) {
        return hb.get(s -> s.createQuery("From Ad a Where brand != :brand"))
                .setParameter("brand", brand)
                .list();
    }

}
