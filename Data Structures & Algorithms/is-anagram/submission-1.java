class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        for(char i : ch1){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(char i : ch2){
            if(map.getOrDefault(i, 0)>0){
                map.put(i, map.get(i)-1);
                if(map.get(i)==0){
                    map.remove(i);
                }
            }
        }
        return map.size()==0;
    }
}
