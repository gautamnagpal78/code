import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by gnagpal@eng.ucsd.edu
 * SID : A53203195
 */

public class Hangman {

    private static final char letters[] = {'A','B','C','D','E','F','G','H','I','J','K','L',
            'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static void main(String[] args) {

        Map<String,Float> probabilityMap = initWordProbabilities();

        //(a) : Print most and least frequent elements
        printSortedProbabilities(probabilityMap);

        //(b) : Fill up the table one by one by entering in the following format
        //word guessed so far
        char wordSoFar[] = {'-','-','U','-','-'};
        //incorrect guesses
        Character guesses[] = {'O','D','L','C'};

        //calculateMaxProbableCharacter(probabilityMap, wordSoFar, guesses);
    }

    /**
     * method to print the words sorted based on their probabilities of words
     * @param probabilityMap map of words and their probabilities
     */
    private static void printSortedProbabilities(Map<String,Float> probabilityMap) {

        List<Map.Entry<String, Float>> sortedList = sortByValue(probabilityMap);
        int listSize = sortedList.size();

//        System.out.println("Fifteen most frequent 5-letter words");
//        for(int i = 0; i < 15; i++){
//            System.out.println(sortedList.get(listSize - i - 1).getKey());
//        }

        System.out.println("Fourteen least frequent 5-letter words");
        for(int i = 0; i < 15; i++){
            System.out.println(sortedList.get(i).getKey() + " :: " + sortedList.get(i).getValue());
        }
    }

    /**
     * Compute most probable next character
     * @param probabilityMap map of words and their probabilities
     * @param wordSoFar Current status of word
     * @param guesses incorrect guesses
     */
    private static void calculateMaxProbableCharacter(Map<String,Float> probabilityMap,
                                                      char[] wordSoFar, Character[] guesses){

        char character = '#';
        double max = 0;
        List<Character> characterList = getCharSet(wordSoFar, guesses);
        float denominator = 0;

        //sigma(P(E|W = w) * P(W = w))
        for(Map.Entry<String, Float> wordMap : probabilityMap.entrySet()){
            denominator+=(matchEventsGivenWord(wordSoFar, wordMap.getKey(), guesses)*wordMap.getValue());
        }

        for(char letter : letters){
            float numerator = 0;
            double prob;
            if(characterList.contains(letter))
                prob = 0;
            else{
                //P(Li = l for i in {empty indices} | W = w) * P(E|W = w) * P(W = w)
                for(Map.Entry<String, Float> wordProbability : probabilityMap.entrySet()){
                    numerator+=(wordContainsCharacter(wordSoFar, letter, wordProbability.getKey()))
                            * wordProbability.getValue()
                            * matchEventsGivenWord(wordSoFar, wordProbability.getKey(), guesses);
                }

                //Final Computation
                prob = numerator/denominator;

            }
            if(prob > max){
                max = prob;
                character = letter;
            }
        }

        System.out.println(character + " " + Math.round( max * 10000.0 ) / 10000.0);

     }

    /**
     * Populate characters that are invalid
     * @param wordSoFar Current status of word
     * @param guesses incorrect guesses
     * @return characterSet
     */
    private static List<Character> getCharSet(char[] wordSoFar, Character[] guesses) {
        List<Character> charSet = new ArrayList<>();
        //All correctly guessed characters
        for (char c : wordSoFar) {
            if (c != '-') charSet.add(c);
        }
        //All incorrect guesses
        charSet.addAll(Arrays.asList(guesses));

        return charSet;
    }

    /**
     * method to compute P(Li = l for i in {empty indices} | W =w)
     * @param wordSoFar Current status of word
     * @param c letter to be searched for in w (word)
     * @param word word from dictionary
     * @return probability
     */
    private static int wordContainsCharacter(char[] wordSoFar, char c, String word){

        for(int i=0; i<wordSoFar.length; i++){
        //if the given character is available at an empty position in dictionary word
            if(wordSoFar[i]=='-' && word.charAt(i) == c)
                return 1;
        }

        return 0;
    }

    /**
     * method to calculate P(E|W = w)
     * @param wordSoFar Current status of word
     * @param word word from dictionary
     * @param guesses Incorrect guesses
     * @return probability
     */
    private static int matchEventsGivenWord(char wordSoFar[], String word, Character[] guesses){

        List<Character> charSet = getCharSet(wordSoFar, guesses);

        for(int i = 0; i<5; i++){
            //if the characters in dictionary word and in the incomplete word don't match
            if(wordSoFar[i] != '-' && (wordSoFar[i]!=word.charAt(i))){
                return 0;
            }
            //if the empty places in incomplete word contain an already guessed character
            if(wordSoFar[i] == '-' && charSet.contains(word.charAt(i))){
                return 0;
            }
        }

        return 1;
    }

    /**
     * The method reads from text file and populates the word probabilities
     * @return Map of word and its probability
     */
    private static Map<String, Float> initWordProbabilities() {
        Map<String, Integer> countMap = new HashMap<>();

        String pathToFile = "/Users/gnagpal/Desktop/explore/src/main/java/words.txt";
        int totalCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile)))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                int count = Integer.parseInt(sCurrentLine.split(" ")[1]);
                totalCount+=count;
                countMap.put(sCurrentLine.split(" ")[0], count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String,Float> probabilityMap = new HashMap<>();

        for(Map.Entry<String, Integer> entry : countMap.entrySet()){
            probabilityMap.put(entry.getKey(), ((float) entry.getValue())/totalCount);
        }

        return probabilityMap;


    }

    /**
     * The method returns a list of (Word, Probability) sorted by Probability
     * @param unsortedMap unsorted map of (Word, Probability)
     * @return sorted list based on probability of word
     */
    private static List<Map.Entry<String, Float>> sortByValue(Map<String, Float> unsortedMap) {

        List<Map.Entry<String, Float>> list =
                new LinkedList<>(unsortedMap.entrySet());

        Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

        return list;
    }


}
