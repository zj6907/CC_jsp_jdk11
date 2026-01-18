<%@ include file="/WEB-INF/views/common/common.jsp" %>

<html>

<head>
<title>Welcome</title>
</head>

<body>
  <h2>店舗情報照会</h2>

  <div class="body-wrapping">

    <ul>
      <c:forEach var="b" items="${list}">
        <li>${b.systemBankCode} - ${b.bankCode} - ${b.branchCode} - ${b.branchName} - ${b.branchNameKanji} }</li>
      </c:forEach>
    </ul>

    <!-- 戻る -->
    <form action="<c:url value='/branchCond'/>" method="get">
      <button class="btn-common btn-rtn" type="submit">戻る</button>
    </form>
  </div>
</body>

</html>
