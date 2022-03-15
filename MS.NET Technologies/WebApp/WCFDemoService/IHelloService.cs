using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WCFDemoService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IWCFDemoService" in both code and config file together.
    [ServiceContract]
    public interface IHelloService
    {
        [OperationContract]
        void DoWork();

        [OperationContract]
        string message(string message);

        [OperationContract]
        int Addnumbers(int x, int y);

    }
}
