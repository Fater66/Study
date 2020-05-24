package Tool;

import java.util.regex.Pattern;

public class RegularExpression {
    /*
    \d:匹配0-9
    *：零次或多次匹配前面的字符或子表达式。例如，zo* 匹配"z"和"zoo"。* 等效于 {0,}。
    +:一次或多次匹配前面的字符或子表达式。例如，"zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+ 等效于 {1,}。
    ?:零次或一次匹配前面的字符或子表达式。例如，"do(es)?"匹配"do"或"does"中的"do"。? 等效于 {0,1}。
    [a-z]:字符范围。匹配指定范围内的任何字符。例如，"[a-z]"匹配"a"到"z"范围内的任何小写字母。
    [^a-z]:反向范围字符。匹配不在指定的范围内的任何字符。例如，"[^a-z]"匹配任何不在"a"到"z"范围内的任何字符。
    x|y:匹配 x 或 y。例如，'z|food' 匹配"z"或"food"。'(z|f)ood' 匹配"zood"或"food"。
    [xyz]:字符集。匹配包含的任一字符(只要又一个就行)。例如，"[abc]"匹配"plain"中的"a"。
    [^xyz]:反向字符集。匹配未包含的任何字符。例如，"[^abc]"匹配"plain"中"p"，"l"，"i"，"n"。
     */
    public static void main(String[] args) {
        String content = "Adds ";
        String pattern = "Ad.*";

        boolean isFind = Pattern.matches(pattern,content);
        System.out.println(content + "内有没有对应的"+ pattern+" "+isFind);
    }
}
