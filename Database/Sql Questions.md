<div style="font-family: 'Kanit', sans-serif;text-align: center;border: 10px solid #fff;box-shadow: 1px 1px 2px #e6e6e6;background: linear-gradient(to left top, #11998e, #38ef7d); padding: 50px 0;">
<div style="color: #fff;">
    <h3 style="font-size: 25px;font-weight: 600;letter-spacing: 1px;text-transform: uppercase;margin: 0;">
       SQL Question
    </h3>
    <span style="font-size: 16px;text-transform: capitalize;">
    	SQL题目
    </span>
</div>
</div>


[toc]

## 组合两个表

表: `Person`

```mysql
+-------------+---------+
| 列名         | 类型     |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
personId 是该表的主键（具有唯一值的列）。
该表包含一些人的 ID 和它们的姓和名的信息。
```

表: `Address`

```mysql
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
addressId 是该表的主键（具有唯一值的列）。
该表的每一行都包含一个 ID = PersonId 的人的城市和州的信息。
```

编写解决方案，报告 `Person` 表中每个人的姓、名、城市和州。如果 `personId` 的地址不在 `Address` 表中，则报告为 `null` 。

以 **任意顺序** 返回结果表。

**解析**

本题关键点在于“如果 `personId` 的地址不在 `Address` 表中，则显示`null`”，由此可以想到 **left join 左外连接**去查询，把person表当左表，address当右表，左表的数据全部显示，右表显示符合搜索条件的记录。

```mysql
select p.firstName,
       p.lastName,
       a.city,
       a.state
from person p left join address a on p.personId = a.personId
```



## 第二高的薪水

`Employee` 表：

```mysql
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
在 SQL 中，id 是这个表的主键。
表的每一行包含员工的工资信息。
```

查询并返回 `Employee` 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 `null(Pandas 则返回 None)` 。

**解析**

1. 首先考虑重复问题，则需要使用 `distinct` 来去除重复
2. 第二高可以使用 `limit 1 offset 1` 来实现返回第二高的数据
3. 最重要的是要考虑到如果数据只有一条的时候，就应该使用 `ifnull` 来处理查不到第二高的时候来返回null

```mysql
select ifnull(
    (select distinct salary
     from employee
     order by salary desc
     limit 1,1)
    ,null) as SecondHighestSalary
```



## 第N高的薪水

表: `Employee`

```mysql
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
在 SQL 中，id 是该表的主键。
该表的每一行都包含有关员工工资的信息。
```

查询 `Employee` 表中第 `n` 高的工资。如果没有第 `n` 个最高工资，查询结果应该为 `null` 。

**解析**

```mysql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
  # mysql索引从0开始，所以减一
  SET M = N - 1;
  RETURN (
    select distinct salary
     from Employee
     order by salary desc
     limit M,1
  );
END
```



## 分数排名

表: `Scores`

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| score       | decimal |
+-------------+---------+
id 是该表的主键（有不同值的列）。
该表的每一行都包含了一场比赛的分数。Score 是一个有两位小数点的浮点值。
```

编写一个解决方案来查询分数的排名。排名按以下规则计算:

- 分数应按从高到低排列。
- 如果两个分数相等，那么两个分数的排名应该相同。
- 在排名相同的分数后，排名数应该是下一个连续的整数。换句话说，排名之间不应该有空缺的数字。

按 `score` 降序返回结果表。

查询结果格式如下所示。

**示例 1:**

```mysql
输入: 
Scores 表:
+----+-------+
| id | score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
输出: 
+-------+------+
| score | rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
```

**解析**

```mysql
select score, (
    select count(distinct score)
    from scores s2
    where s2.score >= s1.score
) as "rank"
from scores s1
order by score desc
```



## 连续出现的数字

表：`Logs`

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
在 SQL 中，id 是该表的主键。
id 是一个自增列。
```

找出所有至少连续出现三次的数字。

返回的结果表中的数据可以按 **任意顺序** 排列。

结果格式如下面的例子所示：

**示例 1:**

```mysql
输入：
Logs 表：
+----+-----+
| id | num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
```
```mysql
输出：
Result 表：
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
```
解释：1 是唯一连续出现至少三次的数字。

**解析**

```mysql
-- 找出连续出现三次的数字，题目意思说明了id要连续，并且num要相等
-- 连续出现的意味着相同数字的 Id 是连着的，由于这题问的是至少连续出现 3 次，我们使用 Logs 并检查是否有 3 个连续的相同数字。
-- 同时我们需要添加关键字 DISTINCT ，因为如果一个数字连续出现超过 3 次，会返回重复元素。
select distinct l1.num as ConsecutiveNums
from Logs l1, Logs l2, Logs l3
where l1.id = l2.id - 1
  and l2.id = l3.id - 1
  and l1.num = l2.num
  and l2.num = l3.num
```



## 超过经理收入的员工

