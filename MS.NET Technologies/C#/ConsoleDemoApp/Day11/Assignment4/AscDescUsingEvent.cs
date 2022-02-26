using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day11.Assignment4
{
    delegate void MyEventHandlr(int[] arr);
    internal class AscDescUsingEvent
    {
        public event MyEventHandlr Sorter;
        public void SortAscending(int[] arr)
        {
            for (int i = 0; i < arr.Length - 1; i++)
            {
                for (int j = i + 1; j < arr.Length; j++)
                {
                    if (arr[i] > arr[j])
                    {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            foreach (int i in arr)
            {
                Console.WriteLine(i);
            }
        }
        public void SortDescending(int[] arr)
        {
            for (int i = 0; i < arr.Length - 1; i++)
            {
                for (int j = i + 1; j < arr.Length; j++)
                {
                    if (arr[i] < arr[j])
                    {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            foreach (int i in arr)
            {
                Console.WriteLine(i);
            }
        }
        static void Main(string[] args)
        {
            AscDescUsingEvent ascDescUsingEvent = new AscDescUsingEvent();
            //int[] arr = { 10, 50, 11, 2, 30, 4, 8, 15 };

            Console.Write("Enter size of the array: ");
            int n = int.Parse(Console.ReadLine());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
            {
                Console.Write($"Enter element at position {i} array: ");
                arr[i] = int.Parse(Console.ReadLine());
            }
            Console.WriteLine("Enter 1 to sort in ascending order");
            Console.WriteLine("Enter 2 to sort in descending order");
            Console.Write("Enter your choice: ");
            int choice = int.Parse(Console.ReadLine());
            if (choice == 1)
                ascDescUsingEvent.Sorter = ascDescUsingEvent.SortAscending;
            else if (choice == 2)
                ascDescUsingEvent.Sorter = ascDescUsingEvent.SortDescending;


            ascDescUsingEvent.Sorter(arr);
        }
    }
}
