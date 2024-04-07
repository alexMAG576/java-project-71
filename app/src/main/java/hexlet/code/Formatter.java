package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Formatter {
    public static String formatter(List<Map<String, Object>> dataForFormatting, String format)
            throws Exception {
        List<Map<String, Object>> tempList = new ArrayList<>(dataForFormatting);
        switch (format) {
            case "plain" -> {
                return Plain.plain(tempList);
            }
            case "json" -> {
                return Json.json(tempList);
            }
            default -> {
                return Stylish.stylish(tempList);
            }
        }
    }
}
