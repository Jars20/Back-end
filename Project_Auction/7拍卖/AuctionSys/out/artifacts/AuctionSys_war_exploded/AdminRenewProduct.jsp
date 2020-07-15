<%@ page import="auction.ss.entity.Product" %>
<%@ page import="java.net.URL" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
  <!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <form action="renewProdcuct.do" name="productModified">
            <%
                Product product = (Product) session.getAttribute("productRenew");
                String name = product.getName();
                Double basePrice =product.getBasePrice();
                Double lowPrice = product.getLowPrice();
                String startTime =product.getStartTime();
                String finalTime =product.getFinalTime();
                String description =product.getDescription();
            %>
        <dl>
            <dd >
                <input type="hidden" name="productToRenew" value="<%=product%>">
              <label>名称：</label>
              <input type="text" class="inputh lf" value="<%=name%>" name="name"/>
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input type="text" class="inputh lf" value="<%=basePrice%>" name="basePrice"/>
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>底价：</label>
              <input type="text" class="inputh lf" value="<%=lowPrice%>" name="lowPrice" />
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input type="text" class="inputh lf" value="<%=startTime%>" name="startTime" />
              <div class="lf red laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input type="text" class="inputh lf" value="<%=finalTime%>" name="finaTime" />
              <div class="lf red laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd class="dds">
              <label>描述：</label>
              <textarea name="description" cols="" rows="" class="textarea" ><%=description%></textarea>
            </dd>
            <dd>
              <label>修改图片：</label>
              <div class="lf salebd"><a href="#"><img src="images/ad20.jpg" width="100" height="100" /></a></div>
               <input name="" type="file" class="marg10" />
            </dd>
            <dd class="hegas">
                <input name="" type="submit" value="保 存" class="spbg buttombg buttombgs f14 lf buttomb" />
                <a href="search_product.do"><input name="" type="submit" value="取 消" class="spbg buttombg buttombgs f14 lf buttomb" /></a>
                
            </dd>
          </dl>
        </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 
</div>
</body>
</html>
