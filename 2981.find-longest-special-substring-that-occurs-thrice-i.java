/*
 * @lc app=leetcode id=2981 lang=java
 *
 * [2981] Find Longest Special Substring That Occurs Thrice I
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    // The length of special substring can be anywhere in between 0 and n-2
    // we can determine if a special substring of length k exists thrice in linear time
    public int maximumLength(String s) {
        int low = 1, high = s.length()-2 ;
        int result = -1 ;
        //binary search over length of special substring
        while(low <= high){
            int mid = (low+high)/2 ;
            if(checkSpecialSubstringExists(s, mid)){
                result = mid ;
                low = mid+1 ;
            }
            else {
                high = mid-1 ;
            }
        }
        return result ;
    }
    private boolean checkSpecialSubstringExists(String s, int len){
        int i = 1 ;
        char c = s.charAt(0) ;
        int char_frequency = 1 ;
        Map<Character,Integer> substringFreq = new HashMap<>() ;
        // run through the string keeping track of special substrings 
        // that meet length requirement
        while(i < s.length()){
            if(s.charAt(i) == c)
                char_frequency++ ;
            else {
                if(char_frequency >= len)
                    substringFreq.put(c, substringFreq.getOrDefault(c, 0) + char_frequency-len+1) ;
                c = s.charAt(i) ;
                char_frequency = 1 ;
            }
            i++ ;
        }
        //additional check for when closing character has special substring
        if(char_frequency >= len)
                substringFreq.put(c, substringFreq.getOrDefault(c, 0) + char_frequency-len+1) ;

        //identify if any special substring is repeated thrice
        for(Character d : substringFreq.keySet())
            if(substringFreq.get(d) > 2)
                return true ;
        return false ;
    }
}
// @lc code=end

