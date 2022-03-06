using MVCWebProject.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCWebProject.Controllers
{
    public class PassingDataController : Controller
    {
        // GET: PassingData
        // Default
        public ActionResult Index()
        {
            return View();
        }

        // POST: PassingData
        [HttpPost]
        public string Index(string fname, string lname)
        {
            return $"Data using parameters: {fname} {lname}";
        }


        // Using Request
        // By default POST method when using razor syntax form
        [HttpPost]
        public string PostUsingRequest()
        {
            return $"Data using Request: {Request["fname"]} {Request["lname"]}";
        }

        // Using FormCollection
        [HttpPost]
        public string PostUsingForm(FormCollection form)
        {
            return $"Data using FormCollection: {form["fname"]} {form["lname"]}";
        }

        // GET: Passing Data
        public ViewResult RegisterStudent()
        {
            return View();
        }

        //[HttpPost]
        //public string RegisterStudent(Student student)
        //{
        //    return $"Data using Model: ID: {student.Id}\tName: {student.Name}\tAddress:  {student.Address}\t Mark: {student.Mark}";
        //}

        [HttpPost]
        public ViewResult RegisterStudent(Student student)
        {
            return View("Details", student);
        }
    }
}