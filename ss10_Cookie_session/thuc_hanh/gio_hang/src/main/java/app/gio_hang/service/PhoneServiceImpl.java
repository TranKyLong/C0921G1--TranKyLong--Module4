package app.gio_hang.service;

import app.gio_hang.model.Phone;
import app.gio_hang.reponsitory.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements IPhoneService {
    @Autowired
    IPhoneRepository iPhoneRepository;

    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return iPhoneRepository.findAll(pageable);
    }

    @Override
    public Phone findById(Integer id) {
        return iPhoneRepository.findById(id).get();
    }
}
