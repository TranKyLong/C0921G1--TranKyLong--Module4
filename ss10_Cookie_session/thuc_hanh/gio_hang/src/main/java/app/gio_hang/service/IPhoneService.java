package app.gio_hang.service;

import app.gio_hang.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPhoneService {
    Page<Phone> findAll(Pageable pageable);

    Phone findById(Integer id);
}
