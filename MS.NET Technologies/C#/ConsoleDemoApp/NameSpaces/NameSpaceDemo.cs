using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MConsole = ConsoleDemoApp.NameSpaces.Console;
using MyConsole = System.Console;

namespace ConsoleDemoApp.NameSpaces
{
    internal class NameSpaceDemo
    {
        static void Main(string[] args)
        {
            System.Console.WriteLine("Arisha");
            MyConsole.WriteLine("Aftab");
            Console obj = new Console();
            obj.print();
            MConsole obj2 = new MConsole();
            obj2.print();
        }
    }
    class Console
    {
        public void print()
        {
            System.Console.WriteLine("Faraz");
            MyConsole.WriteLine("Haque");
        }
    }
}
