using MVCWebProject.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCWebProject.Controllers
{
    public class EmployeeController : Controller
    {
        // GET: Employee
        public ActionResult Index()
        {
            return View();
        }
        public string Name()
        {
            return "Faraz";
        }
        public string Hello()
        {
            return "Welcome to ASP.NET MVC Class";
        }
        string Id()
        {
            return "1";
        }
        public string EmpProfile(int? id) // ?->to make it nullable form
        {
            string profile = string.Empty;
            switch (id)
            {
                case 1:
                    profile = "Employee 1 profile";
                    break;
                case 2:
                    profile = "Employee 2 profile";
                    break;
                case 3:
                    profile = "Employee 3 profile";
                    break;
                default:
                    profile = "No Employee found";
                    break;
            }
            return profile;
        }

        public ActionResult ContactUs()
        {
            ViewBag.Message = "This is contact us page. Employee contact us view page.";
            ViewBag.Id = 1000;
            return View();
        }
        public ViewResult AboutUs()
        {
            ViewBag.Message = "This is about us page. Employee about us view page.";
            return View();
        }
        public ViewResult GetAllEmployee()
        {
            ViewBag.Message = "Get All Employee view page.";
            return View(viewName: "GetEmployee"); //passing view name other than action name to render the response
        }

        // method to return employee obj
        private Employee GetEmployee()
        {
            return new Employee()
            {
                Id = 1000,
                Name = "Admin",
                Salary = 65450.00f
            };
        }
        public ViewResult ViewEmployee()
        {
            var emp = GetEmployee();
            return View(emp); // passing employee model object with view 
        }

    }
}