package setandmap;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author xuepipi
 */
public class FileOperation {

    /**
     * 读取文件名为fileName的内容，并将其中所含的所有词语放进words中
     *
     * @param fileName 文件名
     * @param words    收集词汇
     * @return true or false
     */
    public static boolean readFile(String fileName, ArrayList<String> words) {
        if (fileName == null || words == null) {
            System.out.println("fileName or words is null");
            return false;
        }

        // 文件读取
        Scanner scanner;

        try {
            File file = new File(fileName);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("Can't open " + fileName);
            return false;
        }

        /**
         * 简单分词
         */
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }

            }
        }
        return true;

    }

    /**
     * 找寻从start开始第一个字母字节的位置
     *
     * @param s s
     * @param start    start
     * @return index
     */
    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }

        }
        return s.length();
    }
}
