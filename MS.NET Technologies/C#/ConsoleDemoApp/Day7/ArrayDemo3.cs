using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day7
{
    internal class ArrayDemo3
    {
        static void Main(string[] args)
        {
            //Creating and using arrays using Array Class
            Array cities = Array.CreateInstance(typeof(string), 5);
            // Array matrix = Array.CreateInstance(typeof(int), 5,4);
            //cities[0] = "patna"; //invalid
            //Console.WriteLine(cities[2]);//invalid
            //for assigning value use Setvalue() method
            cities.SetValue("patna", 0);
            cities.SetValue("noida", 1);
            cities.SetValue("delhi", 2);
            cities.SetValue("mumbai", 3);
            cities.SetValue("lucknow", 4);
            //for reading value use Getvalue() method
            //for (int i = 0; i < cities.Length; i++)
            //{
            //    Console.WriteLine(cities.GetValue(i));
            //}

            //Console.WriteLine(cities.GetValue(1));
            //Console.WriteLine(cities.GetValue(2));
            //Console.WriteLine(cities.GetValue(3));
            //Console.WriteLine(cities.GetValue(4));
            Console.WriteLine("using foreach:");
            foreach (var city in cities)
            {
                Console.WriteLine(city);
            }

            Array newcity = (Array)cities.Clone();//cloning,shallow copy
            newcity.SetValue("Bhopal", 3);
            //Console.WriteLine(string.Join(",",cities));
            //Console.WriteLine(string.Join(",", newcity));
            Console.WriteLine("new cities:");
            foreach (var city in newcity)
            {
                Console.WriteLine(city);
            }
            Console.WriteLine("Original cities:");
            foreach (var city in cities)
            {
                Console.WriteLine(city);
            }


            int[] arr = Enumerable.Range(500, 100)
                                 .Where(n => n % 2 == 0) //n=>n%2==0 lambda expression                            
                                 .ToArray();
            Console.WriteLine("Array values:");
            Console.WriteLine(string.Join(",", arr));

            int sum = Enumerable.Range(500, 100)
                                  .Where(n => n % 2 != 0) //n=>n%2!=0 lambda expression                            
                                  .ToArray().Sum();
            Console.WriteLine("odd sum:" + sum);
        }
    }
}