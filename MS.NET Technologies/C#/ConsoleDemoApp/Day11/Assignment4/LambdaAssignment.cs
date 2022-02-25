using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/* WAP to input two strings. Examine both the string & 
 * remove all the common characters from both of these 
 * string and display the resultant string, this program 
 * should be created using lambda expression. 
 */
namespace ConsoleDemoApp.Day11.Assignment4
{
    public delegate string CommonRemoveDelegate(string s1, string s2);
    internal class LambdaAssignment
    {
        static void Main(string[] args)
        {
            CommonRemoveDelegate commonRemoveDelegate = (string s1, string s2) =>
            {
                string s = "";
                for (int i = 0; i < s1.Length; i++)
                {
                    if (!s2.Contains(s1[i]))
                    {
                        s += s1[i];
                    }
                }
                for (int i = 0; i < s2.Length; i++)
                {
                    if (!s1.Contains(s2[i]))
                    {
                        s += s2[i];
                    }
                }

                return s;
            };

            Console.Write("Enter String1: ");
            string str1 = Console.ReadLine();

            Console.Write("Enter String2: ");
            string str2 = Console.ReadLine();

            string res = commonRemoveDelegate(str1, str2);
            Console.WriteLine(res);
        }
    }
}
