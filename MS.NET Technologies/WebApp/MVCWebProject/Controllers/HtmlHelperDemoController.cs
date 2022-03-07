using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCWebProject.Controllers
{
    public class HtmlHelperDemoController : Controller
    {
        // GET: HtmlHelperDemo
        public ActionResult Index()
        {
            ViewBag.Courses = new string[] { "C", "C++", "Java" };
            return View();
        }
        public ViewResult StandardHelper()
        {
            ViewBag.Qualification = new string[] { "M.tech", "MCA", "MBA", "B.tech" };

            ViewBag.City = new SelectList(new string[] { "Patna", "Lucknow", "Delhi", "Mumbai" });
            return View();
        }

        [HttpPost]
        public string StandardHelper(FormCollection form)
        {
            return "Details: " + form["Id"] + ", " + form["Name"] + ", " + form["Gender"] + ", " + form["City"];
        }

        public ViewResult TemplatedHelper()
        {
            return View();
        }
    }
}