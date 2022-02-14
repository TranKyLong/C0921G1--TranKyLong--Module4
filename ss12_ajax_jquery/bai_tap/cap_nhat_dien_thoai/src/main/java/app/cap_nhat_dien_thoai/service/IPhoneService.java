package app.cap_nhat_dien_thoai.service;

import app.cap_nhat_dien_thoai.model.Phone;

import java.util.List;
import java.util.Optional;

public interface IPhoneService {
    void save(Phone phone);

    List<Phone> findAll();

    void delete(Integer id);

    Optional<Phone> findById(Integer id);
}
