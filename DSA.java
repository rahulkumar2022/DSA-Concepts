//Pallindrom counter
public int countSubstring(String s){ // Total = O(n*n)
	int pallindromCount = 0;
	for(int i=0;i<s.length();i++){ // O(n)
		int odd = pallindromeCounter(s,i-1,i+1);// O(n)
		int even = pallindromeCounter(s,i,i+1); // O(n)
		pallindromCount += even + odd + 1; 
	}
	return pallindromCount;
}
private int pallindromeCounter(String s,int start,int end){
	int subStringPallindromeCounter = 0;
	while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
		subStringPallindromeCounter++;
		start--;
		end++;
	}
	return subStringPallindromeCounter;
}
// Using DP
public int countSubstring(String s){
	int n = s.length();
	boolean[][] pallindrome = new boolean[n][n];
	int ans = 0;
	for(int i=0;i<n;i++){
		pallindrome[i][i] = true;
		ans++;
	}
	for(int i=0;i<n;i++){
		if(s.charAt(i)==s.charAt(i+1){
			pallindrome[i][i+1] = true;
			ans++;
		}
	}
	for(int len=3;len<=n;len++){
		for(int i=0;i<n-len+1;i++){
			if(s.charAt(i)==s.charAt(i+len-1) && pallindrome[i+1][i+len-2]){
				pallindrom[i][i+len-1] = true;
				ans++;
			}
		}
	}
	return ans;
}
//--------------------------------------
// Reverse a linkedList
public ListNode reverseList(ListNode head){
	ListNode curr = null;
	while(head!=null){
		ListNode temp = head.next;
		head.next = curr;
		curr = head;
		head = temp;
	}
	return curr;
}
//--------------------------------------
// Implement Stack using LinkedList
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
class Stack{
	Node head;
	Stack(){
		this.head = null;
	}
	isEmpty():boolean{
		return head==null;
	}
	push(int data):void{
		Node newNode = new Node(data);
		if(newNode==null) throw new StackOverFlowException("Stack out of memory");
		newNode.next  = head;
		head = newNode;
	}
	pop():void{
		if(isEmpty()) throw new StackEmptyException("Stack is empty");
		Node temp = head;
		head = head.next;
		temp = null;
	}
	peek():Node{
		return head;
	}
}
//----------------------------
// Implement stack using array
class Stack{
	static final int MAX = 1000;
	int top ;
	int a[] = new int[MAX];
	Stack() {
		top = -1;
	}
	isEmpty():boolean{
		return top<0;
	}
	push(int x):boolean{
		if(top>=(max-1)){
			System.out.println("Stack Overflow");
			return false;
		}
		a[++top] = x;
		return true;
	}
	pop():int{
		if(top<0){
			System.out.println("NO data in stack");
			return 0;
		}
		int num = a[top--];
		return num;
	}
	peek():number{
		if(top<0){
			System.out.println("No data");
			return 0;
		}
		return a[top];
	}
}
//-----------------------------------
// Min Stack
class MinStack{
	Stack<int[]> st;
	public MinStack(){
		st = new Stack<>();
	}
	public int peek(){
		return st.isEmpty()?-1:st.get(st.size()-1)[0];
	}
	public void pop(){
		st.pop();
	}
	public int getMin(){
		return st.isEmpty()?-1:st.get(st.size()-1)[1];
	}
	public void push(int val){
		int[] top = st.isEmpt()?new int[]{val,val}:st.get(st.size()-1);
		int min_val = top[1];
		if(min_val<val){
			st.add(new int[]{val,min_val});
		}else{
			st.add(new int[]{val,val})
		}
	}
}
