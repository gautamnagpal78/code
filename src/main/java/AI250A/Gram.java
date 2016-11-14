package AI250A;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Gram {
    static  Map<String, Integer> countMap = new HashMap<>();
    static List<String> tokenList = new ArrayList<String>();
    static Map<String, Map<String, Integer>> bigram = new HashMap<>();
    static Map<String,Float> probabilityMap = new HashMap<>();


    public static void main(String[] args) throws FileNotFoundException {
        String pathToToken = "/Users/gnagpal/Desktop/explore/src/main/java/AI250A/Token";
        String pathToUnigram = "/Users/gnagpal/Desktop/explore/src/main/java/AI250A/Unigram";
        String pathToBigram = "/Users/gnagpal/Desktop/explore/src/main/java/AI250A/Bigram";
        int totalCount = 0;
        BufferedReader token = new BufferedReader(new FileReader(pathToToken));
        BufferedReader unigram = new BufferedReader(new FileReader(pathToUnigram));
        while(true){

            try {
                String tokenVal = token.readLine();
                String tokenCount = unigram.readLine();

                if(tokenVal == null || tokenCount == null){
                    break;
                }

                tokenList.add(tokenVal);
                countMap.put(tokenVal, Integer.parseInt(tokenCount));
                totalCount+=Integer.parseInt(tokenCount);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //PART A
        for(String tokenString : tokenList){
            probabilityMap.put(tokenString, ((float) (countMap.get(tokenString))/totalCount));
            if(tokenString.matches("A(.*)")){
                System.out.println(tokenString + " " + probabilityMap.get(tokenString));
            }
        }



        try(BufferedReader bigramReader = new BufferedReader(new FileReader(pathToBigram))){
            String sCurrentLine;

            while ((sCurrentLine = bigramReader.readLine()) != null) {
                String word1 = tokenList.get(Integer.parseInt(sCurrentLine.split("\t")[0]) - 1);
                String word2 = tokenList.get(Integer.parseInt(sCurrentLine.split("\t")[1]) - 1);
                Integer count = Integer.parseInt(sCurrentLine.split("\t")[2]);
                if(bigram.containsKey(word1)){
                    bigram.get(word1).put(word2, count);
                }else{
                    Map<String, Integer> map = new HashMap<>();
                    map.put(word2, count);
                    bigram.put(word1, map);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //PART B
        //Most likely words to follow 'THE'
        mostLikely("THE");

        //PART C
        //Log-likelihood unigram model
        System.out.println((Math.log(computeLogLikelihoodUnigram("Last week the stock market fell by one hundred points"))));
        System.out.println((Math.log(computeLogLikelihoodBigram("Last week the stock market fell by one hundred points"))));


        System.out.println((Math.log(computeLogLikelihoodUnigram("The nineteen officials sold fire insurance"))));
        System.out.println((Math.log(computeLogLikelihoodBigram("The nineteen officials sold fire insurance"))));

        //PART - D
        //Mixture model
        mixture("The nineteen officials sold fire insurance");
    }

    private static void mostLikely(String key) {
        Map<String, Integer> mapOfWords = bigram.get(key);
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(mapOfWords.entrySet());

        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        int i = 0;
        for(Map.Entry<String, Integer> entry : list){
            if(i++ < 5){
                System.out.println(((float) entry.getValue()/countMap.get(key)));
            } else break;
        }

    }

    private static float computeLogLikelihoodUnigram(String sentence){
        String words[] = sentence.toUpperCase().split(" ");
        float answer = 1;
        for(String word : words){
            answer*=(probabilityMap.get(word));
        }

        return answer;
    }

    private static float computeLogLikelihoodBigram(String sentence){
        sentence = sentence.toUpperCase();
        sentence = "<s> " + sentence;
        String words[] = sentence.split(" ");
        float answer = 1;
        for(int i = 0; i < words.length - 1; i++){
            if(!bigram.get(words[i]).containsKey(words[i+1])){
                System.out.println(words[i] + " " + words[i+1]);
                return 0;
            }

            answer*=((float) (bigram.get(words[i]).get(words[i + 1])) / countMap.get(words[i]));
        }


        return answer;
    }

    public static void mixture(String sentence){
        int lambda = 0;
        sentence = sentence.toUpperCase();
        sentence = "<s> " + sentence;
        String words[] = sentence.split(" ");
        List<Float> answer = new ArrayList<>();
        List<Float> lambdaList = new ArrayList<>();
        List<Float> pw1 = new ArrayList<>();
        List<Float> pw1givenw = new ArrayList<>();

        for(int i = 1; i < words.length; i++){
            float unigram = probabilityMap.get(words[i]);
            float bigval  = 0;
            if(bigram.get(words[i-1]).containsKey(words[i])){
                bigval = ((float) (bigram.get(words[i-1]).get(words[i])) / countMap.get(words[i-1]));
            }

            pw1.add(unigram);
            pw1givenw.add(bigval);
        }

        float max = -10000000;
        float lambdaMax = 0;
        while(lambda < 100000){
            float val = 1;
            for(int i = 0; i < pw1.size(); i++) {
                val *= (1-((float)(lambda/100000.0)))*pw1.get(i) + (float)(lambda/100000.0)*pw1givenw.get(i);
            }
            if(val > max){
                max = val; lambdaMax = lambda;
            }
            answer.add(val);
            lambdaList.add((float) (lambda / 100000.0));
            lambda += 1;
        }

//        for(float la : lambdaList ){
//            System.out.print(la + ", ");
//        }
//
//        System.out.println();
//        for(float va : answer ){
//            System.out.print(Math.log(va) + ", ");
//        }
        System.out.println("Approximate Value of lambda =  " + Math.log(max) + " " + (float) (lambdaMax/100000));
    }

}
