using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.MultiThreading
{
    internal class TaskUsingForLoop
    {
        static void Main(string[] args)
        {
            DateTime sTime = DateTime.Now;
            Console.WriteLine($"For loop execution started at: {sTime.ToLongTimeString()}");
            for (int i = 0; i < 10; i++)
            {
                long sum = DoTask();
                Console.WriteLine($"{i} => {sum}");
            }
            DateTime eTime = DateTime.Now;
            Console.WriteLine($"For loop execution ended at: {eTime.ToLongTimeString()}");
            TimeSpan span = eTime - sTime;
            int msecond = Convert.ToInt32(span.TotalMilliseconds);
            Console.WriteLine($"Total time taken: {msecond}");
        }
        static long DoTask()
        {
            long sum = 0;
            //for (int i = 0; i < Int32.MaxValue; i++)
            for (int i = 0; i < 10000000; i++)
            {
                sum += i;
            }
            return sum;
        }
    }
}
