using System;
class DataTypes
{
    static int? id; // static, null
    static void Main(string[] args)
    {
        // ? is used to store null value
        // int? id = null; // local variable
        Console.WriteLine(id);
        if (id.HasValue)
            Console.WriteLine("id " + id);
        id = 20;
        if (id.HasValue)
            Console.WriteLine("id " + id);

        Nullable<int> mark = null;  // c# 2.0 onwards

        int x = default(int);       // older version
        float y = default(float);   // older version
                                    // int x = default();       // newer version
                                    // float y = default();     // newer version

        Console.WriteLine("value of x = {0} and value of y = {1}", x, y);
    }
}