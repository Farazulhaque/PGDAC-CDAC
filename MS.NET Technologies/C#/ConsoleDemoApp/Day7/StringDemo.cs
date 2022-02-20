using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day7
{
    internal class StringDemo
    {
        static void Main(string[] args)
        {
            /*
            string s1 = "cdac";
            string s2 = "cdac";
            StringBuilder sb1 = new StringBuilder("cdac");
            StringBuilder sb2 = new StringBuilder("cdac");

            Console.WriteLine($"s1: {s1.GetHashCode()}");
            Console.WriteLine($"s2: {s2.GetHashCode()}");
            Console.WriteLine($"sb1: {sb1.GetHashCode()}");
            Console.WriteLine($"sb2: {sb2.GetHashCode()}");

            Console.WriteLine($"s1 == s2: {s1 == s2}");
            Console.WriteLine($"sb1 == sb2: {sb1 == sb2}");
            Console.WriteLine($"s1.Equals(s2): {s1.Equals(s2)}");
            Console.WriteLine($"sb1.Equals(sb2): {sb1.Equals(sb2)}");

            
            string str = "";
            str = string.Empty;
            if (str == string.Empty)
                Console.WriteLine("String is Empty");

            int x = 20;
            int y = 30;
            string str2 = string.Format("value of x: {0}\tValue of y: {1}", x, y);
            Console.WriteLine(str2);
            */
            StringBuilder sb = new StringBuilder("C Sharp", 20);
            Console.WriteLine(sb);
            Console.WriteLine(sb.Length);       // length
            Console.WriteLine(sb.Capacity);     // some default value beween sb.Length and sb.MaxCapacity
            Console.WriteLine(sb.MaxCapacity);  // max value it can hold
            Console.WriteLine(Int32.MaxValue);

            sb.Append(" is programmming language");
            Console.WriteLine(sb);
            Console.WriteLine(sb.Length);       // length
            Console.WriteLine(sb.Capacity);     // some default value beween sb.Length and sb.MaxCapacity
                                                //    Console.WriteLine(sb.MaxCapacity);  // max value it can hold
        }
    }
}
