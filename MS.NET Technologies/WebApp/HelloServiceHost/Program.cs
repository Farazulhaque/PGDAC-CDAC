using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace HelloServiceHost
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Hosting logic the service
            ServiceHost host = new ServiceHost(typeof(WCFDemoService.HelloService));
            host.Open();
            Console.WriteLine("Service Started at: " + DateTime.Now);
            Console.ReadKey();
        }
    }
}
