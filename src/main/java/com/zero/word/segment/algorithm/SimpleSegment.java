package com.zero.word.segment.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: 蛇藨(shebiao)
 * @Date: 2020/2/20 17:03
 * @Description:
 */
public class SimpleSegment {

    private static List<String> INTERN_DICTIONARY = new LinkedList<>();

    static {
        INTERN_DICTIONARY.add("and");
    }

    public List<String> segment(String content){
        return segment(content, Collections.emptyList());

    }

    public List<String> segment(String content, Collection<String> userDictionary){
        List<String> result = new LinkedList<>();
        Set<String> dictionary = new HashSet<>();
        dictionary.addAll(INTERN_DICTIONARY);
        dictionary.addAll(userDictionary);

        int len = content.length();
        int start = 0;
//        int end = 1;
        for (int i = 1 ; i < len; i++){
            String check = content.substring(start, i);
            if(dictionary.contains(check)){
                result.add(check);
                start = i;
            }
        }
        return result;
    }


}
