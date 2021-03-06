# 算法与数据结构
## 一、线性结构
- 线性结构是最常用的数据结构，特点是<font color="red">数据元素之前存在一对一的线性关系</font>
- 线性结构有2种不同的存储结构，顺序存储结构和链式存储结构
- 顺序存储的线性表叫顺序表，顺序表中的存储元素是连续的，也就是在内存中是连续的，比如数组
- 链式存储的线性表叫链表，链表中的存储元素不一定是连续的，元素节点中存放数据元素以及相邻元素的地址信息，好处是可以充分利用内存碎片地址
- 线性结构常见有：数组、队列、链表、栈
## 二、非线性结构
非线性结构不是一对一的关系，非线性结构包括：二维数组、多维数组、广义表(hash表)、树结构、图结构
## 三、稀疏数组
### 1、五子棋的棋盘保存
- 编写五子棋程序的时候，有存盘退出和续上盘的功能
- 棋盘使用二维数组来构建复盘，因为该二维数组可能有很多值都是默认值0，会记录很多没有意义的数据，这里我们就可以考虑使用稀疏数组
### 2、稀疏数组简介
- 当一个数组中大部分元素为0，或者为同一个值的时候，可以使用稀疏数组来保存该数组，稀疏数组的处理方法是：
- 记录数组一共有几行几列，有多少个不同的值
- 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
- 第1行第1列记录原始数组的行数，第1行第2列记录原是数组的列数，第1行第3列记录总共有多少个非0值。
- 第2行记录原来数组的第1个有效数据
- 第3行记录原来数组的第2个有效数据，依次类推
### 3、应用实例
- 使用稀疏数组，来保存类似前面的二维数组(棋盘，地图等)
- 把稀疏数组存盘，可以重新恢复原来的二维数组数
### 4、整体思路分析
#### 4.1、二维数组转稀疏数组的思路
- 遍历原始的二维数组，得到有效数组的个数count
- 根据count就可以创建稀疏数组int[] sparseArr=new int[count+1][3];
- 将二维数组的有效数据存入到稀疏数组
#### 4.2、稀疏数组转二维数组的思路
- 先读取稀疏数组的第1行，根据第1行的数据，创建原始的二维数组，比如原来数组int[][] originArr=new int[11][11];
- 在读取稀疏数组后几行的数组，并赋值给原来的二维数组就行。
## 四、队列
### 1、队列的介绍
- 队列是一个有序列表，可以用数组或者链表来实现
- 队列是先进先出的原则，也即是先存入的数据，要先取出。后存入的要后取出
### 2、用数组来模拟队列
- 首先数组是从下标0开始的，所以刚开始队列Queue为空的时候，有一个队头front，队尾rear，从队尾rear存入数据，从队头front取出数据。
- 刚开始空队列，rear=front=-1。
- 当有4个数据加队列的时候，front并没有变化还是-1，rear++来移动位置。比如说移动到3
- 当从队列中取出1个数据的时候，rear并没有变化，还是3，但是front会变化front++，从-1变为0
- 队列还有1个属性maxSize是该队列的最大容量。
- front随着数据输出而改变，rear随着输入而改变
### 3、操作队列
#### 3.1、将数据存入队列时叫addQueue
- 将rear尾部指针往后移动：rear+1，当front=rear说明队列为空
- 当rear<maxSize-1，则可以将数据存到队列中，否则无法存入，也就是rear==maxSize-1说明队列已满
#### 3.2、普通队列ArrayQueue的问题分析与优化
- 目前数据使用一次就不能复用，没有达到复用的效果
- 改进：将这个数组使用算法，改进成一个环形的队列，使用取模运算%
### 4、使用数组模拟环形队列的思路分析
#### 4.1、思路如下
- front变量的含义做个调整：front就指向队列的第一个元素，也就是说arr[front]就是队列的第1个元素，front的初始值为0
- rear变量的含义做一个调整：rear指向队列的最后一个位置，因为希望空出一个空间做为约定，rear的初始值为0
- 当队列满时，条件是(rear+1)%maxSize==front
- 此处rear+1是因为rear指向真实的队尾位置，如果成为环形，rear+1是下一个，如果模maxSize等于front说明rear已经移动到front的位置，也就重合了，所以就表示队列已满。
- 队列为空的条件，rear==front为空
- 我们分析出队列中有效的数据个数为(rear-front+maxSize)%maxSize
- 我们可以在原来的ArrayQueue中修改得到一个环形队列
### 5、环形队列和一般队列的区别
| 区别 | 一般队列 | 环形队列 |
| ------ | ------ | ------ |
| front | front初始值为-1，取出数据front+1 | front初始值为0，取出数据temp=a[front],然后front=(front+1)%maxSize |
| rear | rear初始值为-1，添加数据rear+1 | rear，添加数据a[rear]=data,rear=(rear+1)%maxSize |
| 判断为空 | rear==front | rear==front |
| 判断为满 | rear==maxSize-1 | (rear+1)%maxSize==front |
| 有效数据个数 | rear-front | (rear-front+maxSize)%maxSize |
















