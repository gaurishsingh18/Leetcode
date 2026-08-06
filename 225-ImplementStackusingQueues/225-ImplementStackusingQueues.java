// Last updated: 06/08/2026, 20:57:00
1class MyStack {
2    Queue<Integer> q1;
3    Queue<Integer> q2;
4    public MyStack() {
5        q1 = new LinkedList<>();
6        q2 = new LinkedList<>();
7    }
8    public void push(int x) {
9        q2.offer(x);
10
11        while (!q1.isEmpty()) {
12            q2.offer(q1.poll());
13        }
14        Queue<Integer> temp = q1;
15        q1 = q2;
16        q2 = temp;
17    }
18    public int pop() {
19        return q1.poll();
20    }
21    public int top() {
22        return q1.peek();
23    }
24    public boolean empty() {
25        return q1.isEmpty();
26    }
27}