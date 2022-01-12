package app.reponsitory;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryReponsitoryImpl implements IDictionaryReponsitory {
    private static Map<String, String> dictionaryMap;

    static {
        dictionaryMap = new HashMap<>();
        dictionaryMap.put("mouse", "con chuột");
        dictionaryMap.put("computer", "máy tính");
        dictionaryMap.put("drink", "uống");
        dictionaryMap.put("bug", "con bọ");

    }

    @Override
    public String findByWord(String word) {
        for (Map.Entry<String, String> entry : dictionaryMap.entrySet()) {
            if (word.equals(entry.getKey())) {
                return entry.getValue();
            }


        }
        return "NOT FOUND";
    }
}
