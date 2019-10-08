import java.util.Scanner;
class DiffieHellman{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter p : ");
		int p = s.nextInt();
		System.out.print("Enter alpha: ");
		int alpha = s.nextInt();
		System.out.print("Enter sender private value a = ");
		int a = s.nextInt();
		System.out.print("Enter receiver private value b = ");
		int b = s.nextInt();
		keyExchange(p, alpha,a,b);
	}
	public static void keyExchange(int p, int alpha,int a,int b){
		int alice = sender(p, alpha,a);
		int bob = receiver(p, alpha,b);
		int keyA = sender(p, bob,a);
		int keyB = sender(p, alice,b);
		System.out.println("sender key = "+keyA );
		System.out.println("receiver key = "+keyB );
	}
	public static int sender(int p, int alpha,int a){
		
		int alice = 1;
		for(int i = 0 ; i < a ; i++){
    		alice = (alice * alpha) %p;	
    	} 
    	return alice;
	}
	public static int receiver(int p, int alpha,int b){
		int bob = 1;
		for(int i = 0 ; i < b ; i++){
    		bob = (bob * alpha) %p;	
    	} 
    	return bob;
	}
}