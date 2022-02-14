package app.quan_ly_dien_thoai.service;

import app.quan_ly_dien_thoai.model.Phones;
import app.quan_ly_dien_thoai.reponsitory.IPhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPhoneServiceImpl implements IPhoneService {
    @Autowired
    IPhonesRepository iPhonesRepository;

    @Override
    public List<Phones> findAll() {
        return iPhonesRepository.findAll();
    }

    @Override
    public Phones save(Phones phones) {
        return iPhonesRepository.save(phones);
    }

    @Override
    public Phones savePhones(Phones phones) {
        return phones;
    }

    @Override
    public void delete(Integer id) {
        iPhonesRepository.deleteById(id);
    }

    @Override
    public Optional<Phones> findById(Integer id) {
        return iPhonesRepository.findById(id);
    }
}
