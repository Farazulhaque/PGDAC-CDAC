using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleDemoApp.MultiThreading
{
    class Test3
    {
        public static void Print(object obj)
        {
            Console.WriteLine("\nRunning Thread: " + Thread.CurrentThread.Name + "\tPooled Thread: " + Thread.CurrentThread.IsThreadPoolThread);
            //Console.WriteLine("\tPooled Thread: " + Thread.CurrentThread.IsThreadPoolThread);
        }
        public static void ProcessWithThreadMethod()
        {
            for (int i = 0; i < 5; i++)
            {
                Thread obj = new Thread(new ParameterizedThreadStart(Test3.Print));
                obj.Name = "Th - " + i;
                obj.Start();
                //obj.Start("Th - " + i);

            }
        }
        public static void ProcessWithThreadPoolMethod()
        {
            for (int i = 0; i < 5; i++)
            {
                ThreadPool.QueueUserWorkItem(new WaitCallback(Print));
            }
        }
    }
    internal class ThreadDemo2
    {
        static void Main(string[] args)
        {
            Stopwatch watch = new Stopwatch();
            Console.WriteLine("\nNormal Thread Execution: ");
            watch.Start();
            Test3.ProcessWithThreadMethod();
            watch.Stop();
            Console.WriteLine("Total Time consumed (ms): " + watch.ElapsedMilliseconds);
            Console.WriteLine("Total Time consumed: " + watch.ElapsedTicks);

            Console.WriteLine("ThreadPool Execution: ");
            watch.Start();
            Test3.ProcessWithThreadPoolMethod();
            watch.Stop();
            Console.WriteLine("Total Time consumed (ms): " + watch.ElapsedMilliseconds);
            Console.WriteLine("Pooled Total Time consumed: " + watch.ElapsedTicks);


            Console.WriteLine("Main Ended");
        }
    }
}
