package app.cap_nhat_dien_thoai.service;

import app.cap_nhat_dien_thoai.model.Phone;
import app.cap_nhat_dien_thoai.reponsitory.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements IPhoneService {

    @Autowired
    IPhoneRepository iPhoneRepository;

    @Override
    public void save(Phone phone) {
        iPhoneRepository.save(phone);
    }

    @Override
    public List<Phone> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        iPhoneRepository.deleteById(id);
    }

    @Override
    public Optional<Phone> findById(Integer id) {
        return iPhoneRepository.findById(id);
    }
}
