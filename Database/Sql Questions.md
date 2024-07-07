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

```
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

```
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

```
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

```
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

```
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

```
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

```
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

```
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

```
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
```
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

