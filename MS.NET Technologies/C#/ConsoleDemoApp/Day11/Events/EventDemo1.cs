using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day11.DelegateDemo
{
    delegate void MyEventHandler();
    internal class EventDemo1
    {
        //Event Decln
        public event MyEventHandler CheckSingleDigit;

        //handler method
        static void Message()
        {
            Console.WriteLine("you entered a single digit number");
        }
        static void Main(string[] args)
        {
            //Event subscription/instantiation
            EventDemo1 ev = new EventDemo1();

            // ev.CheckSingleDigit += new MyEventHandler(EventDemo1.Message);
            ev.CheckSingleDigit += EventDemo1.Message;//Event subscription/instantiation

            //Event Invocation/Fire the event
            int i = 5;

            while (i-- > 0)
            {
                int num;
                Console.WriteLine("Enter any number:");
                num = Int32.Parse(Console.ReadLine());
                if (num > 0 && num < 10)
                {
                    //ev.CheckSingleDigit.Invoke();
                    ev.CheckSingleDigit();//evnt invocation
                }
            }
        }
    }
}