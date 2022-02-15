using System;

class Count
{
    static void Main()
    {
        string str;
        Console.WriteLine("Enter a string:");
        str = Console.ReadLine();
        DuplicateCount(str);

    }
    static void DuplicateCount(string str)
    {
        int count = 0;
        for (int i = 0; i < str.Length; i++)
        {
            char ch = str[i];
            int freq = 0;
            foreach (char c in str)
            {
                if (c == ch)
                {
                    freq++;
                }
            }
            if (freq > 1)
            {
                str = str.Replace(str[i] + "", "");
                count++;
            }
        }
        Console.WriteLine(count);
    }
}