表：`Employee` 

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| salary      | int     |
| managerId   | int     |
+-------------+---------+
id 是该表的主键（具有唯一值的列）。
该表的每一行都表示雇员的ID、姓名、工资和经理的ID。
```

编写解决方案，找出收入比经理高的员工。

以 **任意顺序** 返回结果表。

结果格式如下所示。

**示例 1:**

```mysql
输入: 
Employee 表:
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | Null      |
| 4  | Max   | 90000  | Null      |
+----+-------+--------+-----------+
输出: 
+----------+
| Employee |
+----------+
| Joe      |
+----------+
解释: Joe 是唯一挣得比经理多的雇员。
```

**解析**

```mysql
-- 从两个表里使用 Select 语句可能会导致产生 笛卡尔乘积 。在这种情况下，输出会产生 4*4=16 个记录。然而我们只对雇员工资高于经理的人感兴趣。所以我们应该用 WHERE 语句加 2 个判断条件
-- 方法1
select s1.name as Employee
from Employee s1,Employee s2
where s1.managerId = s2.id
  and s1.salary > s2.salary;
-- 方法2
select s1.name as Employee
from Employee s1 join Employee s2
where s1.managerId = s2.id
  and s1.salary > s2.salary;
```



## 查找重复的电子邮箱

表: `Person`

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
id 是该表的主键（具有唯一值的列）。
此表的每一行都包含一封电子邮件。电子邮件不包含大写字母。
```

编写解决方案来报告所有重复的电子邮件。 请注意，可以保证电子邮件字段不为 NULL。

以 **任意顺序** 返回结果表。

结果格式如下例。

**示例 1:**

```mysql
输入: 
Person 表:
+----+---------+
| id | email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
输出: 
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
解释: a@b.com 出现了两次。
```

**解析**

```mysql
-- 向 GROUP BY 添加条件的一种更常用的方法是使用 HAVING 子句，该子句更为简单高效。
select email
from Person
group by email
having count(email) > 1;
```



## 从不订购的客户

`Customers` 表：

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
在 SQL 中，id 是该表的主键。
该表的每一行都表示客户的 ID 和名称。
```

`Orders` 表：

```mysql
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| customerId  | int  |
+-------------+------+
在 SQL 中，id 是该表的主键。
customerId 是 Customers 表中 ID 的外键( Pandas 中的连接键)。
该表的每一行都表示订单的 ID 和订购该订单的客户的 ID。
```

找出所有从不点任何东西的顾客。

以 **任意顺序** 返回结果表。

结果格式如下所示。

**示例 1：**

```mysql
输入：
Customers table:
+----+-------+
| id | name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders table:
+----+------------+
| id | customerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
输出：
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```

**解析**

```mysql
# Write your MySQL query statement below
select name as Customers
from Customers
where id not in (
    select customerId
    from Orders
)
```



## 部门工资最高的员工

表： `Employee`

```mysql
+--------------+---------+
| 列名          | 类型    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
在 SQL 中，id是此表的主键。
departmentId 是 Department 表中 id 的外键（在 Pandas 中称为 join key）。
此表的每一行都表示员工的 id、姓名和工资。它还包含他们所在部门的 id。
```

表： `Department`

```mysql
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
在 SQL 中，id 是此表的主键列。
此表的每一行都表示一个部门的 id 及其名称。
```

查找出每个部门中薪资最高的员工。
按 **任意顺序** 返回结果表。
查询结果格式如下例所示。

**示例 1:**

```mysql
输入：
Employee 表:
+----+-------+--------+--------------+
| id | name  | salary | departmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
Department 表:
+----+-------+
| id | name  |
+----+-------+
| 1  | IT    |
| 2  | Sales |
+----+-------+
输出：
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
| IT         | Max      | 90000  |
+------------+----------+--------+
解释：Max 和 Jim 在 IT 部门的工资都是最高的，Henry 在销售部的工资最高。
```

```mysql
-- 首先表中的数据显示了部门工资最高的员工不止一个
-- 所以可以先把每个部门最高的工资先查出来
select departmentId, max(salary)
from Employee
group by departmentId;
-- 下面就可以用left join来连接两个表
-- 然后通过上面的sql得到的数据来匹配部门编号和工资，查出部门工资最高的员工
select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e
left join Department d on e.departmentId = d.id
where (e.departmentId, salary) in (
	select departmentId, max(salary)
	from Employee
	group by departmentId
);
-- 这个解析中，Department表就起到一个展示部门名称的作用，核心逻辑还是去处理的Employee表
```



## 部门工资前三高的所有员工

表: `Employee`

```mysql
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
id 是该表的主键列(具有唯一值的列)。
departmentId 是 Department 表中 ID 的外键（reference 列）。
该表的每一行都表示员工的ID、姓名和工资。它还包含了他们部门的ID。
```

表: `Department`

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
id 是该表的主键列(具有唯一值的列)。
该表的每一行表示部门ID和部门名。
```

公司的主管们感兴趣的是公司每个部门中谁赚的钱最多。一个部门的 **高收入者** 是指一个员工的工资在该部门的 **不同** 工资中 **排名前三** 。

编写解决方案，找出每个部门中 **收入高的员工** 。

