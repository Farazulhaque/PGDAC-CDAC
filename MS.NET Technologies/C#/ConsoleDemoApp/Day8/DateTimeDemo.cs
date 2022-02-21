using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day8
{
    internal class DateTimeDemo
    {
        static void Main(string[] args)
        {
            //DateTime dt = new DateTime(2022, 2, 21);
            //Console.WriteLine(dt);
            DateTime dt = DateTime.Now;
            Console.WriteLine($"dt                              : {dt}");
            Console.WriteLine($"dt.Date                         : {dt.Date}");
            Console.WriteLine($"dt.Month                        : {dt.Month}");
            dt = dt.AddMonths(1);
            Console.WriteLine($"dt.Month                        : {dt.Month}");
            Console.WriteLine($"dt.Year                         : {dt.Year}");
            Console.WriteLine($"dt.ToLongTimeString()           : {dt.ToLongTimeString()}");
            Console.WriteLine($"dt.ToLongDateString()           : {dt.ToLongDateString()}");
            Console.WriteLine($"dt.ToShortDateString()          : {dt.ToShortDateString()}");
            Console.WriteLine($"dt.ToShortTimeString()          : {dt.ToShortTimeString()}");
            Console.WriteLine($"dt.ToString(\"MM / dd / yyyy\")   : {dt.ToString("MM /dd/yyyy")}");
            Console.WriteLine($"dt.ToString(\"dddd, MMMMM, yy\")  : {dt.ToString("dddd, MMMMM, yy")}");
            Console.WriteLine($"dt.ToString(\"dd, MM, yy, HH: mm:ss\")   : {dt.ToString("dd, MM, yy, HH:mm:ss")}");
            Console.WriteLine($"dt.ToString(\"dd, MM, yy, HH: mm:ss tt\"): {dt.ToString("dd, MM, yy, HH:mm:ss tt")}");
            Console.WriteLine($"dt.ToString(\"dd - MM - yy, HH: mm:ss zzz\"): {dt.ToString("dd, MM, yy, HH:mm:ss zzz")}");


        }
    }
}
