package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reponsitory.DictionaryReponsitoryImpl;
import reponsitory.IDictionaryReponsitory;

@Service
public class DictionaryServiceImpl implements IDictionaryService{


    IDictionaryReponsitory dictionaryReponsitory = new DictionaryReponsitoryImpl();

    @Override
    public String getWord(String findByWord) {
        return dictionaryReponsitory.getWord(findByWord);
    }
}
