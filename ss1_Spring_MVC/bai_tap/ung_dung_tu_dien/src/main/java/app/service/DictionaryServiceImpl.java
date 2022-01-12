package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.reponsitory.DictionaryReponsitoryImpl;
import app.reponsitory.IDictionaryReponsitory;

@Service
public class DictionaryServiceImpl implements IDictionaryService{
//
    @Autowired
    IDictionaryReponsitory dictionaryReponsitory;
//    IDictionaryReponsitory dictionaryReponsitory = new DictionaryReponsitoryImpl();

    @Override
    public String findByWord(String word) {
        return dictionaryReponsitory.findByWord(word);
    }
}
