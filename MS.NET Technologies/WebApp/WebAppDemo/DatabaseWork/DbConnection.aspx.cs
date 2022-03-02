using System;
using System.Collections.Generic;
using System.Data; // For ConnectionState Enum
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAppDemo.DatabaseWork
{
    public partial class DbConnection : System.Web.UI.Page
    {
        static SqlConnection con;
        String connectionString = "server=PC; database=pgdacsepdb; uid=sa; pwd=sql";
        //String connectionString = "server=PC; database=pgdacsepdb; integrated security=true";


        /* 
         * ASP.NET Page Life Cycle
         * Page_PreInit -> Object initialisation 
         * Page_Init    -> Over ride this to initialise 
         * Page_Load    -> Server side logic default
         * Page_Render  -> control specific generate hypertext
         * Page_Unload  -> use for memory cleanup
         * 
         */
        protected void Page_PreInit(object sender, EventArgs e)
        {
            // object creation
            Response.Write("PreInit Called <br/>");
        }
        protected void Page_Init(object sender, EventArgs e)
        {
            /// object properties initialisation
            Response.Write("Init Called <br/>");
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            Response.Write("Load Called <br/>");
            //if (con == null)
            if (!Page.IsPostBack)
            {
                Response.Write("Inside if Called");
                con = new SqlConnection(connectionString);
            }
        }

        // Connect With Database
        protected void Button1_Click(object sender, EventArgs e)
        {
            // con = new SqlConnection(connectionString);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
                Response.Write("<b>Connection Established with Database Server.</b>");
            }
            else
            {
                Response.Write("<b>Already Connected With Database Server.</b>");
            }
        }

        // Disconnect From Database
        protected void Button2_Click(object sender, EventArgs e)
        {
            if (con.State == ConnectionState.Open)
            {
                con.Close();
                Response.Write("<b>Connection Removed From Database Server.</b>");
            }
            else
            {
                Response.Write("<b>Already Disconnected From Database Server.</b>");
            }
        }

        // Check Connection State
        protected void Button3_Click(object sender, EventArgs e)
        {
            if (con.State == ConnectionState.Open)
            {
                Response.Write("<b>Connection is Open.</b>");
            }
            else
            {
                Response.Write("<b>Connnection is Closed.</b>");
            }

        }

    }
}