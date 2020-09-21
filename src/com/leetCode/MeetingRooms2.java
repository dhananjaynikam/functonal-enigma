package com.leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    static class Interval{
        int start;
        int end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String args[]){
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(35,45);
        intervals[2] = new Interval(50,55);

        System.out.print(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(Interval[] intervals){
        if(intervals.length == 0 || intervals == null){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
        minHeap.add(intervals[0]);
        for(int i = 1; i < intervals.length;i++){
            Interval current = intervals[i];
            Interval earliest = minHeap.remove();
            if(current.start >= earliest.end){
                earliest.end = current.end;
            }else{
                minHeap.add(current);
            }
            minHeap.add(earliest);
        }
        return minHeap.size();
    }
}
