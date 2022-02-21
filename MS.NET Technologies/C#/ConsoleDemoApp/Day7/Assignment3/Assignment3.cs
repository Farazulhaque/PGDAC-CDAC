using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day7.Assignment3
{
    internal class Assignment3
    {
        static void Main(string[] args)
        {
            FetchOutput("A4B5C2");
            Console.WriteLine("\n=====================\n");
            GetFrame(4, 5, "#");
            Console.WriteLine("\n=====================\n");
            ToCamelCase("hello_csharp");
            ToSnakeCase("helloCsharp");
            ToCamelCase("is_modal_open");
            ToSnakeCase("getColor");
            Console.WriteLine("\n=====================\n");
            Console.WriteLine($"Math.PI               : {Math.PI}");
            Console.WriteLine($"Math.Round(100.4)     : {Math.Round(100.4)}");
            Console.WriteLine($"Math.Round(100.6)     : {Math.Round(100.6)}");
            Console.WriteLine($"Math.Floor(100.4)     : {Math.Floor(100.4)}");
            Console.WriteLine($"Math.Floor(100.6)     : {Math.Floor(100.6)}");
            Console.WriteLine($"Math.Ceiling(100.4)   : {Math.Ceiling(100.4)}");
            Console.WriteLine($"Math.Ceiling(100.6)   : {Math.Ceiling(100.6)}");
            Console.WriteLine($"Math.Sqrt(25)         : {Math.Sqrt(25)}");
            Console.WriteLine($"Math.Truncate(110.52) : {Math.Truncate(110.52)}");
            Console.WriteLine($"Math.Truncate(110.32) : {Math.Truncate(110.32)}");
            Console.WriteLine($"Math.Math.Pow(3,4)    : {Math.Pow(3, 4)}");
            Console.WriteLine($"Math.Sin(60)          : {Math.Sin(60)}");
            Console.WriteLine($"Math.Cos(60)          : {Math.Cos(60)}");
            Console.WriteLine($"Math.Tan(60)          : {Math.Tan(60)}");
            Console.WriteLine($"Math.Round(100.4236,2): {Math.Round(100.4236, 2)}");
            Console.WriteLine($"Math.Round(100.4456,2): {Math.Round(100.4456, 2)}");
        }
        static void FetchOutput(string str)
        {
            string str2 = "";
            char alph = ' ';
            foreach (dynamic chr in str)
            {
                int num = (int)Char.GetNumericValue(chr);
                if (num > 0)
                {
                    for (int i = 0; i < num; i++)
                    {
                        str2 += alph;
                    }
                }
                else
                {
                    alph = chr;
                }
            }
            Console.WriteLine(str2);
        }
        static void GetFrame(int width, int height, string ch)
        {
            if (width < 3 || height < 3)
            {
                Console.WriteLine("Invalid");
            }
            else
            {
                Array frame = Array.CreateInstance(typeof(string), height);
                for (int i = 0; i < height; i++)
                {
                    for (int j = 0; j < width; j++)
                    {
                        if (i == 0 || i == height - 1 || j == 0 || j == width - 1)
                        {
                            Console.Write("#");
                        }
                        else if (j != 0 || j != width - 1)
                        {
                            Console.Write(" ");
                        }
                    }
                    Console.WriteLine();
                }
            }
        }
        static void ToCamelCase(string str)
        {
            string camel_case = "";
            for (int i = 0; i < str.Length; i++)
            {
                if (str[i] == '_')
                {
                    camel_case += str[++i].ToString().ToUpperInvariant();
                }
                else
                {
                    camel_case += str[i];
                }
            }
            Console.WriteLine(camel_case);
        }
        static void ToSnakeCase(string str)
        {
            string snake_case = "";
            for (int i = 0; i < str.Length; i++)
            {
                if (str[i] >= 65 && str[i] <= 90)
                {
                    snake_case += "_" + str[i].ToString().ToLowerInvariant();
                }
                else
                {
                    snake_case += str[i];
                }
            }
            Console.WriteLine(snake_case);
        }
    }

}
