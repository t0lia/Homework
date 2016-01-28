<%@ page import="util.SqrtResolver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="main.css">
    <script type="application/javascript" src="main.js"></script>
    <script language="JavaScript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"/>

</head>
<body>
<script type="application/javascript">


</script>

<div id="my">
    Здесь будет результат Ajax-запроса
</div>

<div id="main_frame">
    <div id="display_block">
        <input type="text"onkeypress='return event.charCode >= 48 && event.charCode <= 57'
               id="display_input" style="text-align: right" \ >
    </div>
    <div id="bttn_block">
        <input type="button" onclick="addSmb(7)"    value="7" \>
        <input type="button" onclick="addSmb(8)"    value="8" \>
        <input type="button" onclick="addSmb(9)"    value="9" \>
        <input type="button" onclick="divOp()"      value="/" \>
        <input type="button" onclick="clearDsp()"   value="C" \>
        <input type="button" onclick="addSmb(4)"    value="4" \>
        <input type="button" onclick="addSmb(5)"    value="5" \>
        <input type="button" onclick="addSmb(6)"    value="6" \>
        <input type="button" onclick="mulOp()"      value="x" \>
        <input type="button" onclick="sqrtOp()"     value="√" \>
        <input type="button" onclick="addSmb(1)"    value="1" \>
        <input type="button" onclick="addSmb(2)"    value="2" \>
        <input type="button" onclick="addSmb(3)"    value="3" \>
        <input type="button" onclick="subOp()"      value="-" \>
        <input type="button" onclick="evaluateOp()" value="=" class="double_height" \>
        <input type="button" onclick="addSmb(0)"    value="0" \>
        <input type="button" onclick="addSmb('.')"  value="." \>
        <input type="button" onclick="modOp()"      value="%"  \>
        <input type="button" onclick="addOp()"      value="+" \>
    </div>

</div>
</body>
</html>