以 **任意顺序** 返回结果表。

返回结果格式如下所示。

**示例 1:**

```mysql
输入: 
Employee 表:
+----+-------+--------+--------------+
| id | name  | salary | departmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 85000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
| 7  | Will  | 70000  | 1            |
+----+-------+--------+--------------+
Department  表:
+----+-------+
| id | name  |
+----+-------+
| 1  | IT    |
| 2  | Sales |
+----+-------+
输出: 
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Joe      | 85000  |
| IT         | Randy    | 85000  |
| IT         | Will     | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+
解释:
在IT部门:
- Max的工资最高
- 兰迪和乔都赚取第二高的独特的薪水
- 威尔的薪水是第三高的

在销售部:
- 亨利的工资最高
- 山姆的薪水第二高
- 没有第三高的工资，因为只有两名员工
```

**解析**

```mysql
-- 公司里前 3 高的薪水意味着有不超过 3 个工资比这些值大。
-- 在这个代码里，我们统计了有多少人的工资比 e1.Salary 高。
select e1.Name as 'Employee', e1.Salary
from Employee e1
where 3 >
(
    select count(distinct e2.Salary)
    from Employee e2
    where e2.Salary > e1.Salary
);
-- 然后，我们需要把表 Employee 和表 Department 连接来获得部门信息。
SELECT
    d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM
    Employee e1
        JOIN
    Department d ON e1.DepartmentId = d.Id
WHERE
    3 > (SELECT
            COUNT(DISTINCT e2.Salary)
        FROM
            Employee e2
        WHERE
            e2.Salary > e1.Salary
                AND e1.DepartmentId = e2.DepartmentId
        );
```

## 上升的温度

表： `Weather`

```mysql
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
id 是该表具有唯一值的列。
没有具有相同 recordDate 的不同行。
该表包含特定日期的温度信息
```

编写解决方案，找出与之前（昨天的）日期相比温度更高的所有日期的 `id` 。

返回结果 **无顺序要求** 。

结果格式如下例子所示。

**示例 1：**

```mysql
输入：
Weather 表：
+----+------------+-------------+
| id | recordDate | Temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
输出：
+----+
| id |
+----+
| 2  |
| 4  |
+----+
解释：
2015-01-02 的温度比前一天高（10 -> 25）
2015-01-04 的温度比前一天高（20 -> 30）
```

**解析**

```mysql
# Write your MySQL query statement below
# DATEDIFF()函数是一个强大而实用的工具，它专门用于计算两个日期之间的差异。 该函数通过返回两个日期之间的天数差，帮助我们精准地掌握时间间隔
select w2.id
from Weather w1, Weather w2
where datediff(w2.recordDate,w1.recordDate) = 1
  and w2.Temperature > w1.Temperature
```



## 行程和用户

表：`Trips`

```mysql
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| client_id   | int      |
| driver_id   | int      |
| city_id     | int      |
| status      | enum     |
| request_at  | varchar  |     
+-------------+----------+
```
id 是这张表的主键（具有唯一值的列）。
这张表中存所有出租车的行程信息。每段行程有唯一 id ，其中 client_id 和 driver_id 是 Users 表中 users_id 的外键。
status 是一个表示行程状态的枚举类型，枚举成员为(‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’) 。


表：`Users`

```mysql
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| users_id    | int      |
| banned      | enum     |
| role        | enum     |
+-------------+----------+
```
users_id 是这张表的主键（具有唯一值的列）。
这张表中存所有用户，每个用户都有一个唯一的 users_id ，role 是一个表示用户身份的枚举类型，枚举成员为 (‘client’, ‘driver’, ‘partner’) 。
banned 是一个表示用户是否被禁止的枚举类型，枚举成员为 (‘Yes’, ‘No’) 。


**取消率** 的计算方式如下：(被司机或乘客取消的非禁止用户生成的订单数量) / (非禁止用户生成的订单总数)。

编写解决方案找出 `"2013-10-01"` 至 `"2013-10-03"` 期间非禁止用户（**乘客和司机都必须未被禁止**）的取消率。非禁止用户即 banned 为 No 的用户，禁止用户即 banned 为 Yes 的用户。其中取消率 `Cancellation Rate` 需要四舍五入保留 **两位小数** 。

返回结果表中的数据 **无顺序要求** 。

结果格式如下例所示。

**示例 1：**

