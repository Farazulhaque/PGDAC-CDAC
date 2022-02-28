using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleDemoApp.MultiThreading
{
    class Test4
    {
        public void Print() // t4
        {
            lock (this)
            {
                for (int i = 0; i < 10; i++)
                {
                    Console.WriteLine($"Running Thread: {Thread.CurrentThread.Name}\tValue of i: {i}");
                }
                GetRandom = new Random().Next(0, 50);
                Monitor.Pulse(this); // Notifies the thread is in waiting queue
            }
        }
        public int GetRandom
        {
            get;
            set;
        }
    }
    internal class ThreadDemo3
    {
        static void Main(string[] args)
        {
            Test4 t4 = new Test4();
            Thread th1 = new Thread(t4.Print);
            th1.Name = "Thread - 1";
            th1.Start();

            Thread th2 = Thread.CurrentThread;
            th2.Name = "Main Thread";
            lock (t4)
            {
                Monitor.Wait(t4); // wait for resource to be free
                Console.WriteLine("In Main");
                for (int i = 0; i < t4.GetRandom; i++)
                {
                    Console.WriteLine($"Running Thread: {Thread.CurrentThread.Name}\tValue of i: {i}");
                }
            }


        }
    }
}
