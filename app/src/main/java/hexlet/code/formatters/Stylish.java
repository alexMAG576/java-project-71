package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<String, Object>> listForFormatting) {
        StringBuilder formattedString = new StringBuilder("{\n");
        listForFormatting.forEach(map -> {
            switch (map.get("type of change").toString()) {
                case "add" -> formattedString
                        .append(String.format("  + %s: %s\n", map.get("key"), map.get("newValue")));
                case "delete" -> formattedString
                        .append(String.format("  - %s: %s\n", map.get("key"), map.get("oldValue")));
                case "nothing" -> formattedString
                        .append(String.format("    %s: %s\n", map.get("key"), map.get("oldValue")));
                case "change" -> {
                    formattedString.append(String.format("  - %s: %s\n", map.get("key"), map.get("oldValue")));
                    formattedString.append(String.format("  + %s: %s\n", map.get("key"), map.get("newValue")));
                }
                default -> { }
            }
        });
        return formattedString.append("}").toString();
    }
}
