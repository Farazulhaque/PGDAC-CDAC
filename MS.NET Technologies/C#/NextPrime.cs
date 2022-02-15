using System;

class Prime
{
    static void Main()
    {
        int num;
        Console.WriteLine("Enter a number:");
        num = Int32.Parse(Console.ReadLine());
        NextPrime(num);

    }
    static void NextPrime(int n)
    {
        if (isPrime(n))
        {
            Console.WriteLine(n);
        }
        else
        {
            int next_prime = GetNextprime(n);
            Console.WriteLine(next_prime);
        }
    }
    static bool isPrime(int num)
    {
        bool flag = false;
        for (int i = 2; i <= num / 2; ++i)
        {
            if (num % i == 0)
            {
                flag = true;
                break;
            }
        }

        if (!flag)
            return true;
        else
            return false;
    }

    static int GetNextprime(int num)
    {
        // int i = num;
        while (!isPrime(num))
        {
            num++;
        }
        return num;
    }
}