using System;
using PrivateAssembly; // namespace reference of created dll

class UsePrivateLib{
    static void Main(){
        Calculator obj = new Calculator();
        obj.Addition(30,30);
        // obj.Substract(60,30); // not accessible because it is protected member 
        // obj.Multiply(30,2); // not accessible because it is protected member
        Test t = new Test();
        t.Show();
    }
}

class Test:Calculator{
    public void Show(){
        this.Substract(60,30);
        this.Multiply(30,2);

        
    }
}