using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloServiceConsoleClient
{
    internal class Program
    {
        static void Main(string[] args)
        {
            MyFirstService.HelloServiceClient client = new MyFirstService.HelloServiceClient("NetTcpBinding_IHelloService");
            client.DoWork();

            Console.WriteLine($"Sum is: {client.Addnumbers(30, 50)}");
            Console.WriteLine($"{client.message("Hello")}");
        }
    }
}
