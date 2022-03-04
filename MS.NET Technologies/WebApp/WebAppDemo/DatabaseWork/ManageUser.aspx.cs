using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAppDemo.DatabaseWork
{
    public partial class ManageUser : System.Web.UI.Page
    {

        SqlConnection con = new SqlConnection("server=PC;database=pgdac2021;uid=sa;pwd=sql");
        DataSet ds;
        SqlCommand cmd;
        SqlDataAdapter adapter;
        SqlDataReader reader;


        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                FillGrid();
            }
            if (Request.QueryString["name"] != null)
            {
                // Retrieving data from query string
                Response.Write("Welcome " + Request.QueryString["name"]);
            }
            else
            {
                //Server.Transfer("Login.aspx");
                Response.Redirect("Login.aspx");
            }
        }



        protected void btnSearch_Click(object sender, EventArgs e)
        {
            //working with parametriz queries
            String searchQry = "select username,fullname,mobile from user_master where user_id=@id";

            cmd = new SqlCommand(searchQry, con);

            //bindinfg parameter values
            cmd.Parameters.AddWithValue("@id", txtUserId.Text);

            con.Open();
            //fetching data using DataReader
            reader = cmd.ExecuteReader();


            if (reader.Read())
            {
                //txtUserName.Text = reader[0].ToString();
                //txtName.Text = reader[1].ToString();
                //txtMobile.Text = reader[2].ToString();

                txtUserName.Text = reader.GetString(0);
                txtName.Text = reader.GetString(1);
                txtMobile.Text = reader.GetDecimal(2).ToString();

            }
            else
            {
                Label1.Text = "No Record Found";
                Label1.ForeColor = System.Drawing.Color.Red;
            }
            con.Close();
        }

        protected void btnUpdate_Click(object sender, EventArgs e)
        {
            string updateQry = "update user_master set " + "username=@uname, fullname=@name, mobile=@mobile where user_id=@id";
            //cmd = new SqlCommand(@updateQry, con);
            //cmd.Parameters.AddWithValue("@id", txtUserId.Text);
            //cmd.Parameters.AddWithValue("@uname", txtUserName.Text);
            //cmd.Parameters.AddWithValue("@name", txtName.Text);
            //cmd.Parameters.AddWithValue("@mobile", txtMobile.Text);

            // create SqlParameter Array
            SqlParameter[] parameters = new SqlParameter[] {
                new SqlParameter("@id", txtUserId.Text),
                new SqlParameter("@uname", txtUserName.Text),
                new SqlParameter("@name", txtName.Text),
                new SqlParameter("@mobile", txtMobile.Text),

            };
            //cmd.Parameters.AddRange(parameters);
            //await con.OpenAsync();
            //int res = await cmd.ExecuteNonQueryAsync();
            //if (res > 0)
            //{
            //    Label1.Text = "User Details updated Successfully";
            //    FillGrid();
            //    Label1.ForeColor = System.Drawing.Color.Green;
            //}
            //con.Close();
            int res = BusinessLogic.ExecuteQry(updateQry, parameters);
            if (res > 0)
            {
                Label1.Text = "User Details updated Successfully";
                FillGrid();
                Label1.ForeColor = System.Drawing.Color.Green;
            }
        }
        void FillGrid()
        {
            string qry = "select user_id, username, fullname, mobile from user_master";
            adapter = new SqlDataAdapter(qry, con);
            ds = new DataSet();
            adapter.Fill(ds);
            GridView1.DataSource = ds;
            GridView1.DataBind();
        }
        protected void btnDelete_Click(object sender, EventArgs e)
        {

        }

        protected void btnViewAll_Click(object sender, EventArgs e)
        {
            FillGrid();
        }
    }
}