```mysql
输入： 
Trips 表：
+----+-----------+-----------+---------+---------------------+------------+
| id | client_id | driver_id | city_id | status              | request_at |
+----+-----------+-----------+---------+---------------------+------------+
| 1  | 1         | 10        | 1       | completed           | 2013-10-01 |
| 2  | 2         | 11        | 1       | cancelled_by_driver | 2013-10-01 |
| 3  | 3         | 12        | 6       | completed           | 2013-10-01 |
| 4  | 4         | 13        | 6       | cancelled_by_client | 2013-10-01 |
| 5  | 1         | 10        | 1       | completed           | 2013-10-02 |
| 6  | 2         | 11        | 6       | completed           | 2013-10-02 |
| 7  | 3         | 12        | 6       | completed           | 2013-10-02 |
| 8  | 2         | 12        | 12      | completed           | 2013-10-03 |
| 9  | 3         | 10        | 12      | completed           | 2013-10-03 |
| 10 | 4         | 13        | 12      | cancelled_by_driver | 2013-10-03 |
+----+-----------+-----------+---------+---------------------+------------+
Users 表：
+----------+--------+--------+
| users_id | banned | role   |
+----------+--------+--------+
| 1        | No     | client |
| 2        | Yes    | client |
| 3        | No     | client |
| 4        | No     | client |
| 10       | No     | driver |
| 11       | No     | driver |
| 12       | No     | driver |
| 13       | No     | driver |
+----------+--------+--------+
输出：
+------------+-------------------+
| Day        | Cancellation Rate |
+------------+-------------------+
| 2013-10-01 | 0.33              |
| 2013-10-02 | 0.00              |
| 2013-10-03 | 0.50              |
+------------+-------------------+
```
解释：
2013-10-01：
  - 共有 4 条请求，其中 2 条取消。

  - 然而，id=2 的请求是由禁止用户（user_id=2）发出的，所以计算时应当忽略它。

  - 因此，总共有 3 条非禁止请求参与计算，其中 1 条取消。

  - 取消率为 (1 / 3) = 0.33

2013-10-02：

  - 共有 3 条请求，其中 0 条取消。

  - 然而，id=6 的请求是由禁止用户发出的，所以计算时应当忽略它。

  - 因此，总共有 2 条非禁止请求参与计算，其中 0 条取消。

  - 取消率为 (0 / 2) = 0.00

2013-10-03：

  - 共有 3 条请求，其中 1 条取消。

  - 然而，id=8 的请求是由禁止用户发出的，所以计算时应当忽略它。

  - 因此，总共有 2 条非禁止请求参与计算，其中 1 条取消。

  - 取消率为 (1 / 2) = 0.50

**解析**

```mysql
-- 首先，我们先找到那些用户是非禁止用户，即banned=No的用户
select u1.users_id
from Users u1
where banned = "No"
-- 第二，根据非禁止用户，把那些trips表里那些是非禁止用户的订单找出来
select *
from Trips t
where client_id not in (
    select u1.users_id
    from Users u1
    where banned = "Yes"
)
  and driver_id not in (
    select u2.users_id
    from Users u2
    where banned = "Yes"
)
-- 第三，根据要求限制时间
select *
from Trips t
where request_at between '2013-10-01' and '2013-10-03'
  and client_id not in (
    select u1.users_id
    from Users u1
    where banned = "Yes"
)
  and driver_id not in (
    select u2.users_id
    from Users u2
    where banned = "Yes"
)
-- 第四，结果格式中显示要按照日期来分组，所以加上分组
select *
from Trips t
where request_at between '2013-10-01' and '2013-10-03'
  and client_id not in (
    select u1.users_id
    from Users u1
    where banned = "Yes"
)
  and driver_id not in (
    select u2.users_id
    from Users u2
    where banned = "Yes"
)
group by request_at
-- 最后，把结果格式中要求的Day字段和Cancellation Rate字段展示出来，即日期和取消率
-- 每组总行程数：count(t.status)
-- 每组取消的行程数：SUM(IF(t.status = 'completed',0,1))
-- 取消率最后再用 Round 函数来四舍五入保留最后两位
select request_at as "Day",
	ROUND(
			SUM(
				IF(t.status = 'completed',0,1)
			)
			/ 
			COUNT(t.status),
			2
	) AS `Cancellation Rate`
from Trips t
where request_at between '2013-10-01' and '2013-10-03'
  and client_id not in (
    select u1.users_id
    from Users u1
    where banned = "Yes"
)
  and driver_id not in (
    select u2.users_id
    from Users u2
    where banned = "Yes"
)
group by request_at
```

- Round 函数：用于数据的四舍五入，round(要处理的数, 保留几位小数)



## 游戏玩法分析Ⅰ

活动表 `Activity`：

```mysql
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
```
在 SQL 中，表的主键是 (player_id, event_date)。
这张表展示了一些游戏玩家在游戏平台上的行为活动。
每行数据记录了一名玩家在退出平台之前，当天使用同一台设备登录平台后打开的游戏的数目（可能是 0 个）。


查询每位玩家 **第一次登录平台的日期**。

查询结果的格式如下所示：

```mysql
Activity 表：
+-----------+-----------+------------+--------------+
| player_id | device_id | event_date | games_played |
+-----------+-----------+------------+--------------+
| 1         | 2         | 2016-03-01 | 5            |
| 1         | 2         | 2016-05-02 | 6            |
| 2         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+

Result 表：
+-----------+-------------+
| player_id | first_login |
+-----------+-------------+
| 1         | 2016-03-01  |
| 2         | 2017-06-25  |
| 3         | 2016-03-02  |
+-----------+-------------+
```

**解析**

```mysql
# Write your MySQL query statement below
select player_id, min(event_date) as "first_login"
from Activity
group by player_id
```



