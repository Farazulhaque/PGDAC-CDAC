using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day11.Assignment4
{
    delegate void MyEventHandler(int num);
    internal class EventCurrencyAssignment
    {
        public event MyEventHandler CurrencyFormatter;
        public void Convert(int num)
        {
            string str = num.ToString();
            string s1 = "";
            if (str.Length == 5)
            {
                for (int i = 0; i < str.Length; i++)
                {
                    if (str[i] == '0') { s1 += ""; }
                    else if (str[i] == '1') { s1 += "One "; }
                    else if (str[i] == '2') { s1 += "Two "; }
                    else if (str[i] == '3') { s1 += "Three "; }
                    else if (str[i] == '4') { s1 += "Four "; }
                    else if (str[i] == '5') { s1 += "Five "; }
                    else if (str[i] == '6') { s1 += "Six "; }
                    else if (str[i] == '7') { s1 += "Seven "; }
                    else if (str[i] == '8') { s1 += "Eight "; }
                    else if (str[i] == '9') { s1 += "Nine "; }
                }
                Console.WriteLine(s1);
            }
            else if (str.Length == 4)
            {
                for (int i = 0; i < str.Length; i++)
                {
                    // For Thousands
                    if (i == 0)
                    {
                        if (str[i] == '1') { s1 += "One Thousand "; }
                        else if (str[i] == '2') { s1 += "Two Thousand "; }
                        else if (str[i] == '3') { s1 += "Three Thousand "; }
                        else if (str[i] == '4') { s1 += "Four Thousand "; }
                        else if (str[i] == '5') { s1 += "Five Thousand "; }
                        else if (str[i] == '6') { s1 += "Six Thousand "; }
                        else if (str[i] == '7') { s1 += "Seven Thousand "; }
                        else if (str[i] == '8') { s1 += "Eight Thousand "; }
                        else if (str[i] == '9') { s1 += "Nine Thousand "; }
                    }
                    // For Hundreds
                    else if (i == 1)
                    {
                        if (str[i] == '0') { s1 += ""; }
                        else if (str[i] == '1') { s1 += "One Hundred "; }
                        else if (str[i] == '2') { s1 += "Two Hundred "; }
                        else if (str[i] == '3') { s1 += "Three Hundred "; }
                        else if (str[i] == '4') { s1 += "Four Hundred "; }
                        else if (str[i] == '5') { s1 += "Five Hundred "; }
                        else if (str[i] == '6') { s1 += "Six Hundred "; }
                        else if (str[i] == '7') { s1 += "Seven Hundred "; }
                        else if (str[i] == '8') { s1 += "Eight Hundred "; }
                        else if (str[i] == '9') { s1 += "Nine Hundred "; }
                    }
                    // For Tens
                    else if (i == 2)
                    {
                        if (str[i] == '0') { s1 += ""; }
                        else if (str[i] == '1')
                        {
                            if (str[i + 1] == '0') { s1 += "Ten"; }
                            else if (str[i + 1] == '1') { s1 += "Eleven"; }
                            else if (str[i + 1] == '2') { s1 += "Twelve"; }
                            else if (str[i + 1] == '3') { s1 += "Thirteen"; }
                            else if (str[i + 1] == '4') { s1 += "Fourteen"; }
                            else if (str[i + 1] == '5') { s1 += "Fifteen"; }
                            else if (str[i + 1] == '6') { s1 += "Sixteen"; }
                            else if (str[i + 1] == '7') { s1 += "Seventeen"; }
                            else if (str[i + 1] == '8') { s1 += "Eighteen"; }
                            else if (str[i + 1] == '9') { s1 += "Nineteen"; }
                        }
                        else if (str[i] == '2') { s1 += "Twenty "; }
                        else if (str[i] == '3') { s1 += "Thirty "; }
                        else if (str[i] == '4') { s1 += "Fourty "; }
                        else if (str[i] == '5') { s1 += "Fifty"; }
                        else if (str[i] == '6') { s1 += "Sixty "; }
                        else if (str[i] == '7') { s1 += "Seventy "; }
                        else if (str[i] == '8') { s1 += "Eighty "; }
                        else if (str[i] == '9') { s1 += "Ninety "; }
                    }
                    // For Ones
                    else if (i == 3)
                    {
                        if (str[i] == '0') { s1 += ""; }
                        else if (str[i] == '1') { s1 += "One "; }
                        else if (str[i] == '2') { s1 += "Two "; }
                        else if (str[i] == '3') { s1 += "Three "; }
                        else if (str[i] == '4') { s1 += "Four "; }
                        else if (str[i] == '5') { s1 += "Five "; }
                        else if (str[i] == '6') { s1 += "Six "; }
                        else if (str[i] == '7') { s1 += "Seven "; }
                        else if (str[i] == '8') { s1 += "Eight "; }
                        else if (str[i] == '9') { s1 += "Nine "; }
                    }
                }
                Console.WriteLine(s1);
            }
            else { Console.WriteLine($"You Entered Wrong Number."); }

        }
        static void Main(string[] args)
        {
            // Event subscription/instantiation
            EventCurrencyAssignment eventCurrencyAssignment = new EventCurrencyAssignment();

            // Event subscription/instantiation
            eventCurrencyAssignment.CurrencyFormatter = eventCurrencyAssignment.Convert;

            // Event invocation
            eventCurrencyAssignment.CurrencyFormatter(1234);
            eventCurrencyAssignment.CurrencyFormatter(12345);
            eventCurrencyAssignment.CurrencyFormatter(123);

        }
    }
}
