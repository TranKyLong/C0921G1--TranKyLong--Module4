package reponsitory;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryReponsitoryImpl implements IDictionaryReponsitory {
  private static Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("computer", "máy tính");
        dictionary.put("bug", "con bọ");
        dictionary.put("mouse", "con chuột");
        dictionary.put("drink", "uống");
        dictionary.put("table", "cái bàn");
    }

//    @Override
//    public Map<String, String> getAll() {
//        return dictionary;
//    }

    @Override
    public  String getWord (String findByWord) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (findByWord.equals(entry.getKey())) {
                return entry.getValue();
            }
        }


       return "not found";
    }
}
