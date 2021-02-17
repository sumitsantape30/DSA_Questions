Factorial of a non-negative integer, is the multiplication of all integers smaller than or equal to n. For example factorial of 6 is 6*5*4*3*2*1 which is 720.

How to compute factorial of 100 using a java program? 
Factorial of 100 has 158 digits. It is not possible to store these many digits even if we use long long int. 
Examples : 

Input : 100
Output : 933262154439441526816992388562667004-
         907159682643816214685929638952175999-
         932299156089414639761565182862536979-
         208272237582511852109168640000000000-
         00000000000000

Input :50
Output : 3041409320171337804361260816606476884-
         4377641568960512000000000000

Code:
     package ArraysCracker;

import java.util.Scanner;

class Node{
	int data;
	Node prev; //previous pointer lere jo prev ko pointer karega, kyuki mai tail pointer ko banana chah rha hu
	
	public Node() {
		this.data= data;
		this.prev= prev;
	}
	
	public Node(int data) {
		this.data= data;
	}
}

public class FactorialOfLargeNumber {
	
	public static void print(Node tail) {
		
		if( tail == null) {
			return;
		}
		
		//I'm using tail recursion here rather than head recursion. To yeh recursively last pe jab pohoch jayega uske bad hi prnint krna shuru karega so it'll print the linkedlist in reverse order
		print(tail.prev);
		System.out.print(tail.data+" ");
	}
	
	public static void multiply(Node tail, int n) {
		Node temp= tail, prevNode= tail; // temp and previous node dono initially tail hogi
		int carry= 0; //carry abhi zero hai
		
		while( temp != null) { //jabtak linkedlist mai mere pas koi content hai tab tak
			int data= temp.data*n + carry ; //temp data means jo node mai data hai *n jiski multiply karni hai plus carry
			temp.data= data %10; //jo current node hai uske data mai dal dunga dats % 10 kyuki digit rakhni hai
			carry= data/ 10; // mere carry mai data/10 wali value aajayegi
			prevNode= temp; //previous node will become temp.
			temp= temp.prev; // and temp will become temp ka previous
		}
		
		while( carry != 0) { //agar mera carry zero nhi hai to mai new Node banaunga prev pe
			prevNode.prev= new Node((int)(carry%10));
			//aur carry ko 10 se divide karenge
			carry /= 10;
			prevNode= prevNode.prev;
		}
		// 1-->2-->4 iss tarah se mko new linkedlist banani hai
	}
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		//i'll create a new node called as tail and isko mai 1 se initialise kar dunga
		Node tail= new Node(1);
		for( int i=2; i< n; i++) {//i'll run a loop fronm i=2 to n and with multiply it with my tail
			multiply(tail, i);
		}
		
		//last mai linkedlist print karenge
		print(tail);
		System.out.println();
		
	}

}
