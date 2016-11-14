//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * Created by gnagpal on 10/14/16.
// */
//public class Geans {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int len = scanner.nextInt();
//        scanner.nextLine();
//        String s = scanner.nextLine();
//        System.out.println(s);
//        Map<Character, Integer> countMap = new HashMap<>();
//        int arr[] = new int[4];
//        for(int i = 0; i < len; i++){
//            if(countMap.containsKey(s.charAt(i))) countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
//            else countMap.put(s.charAt(i), 1);
//        }
//
//        Map<Character, Integer> incountMap = new HashMap<>();
//
//        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
//            if(entry.getValue() > (len/4)){
//                incountMap.put(entry.getKey(), entry.getValue() - (len/4));
//            }
//        }
//
//        for(Map.Entry<Character, Integer> entry : incountMap.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//
//        int j = 0;
//        for(int i = 0; i<len; i++){
//            while(j)
//        }
//    }
//}
