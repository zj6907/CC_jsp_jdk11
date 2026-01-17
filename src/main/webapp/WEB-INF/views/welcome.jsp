<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/resources/app/css/common.css' />">
<html>
<head>
<title>Welcome</title>
</head>
<body>
  <h2>メインメニュー</h2>

  <div class="body-wrapping" style="display: flex; justify-content: center;">
    <!-- 店舗条件指定 -->
    <form action="<c:url value='/branchCond'/>" method="get">
      <button class="btn-common" type="submit">店舗条件指定</button>
    </form>
  </div>

</body>
</html>
