using System;

namespace ConsoleDemoApp.Day6
{
    internal class Student
    {
        int _RollNo;
        string _Name;
        int _Age;
        string _Course;
        static string _College;
        static Student()
        {
            _College = "Astric";
        }

        public int RollNo
        {
            get
            {
                return _RollNo;
            }
            set
            {
                _RollNo = value;
            }
        }
        public string Name
        {
            get
            {
                return _Name; ;
            }
            set
            {
                _Name = value;
            }
        }
        public int Age
        {
            get
            {
                return _Age;
            }
            set
            {
                if (value > 0)
                    _Age = value;
                else
                    Console.WriteLine("Only Positive Value is allowed");
            }
        }
        // Write only property
        public string Course
        {
            set
            {
                _Course = value;
            }
        }
        // Read only property
        public string College
        {
            get
            {
                return _College;
            }
        }
        public override string ToString()
        {
            return $"Roll: {_RollNo}\tName: {_Name}\tAge: {_Age}\tCourse: {_Course}\tCollege: {_College}";
        }

        // auto implemented property
        // wthout any class data fields
        // for such property both get and set accessor are compulsory
        // compiler will create backing data field internally
        public int MyProperty1 { get; set; }
        public string MyProperty2 { get; set; }
        public float MyProperty3 { get; set; }

    }
    class StudentMain
    {
        static void Main(string[] args)
        {
            /*
            Student st = new Student();
            // Write operation, set accessor will be called
            st.Name = "Arisha♥";
            st.Age = 25;
            st.RollNo = 1;
            // Read operation, get accessor will be called
            Console.WriteLine($"{st.Name}\t{st.RollNo}\t{st.Age}");
            // print using ToString() method
            Console.WriteLine(st);

            Student st2 = new Student()
            {
                RollNo = 2,
                Name = "Faraz☺",
                Age = 25
            };
            Student st3 = new Student()
            {
                RollNo = 3,
                Name = "Kashaf☻"
            };
            Student st4 = new Student()
            {
                RollNo = 4
            };

            Console.WriteLine(st2);
            Console.WriteLine(st3);
            Console.WriteLine(st4);

            Student st5 = new Student();
            st5.Course = "PG-DAC";
            //st5.College = "CDAC"; // In valid
            // Console.WriteLine(st5.Course); //  In valid
            Console.WriteLine(st5);
            Console.WriteLine(st5.College);
        */

            Student st6 = new Student();
            st6.MyProperty1 = 1000;
            st6.MyProperty2 = "CDAC";
            st6.MyProperty3 = 1.2f;
            Console.WriteLine(st6.MyProperty1);
            Console.WriteLine(st6.MyProperty2);
            Console.WriteLine(st6.MyProperty3);

            Employee emp = new Employee();
            emp.FirstName = "Kashaf";
            emp.LastName = "Syed";
            emp.Age = 25;
            emp.Display(100);
            emp.DisplayAge();
        }
    }
}
