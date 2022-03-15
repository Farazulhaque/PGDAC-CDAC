using DB_FirstEntity.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace DB_FirstEntity.Controllers
{
    [AllowAnonymous]
    public class AccountController : Controller
    {
        // GET: Account
        CollegeDbEntities1 db = new CollegeDbEntities1(); //context object for db operations
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(Login login)
        {
            if (ModelState.IsValid)
            {
                // Login query
                bool isValidUser = db.Logins.Any(u => u.Username == login.Username && u.Password == login.Password);
                if (isValidUser)
                {
                    FormsAuthentication.SetAuthCookie(login.Username, false);

                    return RedirectToAction("Index", "Students");
                }
                else
                {
                    ModelState.AddModelError("", "Invalid Username/Password");
                }
            }
            return View(login);
        }
        //[AllowAnonymous]
        public ActionResult Register()
        {
            return View();
        }

        //[AllowAnonymous]
        [HttpPost]
        public ActionResult Register(Login login)
        {
            if (ModelState.IsValid)
            {
                db.Logins.Add(login); // to save user data in context
                db.SaveChanges(); // to save user data in db
                return RedirectToAction("Login");
            }
            return View(login);
        }

        [Authorize]
        public ActionResult UserProfile()
        {
            /*
            //checking and reading cookies data
            if (Request.Cookies["PGDAC"] != null)
            {
                ViewBag.UserName = Request.Cookies["PGDAC"]["UserName"];

                ViewBag.LoginTime = Request.Cookies["PGDAC"]["LoginTime"];
                return View();
            }
            else
            {
                return View("Login");
            }
            */
            //-------------------------
            // Using Session
            if (Session.IsNewSession)
            {
                return View("SessionExpired");
            }
            if (Session["UserName"] != null)
            {
                ViewBag.UserName = Session["UserName"];
                ViewBag.LoginTime = Session["LoginTime"];
                ViewBag.TotalVisitors = HttpContext.Application["totalvisitor"];
                return View();
            }
            else
            {
                return View("Login");
            }
        }

        public ActionResult SignOut()
        {
            /*
            //Request.Cookies["PGDAC"].Expires = DateTime.Now.AddMilliseconds(-1);
            //Request.Cookies.Remove("PGDAC");
            HttpCookie cookie = Request.Cookies["PGDAC"];
            cookie.Expires = DateTime.Now.AddMilliseconds(-1);
            Response.Cookies.Add(cookie);
            */
            //Session.Abandon();
            FormsAuthentication.SignOut();
            return View("Login");
        }

        public ActionResult SessionExpired()
        {
            return View();
        }
    }
}