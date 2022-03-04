<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" Async="true" AutoEventWireup="true" CodeBehind="ManageUser.aspx.cs" Inherits="WebAppDemo.DatabaseWork.ManageUser" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">

    <table style="width: 70%; margin: auto; border: 2px solid #0000FF; background-color: #CCFFCC">
        <tr>
            <td style="width: 400px;"><strong>Manage User</strong></td>
            <td style="width: 803px;">&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 400px"><strong>USER ID</strong></td>
            <td>
                <asp:TextBox ID="txtUserId" runat="server" Style="font-weight: bold;"></asp:TextBox>
                <strong>&emsp;
                    <asp:Button ID="btnSearchUser" runat="server" EnableTheming="True" OnClick="btnSearch_Click" Text="FIND USER" Style="font-weight: bold" />
                </strong>
            </td>
        </tr>
        <tr>
            <td style="width: 400px"><strong>USER NAME</strong></td>
            <td>
                <asp:TextBox ID="txtUserName" runat="server" Style="font-weight: bold;"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 400px"><strong>FULL NAME</strong></td>
            <td>
                <asp:TextBox ID="txtName" runat="server" Style="font-weight: bold;"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 400px"><strong>MOBILE</strong></td>
            <td>
                <asp:TextBox ID="txtMobile" runat="server" Style="font-weight: bold;"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td style="height: 29px" colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td style="height: 29px" colspan="2">&emsp;
                <strong>
                    <asp:Button ID="btnUpdate" runat="server" EnableTheming="True" OnClick="btnUpdate_Click" Text="UPDATE USER" Style="font-weight: bold" />
                    <asp:Button ID="btnDelete" runat="server" EnableTheming="True" OnClick="btnDelete_Click" Text="DELETE USER" Style="font-weight: bold" />
                </strong>&nbsp;<strong><asp:Button ID="btnViewAll" runat="server" EnableTheming="True" OnClick="btnViewAll_Click" Text="VIEW ALL USER" Style="font-weight: bold" />
                </strong>
            </td>
        </tr>
        <tr>
            <td style="height: 20px" colspan="2">
                <strong>
                    <asp:Label ID="Label1" runat="server"></asp:Label>
                </strong>
            </td>
        </tr>
        <tr>
            <td style="height: 234px" colspan="2">
                <asp:GridView ID="GridView1" runat="server" Height="234px" Style="margin-top: 0px" Width="506px" BackColor="White" BorderColor="#999999" BorderStyle="None" BorderWidth="1px" CellPadding="3" GridLines="Vertical">
                    <AlternatingRowStyle BackColor="#DCDCDC" />
                    <FooterStyle BackColor="#CCCCCC" ForeColor="Black" />
                    <HeaderStyle BackColor="#000084" Font-Bold="True" ForeColor="White" />
                    <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                    <RowStyle BackColor="#EEEEEE" ForeColor="Black" />
                    <SelectedRowStyle BackColor="#008A8C" Font-Bold="True" ForeColor="White" />
                    <SortedAscendingCellStyle BackColor="#F1F1F1" />
                    <SortedAscendingHeaderStyle BackColor="#0000A9" />
                    <SortedDescendingCellStyle BackColor="#CAC9C9" />
                    <SortedDescendingHeaderStyle BackColor="#000065" />
                </asp:GridView>
            </td>
        </tr>
    </table>

</asp:Content>
