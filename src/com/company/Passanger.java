package com.company;

public class Passanger implements Comparable {
    private int memberLevel;
    private int memberDays;

    public Passanger(int level, int days){
        memberDays= days;
        memberLevel= level;
    }

    @Override
    public int compareTo(Object o) {
        Passanger p = (Passanger) o;
        if(memberLevel > p.memberLevel)
            return -1;
        else if(memberLevel < p.memberLevel)
            return 1;
        else{
            if(memberDays > p.memberDays)
                return -1;
            if(memberDays < p.memberDays)
                return 1;
            else return 0;
        }

    }

    public int getMemberLevel(){
        return memberLevel;
    }
    public int getMemberDays(){
        return memberDays;
    }


}
