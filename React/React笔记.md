### 前端技术栈大全

相关链接

[前端技术栈大全](https://segmentfault.com/a/1190000039085521)

[前端常用技术栈](https://blog.csdn.net/renqq001/article/details/141950011)

基础技术

- **HTML/CSS**: 用于网页结构和样式设计。
- **JavaScript**: 前端开发的核心编程语言。

前端框架和库

- **React**: 由Facebook开发的用于构建用户界面的JavaScript库。
- **Vue.js**: 轻量级的JavaScript框架，适合快速开发。
- **Angular**: 由Google维护的前端框架，适合大型应用。

状态管理

- **Redux**: 常用于React应用的状态管理库。
- **Vuex**: Vue.js的状态管理模式。
- **MobX**: 另一种用于React的状态管理库。

UI组件库

- **Element UI**: 基于Vue.js的UI组件库。
- **Ant Design**: 基于React的UI组件库。
- **Bootstrap**: 最流行的前端框架之一，提供了丰富的UI组件。

打包工具

- **Webpack**: 最常用的模块打包工具。
- **Vite**: 新一代前端构建工具，速度更快。
- **Rollup**: 专注于打包JavaScript库的工具。

请求库

- **Axios**: 基于Promise的HTTP请求库。
- **Fetch API**: 原生的JavaScript请求库。

跨平台开发

- **React Native**: 用于构建移动应用的框架。
- **Flutter**: Google推出的跨平台移动应用开发框架。
- **Electron**: 用于构建桌面应用的框架。

性能优化

- **Lighthouse**: Google提供的性能分析工具。
- **Webpack Bundle Analyzer**: 分析Webpack打包结果的工具。

前端工具

- **npm/yarn**: 包管理工具。
- **ESLint**: JavaScript代码质量工具。
- **Prettier**: 代码格式化工具。

前端测试

- **Jest**: JavaScript测试框架。
- **Mocha**: 灵活的JavaScript测试框架。
- **Cypress**: 端到端测试框架。

响应式设计

- **Media Queries**: CSS中的媒体查询，用于响应式设计。
- **Bootstrap**: 提供响应式设计的网格系统。

移动端适配

- **Rem/Em**: CSS中的相对单位，用于适配不同屏幕尺寸。
- **Viewport**: 控制视口的HTML标签。

SEO优化

- **Next.js**: 基于React的框架，支持服务器端渲染，有助于SEO优化。
- **Nuxt.js**: 基于Vue.js的框架，支持服务器端渲染。



### 工程构建

```bash
###### 1.创建项目
npm init vite
###### 2.安装依赖
npm i
###### 3.删除不必要的文件
###### 4.配置vite.config.ts
###### 5.安装reset-css
npm i reset-css
###### 6.main.tsx引入reset-css文件
## css文件引入顺序
## 一、引入reset-css
## 二、引入UI框架样式
## 三、引入全局样式
## 四、引入业务样式
import 'reset-css'
###### 7.构建工程样式
## 安装scss
npm i --save-dev sass
## src下新建assets/styles/global.scss
## main.tsx中引入全局样式
import '@/assets/styles/global.scss'
###### 8.配置@符号的路径别名
  // 配置模块解析规则
  resolve: {
    // 配置路径别名
    alias: {
      '@': path.resolve(__dirname, './src'),
    },
    // 配置省略文件后缀
    extensions: ['.js', '.json', '.jsx', '.ts', '.tsx'],
  },
###### 9.配置路径别名提示
  "compilerOptions": {
    "baseUrl": "./",
    "paths": {
      "@/": [
        "src/*"
      ]
    }
  }
###### 10.模块化引入scss
###### 11.配置ui框架样式自动按需引入
###### 12.编写路由
```



### React路由

第一种

```jsx
// router/index.tsx
import {BrowserRouter, Route, Routes} from "react-router-dom";
import App from "../App.tsx";
import Login from "../components/login/login.tsx";
import Dashboard from "../components/dashboard/dashboard.tsx";
import PermissionDenied from "../components/Error/PermissionDenied.tsx";
import NotFound from "../components/Error/NotFound.tsx";
import ServerError from "../components/Error/ServerError.tsx";
const baseRouter = () => (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<App/>}>
                <Route path="/login" element={<Login/>}></Route>
                <Route path="/dashboard" element={<Dashboard/>}></Route>
                <Route path="/403" element={<PermissionDenied/>}></Route>
                <Route path="/404" element={<NotFound/>}></Route>
                <Route path="/500" element={<ServerError/>}></Route>
            </Route>
        </Routes>
    </BrowserRouter>
)
export default baseRouter;
// main.tsx
import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import 'reset-css'
import '@/assets/styles/global.scss'
import Router from './router'
createRoot(document.getElementById('root')!).render(
    <StrictMode>
        {/*<App />*/}
        <Router/>
    </StrictMode>,
)
// App.tsx
import {Outlet} from "react-router-dom";
function App() {

    return (
        <div>
            {/*占位符组件，类似于窗口*/}
            <Outlet></Outlet>
        </div>
    )
}
export default App
```





### 好用的库

- reset-css：清除浏览器提供的默认样式



### css文件引入顺序

1. 引入reset-css
2. 引入antd样式
3. 引入全局样式
4. 引入业务样式



### vite.config.ts配置

```tsx
import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react'
import * as path from "node:path";
import basicSsl from "@vitejs/plugin-basic-ssl";

// https://vitejs.dev/config/
export default defineConfig({
  base: './',
  publicDir: 'public',

  // 项目构建过程配置
  build: {
    // 打包输出目录
    outDir: 'dist',
    // 是否压缩代码
    minify: false,
    // 是否生成sourcemap
    sourcemap: true,
  },

  // 全局变量
  define: {},

  // 配置插件
  plugins: [react(), basicSsl()],

  // 配置模块解析规则
  resolve: {
    // 配置路径别名
    alias: {
      '@': path.resolve(__dirname, './src'),
    },
    // 配置省略文件后缀
    extensions: ['.js', '.json', '.jsx', '.ts', '.tsx'],
  },

  // 配置服务端
  server: {
    // 端口号
    port: 4000,
    // 是否自动打开浏览器
    open: true,
    // 是否开启https
    https: true,
    // 监听所有地址
    host: true,
    // 跨域代理，为开发服务器配置CORS
    cors: true,
    // 代理配置
    proxy: {
      // '/api': {
      //     target: 'URL_ADDRESS',
      //     changeOrigin: true,
      //     rewrite: (path) => path.replace(/^\/api/, ''),
      // },
    },
  },


  // 配置css
  css: {
    preprocessorOptions: {
      scss: {
        api: 'modern-compiler',
      },
    },
  }
})

```

