<%@ page import="www.project.dao.UserDAO" %>
<%@ page import="www.project.bean.User" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: gio
  Date: 06/01/2020
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="Description" content=""/>

    <link type="text/css" rel="stylesheet" href="./css/main.css" />
<%--    <link type="text/css" rel="stylesheet" href="./css/normalize.css" />--%>

    <title>Messenger Cool</title>
</head>
<body>

<div class="wrapper">
    <header>
        <div class="container">
            <div class="left"><h2>Messenger Cool</h2></div>

            <div class="middle">
                <h3>Gio Simon</h3>
                <p>Messenger Cool</p>
            </div>

            <div class="right">
                <div class="username">
                    <%
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.getUser((String) session.getAttribute("username"));
                        String full = user.getFirstName() + " " + user.getLastName();
                    %>
                    <%=full%>
                </div>
            </div>
        </div>
    </header>

    <main>
        <div class="col-left">
            <div class="col-content">
                <div class="messages" id="msg">

                    <li>
                        <h3>Giorgos Simos</h3>
                        <p>Be there soon.</p>
                    </li>

                    <li>
                        <h3>Panayiotis Yiannoukkos</h3>
                        <p>You: Yep, let's do it!</p>
                    </li>

                    <li>
                        <h3>Nick Aridas</h3>
                        <p>How does it look? I started making it a while ago</p>
                    </li>

                    <li>
                        <h3>Thanos Tzikas</h3>
                        <p>Goddamn Aliens! &#128514;</p>
                    </li>

                    <li>
                        <h3>Charalambos Pistis</h3>
                        <p>Hello</p>
                    </li>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="col-content">
                <section class="message">
                    <div class="grid-message" id="message">
                        <div class="col-message-received">
                            <div class="message-received">
                                <p>Ok.</p>
                            </div>
                            <div class="message-received">
                                <p>Do you play EVE Online?</p>
                            </div>
                        </div>
                        <div class="col-message-sent">
                            <div class="message-sent">
                                <p>Not anymore.</p>
                            </div>
                        </div>
                        <div class="col-message-received">
                            <div class="message-received">

                                <p>But, can you?</p>
                            </div>
                        </div>
                        <div class="col-message-sent">
                            <div class="message-sent">
                                <p>I guess if I had some practice I could again. It's been years.</p>
                            </div>
                        </div>
                        <div class="col-message-received">
                            <div class="message-received">
                                <p>Dat titan though...</p>
                            </div>
                        </div>
                        <div class="col-message-sent">
                            <div class="message-sent">
                                <p>Trombone, guitar, titan?</p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <div class="col-foot">

                <div class="compose">
                    <input placeholder="Type a message">
                    <div class="compose-dock">
                    </div>

                </div>

            </div>
        </div>
        <div class="col-right">

            <div class="col-content">

                <div class="user-panel">

                    <h3>Gio Simon</h3>
                    <p>London, United Kingdom</p>
                </div>

            </div>

        </div>
    </main>
</div>
</body>
</html>