## 游戏玩法分析Ⅳ

Table: `Activity`

```mysql
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
```
（player_id，event_date）是此表的主键（具有唯一值的列的组合）。
这张表显示了某些游戏的玩家的活动情况。
每一行是一个玩家的记录，他在某一天使用某个设备注销之前登录并玩了很多游戏（可能是 0）。


编写解决方案，报告在首次登录的第二天再次登录的玩家的 **比率**，**四舍五入到小数点后两位**。换句话说，你需要计算从首次登录日期开始至少连续两天登录的玩家的数量，然后除以玩家总数。

结果格式如下所示：

**示例 1：**

```mysql
输入：
Activity table:
+-----------+-----------+------------+--------------+
| player_id | device_id | event_date | games_played |
+-----------+-----------+------------+--------------+
| 1         | 2         | 2016-03-01 | 5            |
| 1         | 2         | 2016-03-02 | 6            |
| 2         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+
输出：
+-----------+
| fraction  |
+-----------+
| 0.33      |
+-----------+
解释：
只有 ID 为 1 的玩家在第一天登录后才重新登录，所以答案是 1/3 = 0.33
```

**解析**

```mysql
-- 方法1
# 首先找出每个玩家他的第二天登录的时间，方法是查询出 Activity 表中每个用户的第一天时间，并加上 1.
select player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY) as second_date
from Activity
group by player_id;
# 然后根据这个记录找出，那些玩家是真的第二天登录了的
select a.player_id as player_id
from (
    select player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY) as second_date
    from Activity
    group by player_id
) e, Activity a
where a.event_date = e.second_date
and a.player_id = e.player_id;
# 然后再根据 第二天真的登录了的玩家的数量 / 玩家总数 得出结果
# 再使用 ROUND 来四舍五入两位小数并用IFNULL来保证再没有数据的情况下的结果为0 
select IFNULL(ROUND(count(distinct(r.player_id)) / count(distinct(a2.player_id)),2),0) as fraction
from (
    select a.player_id as player_id
    from (
        select player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY) as second_date
        from Activity
        group by player_id
    ) e, Activity a
    where a.event_date = e.second_date
    and a.player_id = e.player_id
) r, Activity a2;

-- 方法2
# 首先找出每个玩家他的第二天登录的时间
# 然后用where (a2.player_id, a2.event_date) in 玩家第二天登录时间来找出第二天登录了的玩家
select *
from Activity a2
where (a2.player_id, a2.event_date) in (
    select a1.player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY)
    from Activity a1
    group by a1.player_id
)
# 然后直接用 上面的数据的数量（即第二天真的登录了的玩家的数量）/ 玩家总数 得出结果
# 再使用 ROUND 来四舍五入两位小数并用IFNULL来保证再没有数据的情况下的结果为0 
select IFNULL(
    ROUND(
        count(distinct(a2.player_id))
        /
        (select count(distinct(player_id)) from Activity)
        ,2
    )
    ,0
) as fraction
from Activity a2
where (a2.player_id, a2.event_date) in (
    select a1.player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY)
    from Activity a1
    group by a1.player_id
)
```



## 至少有5名直接下属的经理

表: `Employee`

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+
id 是此表的主键（具有唯一值的列）。
该表的每一行表示雇员的名字、他们的部门和他们的经理的id。
如果managerId为空，则该员工没有经理。
没有员工会成为自己的管理者。
```

编写一个解决方案，找出至少有**五个直接下属**的经理。

以 **任意顺序** 返回结果表。

查询结果格式如下所示。

**示例 1:**

```mysql
输入: 
Employee 表:
+-----+-------+------------+-----------+
| id  | name  | department | managerId |
+-----+-------+------------+-----------+
| 101 | John  | A          | Null      |
| 102 | Dan   | A          | 101       |
| 103 | James | A          | 101       |
| 104 | Amy   | A          | 101       |
| 105 | Anne  | A          | 101       |
| 106 | Ron   | B          | 101       |
+-----+-------+------------+-----------+
输出: 
+------+
| name |
+------+
| John |
+------+
```

**解析**

```mysql
-- 首先将员工表复制一份，用来找出有上级经理的员工的信息
select e2.*
from Employee e1, Employee e2
where e2.managerId = e1.id
-- 然后再查出这些员工的上级经理的信息
select e2.*
from Employee e1, Employee e2
where e2.managerId = e1.id
group by e2.managerId
-- 然后用having判断那些经理是有五个直接下属的
select e2.managerId
from Employee e1, Employee e2
where e2.managerId = e1.id
group by e2.managerId
having count(*) >=5
-- 最后用这些经理的id找到他们的名字
select e3.name
from Employee e3
where id in (
    select e2.managerId
    from Employee e1, Employee e2
    where e2.managerId = e1.id
    group by e2.managerId
    having count(*) >=5
)
```



## 员工奖金

表：`Employee` 

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| empId       | int     |
| name        | varchar |
| supervisor  | int     |
| salary      | int     |
+-------------+---------+
empId 是该表中具有唯一值的列。
该表的每一行都表示员工的姓名和 id，以及他们的工资和经理的 id。
```

