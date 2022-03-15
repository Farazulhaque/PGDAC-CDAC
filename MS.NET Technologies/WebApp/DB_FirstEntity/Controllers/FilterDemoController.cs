using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DB_FirstEntity.Controllers
{
    [AllowAnonymous]
    //[HandleError]
    public class FilterDemoController : Controller
    {
        // GET: FilterDemo
        [OutputCache(Duration = 30, Location = System.Web.UI.OutputCacheLocation.Any)]
        public ActionResult Index()
        {
            ViewBag.CurrentTime = "Page cached at" + DateTime.Now;
            return View();
        }

        //[HandleError]
        public ActionResult HandleError()
        {
            throw new Exception();
            return View();
        }
    }
}