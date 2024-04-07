package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Objects;

public class GenDiff {

    public static Object replaceNullValueWithStringNull(Object object) {
        return object == null ? "null" : object;
    }

    public static List<Map<String, Object>> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> treeOfChanges = new ArrayList<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        keys.stream()
                .peek(o -> {
                    Map<String, Object> tempMap = new LinkedHashMap<>();
                    tempMap.put("key", o);
                    if (map1.containsKey(o)) {
                        tempMap.put("type of change", "delete");
                        tempMap.put("oldValue", replaceNullValueWithStringNull(map1.get(o)));
                    }
                    if (map2.containsKey(o)) {
                        tempMap.put("type of change", "add");
                        tempMap.put("newValue", replaceNullValueWithStringNull(map2.get(o)));
                    }
                    if (map1.containsKey(o) && map2.containsKey(o)) {
                        if (Objects.equals(replaceNullValueWithStringNull(map1.get(o)),
                                replaceNullValueWithStringNull(map2.get(o)))) {
                            tempMap.put("type of change", "nothing");
                        } else {
                            tempMap.put("type of change", "change");
                        }
                        tempMap.put("oldValue", replaceNullValueWithStringNull(map1.get(o)));
                        tempMap.put("newValue", replaceNullValueWithStringNull(map2.get(o)));
                    }
                    treeOfChanges.add(tempMap);
                })
                .toList();
        return treeOfChanges;
    }
}