表：`Bonus`

```mysql
+-------------+------+
| Column Name | Type |
+-------------+------+
| empId       | int  |
| bonus       | int  |
+-------------+------+
empId 是该表具有唯一值的列。
empId 是 Employee 表中 empId 的外键(reference 列)。
该表的每一行都包含一个员工的 id 和他们各自的奖金。
```

编写解决方案，报告每个奖金 **少于** `1000` 的员工的姓名和奖金数额。

以 **任意顺序** 返回结果表。

结果格式如下所示。

**示例 1：**

```mysql
输入：
Employee table:
+-------+--------+------------+--------+
| empId | name   | supervisor | salary |
+-------+--------+------------+--------+
| 3     | Brad   | null       | 4000   |
| 1     | John   | 3          | 1000   |
| 2     | Dan    | 3          | 2000   |
| 4     | Thomas | 3          | 4000   |
+-------+--------+------------+--------+
Bonus table:
+-------+-------+
| empId | bonus |
+-------+-------+
| 2     | 500   |
| 4     | 2000  |
+-------+-------+
输出：
+------+-------+
| name | bonus |
+------+-------+
| Brad | null  |
| John | null  |
| Dan  | 500   |
+------+-------+
```

**解析**

```mysql
select e.name, b.bonus
from Employee e
left join Bonus b on e.empId = b.empId
where b.bonus < 1000
   or b.bonus is null;
```



## 寻找用户推荐人

表: `Customer`

```mysql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| referee_id  | int     |
+-------------+---------+
在 SQL 中，id 是该表的主键列。
该表的每一行表示一个客户的 id、姓名以及推荐他们的客户的 id。
```

找出那些 **没有被** `id = 2` 的客户 **推荐** 的客户的姓名。

以 **任意顺序** 返回结果表。

结果格式如下所示。

**示例 1：**

```mysql
输入： 
Customer 表:
+----+------+------------+
| id | name | referee_id |
+----+------+------------+
| 1  | Will | null       |
| 2  | Jane | null       |
| 3  | Alex | 2          |
| 4  | Bill | null       |
| 5  | Zack | 1          |
| 6  | Mark | 2          |
+----+------+------------+
输出：
+------+
| name |
+------+
| Will |
| Jane |
| Bill |
| Zack |
+------+
```

**解析**

```mysql
select name
from Customer
where referee_id != 2
   or referee_id is null;
```



## 2016年的投资

`Insurance` 表：

```mysql
+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| pid         | int   |
| tiv_2015    | float |
| tiv_2016    | float |
| lat         | float |
| lon         | float |
+-------------+-------+
```
pid 是这张表的主键(具有唯一值的列)。
表中的每一行都包含一条保险信息，其中：
pid 是投保人的投保编号。
tiv_2015 是该投保人在 2015 年的总投保金额，tiv_2016 是该投保人在 2016 年的总投保金额。
lat 是投保人所在城市的纬度。题目数据确保 lat 不为空。
lon 是投保人所在城市的经度。题目数据确保 lon 不为空。




编写解决方案报告 2016 年 (`tiv_2016`) 所有满足下述条件的投保人的投保金额之和：

- 他在 2015 年的投保额 (`tiv_2015`) 至少跟一个其他投保人在 2015 年的投保额相同。
- 他所在的城市必须与其他投保人都不同（也就是说 (`lat, lon`) 不能跟其他任何一个投保人完全相同）。

`tiv_2016` 四舍五入的 **两位小数** 。

查询结果格式如下例所示。

**示例 1：**

```mysql
输入：
Insurance 表：
+-----+----------+----------+-----+-----+
| pid | tiv_2015 | tiv_2016 | lat | lon |
+-----+----------+----------+-----+-----+
| 1   | 10       | 5        | 10  | 10  |
| 2   | 20       | 20       | 20  | 20  |
| 3   | 10       | 30       | 20  | 20  |
| 4   | 10       | 40       | 40  | 40  |
+-----+----------+----------+-----+-----+
输出：
+----------+
| tiv_2016 |
+----------+
| 45.00    |
+----------+
```
解释：
表中的第一条记录和最后一条记录都满足两个条件。
tiv_2015 值为 10 与第三条和第四条记录相同，且其位置是唯一的。

第二条记录不符合任何一个条件。其 tiv_2015 与其他投保人不同，并且位置与第三条记录相同，这也导致了第三条记录不符合题目要求。
因此，结果是第一条记录和最后一条记录的 tiv_2016 之和，即 45 。


**解析**

