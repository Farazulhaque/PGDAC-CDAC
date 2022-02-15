using System;

class CheckHexcode
{
    static void Main()
    {
        string hexcode;
        bool flag = true;
        Console.WriteLine("Enter hex code:");
        hexcode = Console.ReadLine();
        if (hexcode[0] == '#')
        {
            if (hexcode.Length <= 7)
            {
                for (int i = 1; i < hexcode.Length; i++)
                {
                    if ((hexcode[i] >= 65 && hexcode[i] <= 90) || (hexcode[i] >= 97 && hexcode[i] <= 122) || hexcode[i] >= 0)
                    {
                        // Console.WriteLine(hexcode[i]);
                    }
                    else
                    {
                        flag = false;
                    }
                }
            }
            else
            {
                flag = false;
            }
        }
        Console.WriteLine(flag);
    }
}