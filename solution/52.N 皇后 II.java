/*
 * @lc app=leetcode.cn id=52 lang=java
 * @lcpr version=30202
 *
 * [52] N 皇后 II
 */

// @lc code=start
/**
 * ### 总结：传参问题及其原因分析

#### 1. **基本类型传值问题**
**问题表现**：  
在原始代码中，`res`作为基本类型`int`通过参数传递给`dfs`方法，但在递归过程中`res`的值没有被正确累积。

**原因**：  
- Java中基本类型（如`int`）是**按值传递**的，方法内对参数的修改不会影响原始变量
- 每次递归调用都会创建新的`res`副本，导致：
  - 找到解时`res++`只修改局部副本
  - 回溯时无法将修改传递回上层调用

**错误代码示例**：
```java
void dfs(..., int res) {
    if (row == n) res++; // 只修改局部副本
    // 递归调用后无法获取子问题的res值
}
```

#### 2. **静态变量误用问题**
**问题表现**：  
将`res`改为`static`后，多次调用`totalNQueens`会累积结果。

**原因**：  
- `static`变量属于类级别，所有实例共享
- 第一次调用后`res`不会被重置，导致：
  - 第二次调用时会在前次结果上继续累加
  - 违反方法的幂等性（相同输入应得到相同输出）

**错误代码示例**：
```java
static int res; // 多个测试用例会共享此变量

int totalNQueens(int n) {
    // 缺少res = 0的初始化
    dfs(...);
    return res; // 后续调用会返回累加值
}
```

#### 3. **正确的参数传递方案**
**解决方案对比**：

| 方案                | 优点                     | 缺点                     | 适用场景               |
|---------------------|--------------------------|--------------------------|-----------------------|
| **实例变量**        | 天然支持递归累计         | 需要每次重置             | 单次方法调用          |
| **返回值累计**       | 无副作用，逻辑清晰       | 需要修改方法签名         | 所有递归场景          |
| **容器对象传参**     | 可模拟引用传递           | 代码稍显复杂             | 需要多结果返回时      |

**推荐方案代码**：
```java
// 方案1：使用实例变量（需重置）
class Solution {
    private int res; // 实例变量
    
    public int totalNQueens(int n) {
        res = 0; // 关键重置
        dfs(...);
        return res;
    }
}

// 方案2：通过返回值累计（更函数式）
private int dfs(...) {
    int count = 0;
    if (row == n) return 1;
    for (...) {
        count += dfs(...);
    }
    return count;
}
```

#### 4. **关键教训**
1. **基本类型传参**：  
   - 需要明确知道Java是值传递
   - 递归中若需要累计结果，应避免用基本类型参数

2. **变量作用域**：  
   - 静态变量在算法题中通常有害
   - 实例变量需注意重置时机

3. **递归设计原则**：  
   - 优先使用返回值传递状态
   - 若用共享变量，必须确保调用间的隔离性

这些传参问题的本质是对Java参数传递机制和变量作用域的理解不足，在递归算法中需要特别注意状态的管理方式。
 */
class Solution {
    /**
     * 只要有结果就加一，不用返回具体的结果
     * @param n
     * @return
     */
    private int res;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        // 初始化
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, n, 0);
        return res;
    }

    private void dfs(char[][] board, int n, int row) {
        // 我们尝试在每一行放一个皇后，如果满足结果就加一，遍历完所有的行了，说明可以
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            // 判读是否满足要求
            if (check(board, row, col, n)) {
                // 放置皇后
                board[row][col] = 'Q';
                dfs(board, n, row + 1);
                // 恢复现场
                board[row][col] = '.';
            }
        }
    }

    private boolean check(char[][] board, int row, int col, int n) {
        // 检查每一列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j --) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

