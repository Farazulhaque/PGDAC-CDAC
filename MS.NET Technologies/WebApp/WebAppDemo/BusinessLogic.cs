using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
#region NamespacesForBusinessLogic
using System.Data;
using System.Data.SqlClient;
using System.Configuration;
using System.Web.UI.WebControls;

#endregion


namespace WebAppDemo
{
    //DAO/DAL
    public static class BusinessLogic
    {
        static SqlConnection con;
        static BusinessLogic()
        {
            string constring = ConfigurationManager.ConnectionStrings["myconnectionstring"]
                                                   .ConnectionString;
            con = new SqlConnection(constring);
        }

        public static void OpenConnection()
        {
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }
        }
        public static void CloseConnection()
        {
            if (con.State == ConnectionState.Open)
            {
                con.Close();
            }
        }
        //insert/update/delete
        public static int ExecuteQry(string qry)
        {

            SqlCommand cmd = new SqlCommand(qry, con);
            OpenConnection();
            int res = cmd.ExecuteNonQuery();
            CloseConnection();
            return res;
        }
        public static int ExecuteQry(string pqry, SqlParameter[] parameters)
        {

            SqlCommand cmd = new SqlCommand(pqry, con);
            cmd.Parameters.AddRange(parameters);
            OpenConnection();
            int res = cmd.ExecuteNonQuery();
            CloseConnection();
            return res;
        }

        public static DataSet GetDataSet(string qry)
        {
            SqlDataAdapter adapter = new SqlDataAdapter(qry, con);
            DataSet ds = new DataSet();
            adapter.Fill(ds);
            return ds;

        }
        public static SqlDataReader GetDataReader(string qry)
        {
            SqlCommand cmd = new SqlCommand(qry, con);
            OpenConnection();
            SqlDataReader dtr = cmd.ExecuteReader();
            //CloseConnection();
            return dtr;

        }
        public static void FillGrid(string qry, GridView gridView)
        {
            gridView.DataSource = GetDataSet(qry);
            gridView.DataBind();
        }

        public static object AuthenticateUser(string username, string pwd)
        {
            string authQry = "select username from user_master " +
                              "where username='" + username + "' and password='" + pwd + "'";
            SqlCommand cmd = new SqlCommand(authQry, con);
            OpenConnection();
            object uname = cmd.ExecuteScalar();
            return uname;
        }
    }
}