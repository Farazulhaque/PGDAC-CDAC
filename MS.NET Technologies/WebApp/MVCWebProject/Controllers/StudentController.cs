using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCWebProject.Controllers
{
    public class StudentController : Controller
    {
        // GET: Student
        [Route("students/{sid?}")]
        public ActionResult Index(string sid)
        {
            ViewBag.Id = sid;
            return View();
        }
        [Route("students/{studentId}/courses")]
        public ViewResult GetStudentCourses(int? studentId)
        {
            List<string> courses = new List<string>();
            switch (studentId)
            {
                case 1:
                    courses = new List<string>() { "C", "C++", "Java" };
                    break;
                case 2:
                    courses = new List<string>() { "ASP.NET", "C++", "Php", "MYSQL" };
                    break;
                case 3:
                    courses = new List<string>() { "ASP.NET MVC", "C", "WebJava", "React" };
                    break;
                default:
                    courses = new List<string>() { "C/C++", "HTML", "SQL" };
                    break;
            }
            ViewBag.Courses = courses;
            return View();
        }
    }

}