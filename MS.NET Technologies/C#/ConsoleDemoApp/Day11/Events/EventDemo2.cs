using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day11.Events
{
    // Publisher and Subscriber are in different class

    public delegate void MyEventHandler2(int n);
    class Publisher
    {
        // Event Creation
        public event MyEventHandler2 Cube;

        // Generally we use Notify method name
        public void Notify(int num)
        {
            if (Cube != null)
                Cube.Invoke(num); // Invokes event
            else
                Console.WriteLine("No Subscription for Event Cube");
        }

    }
    // Subscriber Class
    internal class EventDemo2
    {
        // Handler method/logic
        static void GetCube(int number)
        {
            Console.WriteLine($"Cube of {number} is {Math.Pow(number, 3)}");
        }
        static void Main(string[] args)
        {
            Publisher publisher = new Publisher();
            publisher.Cube += EventDemo2.GetCube; // Subscription line
            publisher.Notify(5);
            Console.WriteLine("=========");
            //publisher.Cube -= EventDemo2.GetCube; // Remove of event
            publisher.Cube += (num) => { Console.WriteLine(num * num); };
            publisher.Notify(10);
        }

        private static void Publisher_Cube(int n)
        {
            throw new NotImplementedException();
        }
    }
}
