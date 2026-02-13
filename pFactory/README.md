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

### 浅谈

下面，谈一谈我对工厂模式的理解。

还是回归上面的示例代码。

首先，为了践行单一职责原则，我们将每个if语句下的情况切分，可以切分三个类。

```java
public class VisitorService extends UserService  {
    public void serveGrade() {
        System.out.println("游客级别");
        System.out.println("分辨率：360P");
        System.out.println("广告时长：50秒");
    }
}

public class NormalUserService extends UserService {
    public void serveGrade() {
        System.out.println("普通用户级别");
        System.out.println("分辨率：720P");
        System.out.println("广告时长：10秒");
    }
}

public class VipUserService extends UserService {
    public void serveGrade() {
        System.out.println("VIP用户级别");
        System.out.println("分辨率：1080P");
        System.out.println("广告时长：0秒
    }
}
```

如上图，这三个类分别代表了不同用户的权限操作。这样拆分后，拆分的类符合单一职责原则。

不过在此之前，我们还得写一个抽象类（或者接口），使其更具泛用性。

```java
public abstract class UserService {
    public abstract void serveGrade();
}
```

从而，我们可以改写最开始的类。

首先，根据上面的类先建立一个工厂。

```java
public class VideoUserServiceFactory {
    public UserService produceUserService(String userType) {
        UserService userService;
        if (UserType.VISITOR == userType) {
            userService = new VisitorService();
        } else if (UserType.NORMAL == userType) {
            userService = new NormalUserService();
        } else if (UserType.VIP == userType) {
            userService = new VipUserService();
        } else {
            throw new RuntimeException("用户类型错误");
        }
        return userService;
    }
}
```

在这个工厂类中，我们根据用户的实际类型，创建了不同的用户对象，然后返回。

下面，我们就可以在实际场景（例如客户端）中使用这个工厂。

```java
public class Main {
    static void main(String[] args) {
        VideoUserServiceFactory factory = new VideoUserServiceFactory();
        UserService userService = factory.produceUserService(UserType.VISITOR);
        userService.serveGrade();
    }
}
```

通过这种方式，我们就可以将创建对象的过程与实际场景解耦，从而实现工厂模式。

当然，你会发现，我实际的代码比这更复杂，这是因为我采用了DDD架构。