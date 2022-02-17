using System;

namespace ConsoleDemoApp.Day4.ClassWork
{
    internal class ControlStmt
    {
        static void Main(string[] args)
        {
            /*
                        Console.WriteLine("Enter a character");
                        char ch = char.Parse(Console.ReadLine());
                        switch (ch)
                        {
                            case 'a':
                            case 'e':
                            case 'i':
                            case 'o':
                            case 'u':
                                Console.WriteLine($"Entered char {ch} is vowel");
                                break;
                            default:
                                Console.WriteLine($"Entered char {ch} is consonant");
                                break;
                        }
            */

            int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
            Console.WriteLine("Array values are: ");
            // 1. forward only loop
            // 2. readonly
            /*
                        foreach (var item in arr)
                        {
                            //item = item + 2; // invalid
                            Console.WriteLine(item);
                        }
            */

            //Boxing and UnBoxing is not Type safe

            //Boxing -> Conversion from value type to reference type
            //object obj = integer;
            object obj = 20;

            //int y = obj; //invalid
            //Unboxing -> Conversion from refernce type to value type
            int y = (int)obj; // valid

            //foreach (object item in arr)
            //{
            //    if ((int)item > 5)
            //    {
            //        Console.WriteLine(item);
            //    }

            //}

            foreach (var item in arr)
            {
                Console.WriteLine(item.GetType());
                if (item > 5)
                {
                    Console.WriteLine(item);
                }
            }

            foreach (dynamic item in arr)
            {
                Console.WriteLine(item.GetType());
                if (item > 5)
                {
                    Console.WriteLine(item);
                }
            }

        }
    }
}
