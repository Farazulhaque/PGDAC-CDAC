<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="AddUser.aspx.cs" Inherits="WebAppDemo.DatabaseWork.AddUser" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <table style="width: 70%; margin: auto; border: 1px solid #000099; background-color: #99CCFF">
        <tr>
            <td style="width: 160px"><strong>Add New User Page</strong></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 160px">User Name </td>
            <td>
                <asp:TextBox ID="txtUserName" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 160px">Password </td>
            <td>
                <asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 160px">Full Name </td>
            <td>
                <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 160px">Mobile Number; </td>
            <td>
                <asp:TextBox ID="txtMobile" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 160px">&nbsp;</td>
            <td>
                <asp:Button ID="Button1" runat="server" Text="Add User" OnClick="btnSave_Click" />
            </td>
        </tr>
        <tr>
            <td style="width: 160px; height: 20px"></td>
            <td style="height: 20px">
                <strong>
                    <asp:Label ID="Label1" runat="server"></asp:Label>
                </strong>
            </td>
        </tr>
    </table>
</asp:Content>
