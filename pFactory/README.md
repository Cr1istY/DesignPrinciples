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

相比于工厂方法模式，抽象方法模式将各种具体的产品进行分类。

例如，武器可以分为不同的类，而我们又可以将这些类根据各自的品牌进行分类。

举一个赛博朋克中的例子，对于突击步枪这一个抽象概念来说，如果给让荒坂公司生产，那它就会生产荒坂野分。同理，如果让军用科技来生产，则会是军用科技-阿贾克斯。

写成代码：

首先，定义这些具体的产品及其接口。

```java
// 步枪接口
public interface AssaultRifle {
    void fire();
    String getCorporateProtocol(); // 企业专属协议
}

// 手枪接口
public interface Pistol {
    void aim();
    boolean hasSmartLink(); // 是否支持自动瞄准
} 

```

对于荒坂公司的产品线，有：

```java
class ArasakaYabumi implements AssaultRifle {
    @Override
    public void fire() {
        System.out.println("【荒坂野分】");
    }
    
    @Override
    public String getCorporateProtocol() {
        return "NEUROTOXIN_COATING | CORPORATE_OATH_ENFORCED";
    }
}

class ArasakaShiShi implements Pistol {
    @Override
    public void aim() {
        System.out.println("【荒坂狮子】");
    }

    @Override
    public boolean hasSmartLink() {
        return true; // 荒坂武器强制神经绑定
    }
}
```

同理，军用科技则有以下产品线：

```java
class MilitechAjax implements AssaultRifle {
    @Override
    public void fire() {
        System.out.println("【军用科技-阿贾克斯】");
    }
    
    @Override
    public String getCorporateProtocol() {
        return "REDUNDANT_SAFETY_SYSTEMS | MILSPEC_CERTIFIED";
    }
}

class MilitechMantis implements Pistol {
    @Override
    public void aim() {
        System.out.println("【军用科技螳螂】");
    }
    
    @Override
    public boolean hasSmartLink() {
        return false; // 军用科技物理扳机（防黑客）
    }
}
```

现在，我们有了具体的产品。开始建立抽象工厂，用来定义武器族标准。

```java
interface CyberpunkWeaponFactory {
    AssaultRifle createAssaultRifle(); // 创建步枪
    Pistol createPistol();              // 创建手枪（关键：产品族完整性！）
}
```

开始定义具体工厂，即荒坂工厂和军用科技工厂。

```java
class ArasakaFactory implements CyberpunkWeaponFactory {
    @Override
    public AssaultRifle createAssaultRifle() {
        return new ArasakaYabumi();
    }
    
    @Override
    public Pistol createPistol() {
        return new ArasakaShiShi();
    }
}

class MilitechFactory implements CyberpunkWeaponFactory {
    @Override
    public AssaultRifle createAssaultRifle() {
        return new MilitechAjax();
    }

    @Override
    public Pistol createPistol() {
        return new MilitechMantis();
    }
}
```

此后，如果我们想要使用不同的产品，只需要在客户端创建不同的工厂即可，例如，下面的代码使用荒坂产品线。

```java
public static void main() {
    CyberpunkWeaponFactory factory = new ArasakaFactory();
    AssaultRifle rifle = factory.createAssaultRifle();
    rifle.fire();
    // 结果为：【荒坂野分】
}
```

#### 抽象工厂模式优缺点

优点：
- 当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一产品族中的对象。

缺点：
- 当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。

使用场景：
- 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
- 系统中有多个产品族，但每次只使用其中一个产品族。
- 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。
