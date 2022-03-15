using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using WebApiDemoApp.Models;

namespace WebApiDemoApp.Controllers
{
    public class UserMasterController : ApiController
    {
        private pgdac2021Entities1 db = new pgdac2021Entities1();

        // GET: api/UserMaster
        public IQueryable<User_Master> GetUser_Master()
        {
            return db.User_Master;
        }

        // GET: api/UserMaster/5
        [ResponseType(typeof(User_Master))]
        public IHttpActionResult GetUser_Master(int id)
        {
            User_Master user_Master = db.User_Master.Find(id);
            if (user_Master == null)
            {
                return NotFound();
            }

            return Ok(user_Master);
        }

        // PUT: api/UserMaster/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutUser_Master(int id, User_Master user_Master)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != user_Master.User_Id)
            {
                return BadRequest();
            }

            db.Entry(user_Master).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!User_MasterExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/UserMaster
        [ResponseType(typeof(User_Master))]
        public IHttpActionResult PostUser_Master(User_Master user_Master)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.User_Master.Add(user_Master);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = user_Master.User_Id }, user_Master);
        }

        // DELETE: api/UserMaster/5
        [ResponseType(typeof(User_Master))]
        public IHttpActionResult DeleteUser_Master(int id)
        {
            User_Master user_Master = db.User_Master.Find(id);
            if (user_Master == null)
            {
                return NotFound();
            }

            db.User_Master.Remove(user_Master);
            db.SaveChanges();

            return Ok(user_Master);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool User_MasterExists(int id)
        {
            return db.User_Master.Count(e => e.User_Id == id) > 0;
        }
    }
}