using System;
using System.Linq;

namespace ConsoleDemoApp.Day6
{
    internal class ArrayDemo1
    {
        static void Main(string[] args)
        {
            // Normal Array
            //int[] arr; //declaration
            //arr = new int[5];// initialisation
            //int[] arr = new int[5]; // declaration + initialisation
            //int[,] arr = new int[5, 4]; // 2d array
            //int[,,] arr = new int[5, 4, 3]; // 3d array
            //Console.WriteLine($"Length: {arr.Length}  | Number of elements stored in array");
            //Console.WriteLine($"Rank  : {arr.Rank}  | Dimension of array");
            //Console.WriteLine($"GetUpperBound(0): {arr.GetUpperBound(0)} | Get Last index of dimension w.r.t array");
            //Console.WriteLine($"GetUpperBound(1): {arr.GetUpperBound(1)} | Get Last index of dimension w.r.t array");
            //Console.WriteLine($"GetUpperBound(2): {arr.GetUpperBound(2)} | Get Last index of dimension w.r.t array");
            //Console.WriteLine($"GetLength(0): {arr.GetLength(0)} | Get length of dimensions");
            //Console.WriteLine($"GetLength(1): {arr.GetLength(1)} | Get length of dimensions");
            //Console.WriteLine($"GetLength(2): {arr.GetLength(2)} | Get length of dimensions");

            //int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
            int[] arr = { 10, 2, 3, 40, 5, 60 };

            Console.WriteLine("Array elements are: ");
            for (int i = 0; i <= arr.GetUpperBound(0); i++)
            {
                Console.WriteLine($"arr[{i}] = {arr[i]}");
            }

            //Console.WriteLine("Input array values: ");
            //for (int i = 0; i <= arr.GetUpperBound(0); i++)
            //{
            //    Console.Write($"arr[{i}] = ");
            //    arr[i] = Int32.Parse(Console.ReadLine());
            //}
            //Console.WriteLine("Entered array elements are: ");
            ////foreach (int i in arr)
            //for (int i = 0; i <= arr.GetUpperBound(0); i++)
            //{
            //    Console.WriteLine($"arr[{i}] = {arr[i]}");
            //}

            Console.WriteLine($"Min: {arr.Min()}");
            Console.WriteLine($"Max: {arr.Max()}");
            Console.WriteLine($"Avg: {arr.Average()}");

            Array.Reverse(arr);
            Console.WriteLine("Reversed array elements are:");
            for (int i = 0; i <= arr.GetUpperBound(0); i++)
            {
                Console.WriteLine($"arr[{i}] = {arr[i]}");
            }

            Array.Sort(arr);
            Console.WriteLine("Sorted array elements are:");
            for (int i = 0; i <= arr.GetUpperBound(0); i++)
            {
                Console.WriteLine($"arr[{i}] = {arr[i]}");
            }



            int x = 40;
            //int[] arr2 = { 10, 20, 30, 40, 50, 60 };
            int[] arr2 = arr;
            int res = Array.BinarySearch<int>(arr2, x);// index if element found, else any negative number
            Console.WriteLine($"Binary Search: {res}");

            bool contain = arr.Contains(x);
            Console.WriteLine($"arr.Contains({x}): {contain}");
        }
    }
}
