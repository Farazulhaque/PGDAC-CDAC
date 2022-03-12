using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DB_FirstEntity.Models
{
    //DTO (Data Transfer Object) Class
    public class EmployeeDetails
    {
        // Employee POCO (Plain Old Clr Object)
        public int EId { get; set; }
        public string Name { get; set; }
        public string Email { get; set; }

        //Address POCO
        public string Addressline { get; set; }
        public string state { get; set; }
        public string city { get; set; }
    }
}