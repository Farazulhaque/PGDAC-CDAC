using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace EFCodeFirstDemo.Models
{
    public partial class PGDACContext : DbContext
    {
        public PGDACContext()
            : base("name=PGDACDB")
        {
        }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
        }
        public virtual DbSet<Student> Students { get; set; }
        public virtual DbSet<Address> Addresses { get; set; }
    }
}
