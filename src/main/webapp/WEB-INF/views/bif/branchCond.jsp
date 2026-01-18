<%@ include file="/WEB-INF/views/common/common.jsp"%>

<style>
.grid-wrapper {
  width: 22rem;
  margin: 0 auto;
}

.grid-container {
  display: grid;
  grid-template-columns: 7rem 5rem 8rem;
  border: 1px solid #ccc;
  border-radius: 6px;
  padding: 10px;
  row-gap: 0.5rem;
  grid-auto-rows: 2rem;
}

.grid-container :nth-child(3n+2) {
  margin-left: 1rem;
}

.grid-container :nth-child(3n+3) {
  margin-left: 3rem;
}

.btn-shoukai {
  display: block;
  margin: 0 auto;
  padding: 0 1.5rem;
  margin-top: 1rem;
  background-color: chocolate;
}
</style>

<html>

<head>
<title>Welcome</title>
</head>

<body>
  <h2>店舗条件指定</h2>

  <div class="body-wrapping">

    <c:url var="branchUrl" value="/branch" />
    <form:form modelAttribute="f" method="post" action="${branchUrl}">
      <div class="grid-wrapper">
        <!-- 全件検索 -->
        <div class="grid-container">
          <label for="bankCode1">金融機関コード</label>
          <form:input path="bankCode1" />
          <button class="btn-common" type="submit" name="action" value="ALL">全件検索</button>
        </div>

        <br>

        <!-- 指定検索 -->
        <div class="grid-container">
          <label for="bankCode2">金融機関コード</label>
          <form:input path="bankCode2" />
          <button class="btn-common" type="submit" name="action" value="SPECIFIC">指定検索</button>

          <label for="branchCode">店舗コード</label>
          <form:input path="branchCode" />
        </div>

        <br>

        <!-- 研修金庫指定 -->
        <div class="grid-container" style="border: none;">
          <label for="trainingBank">研修金庫指定</label>
          <input type="checkbox" id="trainingBank" name="trainingBank" style="margin-left: -1rem;" />
        </div>

        <!-- Submit -->
        <!-- <button class="btn-common btn-shoukai" type="submit">照会</button> -->

      </div>
    </form:form>
    <!-- 戻る -->
    <form action="<c:url value='/'/>" method="get">
      <button class="btn-common btn-rtn" type="submit">戻る</button>
    </form>
  </div>
</body>

</html>