class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Nearest greater to right, stock span problem
        int[] arr=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> index=new Stack<>();
            for(int i=temperatures.length-1;i>=0;i--){
                if(stack.size()==0){
                    arr[i]=0;
                }else if(stack.size()!=0 && stack.peek()>temperatures[i] ){
                    arr[i]=index.peek()-i;
                }else if(stack.size()!=0 && stack.peek()<=temperatures[i]){
                    while(!stack.isEmpty() && stack.peek()<=temperatures[i]){
                        stack.pop();
                        index.pop();
                    }
                    if(stack.size()==0){
                        arr[i]=0;
                    }else{
                        arr[i]=index.peek()-i;
                    }
                }
                stack.push(temperatures[i]);
                index.push(i);
            }
        Collections.reverse(Arrays.asList(arr));
        return arr;
    }
}