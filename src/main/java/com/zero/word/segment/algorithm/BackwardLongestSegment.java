package com.zero.word.segment.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 逆向最长匹配的分词算法
 * @Auther: zero
 * @Date: 2020/2/20 17:03
 * @Description:
 */
public class BackwardLongestSegment {

    /**
     * 内置用户词典
     */
    private static List<String> INTERN_DICTIONARY = new LinkedList<>();

    static {
        String[] words = new String[]{
                "i", "like", "sam", "sung","samsung", "mobile", "ice", "cream", "man", "go", "and"
        };
        INTERN_DICTIONARY.addAll(Arrays.asList(words));
    }

    public List<String> segment(String text) {
        return segmentBackwardLongest(text, new LinkedList<>());
    }

    public List<String> segment(String text, Collection<String> userDictionary) {
        return segmentBackwardLongest(text, userDictionary);
    }

    public List<String> segmentWithOnlyUserDictionary(String text, Collection<String> userDictionary) {
        List<String> wordList = segmentBackwardLongest(text, userDictionary);
        return wordList.stream().filter(w -> userDictionary.contains(w)).collect(Collectors.toList());
    }

    /**
     * 逆向最长匹配的分词算法
     *
     * @param text       待分词的文本
     * @param userDictionary 用户词典
     * @return 单词列表
     */
    private List<String> segmentBackwardLongest(String text, Collection<String> userDictionary) {
        List<String> wordList = new LinkedList<>();
        Set<String> dictionary = new HashSet<>();
        dictionary.addAll(INTERN_DICTIONARY);
        dictionary.addAll(userDictionary);
        for (int i = text.length() - 1; i >= 0; ) {
            String longestWord = text.substring(i, i + 1);
            for (int j = 0; j <= i; ++j) {
                String word = text.substring(j, i + 1);
                if (dictionary.contains(word)) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
            wordList.add(0, longestWord);
            i -= longestWord.length();
        }
        return wordList;
    }

}
