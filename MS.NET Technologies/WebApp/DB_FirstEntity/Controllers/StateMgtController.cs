using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DB_FirstEntity.Controllers
{
    public class Test
    {
        public int Id { get; set; }
    }
    public class StateMgtController : Controller
    {
        // GET: StateMgt
        public ActionResult Index()
        {
            ViewData["Message"] = "Data from view data";
            ViewData["Test"] = new Test() { Id = 2000 };
            return View();
        }
    }
}