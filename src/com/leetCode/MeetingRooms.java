package com.leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

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

        System.out.print(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(Interval[] intervals){
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        for(int i = 0; i < intervals.length-1; i++){
            if(intervals[i].end > intervals[i+1].start){
                return false;
            }
        }
        return true;
    }
}
