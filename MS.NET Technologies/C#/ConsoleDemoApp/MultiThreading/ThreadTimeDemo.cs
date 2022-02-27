using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleDemoApp.MultiThreading
{
    class Test
    {
        public void DisplayTime()
        {
            DateTime d = DateTime.Now;
            //Console.WriteLine(d.ToString());
            string dt = d.ToString();
            Console.Write(dt);
            Console.SetCursorPosition(dt.Length, 0);

            int sec = int.Parse(dt.Split(':')[2]);
            int min = int.Parse(dt.Split(':')[1]);
            int hr = int.Parse(dt.Split(':')[0].Substring(dt.Split(':')[0].Length - 2));
            //Console.WriteLine("\n" + hr);
            while (true)
            {
                if (sec < 10)
                {
                    Console.Write("\b");
                    Console.Write(sec++);
                    Thread.Sleep(1000);
                }
                else if (sec < 60)
                {
                    Console.SetCursorPosition(dt.Length, 0);
                    Console.Write("\b");
                    Console.Write("\b");
                    Console.Write(sec++);
                    Thread.Sleep(1000);
                }
                else if (sec == 60)
                {
                    sec = 0;
                    Console.Write("\b");
                    Console.Write("\b");
                    Console.Write("00");

                    Console.SetCursorPosition(dt.Length - 3, 0);
                    min++;
                    if (min < 10)
                    {
                        Console.Write("\b");
                        Console.Write(min);
                        //Thread.Sleep(1000);
                        Console.SetCursorPosition(dt.Length, 0);

                    }
                    else if (min < 60)
                    {
                        Console.Write("\b");
                        Console.Write("\b");
                        Console.Write(min);
                        //Thread.Sleep(1000);
                        Console.SetCursorPosition(dt.Length, 0);
                    }
                    else if (min == 60)
                    {
                        min = 0;
                        Console.Write("\b");
                        Console.Write("\b");
                        Console.Write("00");

                        Console.SetCursorPosition(dt.Length - 6, 0);
                        hr++;
                        if (hr < 10)
                        {
                            Console.Write("\b");
                            Console.Write(hr);
                            //Thread.Sleep(1000);
                            Console.SetCursorPosition(dt.Length, 0);
                        }
                        else if (hr < 24)
                        {
                            Console.Write("\b");
                            Console.Write("\b");
                            Console.Write(hr);
                            //Thread.Sleep(1000);
                            Console.SetCursorPosition(dt.Length, 0);
                        }
                        else
                        {
                            Console.Write("\b");
                            Console.Write("\b");
                            Console.Write("00");
                            Console.WriteLine("00");
                            Console.SetCursorPosition(dt.Length, 0);
                        }
                    }
                }
            }


        }
    }
    internal class ThreadTimeDemo
    {
        static void Main(string[] args)
        {
            //DateTime da = new DateTime();
            //Console.WriteLine(da.ToLongTimeString());
            //Console.WriteLine(da.ToLocalTime());
            //Console.WriteLine(DateTime.Now.ToLongTimeString());
            Test t1 = new Test();
            Thread th = new Thread(t1.DisplayTime);
            th.Start();
        }
    }
}
