/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    Stack<Integer> stk1 ;
    Stack<Integer> stk2 ;
    public MyQueue() {
        stk1 = new Stack<>() ;
        stk2 = new Stack<>() ;
    }
    
    public void push(int x) {
       stk1.push(x) ;
    }
    
    public int pop() {
        while(stk1.size() != 1)
            stk2.push(stk1.pop()) ;
        int res = stk1.pop() ;
        while(!stk2.isEmpty())
            stk1.push(stk2.pop()) ;
        return res ;
    }
    
    public int peek() {
        while(stk1.size() != 1)
            stk2.push(stk1.pop()) ;
        int res = stk1.peek() ;
        while(!stk2.isEmpty())
            stk1.push(stk2.pop()) ;
        return res ;
    }
    
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty() ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

