package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    
    
    /** Inserts toInsert after each String in stringList
    *  that contains the letter "i"
    *
    *  DOES mutate (modify) elements of stringList.
    *  PRECONDITION: stringList.size() > 0, toInsert.length() > 0
    *
    *  @param stringList  original arraylist of Strings
    *  @param str String to insert
    */
    public static ArrayList<String> insertAfterI(ArrayList<String> stringList, String str){
        ArrayList<String> after = stringList;
        for(int i = 0; i < after.size(); i ++) {
            for(int j = 0; j < after.get(i).length(); j ++) {
                if(after.get(i).substring(j, j + 1).equals("i")) {
                    after.add(i + 1, str);
                    i ++;
                }
            }
        }
       return after;
    }



    /** Removes all Strings from stringList that have a length of 3
   *
   *  DOES mutate (modify) elements of stringList.
   *  PRECONDITION: stringList.size() > 0
   *
   *  @param stringList  original arraylist of Strings
   */
    public static ArrayList<String> removeThree(ArrayList<String> stringList){
        for(int i = 0; i < stringList.size(); i ++) {
            if(stringList.get(i).length() == 3) {
                stringList.remove(i);
                i --;
            }
        }
        return stringList;
    }



    /** Returns an ArrayList with all elements of arr reversed
   *
   *  Does NOT mutate (modify) elements in intList.
   *  PRECONDITION: intList.size() > 0
   *
   *  @param intList  original array of integers
   */
    public static ArrayList<Integer> reverseArray(int[] intList){
        ArrayList<Integer> reversed = new ArrayList<Integer>();
        for(int i = intList.length - 1; i >= 0; i --) {
            reversed.add(intList[i]);
        }
        return reversed;
    }



    /** Appends an uppercase version of each string to the end of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0,
     *                 all words in wordList are initially lowercase
     *
     *  @param wordList  arraylist of Strings
     */
    public static ArrayList<String> duplicateUpperEnd(ArrayList<String> wordList){
        int currentLength = wordList.size();
        for(int i = 0; i < currentLength; i ++) {
            wordList.add(wordList.get(i).toUpperCase());
        }
        return wordList;
    }



    /** Returns an arraylist of Strings that represents the input sentence parsed
   *  into separate words, using a single space (" ") as the delimiter
   *
   *  For example, if sentence = "This is my sentence!"
   *  this method return the arraylist: [This, is, my, sentence!]
   *
   *  PRECONDITION: sentence does not end with a space and each word is
   *                separated by exactly one space
   *
   *  @param sentence  the input String
   *  @return  new arraylist of Strings containing the words of sentence
   */

    public static ArrayList<String> parseSentence(String sentence){
        ArrayList<String> parsed = new ArrayList<String>();
        while(sentence.indexOf(" ") >= 0) {
            parsed.add(sentence.substring(0, sentence.indexOf(" ")));
            sentence = sentence.substring(sentence.indexOf(" ") + 1);
        }
        parsed.add(sentence);
        return parsed;
    }



    /** Moves all words in wordList that begin with "b" to the front of
   *  wordList; all "b" words that are moved should appear in the same order
   *  in the modified arrayList as they did before being moved
   *
   *  For example, this method will take a wordList:
   *  ["apple", "banana", "cherry", "donut", "Bagel", "danish", "berry", "baguette", "soda"]
   *  and modify it to
   *  ["banana", "Bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
   *
   *  DOES mutate (modify) elements in wordList
   *  PRECONDITIONS: - wordList.size() > 0
   *                 - all strings in wordList have length >= 1
   *
   *  @param wordList  arraylist of words
   */
    public static ArrayList<String> moveBWords(ArrayList<String> wordList){
        int indexB = 0;
        for(int i = 0; i < wordList.size(); i ++) {
            if(wordList.get(i).substring(0,  1).equalsIgnoreCase("b")) {
                wordList.add(indexB, wordList.remove(i));
                indexB ++;
            }
        }
        return wordList;
    }



    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> intList){
        for(int i = 0; i < intList.size(); i ++) {
            for(int j = i + 1; j < intList.size(); j ++) {
                if(intList.get(i) == intList.get(j)) {
                    intList.remove(j);
                    j --;
                }
            }
        }
        return intList;
    }

    // Given an array of ints, 
    // return true if the array is length 1 or more, 
    // and the first element and the last element are equal.
    // sameFirstLast([1, 2, 3]) → false
    // sameFirstLast([1, 2, 3, 1]) → true
    // sameFirstLast([1, 2, 1]) → true
    //sameFirstLast([]) -> false
    public static boolean sameFirstLast(ArrayList<Integer> list){
        if(list.size() > 0 && list.get(0) == list.get(list.size() - 1)) {
            return true;
        }
        return false;
    }



    // Given an array of ints, swap the first and last elements in the array. 
    // Return the modified array. The array length will be at least 1.
    // swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    // swapEnds([1, 2, 3]) → [3, 2, 1]
    // swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
    // swapEnds([]->[])
    public static ArrayList<Integer> swapEnds(ArrayList<Integer> list){    
        if(list.size() > 0) {
            list.add(list.set(0, list.remove(list.size() - 1)));
        }    
        return list;
    }



    // Return an array that contains the exact same numbers as the given array, 
    // but rearranged so that all the zeros are grouped at the start of the array. 
    // The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. 
    // You may modify and return the given array or make a new array.
    // zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    // zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    // zeroFront([1, 0]) → [0, 1]
    public static ArrayList<Integer> zeroFront(ArrayList<Integer> list){
        for(int i = 0; i < list.size();i ++) {
            if(list.get(i) == 0) {
                list.add(0, list.remove(i));
            }
        }
        return list;
    }



    // We'll say that an element in an array is "alone" if there are values before and after it, 
    // and those values are different from it. If the value is at the end compare to the left and if its at the beginning compare to the right
    //Return a version of the given array where every instance 
    // of the given value which is alone is replaced by whichever value to its left or right is larger.
    // notAlone([1, 2, 3], 2) → [1, 3, 3]
    // notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 5]
    // notAlone([3, 4], 3) → [3, 3]
    public static ArrayList<Integer> notAlone(ArrayList<Integer> list, int val){
        for(int i = 0 ; i < list.size(); i ++) {
            if(list.get(i) == val) {
                if(i == 0 && list.get(i) != list.get(i + 1)) {
                    if(list.get(i) < list.get(i + 1)) {
                        list.set(i, list.get(i + 1));
                    }

                }
                else if(i == list.size() - 1 && list.get(i) != list.get(i - 1)) {
                    if(list.get(i) < list.get(i - 1)) {
                        list.set(i, list.get(i - 1));
                    }

                }
                else if(!(list.get(i) == list.get(i - 1) || list.get(i) == list.get(i + 1))) {
                    if(list.get(i - 1) >= list.get(i + 1)) {
                        list.set(i, list.get(i - 1));

                    }
                    else {
                        list.set(i, list.get(i + 1));
                    }

                }
            }
        }
        return list;
    }



    // Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. 
    // You may modify and return the given array;
    // shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    // shiftLeft([1, 2]) → [2, 1]
    // shiftLeft([1]) → [1]

    public static ArrayList<Integer> shiftLeft(ArrayList<Integer> list){
        list.add(list.remove(0));
        return list;
    }
    


    // Return an array that contains exactly the same numbers as the given array, 
    // but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
    // but every other number may move. The array contains the same number of 3's and 4's, 
    // every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
    // fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
    // fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
    // fix34([3, 2, 2, 4]) → [3, 4, 2, 2]

    public static ArrayList<Integer> fix34(ArrayList<Integer> list){
        int index4 = -1;
        for(int i = 0; i < list.size(); i ++) {
            if(list.get(i) == 3) {
                for(int j = index4 + 1; j < list.size();j ++) {
                    if(list.get(j) == 4) {
                        int temp = list.get(i + 1);
                        list.set(i + 1, 4);
                        list.set(j, temp);  
                        index4 = j;  
                        break;  
                    }
                }
            }
        }
        return list;
    }



    /** Returns an arraylist of Integers that contain all mode(s) of the array numList.
   *  The mode of a list is the value that appears the greatest number of times.
   *  A list can have one mode, multiple mode, or no mode.
   *
   *  If all elements in the list appear the exact same number of times, there is no
   *  mode and this method should return an empty arraylist.
   *
   *  For example, if numList is: [1, 2, 6, 2, 3, 4, 6, 5, 5, 6, 7],
   *  then numList contains one mode: 6
   *  and this method returns an arrayList containing 6
   *
   *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6],
   *  then numList contains two modes: 2, 5
   *  and this method returns an arraylist containing 2 and 5 (in any order)
   *
   *  If numList is: [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6],
   *  then numList contains no mode because all values appear the same number of times
   *  and this method returns an empty arrayList: []
   *
   *  Does NOT mutate (modify) elements in numList
   *  PRECONDITIONS: numList.length > 0
   *
   *  @param numList  numList of ints
   */
    public static ArrayList<Integer> modes(int[] numList){
        int greatest = 1;
        ArrayList<Integer> mode = new ArrayList<Integer>();
        for(int i = 0; i < numList.length; i ++) {
            int repeats = 1;
            for(int j = i + 1; j < numList.length; j ++) {
                if(numList[i] == numList[j]) {
                    repeats ++;
                }
            }
            if(repeats > greatest) {
                mode = new ArrayList<Integer>();
                mode.add(numList[i]);
                greatest = repeats;
            }
            else if(repeats == greatest && greatest > 1) {
                mode.add(numList[i]);
            }

        }

        if(greatest == 1 || mode.size() * greatest == numList.length) {
            mode = new ArrayList<>();
        }
        
        return mode;
    }

    public static void main(String[] args) {
        // ArrayList<String> stringList = new ArrayList<String>(Arrays.asList("apple", "boy", "fox", "bi", "night"));
        // System.out.println(moveBWords(stringList));

        // int[] sumnums = {1,2,3,4,5,6};
        // System.out.println(reverseArray(sumnums));

        // String sentence = "I have no idea what I am saying? Yet it should work";
        // System.out.println(parseSentence(sentence));

        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 2, 3, 0, 5, 7, 0));
        System.out.println(notAlone(nums, 2));
    }
}