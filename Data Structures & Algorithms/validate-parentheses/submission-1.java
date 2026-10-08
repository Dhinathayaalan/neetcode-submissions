class Solution {
    public boolean isValid(String str) {
        char[] ch = str.toCharArray();
        Stack<Character> s = new Stack<>();

        for(int i=0;i<ch.length;i++){
            if(ch[i]=='[' || ch[i]=='(' || ch[i]=='{'){
                s.add(ch[i]);
            }
            else{
                if(s.isEmpty()) return false;
                char v = s.peek();
                if((v=='(' && ch[i]==')') || (v=='[' && ch[i]==']') || (v=='{' && ch[i]=='}')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
}
