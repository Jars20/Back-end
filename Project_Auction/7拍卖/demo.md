# 拍卖系统
## 数据库设计  
- 管理员
    -  ID
    - LoginName
    - Username
    - pwd
- 用户
    -  ID
    - LoginName
    - Username
    - pwd
- 商品
    - ID
    - lowPrice
    - basePrice
    - highPriceTemp
    - SoldOrNot
- 出价记录
    - UserId
    - ProductId
    - Price

- 成交表
    - 