package com.zero.word.segment.algorithm;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zero
 * @Date: 2020/2/20 17:09
 * @Description:
 */
public class BackwardLongestSegmentTest {

    @Test
    public void testStage1() {
        BackwardLongestSegment segment = new BackwardLongestSegment();
        Assert.assertEquals("i like samsung mobile", String.join(" ", segment.segment("ilikesamsungmobile")));
        Assert.assertEquals("i like ice cream and man go", String.join(" ", segment.segment("ilikeicecreamandmango")));
    }

    @Test
    public void testStage2() {
        List<String> userDictionary = Arrays.asList(new String[]{
                "i", "like", "sam", "sung", "mobile", "icecream", "man", "go", "mango"
        });
        BackwardLongestSegment segment = new BackwardLongestSegment();
        Assert.assertEquals("i like samsung mobile", String.join(" ", segment.segment("ilikesamsungmobile", userDictionary)));
        Assert.assertEquals("i like icecream and mango", String.join(" ", segment.segment("ilikeicecreamandmango", userDictionary)));
    }

    @Test
    public void testStage3() {
        List<String> userDictionary = Arrays.asList(new String[]{
                "i", "like", "sam", "sung", "mobile", "icecream", "man", "go", "mango"
        });
        BackwardLongestSegment segment = new BackwardLongestSegment();
        Assert.assertEquals("i like mobile", String.join(" ", segment.segmentWithOnlyUserDictionary("ilikesamsungmobile", userDictionary)));
        Assert.assertEquals("i like icecream mango", String.join(" ", segment.segmentWithOnlyUserDictionary("ilikeicecreamandmango", userDictionary)));
    }
}
