package guava;

import com.google.common.collect.Range;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-03-23
 */
public class RangeTest {
    public static void main(String[] args) {
        System.out.println(Range.closed(1, 10));
        System.out.println(Range.closedOpen(1, 10));
        System.out.println(Range.open(1, 10));
        System.out.println(Range.openClosed(1, 10));

        System.out.println(Range.closed(1, 10).lowerEndpoint());
        System.out.println(Range.open(1, 10).upperEndpoint());
        System.out.println(Range.closed(1, 10).hasLowerBound());
        System.out.println(Range.open(1, 10).hasLowerBound());
    }
}
