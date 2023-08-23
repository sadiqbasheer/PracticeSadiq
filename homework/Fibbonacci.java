package homework;

public class Fibbonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int firstNum = 0;
		int secNum = 1;
		int sum = 0;
		int n = 11;
		//System.out.println(firstNum);
		for ( int i = 0; i < n; i++) {
			System.out.println(firstNum);
			//System.out.println(secNum);
			sum = firstNum+secNum;
			firstNum = secNum;
			secNum=sum;
		}
	}

}
