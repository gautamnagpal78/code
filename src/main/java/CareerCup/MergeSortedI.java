package CareerCup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnagpal on 10/23/16.
 */
public class MergeSortedI {
    public static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlap(Interval b){
            if(this.end >= b.start) return true;
            else return false;
        }

        public Interval merge(Interval b){
            return new Interval(Math.min(this.start, b.start), Math.max(this.end,b.end));
        }
        public int compare(Interval b){
            if(this.start < b.start) return -1;
            else if (this.start > b.start) return 1;
            else return 0;
        }

    }
    public static void main(String[] args) {
        List<Interval> arr1 = new ArrayList<>();
        List<Interval> arr2 = new ArrayList<>();
        List<Interval> arr3 = new ArrayList<>();
        List<Interval> arr4 = new ArrayList<>();

        arr1.add(new Interval(3,4));
        arr1.add(new Interval(17,25));
        arr1.add(new Interval(58,73));

        arr2.add(new Interval(6,18));
        arr2.add(new Interval(40,47));

        //arr3.add(arr1.get(0));
        int a = 0;
        int b = 0;
        while(a < arr1.size() && b < arr2.size() ){
            if(arr1.get(a).compare(arr2.get(b)) == 0){
                arr3.add(arr1.get(a));
                a++;b++;
            }
            else if(arr1.get(a).compare(arr2.get(b)) == 1){
                arr3.add(arr2.get(b++));
            }
            else{
                arr3.add(arr1.get(a++));
            }

        }

        if(a < arr1.size()){
            while(a<arr1.size()) arr3.add(arr1.get(a++));
        }


        if(b < arr2.size()){
            while(b<arr2.size()) arr3.add(arr2.get(b++));
        }

        for(Interval x : arr3){
            System.out.println(x.start + " " + x.end);
        }

        Interval last = arr3.get(0);
        int index = 0;
        for(int i = 1; i < arr3.size(); i++){
            if(last.overlap(arr3.get(i))){
                last = arr3.get(i).merge(last);
            }else {
                arr4.add(last);
                last = arr3.get(i);
            }
        }
        arr4.add(last);

        for(Interval x : arr4){
            System.out.println(x.start + " " + x.end);
        }
    }
}
