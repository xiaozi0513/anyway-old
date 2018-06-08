import java.util.HashMap;
import java.util.Map;

/**
 * @author: wang_hui
 * @date: 2018/6/4 下午4:25
 * @since:
 */
public class Test {
    public static void main(String[] args){
//        List<String> metaList = new LinkedList<>();
//        List<String> metaList1 = new LinkedList<>(Arrays.asList("category","topic","author","group","user","game","tag","post"));
//        int index = 0;
//        metaList.add(++index, "category");
//        metaList.add(index++, "topic");
//        metaList.add(1, "author");
//        System.out.println(Arrays.toString(metaList.toArray()));
        Map<String, Object> map = new HashMap<>();
        System.out.println(map.get("total")==null);
    }
}
