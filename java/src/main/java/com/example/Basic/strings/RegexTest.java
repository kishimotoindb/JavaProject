package com.example.Basic.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BigFaceBear on 2018.03.07
 */

public class RegexTest {
    static String regex = "[`~!@#$%^&*()_\\-+=<>?:\"{}|,.;'\\[\\]·~！@#￥%……&*（）——\\-+={}|《》？：“”【】、；‘’，。、]";

    public static void main(String[] args) {
        String string = "/,.799/";

        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(string);
        System.out.println(matcher.find());
    }
}
