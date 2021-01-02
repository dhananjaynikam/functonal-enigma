package com.leetCode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class AirportConstruction {

    /*
     * Complete the 'getMinGates' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY landingTimes
     *  2. INTEGER_ARRAY takeOffTimes
     *  3. INTEGER maxWaitTime
     *  4. INTEGER initialPlanes
     */
    public static void main(String args[]){

    }

    public static int getMinGates(List<Integer> landingTimes, List<Integer> takeOffTimes, int maxWaitTime, int initialPlanes) {
        if(landingTimes.size() == 0 && takeOffTimes.size() != 0){
            if(initialPlanes > takeOffTimes.size()){
                return initialPlanes;
            }
        }
        if(takeOffTimes.size() == 0 && landingTimes.size() != 0){
            return landingTimes.size()+initialPlanes;
        }
        if(takeOffTimes.size() == 0 && landingTimes.size() == 0)
            return initialPlanes;

        for(int i = 0; i < landingTimes.size();i++){
            int landing = landingTimes.get(i);
            int mins = landing %100;
            if(mins + maxWaitTime >= 60 ){
                int temp2 = (landing/100) + 1;
                landing = temp2*100 + (mins+maxWaitTime)%60;
            }else{
                landing += maxWaitTime;
            }
            landingTimes.set(i, landing);
        }

        int gates = initialPlanes;
        int end = 0;
        try{
            for(int i = 0; i < landingTimes.size();i++){
                if(landingTimes.get(i) < takeOffTimes.get(end)){
                    gates++;
                }else{
                    end ++;
                }
            }
        }catch (IndexOutOfBoundsException error){
            gates = gates + landingTimes.size()-takeOffTimes.size();
        }
        return gates;
    }

}

