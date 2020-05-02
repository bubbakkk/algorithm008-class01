package assignments;

public class letter_combinations {
    class Solution {
        Map<Character,String> map = new HashMap<Character,String>() {{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        public List<String> letterCombinations(String digits) {
            List<String> res = new LinkedList<String>();
            if (digits.equals("")) return res;
            char []c = digits.toCharArray();
            helper("" , c , res , 0);
            return res;
        }
        public void helper(String s , char[] charArray , List<String> res , int index) {
            if (index == charArray.length) {
                res.add(s);
                return;
            }
            String letters = map.get(charArray[index]);
            for (char c : letters.toCharArray()) {
                helper(s + c , charArray , res , index + 1);
            }
        }
    }
}
