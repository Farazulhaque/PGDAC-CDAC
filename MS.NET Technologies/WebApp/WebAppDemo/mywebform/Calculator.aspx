<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Site.Master" CodeBehind="Calculator.aspx.cs" Inherits="WebAppDemo.mywebform.Calculator" %>


<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <%--<form id="form1" runat="server">--%>
    <div>
        <h1 style="text-align: center">Working with ASP.NET WebForm</h1>
        <hr />

    </div>
    <table cellpadding="2" class="auto-style1">
        <tr>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><strong>First Number</strong></td>
            <td>
                <asp:TextBox ID="txtNum1" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td><strong>Second Number</strong></td>
            <td>
                <asp:TextBox ID="txtNum2" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td><strong>Third Number</strong></td>
            <td>
                <asp:TextBox ID="txtNum3" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <asp:Button ID="btnAdd" runat="server" Height="33px" Text="Add Values" Width="93px" BackColor="#006600" Font-Bold="True" ForeColor="White" OnClick="btnAdd_Click" />
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <strong>
                    <asp:Label ID="Label1" runat="server" Text=""></asp:Label>
                </strong>
            </td>
        </tr>
    </table>
    <%--</form>--%>
</asp:Content>

