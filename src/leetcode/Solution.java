package leetcode;

class Solution {
    public int romanToInt(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); ) {
            if(i+1 < s.length()){
                if(s.substring(i, i+2).equals(new String("IV"))){
                    value += 4;
                    i += 2;
                }else if(s.substring(i, i+2).equals(new String("IX"))){
                    value += 9;
                    i += 2;
                }else if(s.substring(i, i+2).equals(new String("XL"))){
                    value += 40;
                    i += 2;
                }else if(s.substring(i, i+2).equals(new String("XC"))){
                    value += 90;
                    i += 2;
                }else if(s.substring(i, i+2).equals(new String("CD"))){
                    value += 400;
                    i += 2;
                }else if(s.substring(i, i+2).equals(new String("CM"))){
                    value += 900;
                    i += 2;
                }else{
                    if(s.charAt(i) == 'I'){
                        value += 1;
                        i++;
                    }else if(s.charAt(i) == 'V'){
                        value += 5;
                        i++;
                    }else if(s.charAt(i) == 'X'){
                        value += 10;
                        i++;
                    }else if(s.charAt(i) == 'L'){
                        value += 50;
                        i++;
                    }else if(s.charAt(i) == 'C'){
                        value += 100;
                        i++;
                    }else if(s.charAt(i) == 'D'){
                        value += 500;
                        i++;
                    }else {
                        value += 1000;
                        i++;
                    }
                }
            }else{
                if(s.charAt(i) == 'I'){
                    value += 1;
                    i++;
                }else if(s.charAt(i) == 'V'){
                    value += 5;
                    i++;
                }else if(s.charAt(i) == 'X'){
                    value += 10;
                    i++;
                }else if(s.charAt(i) == 'L'){
                    value += 50;
                    i++;
                }else if(s.charAt(i) == 'C'){
                    value += 100;
                    i++;
                }else if(s.charAt(i) == 'D'){
                    value += 500;
                    i++;
                }else {
                    value += 1000;
                    i++;
                }
            }
        }
        return value;
    }
    public static void main(String[] args){
        String s = new String("MMMXLV");
        Solution solution = new Solution();
        System.out.println(solution.romanToInt(s));
    }
}
