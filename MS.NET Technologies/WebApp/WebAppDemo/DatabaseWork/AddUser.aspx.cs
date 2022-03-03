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
    public partial class AddUser : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection("server=PC; database=pgdac2021; uid=sa; pwd=sql");
            String insertQry = "insert into user_master values('" + txtUserName.Text + "', '" + txtPassword.Text + "', '" + txtName.Text + "', " + txtMobile.Text + ")";

            SqlCommand cmd = new SqlCommand(insertQry, con);
            con.Open();
            int res = cmd.ExecuteNonQuery();
            if (res > 0)
            {
                Label1.Text = "User Details Saved Successfully";
                ClearText();
            }
            con.Close();
        }
        void ClearText()
        {
            txtUserName.Text = "";
            txtName.Text = "";
            txtMobile.Text = "";
        }
    }
}