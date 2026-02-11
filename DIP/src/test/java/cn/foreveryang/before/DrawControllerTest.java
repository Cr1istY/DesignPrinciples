package cn.foreveryang.before;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

// 进行测试
// 从结果上看，程序没有问题，且验证结果也正常
// 但是，如果程序修改很频繁，那么，该写法的维护性就大大降低了
class DrawControllerTest {

    @Test
    void testDoDrawRandom_WhenListSizeLessThanCount_ShouldReturnOriginalList() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();
        list.add(new BetUser("user1", 10));
        list.add(new BetUser("user2", 20));

        // 执行测试
        List<BetUser> result = controller.doDrawRandom(list, 3);

        // 验证结果
        assertEquals(2, result.size());
        assertEquals(list, result);
    }

    @Test
    void testDoDrawRandom_WhenListSizeEqualsCount_ShouldReturnOriginalList() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();
        list.add(new BetUser("user1", 10));
        list.add(new BetUser("user2", 20));

        // 执行测试
        List<BetUser> result = controller.doDrawRandom(list, 2);

        // 验证结果
        assertEquals(2, result.size());
        assertEquals(list, result);
    }

    @Test
    void testDoDrawRandom_WhenListSizeGreaterThanCount_ShouldReturnRandomSubset() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();
        list.add(new BetUser("user1", 10));
        list.add(new BetUser("user2", 20));
        list.add(new BetUser("user3", 30));
        list.add(new BetUser("user4", 40));
        list.add(new BetUser("user5", 50));

        // 执行测试
        List<BetUser> result = controller.doDrawRandom(list, 2);

        // 验证结果
        assertEquals(2, result.size());
        assertTrue(list.containsAll(result));
    }

    @Test
    void testDoDrawWeight_WhenListSizeLessThanCount_ShouldReturnOriginalList() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();
        list.add(new BetUser("user1", 10));
        list.add(new BetUser("user2", 20));

        // 执行测试
        List<BetUser> result = controller.doDrawWeight(list, 3);

        // 验证结果
        assertEquals(2, result.size());
        assertEquals(list, result);
    }

    @Test
    void testDoDrawWeight_WhenListSizeEqualsCount_ShouldReturnOriginalList() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();
        list.add(new BetUser("user1", 10));
        list.add(new BetUser("user2", 20));

        // 执行测试
        List<BetUser> result = controller.doDrawWeight(list, 2);

        // 验证结果
        assertEquals(2, result.size());
        assertEquals(list, result);
    }

    @Test
    void testDoDrawWeight_WhenListSizeGreaterThanCount_ShouldReturnTopWeightedUsers() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();
        list.add(new BetUser("user1", 10));
        list.add(new BetUser("user2", 50));
        list.add(new BetUser("user3", 30));
        list.add(new BetUser("user4", 40));
        list.add(new BetUser("user5", 20));

        // 执行测试
        List<BetUser> result = controller.doDrawWeight(list, 3);

        // 验证结果
        assertEquals(3, result.size());
        assertEquals("user2", result.get(0).getName());
        assertEquals("user4", result.get(1).getName());
        assertEquals("user3", result.get(2).getName());
    }

    @Test
    void testDoDrawWeight_WhenSameWeight_ShouldMaintainOrder() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();
        list.add(new BetUser("user1", 10));
        list.add(new BetUser("user2", 10));
        list.add(new BetUser("user3", 10));

        // 执行测试
        List<BetUser> result = controller.doDrawWeight(list, 2);

        // 验证结果
        assertEquals(2, result.size());
        assertEquals("user1", result.get(0).getName());
        assertEquals("user2", result.get(1).getName());
    }

    @Test
    void testDoDrawRandom_WithEmptyList_ShouldReturnEmptyList() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();

        // 执行测试
        List<BetUser> result = controller.doDrawRandom(list, 2);

        // 验证结果
        assertTrue(result.isEmpty());
    }

    @Test
    void testDoDrawWeight_WithEmptyList_ShouldReturnEmptyList() {
        // 准备测试数据
        DrawController controller = new DrawController();
        List<BetUser> list = new ArrayList<>();

        // 执行测试
        List<BetUser> result = controller.doDrawWeight(list, 2);

        // 验证结果
        assertTrue(result.isEmpty());
    }
}
