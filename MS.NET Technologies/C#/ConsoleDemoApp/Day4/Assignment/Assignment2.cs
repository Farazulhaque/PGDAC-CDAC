using System;
namespace ConsoleDemoApp.Day4.Assignment
{
    internal class Assignment2
    {
        static void Main(string[] args)
        {
            int[][] arr2 = new int[3][]{
                new int[4]{ 4, 2, 7, 1},
                new int[4]{20, 70, 40, 90},
                new int[3]{1, 2, 0}
            };
            FindLargest(arr2);
            Maskify("4556364607935616");
            Maskify("1");
            Maskify("");
            int[] arr = { 92, 6, 73, -77, 81, -90, 99, 8, -85, 34 };
            CountPosSumNeg(arr);
            // SortDescending(73065);
        }
        static void FindLargest(int[][] arr)
        {
            int[] largest = new int[arr.Length];
            for (int r = 0; r < arr.Length; r++)
            {
                int max = 0;
                for (int c = 0; c < arr[r].Length; c++)
                {
                    if (max < arr[r][c])
                    {
                        max = arr[r][c];
                    }
                }
                largest[r] = max;

                //Console.WriteLine();
            }
            foreach (var item in largest)
            {
                Console.WriteLine($"{item}\t");
            }
        }
        static void Maskify(string str)
        {
            string masked_str = "";
            if (str.Length > 4)
            {
                int i;
                for (i = 0; i < str.Length - 4; i++)
                {
                    masked_str += "#";
                }
                masked_str += str.Substring(i);
            }
            else
            {
                masked_str = str;
            }
            Console.WriteLine(masked_str);
        }
        static void CountPosSumNeg(int[] arr)
        {
            int[] newarr = new int[2];
            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i] > 0)
                {
                    newarr[0] += 1;
                }
                else
                {
                    newarr[1] += arr[i];
                }
            }
            for (int i = 0; i < newarr.Length; i++)
            {
                Console.WriteLine(newarr[i]);
            }
        }



        static void SortDescending(int num)
        {
            Console.WriteLine(num);
            string str = "" + num;
            char[] array = new char[str.Length];
            char[] arraydes = new char[str.Length];

            for (int i = 0; i < str.Length; i++)
            {
                array[i] = (char)0;
                arraydes[i] = str[i];
            }


            for (int i = 0; i < array.Length; i++)
            {
                int jcount = 0;
                for (int j = 0; j < arraydes.Length; j++)
                {
                    if (array[i] <= arraydes[j])
                    {
                        array[i]
                            = arraydes[j];
                        jcount = j;

                    }
                }
                arraydes[jcount] = (char)0;
                jcount = 0;
            }
            Console.WriteLine(array);

        }


    }
}
