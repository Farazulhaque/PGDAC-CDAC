<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="DbConnection.aspx.cs" Inherits="WebAppDemo.DatabaseWork.DbConnection" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">

    <asp:Button ID="Button1" runat="server" Text="Connect With Database" OnClick="Button1_Click" Width="225px" />
    <br />
    <br />
    <asp:Button ID="Button2" runat="server" Text="Disconnect From Database" OnClick="Button2_Click" Width="225px" />
    <br />
    <br />
    <asp:Button ID="Button3" runat="server" Text="Check connection State" OnClick="Button3_Click" Width="225px" />

</asp:Content>
