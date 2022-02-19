using System;
namespace ConsoleDemoApp.Day4.Assignment
{
    internal class Admin
    {
        private static Admin _instance;
        private Admin() { }

        public static Admin GetInstance()
        {
            if (_instance == null)
            {
                _instance = new Admin();
            }
            return _instance;
        }
        public void DisplayMessage()
        {
            Console.WriteLine("My First SingleTon Program");
        }
    }
}
