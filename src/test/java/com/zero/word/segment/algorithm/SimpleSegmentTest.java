package com.zero.word.segment.algorithm;


import org.junit.Test;

import java.util.List;

/**
 * @Auther: 蛇藨(shebiao)
 * @Date: 2020/2/20 17:09
 * @Description:
 */
public class SimpleSegmentTest {

    @Test
    public void segment() {
        String text="ilikesamsungmobile";
        SimpleSegment simpleSegment = new SimpleSegment();
        List<String> segment = simpleSegment.segment(text);
        System.out.println(segment);
    }
}
