package app.service;

import app.model.ToKhaiYTe;
import app.reponsitory.IToKhaiYTeReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ToKhaiYTeServiceImpl implements IToKhaiYTeService {
    @Autowired
    IToKhaiYTeReponsitory toKhaiYTe;

    @Override
    public ToKhaiYTe getToKhaiYTe() {
        return toKhaiYTe.getToKhaiYTe();
    }

}
