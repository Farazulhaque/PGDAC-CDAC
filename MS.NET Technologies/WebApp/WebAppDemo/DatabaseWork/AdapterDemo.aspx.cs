using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAppDemo.DatabaseWork
{
    public partial class AdapterDemo : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Logic to fetch all users and displaay in gridview
        protected void Button1_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("server=PC; database=pgdac2021; uid=sa; pwd=sql");
            //DataSet ds = new DataSet();
            DataTable dt = new DataTable();
            string query = "select user_id, username, fullname, mobile from user_master";

            // initialise adapter with query and connection
            SqlDataAdapter adapter = new SqlDataAdapter(query, conn);
            // call fill() method to get data from database and fill it into dataset
            //adapter.Fill(ds);
            adapter.Fill(dt);
            //Label1.Text = "Total Record Found: " + ds.Tables[0].Rows.Count;
            Label1.Text = "Total Record Found: " + dt.Rows.Count;

            //Response.Write("<br>Username: " + ds.Tables[0].Rows[0][1]);


            // Binding data with gridview
            //GridView1.DataSource = ds;
            GridView1.DataSource = dt;

            GridView1.DataBind();

        }
    }
}