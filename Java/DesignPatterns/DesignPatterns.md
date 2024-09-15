<div style="font-family: 'Kanit', sans-serif;text-align: center;border: 10px solid #fff;box-shadow: 1px 1px 2px #e6e6e6;background: linear-gradient(to left top, #11998e, #38ef7d); padding: 50px 0;">
<div style="color: #fff;">
    <h3 style="font-size: 25px;font-weight: 600;letter-spacing: 1px;text-transform: uppercase;margin: 0;">
       Java Desogm Patterns
    </h3>
    <span style="font-size: 16px;text-transform: capitalize;">
    	Java设计模式
    </span>
</div>
</div>


[toc]



## 设计模式常用的七大原则

### 设计模式的目的

在软件开发过程中，程序员面临着来自耦合性、内聚性以及可维护性、可扩展性、重用性、灵活性等多方面的挑战，设计模式是为了让程序具有以下的特性

- 单一职责原则
- 接口隔离原则
- 依赖倒转原则
- 里氏替换原则
- 开闭原则 OCP
- 迪米特法则
- 合成复用原则



### 单一职责原则

对类来说的，即一个类应该只负责一项职责，如负责类A负责两个两个不同职责：职责1，职责2。当职责1需求变更而改变A时，可能造成职责2执行错误，所以需要将类A的粒度分解为A1、A2
