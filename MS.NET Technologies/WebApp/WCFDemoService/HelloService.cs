using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WCFDemoService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "WCFDemoService" in both code and config file together.
    public class HelloService : IHelloService
    {
        public void DoWork()
        {
            Console.WriteLine("Service working");
        }

        public int Addnumbers(int x, int y)
        {
            return x + y;
        }

        public string message(string message)
        {
            return message.ToUpper();
        }
    }
}