```mysql
-- 看完两个条件以后发现都可以用group + having count 的方式来找出两个条件的结果集
-- 首先查出一个条件的结果集
select tiv_2015
from Insurance
group by tiv_2015
having count(*) > 1
-- 再查出第二个条件的结果集，所在城市必须与其他投保人都不同就代表了根据经纬度分组，这个组的数量不能大于1
select lat, lon
from Insurance
group by lat,lon
having count(*) = 1
-- 再用 and 得出交集，得到结果
-- 用concat将经纬度转成一个整体再去对比
select round(sum(tiv_2016),2) as TIV_2016
from Insurance
where tiv_2015 in (
    select tiv_2015
    from Insurance
    group by tiv_2015
    having count(*) > 1
)
  and concat(lat,",",lon) in (
    select concat(lat,",",lon)
    from Insurance
    group by lat,lon
    having count(*) = 1
)
```



## 订单最多的客户

表: `Orders`

```mysql
+-----------------+----------+
| Column Name     | Type     |
+-----------------+----------+
| order_number    | int      |
| customer_number | int      |
+-----------------+----------+
```
在 SQL 中，Order_number是该表的主键。
此表包含关于订单ID和客户ID的信息。




查找下了 **最多订单** 的客户的 `customer_number` 。

测试用例生成后， **恰好有一个客户** 比任何其他客户下了更多的订单。

查询结果格式如下所示。

**示例 1:**

```mysql
输入: 
Orders 表:
+--------------+-----------------+
| order_number | customer_number |
+--------------+-----------------+
| 1            | 1               |
| 2            | 2               |
| 3            | 3               |
| 4            | 3               |
+--------------+-----------------+
输出: 
+-----------------+
| customer_number |
+-----------------+
| 3               |
+-----------------+
```
**解释:** 
customer_number 为 '3' 的顾客有两个订单，比顾客 '1' 或者 '2' 都要多，因为他们只有一个订单。
所以结果是该顾客的 customer_number ，也就是 3 。

**解析**

```mysql
-- 根据customer_number分组，得出每组的数量并倒序排序，然后用limit拿到第一个
select customer_number
from Orders
group by customer_number
order by count(*) desc
limit 1;
```



## 体育馆人流量

表：`Stadium`

```mysql
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| visit_date    | date    |
| people        | int     |
+---------------+---------+
```
visit_date 是该表中具有唯一值的列。
每日人流量信息被记录在这三列信息中：序号 (id)、日期 (visit_date)、 人流量 (people)
每天只有一行记录，日期随着 id 的增加而增加




编写解决方案找出每行的人数大于或等于 `100` 且 `id` 连续的三行或更多行记录。

返回按 `visit_date` **升序排列** 的结果表。

查询结果格式如下所示。

**示例 1:**

```mysql
输入：
Stadium 表:
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 1    | 2017-01-01 | 10        |
| 2    | 2017-01-02 | 109       |
| 3    | 2017-01-03 | 150       |
| 4    | 2017-01-04 | 99        |
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-09 | 188       |
+------+------------+-----------+
输出：
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-09 | 188       |
+------+------------+-----------+
```
解释：
id 为 5、6、7、8 的四行 id 连续，并且每行都有 >= 100 的人数记录。
请注意，即使第 7 行和第 8 行的 visit_date 不是连续的，输出也应当包含第 8 行，因为我们只需要考虑 id 连续的记录。
不输出 id 为 2 和 3 的行，因为至少需要三条 id 连续的记录。

**解析**

```mysql
-- 公共表达式 + 开窗函数 lag 和 lead
with people as {
	select id, visit_date, people,
		LAG(people,2) over(order by id) as pprvPeople,
		LAG(people,1) over(order by id) as prvPeople,
		LEAD(people,2) over(order by id) as nnextPeople,
		LEAD(people,1) over(order by id) as nextPeople,
	from Stadium
}

select id, visit_date, people
from people
where (people >= 100, pprvPeople >= 100, prvPeople >= 100) ||
	  (people >= 100, nextPeople >= 100, nnextPeople >= 100) ||
	  (people >= 100, prvPeople >= 100, nextPeople >= 100);
	  
-- 公共表达式
-- 重点在id-row_number() over() 和 group by t having count(*)>=3
with tmp as (
    select id-row_number() over() as t,id,visit_date,people
    from Stadium
    where people >=100 
)
select tmp.id,tmp.visit_date,tmp.people 
from tmp
where tmp.t in (
    select t from tmp
    group by t
    having count(*)>=3
)

```



## [好友申请 II ：谁有最多的好友](https://leetcode.cn/problems/friend-requests-ii-who-has-the-most-friends/)

`RequestAccepted` 表：

```mysql
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| requester_id   | int     |
| accepter_id    | int     |
| accept_date    | date    |
+----------------+---------+
(requester_id, accepter_id) 是这张表的主键(具有唯一值的列的组合)。
这张表包含发送好友请求的人的 ID ，接收好友请求的人的 ID ，以及好友请求通过的日期。
```

编写解决方案，找出拥有最多的好友的人和他拥有的好友数目。

生成的测试用例保证拥有最多好友数目的只有 1 个人。

查询结果格式如下例所示。

**示例 1：**

