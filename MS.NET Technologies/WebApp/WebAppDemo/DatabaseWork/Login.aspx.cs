using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAppDemo.DatabaseWork
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            object uname = BusinessLogic.AuthenticateUser(txtUserName.Text, txtPassword.Text);
            if (uname != null)
            {
                // passing data using querystring
                Response.Redirect("ManageUser.aspx?name=" + uname); //local and global both url, same as sendRedirect in java
                //Server.Transfer();    // only for local urls., same as forward in java
                //Server.Execute();     // same as include in java
            }
            else
            {
                lblMessage.Text = "Invalid Username/Password";
            }
        }
    }
}