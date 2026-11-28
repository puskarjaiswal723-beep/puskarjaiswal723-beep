class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int idx=0;
        Stack<Integer> stck=new Stack<>();
        for(int i=0;i<pushed.length;i++){
            stck.push(pushed[i]);
            while(!stck.isEmpty() && idx<popped.length && stck.peek()==popped[idx]){
                stck.pop();
                idx++;
            }
        }
        return (idx==popped.length && stck.isEmpty());
    }
}