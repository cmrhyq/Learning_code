# React 学习 demo

## 钩子 hooks
```js
import {useState} from "react";

export default function Input(){
    // 状态变量inputText 和setText 方法用于设置当前键入的文本。useState 钩子在组件开始时初始化。
    // 默认情况下，inputText 将设置为 "hello"。
    const [inputText, setInputText] = useState('hello');

    // 当用户键入时，handleChange 函数，会从浏览器的输入 DOM 元素中读取最新的输入值，并调用setText 函数，更新inputText 的本地状态。
    function handleChange(e){
        setInputText(e.target.value);
    }

    return (
        <div>
            <input value={inputText} onChange={handleChange} />
            <p>You typed: {inputText}</p>
            <button onClick={() => setInputText('hello')}>
                Reset
            </button>
        </div>
    )
}

```
钩子还附带了一系列规则，您在使用它们时需要遵守。这适用于所有 React 挂钩，包括您刚刚学习的useState 挂钩。

- 您只能在组件的顶层或您自己的钩子中调用钩子。
- 您不能在 Loop 或条件中调用钩子。
- 只能在 React 函数中调用钩子，而不能在 Regular JavaScript 函数中调用钩子。

为了演示，让我们扩展前面的示例，在一个组件中包含三个输入文本字段。这可能是一个注册表单，包含名字、姓氏和电子邮件字段。
```js
import {useState} from "react";

export default function RegisterForm() {
    const [form, setForm] = useState({
        firstName: "Alan",
        lastName: "Huang",
        email: "cmrhyq@gmail.com",
    });

    return (
        <div>
            <label>
                First Name:
                <input
                    value={form.firstName}
                    onChange={e =>
                        setForm({
                            ...form, firstName: e.target.value
                        })
                    }/>
            </label>
            <label>
                Last Name:
                <input
                    value={form.lastName}
                    onChange={e =>
                        setForm({
                            ...form, lastName: e.target.value
                        })
                    }/>
            </label>
            <label>
                Email Address:
                <input
                    value={form.email}
                    onChange={e =>
                        setForm({
                            ...form, email: e.target.value
                        })
                    }/>
            </label>
            <p>
                {form.firstName}{" "}
                {form.lastName}{" "}
                {form.email}{" "}
            </p>
        </div>
    )
}

```
请注意，您使用的是form 对象来存储所有三个文本输入字段值的状态：

```js
const[form, setForm] =useState({
firstName:'Luke',
lastName:'Jones',
email:'lukeJones@sculpture.com',
});
```

在这种情况下，您不需要有三个单独的状态变量，而是可以将它们合并到一个form 对象中，以获得更好的可读性。

除了useState 钩子外，还有其他一些钩子也很有用，如useContext,useMemo,useRef 等 。如果需要共享逻辑并在多个组件中重复使用相同的逻辑，可以将逻辑提取到自定义钩子中。自定义钩子具有灵活性，可用于表单处理、动画、计时器等多种 Use Cases。

接下来，我将向您介绍 useRef 挂钩的工作原理。

### useRef钩子

我们使用useRef钩子直接访问子元素

调用useRef钩子时，它会返回一个ref对象。ref对象有一个名为current的属性
```js
function TextInputWithFocusButton() {
  const inputEl = useRef(null);
  const onButtonClick = () => {
    // `current` points to the mounted text input element
    inputEl.current.focus();
  };
  return (
    <>
      <input ref={inputEl} type="text" />
      <button onClick={onButtonClick}>Focus the input</button>
    </>
  );
}
```
使用输入元素上的 ref 属性，我就可以访问当前值，并调用其上的 focus() 方法，从而聚焦输入字段。

在某些情况下，需要直接访问 DOM，这就是 useRef 钩子发挥作用的地方。

## 状态管理

