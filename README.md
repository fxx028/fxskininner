# fxskininner
内部换肤技术：日间/夜间 切换

#### 换肤技术知识点

---
知识点
1. setContentView()到底干了什么
2. LayoutInflater将xml转换成View加载到window中
3. Factory2



通常换肤技术 Skin
缺点：
1. view 集合--所有控件
2. 遍历两层view
3. 是否兼容自定义控件？？？



当前技术
1. 分析super.onCreate(savedInstanceState);
2. AppCompatViewInflater 中控件具体初始化
3. Activity 已经实现Factory2

