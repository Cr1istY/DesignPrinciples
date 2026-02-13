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
    public void produceUserService(String userType) {
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
        UserService userService = factory.produceUserService(UserType.VISITOR);
        userService.serveGrade();
    }
}
```

但是，你可能发现了，如果说用户类型不只有三个，如果我们想要添加几个新的用户类型。那么，我们势必会修改我们的VideoUserServiceFactory类，这显然违背了开闭原则。

所以说，我们不应该也不能直接使用这个工厂类来进行主函数的逻辑。

而是应该在这个工厂类中，根据用户的实际类型，创建了不同的用户对象，然后返回。

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

通过这种方式，我们就可以将创建对象的过程与实际场景解耦，从而实现了工厂模式的雏形，即简单工厂模式。

### 简单工厂模式

简单工厂模式不是一种设计模式，反而更像是一种编程习惯。

在该模式中，主要有三种对象：
1. 抽象产品：定义产品的规范，描述了产品的主要特性和功能。—— UserService
2. 具体产品：实现或继承抽象产品的子类。—— VisitorService等
3. 具体工厂：提供了创建产品的方法，调用者通过该方法来创建产品。—— VideoUserServiceFactory

#### 简单工厂模式中的优缺点

优点：
- 封装了创建对象的过程，可以通过参数直接获取对象。把对象的创建和业务逻辑层分开，这样以后就避免了修改客户代码，如果要实现新产品直接修改工厂类，而不需要在原代码中修改，这样就降低了客户代码修改的可能性，更加容易扩展。

缺点：
- 增加新产品时还是需要修改工厂类的代码，违背了开闭原则。

#### 静态工厂模式

在开发中，一部分人将工厂类中创建对象的功能定义为静态的，而这，被称作静态工厂模式。

为了实践静态工厂模式，我们可以修改我们的工厂类。

```java
public class VideoUserServiceFactory {
    public static UserService produceUserService(String userType) {
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

此后，客户端文件的写法变成了：

```java
public class Main {
    static void main(String[] args) {
        UserService userService = VideoUserServiceFactory.produceUserService(UserType.VISITOR);
        userService.serveGrade();
    }
}
```

### 工厂方法模式

使用简单工厂模式时，我们违背了开闭原则。而工厂方法模式，则是为了解决这个问题。

首先，分析代码，我们之所以违背了开闭原则，是由于，简单工厂模式中，所有产品的生产都被放在了同一个工厂里。

```java
public class VideoUserServiceFactory {
    public static UserService produceUserService(String userType) {
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

如果，我们想要增加新的产品，那么，势必会修改上面这个工厂类的具体代码。

怎么解决这个问题呢，参考最开始的方案。我们可以将工厂类抽象成接口，然后，用具体类来实现，例如：

```java
public abstract class UserServiceFactory {
    
    public abstract UserService produceUserService();
}
```

再用其他的具体类来重写着这个抽象类中的方法，例如，针对VipUserService，有：

```java
public class VipUserServiceFactory extends UserServiceFactory {
    @Override
    public UserService produceUserService() {
        return new VipUserService();
    }
}

public class VistorUserServiceFactory extends UserServiceFactory {
    @Override
    public UserService produceUserService() {
        return new VistorUserService();
    }
}

public class NormalUserServiceFactory extends UserServiceFactory {
    @Override
    public UserService produceUserService() {
        return new NormalUserService();
    }
}
```

从而，当有新的产品需要时，我们只需要使得生产它的工厂符合我们所定义的工厂的标准即可。

从而，我们构建了一个不违背开闭原则的方案。

#### 工厂方法模式优缺点分析

优点：
- 用户只需要知道具体工厂的名称就可以得到所要的产品，无须知道产品的具体创建过程。
- 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则。

缺点：
- 每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。

### 抽象工厂模式

