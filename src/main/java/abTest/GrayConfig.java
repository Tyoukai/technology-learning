package abTest;

import java.util.Random;

import com.google.common.collect.Range;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-18
 */
public class GrayConfig {
    private int totalPercent;
    private Range<Long> range;

    private static final String SEMICOLON = ";";
    private static final String HORIZONTAL_BAR = "-";


    public GrayConfig(int totalPercent, long start, long end) {
        this.totalPercent = totalPercent;
        range = Range.closed(start, end);
    }

    public GrayConfig(String grayConfigStr) {
        String[] configStr = grayConfigStr.split(SEMICOLON);
        String[] nums = configStr[1].split(HORIZONTAL_BAR);
        totalPercent = Integer.parseInt(configStr[0]);
        range = Range.closed(Long.parseLong(nums[0]), Long.parseLong(nums[1]));
    }

    /**
     * 是否命中灰度策略
     *
     * @param grayKey 灰度key
     * @return
     */
    public boolean hitGray(long grayKey) {
        grayKey = Math.abs(grayKey) % totalPercent;
        return range.contains(grayKey);
    }

    public int getTotalPercent() {
        return totalPercent;
    }

    public void setTotalPercent(int totalPercent) {
        this.totalPercent = totalPercent;
    }

    public Range<Long> getRange() {
        return range;
    }

    public void setRange(Range<Long> range) {
        this.range = range;
    }
}
