<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="<c:url value='/resources/app/css/common.css' />">


<html>

<head>
<title>Welcome</title>
</head>

<body>
  <h2>店舗情報照会</h2>

  <div class="body-wrapping">

    <!-- 戻る -->
    <form action="<c:url value='/branchCond'/>" method="get">
      <button class="btn-common btn-rtn" type="submit">戻る</button>
    </form>
  </div>
</body>

</html>
