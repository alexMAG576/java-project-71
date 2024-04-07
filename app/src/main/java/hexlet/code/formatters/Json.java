package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.List;

public class Json {
    public static String json(List<Map<String, Object>> listForFormatting) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        var result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listForFormatting);
        return result;
    }
}
