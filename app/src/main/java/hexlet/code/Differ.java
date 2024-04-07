package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.DataFormatException;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String endOfFile1 = filePath1.substring(filePath1.lastIndexOf(".") + 1);
        String endOfFile2 = filePath2.substring(filePath2.lastIndexOf(".") + 1);
        if (!endOfFile1.equals(endOfFile2)) {
            throw new DataFormatException("The files are of different types");
        }
        if (!endOfFile1.equals("json") && !endOfFile1.equals("yaml") && !endOfFile1.equals("yml")) {
            throw new DataFormatException("There are files of unknown format");
        }
        String linesOfFile1 = Files.readString(Paths.get(filePath1).toAbsolutePath().normalize());
        String linesOfFile2 = Files.readString(Paths.get(filePath2).toAbsolutePath().normalize());
        var file1InMapFormat = Parser.parse(linesOfFile1, endOfFile1);
        var file2InMapFormat = Parser.parse(linesOfFile2, endOfFile2);
        var resultOfComparedFiles = GenDiff.genDiff(file1InMapFormat, file2InMapFormat);
        return Formatter.formatter(resultOfComparedFiles, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
