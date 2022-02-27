using SharedDll;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CalculatorApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(txtNum1.Text);
            int num2 = Convert.ToInt32(txtNum2.Text);
            int num3 = Convert.ToInt32(txtNum3.Text);
            Calculator obj = new Calculator();
            lblresult.Text = obj.Add(num1, num2, num3).ToString();
            //lblresult.Text = (num1 + num2 + num3).ToString();
            MessageBox.Show("Result: " + (num1 + num2 + num3));
        }
    }
}
