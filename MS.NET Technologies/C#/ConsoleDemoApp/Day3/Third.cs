using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day3
{
    enum Month
    {
        Jan, feb, March, April, May
    }
    internal class Third
    {
        static void Main(string[] args)
        {
            /*
             * 
            Console.WriteLine("Press any key: ");
            // ConsoleKeyInfo ck = Console.ReadKey(); // displays pressed key char on console
            ConsoleKeyInfo ck=Console.ReadKey(true); // hides pressed keychar on console
            Console.Write("*");
            // ConsoleKey
            Console.WriteLine("\nPressed Key: "+ck.Key);
            if (ConsoleKey.Enter!=ck.Key)
            {
                Console.WriteLine("\nKeyChar: " + ck.KeyChar);
            }
            */
            Console.WriteLine("Enter Password: ");
            ConsoleKeyInfo ck =Console.ReadKey(true);
            string password = "";
            while(ck.Key != ConsoleKey.Enter)
            {
                Console.Write("*");
                password += ck.KeyChar;
                ck = Console.ReadKey(true);
            }
            Console.WriteLine("\nEntered Password is: " + password);


        }
    }
}
