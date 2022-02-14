package app.quan_ly_dien_thoai.service;

import app.quan_ly_dien_thoai.model.Phones;

import java.util.List;
import java.util.Optional;

public interface IPhoneService {
    List<Phones> findAll();

    Phones save(Phones phones);

    Phones savePhones(Phones phones);

    void delete(Integer id);

    Optional<Phones> findById(Integer id);


}
