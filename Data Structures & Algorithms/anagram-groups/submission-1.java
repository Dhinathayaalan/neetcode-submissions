class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.get(sorted)!=null){
                map.get(sorted).add(strs[i]);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sorted, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
