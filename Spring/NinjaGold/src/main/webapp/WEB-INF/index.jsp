<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        body{
            padding: 5% 20%;
        }
        .op{
            display: flex;
            justify-content: space-between;
            padding: 1% 5%;
        }
        .gol-cont{
            padding: 1% 5%;
        }
        form{
            border-style: solid;
            border-width: 1px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-evenly;
            width: 200px;
            height: 200px;
        }
        h3{
            padding: 0;
            margin: 0;
        }
        .act{
            display: flex;
            flex-direction: column;
            justify-content: space-evenly;
            padding: 1% 5%;
        }
        label{
            margin: 1% 0;
        }
    </style>
</head>
<body>
    <div class="gol-cont">
        <label for="gold">Your Gold: </label>
        <input type="text" value = "0" id="gold">
    </div>
    
    <div class="op">
        <form action="/process" method="post">
            <h3>Farm</h3>
            <p>(earns 10-20 golds)</p>
            <input type="hidden" name="building" value="farm" />
            <input type="submit" value="Find Gold!"/>
          </form>

          <form action="/process" method="post">
            <h3>Cave</h3>
            <p>(earns 5-10 golds)</p>
            <input type="hidden" name="building" value="cave" />
            <input type="submit" value="Find Gold!"/>
          </form>
          
          <form action="/process" method="post">
            <h3>House</h3>
            <p>(earns 2-5 golds)</p>
            <input type="hidden" name="building" value="house" />
            <input type="submit" value="Find Gold!"/>
          </form>
          
          <form action="/process" method="post">
            <h3>Casino</h3>
            <p>(earns/takes 0-50 golds)</p>
            <input type="hidden" name="building" value="casino" />
            <input type="submit" value="Find Gold!"/>
          </form>
    </div>

    <div class="act">
        <label for="acti">Activities:</label>
        <textarea name="consol" id="acti" cols="30" rows="10"></textarea>
    </div>
    
</body>
</html>