using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day8
{
    internal class StringDemo
    {
        static void Main(string[] args)
        {
            string str = "abcd123efg45hijkl67mno89pqrs555tuv12wxyz";
            // Regular expression
            // fetch digit
            // Regex
            // Match
            // MatchCollection
            Regex r = new Regex(@str);
            bool res = Regex.IsMatch(str, "\\d");
            Console.WriteLine(res);

            res = Regex.IsMatch(str, @"\d{4}");
            Console.WriteLine(res);
            Console.WriteLine(str);
            Console.WriteLine("========================");
            Match m = Regex.Match(str, "\\d{2,}");
            Console.WriteLine(m.Success);
            Console.WriteLine(m.Value);
            Console.WriteLine(m.Length);
            m = m.NextMatch();
            Console.WriteLine(m.Value);
            m = m.NextMatch();
            Console.WriteLine(m.Value);
            Console.WriteLine("========================");
            MatchCollection matches = Regex.Matches(str, @"\d{2,}");
            foreach (Match match in matches)
            {
                Console.WriteLine(match.Value);
            }
            Console.WriteLine("========================");
            string[] splitdata = Regex.Split(str, @"\d{2,}");
            foreach (var item in splitdata)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("========================");
            splitdata = Regex.Split(str, @"\D{2,}");
            foreach (var item in splitdata)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("========================");
            string replacedstr = Regex.Replace(str, @"\d{2,}", "_");
            Console.WriteLine(replacedstr);

            //Math.Cos(Math.PI / 2);
            Random random = new Random();
            Console.WriteLine(random.Next(1, 1000));
        }
    }
}
