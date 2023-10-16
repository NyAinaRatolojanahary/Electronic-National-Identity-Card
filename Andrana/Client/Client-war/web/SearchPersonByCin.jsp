<%-- 
    Document   : SearchPersonByCin
    Created on : 11 oct. 2023, 09:59:43
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <title>Search by CIN</title>
    </head>
    <body>
        <div class="container text-center">
            <div class="modal-header" style='margin-bottom: 30px'>
                <h5 class="modal-title">Chercher les infos par le num CIN</h5>
            </div>
            <form class="form-control" action="./PersonByCIN" method="post">
                <input class="form-control" type="text" minlength="4" maxlength="15" name="cin" value="Cin" required placeholder="Num CIN">
                <input class="btn btn-primary mb-3" type="submit" value="Search" style="margin-top: 30px;">
            </form>
        </div>
    </body>
</html>
