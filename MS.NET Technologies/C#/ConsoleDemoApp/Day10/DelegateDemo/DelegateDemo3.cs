using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day10.DelegateDemo
{
    internal class DelegateDemo3
    {
        //for Func Delegate
        //static int Add(int x, int y, int z) {
        //    return x + y + z;
        //}

        //for Action Delegate
        static void Add(int x, int y, int z)
        {
            // return x + y + z;
            Console.WriteLine("sum is:" + (x + y + z));
        }
        static void Main(string[] args)
        {
            //Func Delegate Example
            //Func<int> GetRandom = delegate () {
            //    return new Random().Next(0, 200);
            //};
            //Console.WriteLine("10 random numbers:");
            //for (int i = 0; i < 10; i++)
            //{
            //    Console.WriteLine(GetRandom());
            //}
            //Func<int, int, int, int> AddNumbers = DelegateDemo3.Add;
            //// Func<int, int, int, int> AddNumbers = new Func<int, int, int, int>(Add);
            //int sum = AddNumbers(30,40,50);
            //Console.WriteLine("result:"+sum);

            //Func Delegate Example
            //Action<int, int, int> AddNumbers = DelegateDemo3.Add;
            //AddNumbers(30, 40, 50);
            //Action<int> square = (int n) => { Console.WriteLine($"square of {n} is {n * n}"); };
            //Action<int> square = n => Console.WriteLine($"square of {n} is {n * n}");
            //square(5);

            //Predicate Delegate Example
            Predicate<string> isLower = str => str.Equals(str.ToLower());
            Console.WriteLine(isLower("cdac123"));
            Console.WriteLine(isLower("Cdac123"));
            Console.WriteLine(isLower("cdac!!!"));
        }
    }
}