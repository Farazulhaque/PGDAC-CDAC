using ConsoleDemoApp.Day7;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.LinqExp
{
    internal class LinqDemo1
    {
        static void Main(string[] args)
        {
            int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
            var evenNums = from num in numbers
                           where num % 2 == 0
                           select num;
            Console.WriteLine("Even Numbers: ");
            foreach (int num in evenNums)
                Console.WriteLine(num);

            ArrayList list = new ArrayList()
            {
                10,"Noida", "Patna", 25, 30, "Mumbai",
                30, new Product(){PId=1000}
            };
            list.Add(20);
            var strs = from n in list.OfType<string>() select n;
            Console.WriteLine("List Data of type string");
            foreach (var str in strs)
                Console.WriteLine(str);

            var nums = from n in list.OfType<int>()
                       where n % 2 == 0
                       select n;
            Console.WriteLine("List Data of type int(even)");
            foreach (var num in nums)
                Console.WriteLine(num);


            int[][] arr = new int[3][]
            {
                new int[]{1,2,3,4},
                new int[]{2,4},
                new int[] {9,10,11}
            };

            var maxarr = arr.Select(v => v.Max()).ToArray();
            Console.WriteLine("Maximum of each array are: ");
            foreach (var num in maxarr)
                Console.WriteLine(num);

            IList<string> names = new List<string>()
            {
                "Sunil Kumar",
                "Manoj Kumar",
                "Aman Yadav",
                "Arisha Aftab",
                "Shaziya",
                "Kashaf Shamim"
            };
            var result = from name in names
                         where name.EndsWith("Kumar")
                         orderby name ascending
                         select name;
            Console.WriteLine("Getting alll names that ends with Kumar");
            foreach (var name in result)
                Console.WriteLine(name);
        }
    }
}
