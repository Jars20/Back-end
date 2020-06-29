-- 查询所有一级分类
use shoppingstreet;
select * from product_category where type=1;

-- 登陆用户名和密码aaa和123是否成功
select * from user where loginName ='aaa' and password ='123';

-- 注册
insert into `user` values(null,'aaa','李四', '123', '1', '140225198810013748', '1044732267@qq.com', '13366555010', '1');

-- 搜索商品名称或者描述中有华为的
select * from product where name like '%华为%' or description like '%华为%';

select * from product where (name like '%华为%' or description like '%华为%')  and stock > 0 and (price between 500 and 1000);

select * from product where (name like '%华为%' or description like '%华为%')  and stock > 0 and (price between 500 and 1000) order by price desc;

select * from product where (name like '%华为%' or description like '%华为%')  and stock > 0 and (price between 500 and 1000) order by price desc limit 0,10;

select id from product where stock<5 and stock >0;

select userId,sum(cost) as 总消费额 from `order` group by userId order by sum(cost) desc limit 1 ;

select productId,sum(quantity) from `order_detail` group by productId order by sum(quantity) desc limit 3;

-- 查找21号用户以及其购买的订单信息 用户id订单id金额日期
select o.id,o.userId,o.createTime,o.cost from `order` o join order_detail od on o.id = od.orderId where o.userId=21;


-- 打印分类一分类二分类三，inner join多个表
-- 内联
select 
u.id 名称,
u.loginName 用户名,
o.id 订单号,
o.createTime 订单创建时间,
o.cost 总额,
p.id 商品,
p.name ,
p.categoryLevel1Id,pc1.name 分类1,
p.categoryLevel2Id,pc2.name 分类2,
p.categoryLevel3Id,pc3.name 分类3
from `user` u
inner join `order` o on o.userId = u.id
inner join `order_detail` od on od.orderId = o.id 
inner join `product` p on p.id = od.productId
inner join `product_category` pc1 on pc1.id = p.categoryLevel1Id
inner join `product_category` pc2 on pc2.id = p.categoryLevel2Id
inner join `product_category` pc3 on pc3.id = p.categoryLevel3Id
where u.id=21 and o.id=6;

-- 一次都没购买的人
select u.userName 名字 from user u 
left join shoppingstreet.`order` o on u.id=o.userId 
where o.id is null;
-- 子查询
-- 单行单列	<>=
-- 单行多列	in
-- 多行多列	as

-- 查询一次都没有被购买的商品
select * from product p
left join order_detail od on p.id=od.productId 
where od.productId is null;

-- 查找卖的最好的商品信息
select max(temp.q_sum) from (select sum(quantity) as q_sum from order_detail group by productId) temp;



select productId,sum(quantity) as count
from order_detail group by productId;

select max(quantity) from order_detail;
having count = max(count);





select max(temp) from(select sum(quantity) as temp,productId from order_detail group by productId);

select max(quantity) from order_detail;