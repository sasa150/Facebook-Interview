public class addOneWithoutPlusOperator {
	public void addOne(int num) {
		System.out.println(addOneHelper(num, 1));
		int carry = 1;
		int sum = 0;
		while (carry != 0) {
			sum = num ^ carry;
			carry = (num & carry) << 1;
			num = sum;
		}
		System.out.println(sum);
		
	}
	public int addOneHelper(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return addOneHelper(sum, carry);
	}
}