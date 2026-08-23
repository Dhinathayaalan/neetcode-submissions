class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean res = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            Integer count = map.get(i);
            if(count != null){
                res = true;
                break;
            }
            map.put(i, 1);
        }
        return res;
    }
}