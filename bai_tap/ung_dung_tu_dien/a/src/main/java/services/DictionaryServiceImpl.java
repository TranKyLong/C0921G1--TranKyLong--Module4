package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reponsitory.IDictionaryReponsitory;

@Service
public class DictionaryServiceImpl implements IDictionaryService{

    @Autowired
    IDictionaryReponsitory dictionaryReponsitory;

    @Override
    public String getWord(String findByWord) {
        return dictionaryReponsitory.getWord(findByWord);
    }
}
