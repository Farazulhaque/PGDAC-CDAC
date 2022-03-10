using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EFCodeFirstDemo.Models
{
    public class Student
    {
        public int StudentId { get; set; }
        public string StudentName { get; set; }
        public string DateOfBirth { get; set; }
        public Address Address { get; set; }
    }
    public class Address
    {
        public int Id { get; set; }
        public string AddressLine { get; set; }
        public string City { get; set; }
        public ICollection<Student> Students { get; set; }
    }
}