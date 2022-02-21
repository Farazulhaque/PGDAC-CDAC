using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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

    }

}
