using System;

namespace ConsoleDemoApp.Day4.ClassWork
{
    internal class MethodCalling
    {
        static void Call_By_Value(int x, int y)
        {
            x = x + 30;
            y = y + 40;
            Console.WriteLine($"x: {x}\ty: {y}");
        }

        static void Call_By_Reference(ref int x, ref int y)
        {
            x = x + 30;
            y = y + 40;
            Console.WriteLine($"x: {x}\ty: {y}");
        }
        static void Call_By_OutputParameter(int x, int y, out int sum, out int diff)
        {
            sum = x + y;
            diff = x - y;
        }
        static void Call_By_Named_Default(string fname, string lname = "Aftab", int salary = 25000)
        {
            Console.WriteLine($"Welcome {fname} {lname}");
            Console.WriteLine($"Your salary is {salary}");
        }

        // params argument
        static int Sum_Values(int i, params int[] arr) // if more than one argument are passing then params argument should be last argument
        {
            int sum = 0;
            foreach (var item in arr)
            {
                sum += item;
            }
            return sum;
        }
        static void Main(string[] args)
        {
            /*
            int a, b, sum, diff;
            a = 30; b = 20;
            
            Console.WriteLine($"a: {a}\tb: {b}");
            //Call_By_Value(a, b);
            Call_By_Reference(ref a, ref b);
            Console.WriteLine($"a: {a}\tb: {b}");
            //Call_By_Reference(ref a, ref b);
            

            Call_By_OutputParameter(a, b, out sum, out diff);
            Console.WriteLine($"Sum: {sum}\tDifference: {diff}");
            

            // NamedArgument
            Call_By_Named_Default(fname: "Arisha", lname: "Aftab", salary: 36000);
            Call_By_Named_Default(lname: "Aftab", fname: "Arisha", salary: 45000);
            Call_By_Named_Default(fname: "Arisha", lname: "Aftab");
            Call_By_Named_Default("Arisha");

            */

            int res = Sum_Values(10, new[] { 1, 2, 3, 4, 5 });
            Console.WriteLine("Result: " + res);

            res = Sum_Values(1, 2, 3, 4, 5, 6);
            Console.WriteLine("Result: " + res);

            res = Sum_Values(1, 2, 3, 4);
            Console.WriteLine("Result: " + res);

            res = Sum_Values(1, 2);
            Console.WriteLine("Result: " + res);


        }
    }
}
