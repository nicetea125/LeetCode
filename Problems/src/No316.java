import java.util.*;


public class No316 {

    private static Map<String,Integer> map = new HashMap<String,Integer>();

    public static void main(String[] args)  {

        System.out.print( removeDuplicateLetters("cbacdcbc")  );
    }

    public static String removeDuplicateLetters(String s) {
        int[] letterCnt = new int[36]; // a=10 ~ z=35

        String result = "";
        for(Character c : s.toCharArray()){
            letterCnt[Character.getNumericValue(c)]++;
        }

        for(Character c : s.toCharArray()){
            letterCnt[Character.getNumericValue(c)]--;
            if(result.contains(c.toString())) continue;

            while( result.length()!=0
                    && result.charAt(result.length()-1) > c
                    && letterCnt[Character.getNumericValue(result.charAt(result.length()-1))] > 0){

                result = result.substring(0,result.length()-1);
            }

            result += c;
        }
        return result;
    }


}