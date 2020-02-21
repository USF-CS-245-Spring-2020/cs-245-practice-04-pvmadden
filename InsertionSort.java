
public class InsertionSort implements SortingAlgorithm
{
	public void sort(int [] a)
	{
		int n = a.length;
		for(int i = 1; i < n; i++)
		{
			int nextUnsorted = i;
			int backwards = i - 1;

			while (backwards >= 0 && a[backwards] > nextUnsorted)
			{
				//moving elements greater than nextUnsorted ahead  of their current index
				a[backwards + 1] = a[backwards];
				backwards--;
			}

			//which is now sorted
			a[backwards+1] = nextUnsorted;
		}
	}
}
