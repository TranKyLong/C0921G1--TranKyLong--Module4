package app.reponsitory;

import app.model.ToKhaiYTe;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ToKhaiYTeReponsitoryImpl implements IToKhaiYTeReponsitory {
    private static ToKhaiYTe toKhaiYTe;


    @Override
    public ToKhaiYTe getToKhaiYTe() {
        return toKhaiYTe;
    }

}
