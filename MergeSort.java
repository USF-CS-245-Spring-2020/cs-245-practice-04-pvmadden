import java.util.Arrays;


public class MergeSort implements SortingAlgorithm
{
	public void sort(int[] a)
	{
		//our range is from the beginning and end
		mergeSort(a, 0, a.length - 1);
	}

	void mergeSort(int[] a, int left, int right)
	{
		// checking this because once left = right,  we are
		// "sorted", or at the lowest point with only
		// one element in our imaginary subarray.
		if (left < right)
		{
			int middle = (left + right) / 2;

			// this continuously breaks down the array into
			// smaller and smaller parts.
			mergeSort(a, left, middle);
			mergeSort(a, middle + 1, right);

			//this merges the two sides, checking both sides each
			// time its called the array will be double the size.
			merge(a, left, middle, right);
		}
	}


	void merge(int[] a, int left, int middle, int right)
	{
		// these temporary arrays hold our the values
		// so we can swap elements in a[]. Otherwise, we
		// would lose a value.

		int n1 = middle - left + 1;
		int n2 = right - middle;

		int leftSide[] = new int[n1];
		int rightSide[] = new int[n2];

		for (int i = 0; i < n1; i++)
		{
			leftSide[i] = a[left + i];
		}
		for (int i = 0; i < n2; i++)
		{
			rightSide[i] = a[left + i];
		}


		// this is code from class
		int indexL = 0;
		int indexR = 0;
		int indexTarget = left;

		while (indexL < n1 && indexR < n2)
		{
			if (leftSide[indexL] <= rightSide[indexR])
			{
				a[indexTarget++] = leftSide[indexL++];
			}
			else
			{
				a[indexTarget++] = rightSide[indexR++];
			}
		}

		// once we are done sorting, if there are any sorted elements
		// left in leftSide or rightSide, it will be added to the end of
		// our target array.
		while (indexL < n1)
		{
			a[indexTarget++] = leftSide[indexL++];
		}

		while (indexR < n2)
		{
			a[indexTarget++] = rightSide[indexR++];
		}
	}
}