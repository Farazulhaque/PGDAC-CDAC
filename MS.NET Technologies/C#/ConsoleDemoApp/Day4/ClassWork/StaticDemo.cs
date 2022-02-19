using System;
namespace ConsoleDemoApp.Day4.ClassWork
{
    // In Java, class cannot be static
    // In C#, we cannot declare instance members in static class
    // static classes cannot have instance constructors
    // within static class, all members should be static
    internal static class StaticDemo
    {
        public static int id;
        static StaticDemo()
        {
            Console.WriteLine("Static Constructor");
            id = 1000;
        }
        public static void Display()
        {
            Console.WriteLine($"{id}");
        }

    }
    class StaticMain
    {
        static void Main(string[] args)
        {
            // Cannot create an instance of static class
            // StaticDemo staticDemo = new StaticDemo();

            // We can access static class members by class name
            StaticDemo.Display();
            Console.WriteLine(StaticDemo.id);
        }
    }
}
