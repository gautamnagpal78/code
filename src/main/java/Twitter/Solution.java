package Twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gnagpal on 10/29/16.
 */
public class Solution {
    public static class Event implements Comparable{
        Date date;
        String event;
        int count;

        public Event(Date date, String event, int count) {
            this.date = date;
            this.event = event;
            this.count = count;
        }

        public String timestamp(){
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM");
            String formatted = format1.format(this.date.getTime());
            return formatted;
        }
        public String toStr(){
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM");
            String formatted = format1.format(this.date.getTime());
            return formatted + ',' + ' ' + event + ", " + count;
        }

        public String remain(){

            return ", " + event + ", " + count;
        }

        @Override
        public int compareTo(Object o) {
            Date compareQuantity = ((Event) o).date;

            //ascending order
            return this.date.compareTo(compareQuantity);
        }
    }

    public static int compareStrip(Date date1, Date date2){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        String formatted = format1.format(date1.getTime());
        String formatted2 = format1.format(date2.getTime());
        try {
            Date datem1 = new SimpleDateFormat("yyyy-MM").parse(formatted);
            Date datem2 = new SimpleDateFormat("yyyy-MM").parse(formatted2);
            return datem1.compareTo(datem2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String startEnd = bufferedReader.readLine();
        String []dates = startEnd.split(",\\s+");
        Date startDate = new SimpleDateFormat("yyyy-MM").parse(dates[0]);
        Date endDate = new SimpleDateFormat("yyyy-MM").parse(dates[1]);

        bufferedReader.readLine();
        String str;
        List<Event> op = new ArrayList<>();
        while((str = bufferedReader.readLine())!=null && !str.trim().equals("")){
            //System.out.println("dg");
            String []s = str.split(",\\s+");
            Event event = new Event(new SimpleDateFormat("yyyy-MM-dd").parse(s[0]), s[1], Integer.parseInt(s[2]));
            if(event.date.compareTo(startDate) >=0 && endDate.compareTo(event.date) >=0)
                op.add(event);
           // str = bufferedReader.readLine();
        }

        int counter = 0;
        if(op.size() == 0)
            System.out.println();
        Collections.sort(op);
        Date date = op.get(0).date;
        String ope = op.get(0).toStr();

        String timestamp = op.get(0).timestamp();

        int i;
        List<String> ap = new ArrayList<>();
        List<String> x = new ArrayList<>();
        ap.add(op.get(0).remain());

        for(i = 1; i < op.size(); i++){
            if(compareStrip(op.get(i).date,date) == 0){
                ap.add(op.get(i).remain());
               // ope = ope + ", " + op.get(i).event + ", " + op.get(i).count;
            }
            else{
                Collections.sort(ap);
                ap = util(ap);
                x.add(timestamp + String.join("",ap));
                date = op.get(i).date;
                timestamp = op.get(i).timestamp();
                ap.clear();
                ap.add(op.get(i).remain());
                //ope = op.get(i).toStr();

            }
        }
        //Collections.sort(ap);
        x.add(timestamp + String.join("",ap));

        Collections.reverse(x);
        for(String s : x) System.out.println(s);
    }

    private static List<String> util(List<String> ap) {
        List<String> out = new ArrayList<>();
        String var = ap.get(0).split(",\\s+")[1];
        int count  = Integer.parseInt(ap.get(0).split(",\\s+")[2]);
        for(int i = 1; i < ap.size(); i++){
            if(ap.get(i).split(",\\s+")[1].equals(var)){
                count+=Integer.parseInt(ap.get(i).split(",\\s+")[2]);
            }
            else{
                if(count>0)
                    out.add(", " + var+ ", " + count);
                var = ap.get(i).split(",\\s+")[1];
                count  = Integer.parseInt(ap.get(i).split(",\\s+")[2]);
            }
        }
        if(count > 0)
            out.add(", " + var+ ", " + count);
        return out;
    }
}