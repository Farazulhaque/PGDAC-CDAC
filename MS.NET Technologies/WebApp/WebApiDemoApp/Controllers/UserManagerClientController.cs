using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;
using WebApiDemoApp.Models;

namespace WebApiDemoApp.Controllers
{
    public class UserManagerClientController : Controller
    {
        // GET: UserManagerClient
        public ActionResult Index()
        {
            IEnumerable<User_Master> users;
            var client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:51352/api/"); //API URI
            var responseTask = client.GetAsync("UserMaster");
            responseTask.Wait();
            var result = responseTask.Result;
            if (result.IsSuccessStatusCode)
            {
                var readTask = result.Content.ReadAsAsync<IList<User_Master>>();
                readTask.Wait();
                users = readTask.Result;
            }
            else
            {
                users = Enumerable.Empty<User_Master>();
                ModelState.AddModelError("", "Server Error");
            }
            return View(users);
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(User_Master user_Master)
        {
            var client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:51352/api/UserMaster/"); //API URI
            var postTask = client.PostAsJsonAsync<User_Master>("User_Master", user_Master);
            postTask.Wait();
            var result = postTask.Result;
            if (result.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            ModelState.AddModelError("", "Server Error!!!");
            return View(user_Master);
        }

    }
}