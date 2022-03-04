<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="WebAppDemo.DatabaseWork.Login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <table style="width: 60%; margin: auto; border: 1px solid #000066; background-color: #CCFFFF">
        <tr>
            <td style="width: 200px"><strong>Login Here:</strong></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 200px">UserName</td>
            <td>
                <asp:TextBox ID="txtUserName" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 200px">Password</td>
            <td>
                <asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 200px">&nbsp;</td>
            <td>
                <asp:Button ID="btnLogin" runat="server" Text="Sign In" OnClick="btnLogin_Click" />
            </td>
        </tr>
        <tr>
            <td style="width: 200px">&nbsp;</td>
            <td><strong>
                <asp:Label ID="lblMessage" runat="server" ForeColor="Red"></asp:Label>
            </strong></td>
        </tr>
    </table>
</asp:Content>