```mysql
输入：
RequestAccepted 表：
+--------------+-------------+-------------+
| requester_id | accepter_id | accept_date |
+--------------+-------------+-------------+
| 1            | 2           | 2016/06/03  |
| 1            | 3           | 2016/06/08  |
| 2            | 3           | 2016/06/08  |
| 3            | 4           | 2016/06/09  |
+--------------+-------------+-------------+
输出：
+----+-----+
| id | num |
+----+-----+
| 3  | 3   |
+----+-----+
解释：
编号为 3 的人是编号为 1 ，2 和 4 的人的好友，所以他总共有 3 个好友，比其他人都多。
```

**解析**

```mysql
-- 主要利用了union all全连接
-- 因为不管是 requester_id 和 accepter_id 都算做题目的“他拥有的好友数目”一条记录
-- 所以得根据这两个id来分组两次，来查出，id(拥有最多的好友的人) 和 num(他拥有的好友数目)
-- 然后用 union all 全连接起来，因为union all比union好的地方在于重复的也会在里面
-- 这样就能统计出来每个id 有多少个好友
-- 最后通过group by、order by、limit来找出最多好友的人
select a.id, sum(a.number) as num
from (
    select accepter_id as id, count(accepter_id) as number
    from RequestAccepted
    group by accepter_id
    union all
    select requester_id as id, count(requester_id) as number
    from RequestAccepted
    group by requester_id
) as a
group by a.id
order by num desc
limit 1;
```



## [销售员](https://leetcode.cn/problems/sales-person/description/)

表: `SalesPerson`

```
+-----------------+---------+
| Column Name     | Type    |
+-----------------+---------+
| sales_id        | int     |
| name            | varchar |
| salary          | int     |
| commission_rate | int     |
| hire_date       | date    |
+-----------------+---------+
sales_id 是该表的主键列(具有唯一值的列)。
该表的每一行都显示了销售人员的姓名和 ID ，以及他们的工资、佣金率和雇佣日期。
```

表: `Company`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| com_id      | int     |
| name        | varchar |
| city        | varchar |
+-------------+---------+
com_id 是该表的主键列(具有唯一值的列)。
该表的每一行都表示公司的名称和 ID ，以及公司所在的城市。
```

表: `Orders`

```
+-------------+------+
| Column Name | Type |
+-------------+------+
| order_id    | int  |
| order_date  | date |
| com_id      | int  |
| sales_id    | int  |
| amount      | int  |
+-------------+------+
order_id 是该表的主键列(具有唯一值的列)。
com_id 是 Company 表中 com_id 的外键（reference 列）。
sales_id 是来自销售员表 sales_id 的外键（reference 列）。
该表的每一行包含一个订单的信息。这包括公司的 ID 、销售人员的 ID 、订单日期和支付的金额。
```

编写解决方案，找出没有任何与名为 **“RED”** 的公司相关的订单的所有销售人员的姓名。

以 **任意顺序** 返回结果表。

返回结果格式如下所示。

**示例 1：**

```
输入：
SalesPerson 表:
+----------+------+--------+-----------------+------------+
| sales_id | name | salary | commission_rate | hire_date  |
+----------+------+--------+-----------------+------------+
| 1        | John | 100000 | 6               | 4/1/2006   |
| 2        | Amy  | 12000  | 5               | 5/1/2010   |
| 3        | Mark | 65000  | 12              | 12/25/2008 |
| 4        | Pam  | 25000  | 25              | 1/1/2005   |
| 5        | Alex | 5000   | 10              | 2/3/2007   |
+----------+------+--------+-----------------+------------+
Company 表:
+--------+--------+----------+
| com_id | name   | city     |
+--------+--------+----------+
| 1      | RED    | Boston   |
| 2      | ORANGE | New York |
| 3      | YELLOW | Boston   |
| 4      | GREEN  | Austin   |
+--------+--------+----------+
Orders 表:
+----------+------------+--------+----------+--------+
| order_id | order_date | com_id | sales_id | amount |
+----------+------------+--------+----------+--------+
| 1        | 1/1/2014   | 3      | 4        | 10000  |
| 2        | 2/1/2014   | 4      | 5        | 5000   |
| 3        | 3/1/2014   | 1      | 1        | 50000  |
| 4        | 4/1/2014   | 1      | 4        | 25000  |
+----------+------------+--------+----------+--------+
输出：
+------+
| name |
+------+
| Amy  |
| Mark |
| Alex |
+------+
解释：
根据表 orders 中的订单 '3' 和 '4' ，容易看出只有 'John' 和 'Pam' 两个销售员曾经向公司 'RED' 销售过。
所以我们需要输出表 salesperson 中所有其他人的名字。
```

**解析**

```mysql
-- 首先查出“RED”公司在Orders表中所有订单信息
select *
from Orders o 
left join Company c on o.com_id = c.com_id
where c.name = "RED"
-- 然后再根据上一步查出的信息的sales_id来反推销售人员
-- 那些销售人员的id不在上一步的信息中就代表“没有任何与名为 “RED” 的公司相关的订单”
select name
from SalesPerson
where sales_id not in (
    select sales_id
    from Orders o 
    left join Company c on o.com_id = c.com_id
    where c.name = "RED"
)
```

