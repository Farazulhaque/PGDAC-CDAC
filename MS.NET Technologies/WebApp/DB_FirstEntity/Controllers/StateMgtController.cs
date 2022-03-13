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
            // Writing Data in TempData
            TempData["mykey"] = "Data from TempData";
            return View();
        }

        public ActionResult Index2()
        {
            // Reading Data From TempData
            ViewBag.MyKey1 = TempData["mykey"];
            TempData.Keep("mykey");
            return View();
        }

        public ActionResult Index3()
        {
            // Reading Data From TempData
            ViewBag.MyKey2 = TempData["mykey"];

            return View();
        }
    }
}