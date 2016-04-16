package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-29.
 * @Discreption
 */
public class Interval {
    int start;
    int end;

    Interval(){
        this.start = 0;
        this.end = 0;
    }

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
