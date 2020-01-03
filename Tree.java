public class Tree {
	public static void main(String[] args) {
		int gwiazdki=1, puste=4;
		
		for(int i=0; i<5; i++)
		{
			for(int j=puste; j>0; j--)
			{
				System.out.print(" ");
			}
			for(int j=gwiazdki; j>0; j--)
			{
				System.out.print("*");
			}
			puste--;
			gwiazdki+=2;
			System.out.print("\n");
		}

	}

}
