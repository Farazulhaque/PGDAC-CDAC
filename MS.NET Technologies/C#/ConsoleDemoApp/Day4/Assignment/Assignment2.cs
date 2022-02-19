using System;
namespace ConsoleDemoApp.Day4.Assignment
{
    internal class Assignment2
    {
        static void Main(string[] args)
        {
            Admin admin = Admin.GetInstance();
            admin.DisplayMessage();

            Console.WriteLine("========================================");

            int[][] arr2 = new int[3][]{
                new int[4]{ 4, 2, 7, 1},
                new int[4]{20, 70, 40, 90},
                new int[3]{1, 2, 0}
            };
            FindLargest(arr2);

            Console.WriteLine("========================================");

            Maskify("4556364607935616");
            Maskify("1");
            Maskify("");

            Console.WriteLine("========================================");

            int[] arr = { 92, 6, 73, -77, 81, -90, 99, 8, -85, 34 };
            CountPosSumNeg(arr);

            Console.WriteLine("========================================");

            SortDescending(73065);

            Console.WriteLine("========================================");

            Reverse("This is a typical sentence.");
            Reverse("The dog is big.");
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
            }
            foreach (var item in largest)
            {
                Console.Write($"{item}\t");
            }
            Console.WriteLine();
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
                Console.Write(newarr[i] + "\t");
            }
            Console.WriteLine();
        }
        static void SortDescending(int num)
        {
            string str = "" + num;
            char[] arr = str.ToCharArray();
            for (int i = 0; i < arr.Length; i++)
            {
                for (int j = 0; j < arr.Length; j++)
                {
                    if (int.Parse(arr[i].ToString()) > int.Parse(arr[j].ToString()))
                    {
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            Console.WriteLine(new String(arr));
        }

        static void Reverse(string sentence)
        {
            string[] arr = sentence.Split(' ');
            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i].Length >= 5)
                {
                    char[] word = arr[i].ToCharArray();
                    int first_index = 0;
                    int last_index = word.Length - 1;
                    while (first_index <= last_index)
                    {
                        char temp = word[first_index];
                        word[first_index] = word[last_index];
                        word[last_index] = temp;
                        first_index++;
                        last_index--;
                    }
                    arr[i] = new String(word);
                }
            }
            Console.WriteLine(string.Join(" ", arr));
        }
    }
}
