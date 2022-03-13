using DB_FirstEntity.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DB_FirstEntity.Controllers
{
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
                bool isValidUser = db.Logins.Any(u =>
                u.Username == login.Username &&
                u.Password == login.Password);
                if (isValidUser)
                {
                    //ViewBag.UserName = login.Username;
                    //TempData["UserName"] = login.Username;
                    //return RedirectToAction("UserProfile");

                    // temporary Cookie Creation
                    HttpCookie ht = new HttpCookie("PGDAC");
                    ht.Values.Add("UserName", login.Username);
                    ht.Values.Add("LoginTime", DateTime.Now.ToString());

                    // to create persistent cookie
                    ht.Expires = DateTime.Now.AddMinutes(40);

                    // Writing cookie data with current response
                    Response.Cookies.Add(ht);
                    return RedirectToAction("UserProfile");
                }
                else
                {
                    ModelState.AddModelError("", "Invalid Username/Password");
                }
            }
            return View(login);
        }
        public ActionResult Register()
        {
            return View();
        }

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

        public ActionResult UserProfile()
        {
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
        }

        public ActionResult SignOut()
        {
            //Request.Cookies["PGDAC"].Expires = DateTime.Now.AddMilliseconds(-1);
            //Request.Cookies.Remove("PGDAC");
            HttpCookie cookie = Request.Cookies["PGDAC"];
            cookie.Expires = DateTime.Now.AddMilliseconds(-1);
            Response.Cookies.Add(cookie);
            return View("Login");
        }

    }
}