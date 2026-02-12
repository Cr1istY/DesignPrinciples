## 工厂模式

核心思想：用一个专门的“创建者“（工厂类/方法）替代new，隔离变化点。

即，定义一个创建对象的接口，让其子类自己决定将哪一个工厂类实例化，工厂模式使创建过程延迟到子类中进行。

### 传统做法

例如，参考我们在SRP中提到的例子。

客户端给我们返回了一个用户类型，我们要根据这个用户类型来设置用户的权限。

```java
// 我们可能会这么写
public class VideoUserService {
    public void serveGrade(String userType) {
        if (UserType.VISITOR == userType) {
            System.out.println("游客级别");
            System.out.println("分辨率：360P");
            System.out.println("广告时长：50秒");
        } else if (UserType.NORMAL == userType) {
            System.out.println("普通用户级别");
            System.out.println("分辨率：720P");
            System.out.println("广告时长：10秒");
        } else if (UserType.VIP == userType) {
            System.out.println("VIP用户级别");
            System.out.println("分辨率：1080P");
            System.out.println("广告时长：0秒");
        } else {
            throw new RuntimeException("用户类型错误");
        }
    }
}
```
但是，显然，这样会导致代码维护困难。

我们必须对其进行优化，例如采用工厂模式（可见代码案例）。

改写过程，可见我的秘书（Qwen3-Max-Thinking）生成的网页。

