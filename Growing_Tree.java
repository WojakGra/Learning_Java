public class Growing_Tree {
	public static void main(String[] args) {
		
		int ilosc=2;
		
		for(int i=0; i<4; i++)
		{
			int gwiazdki=1, puste=4;
			for(int j=0; j<ilosc; j++)
			{
				for(int k=puste; k>0; k--)
				{
					System.out.print(" ");
				}
				for(int k=gwiazdki; k>0; k--)
				{
					System.out.print("*");
				}
				puste--;
				gwiazdki+=2;
				System.out.print("\n");
			}
			ilosc++;
		}

	}
}
