using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace EFCodeFirstDemo.Models
{
    //[Table(name:"Student master")]
    public class Student
    {
        public int StudentId { get; set; }

        [Required]
        [Display(Name = "Student Name")]
        public string StudentName { get; set; }

        [Required]
        public string DateOfBirth { get; set; }
        //public string Email { get; set; }
        public Address Address { get; set; }
    }
    public class Address
    {
        public int Id { get; set; }
        [Required]
        public string AddressLine { get; set; }

        [Required(ErrorMessage = "City Name is Mandatory")]
        public string City { get; set; }
        public ICollection<Student> Students { get; set; }
    }
}