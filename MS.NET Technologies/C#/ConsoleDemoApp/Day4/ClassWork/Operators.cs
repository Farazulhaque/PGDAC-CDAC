using System;

namespace ConsoleDemoApp.Day4.ClassWork
{
    internal class Operators
    {
        static void Main(string[] args)
        {
            //int x= 10; // 10+1->-11 (1's complement)
            //// 00001010
            //// 11110101 --> -11
            //// 00001010
            ////       +1
            //// 00001011
            //// -11
            //Console.WriteLine(~x);
            //// 11110101 
            ////       +1
            //// 11110110
            //// 00001001
            ////       +1
            //// 00001010 --> -10
            //Console.WriteLine(~x+1);

            //int a = 30, b = 20;
            //Console.WriteLine(a+~b+1);

            //int z = a++ + ++b;
            //Console.WriteLine(z);

            object str = "cdac";

            //string mystr = (String) str;
            string mystr = str as string;
            Console.WriteLine(mystr);

            int? x = 20;
            if (x is null)
            {
                Console.WriteLine(x);
            }
            if (mystr is string)
            {
                Console.WriteLine(mystr);
            }

            Console.WriteLine(typeof(string));
            Console.WriteLine(sizeof(decimal));

            Type tp = typeof(int);
            Console.WriteLine(tp.Name);
            Console.WriteLine(tp.Namespace);

        }
    }
}
