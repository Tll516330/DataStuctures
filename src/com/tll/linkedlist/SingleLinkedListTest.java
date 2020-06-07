package com.tll.linkedlist;

/**
 * @author tll
 * @create 2020/6/6 10:01
 * 单链表测试
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        //创建英雄
        HeroNodeTest hero1 = new   HeroNodeTest(1, "宋江", "及时雨");
        HeroNodeTest hero3 = new HeroNodeTest(3, "吴用", "智多星");
        HeroNodeTest hero4 = new HeroNodeTest(4, "林冲", "豹子头");
        HeroNodeTest hero2 = new HeroNodeTest(2, "卢俊义", "玉麒麟");

        //创建一个链表
        SingleLinkedListOne listOne = new SingleLinkedListOne();
        //向链表中添加英雄
//        listOne.addHero(hero1);
//        listOne.addHero(hero4);
//        listOne.addHero(hero3);
//        listOne.addHero(hero2);

        //有序插入链表  应用获得的ID直接在内存中进行排序 不需要再数据库中进行排序
        listOne.addHeroOrder(hero4);
        listOne.addHeroOrder(hero3);
        listOne.addHeroOrder(hero3);
        listOne.addHeroOrder(hero2);
        listOne.addHeroOrder(hero1);

        //显示链表
        listOne.list();
        HeroNodeTest hero5 = new HeroNodeTest(3, "有用", "傻白甜");
        listOne.update(hero5);
        System.out.println("更改后");
        listOne.list();

        System.out.println("删除链表");
        listOne.delete(2);
        listOne.delete(2);
        listOne.list();
    }
}

//定义一个链表 管理英雄角色

class SingleLinkedListOne{
    /**
     * 首先定义一个头结点   头结点不包含任何信息
     */
    private HeroNodeTest head = new HeroNodeTest(0,"","");

    /**
     * 返回头结点
     */
    public HeroNodeTest getHead(){
        return head;
    }
    /**
     * 添加节点到当前链表
     * 思路，当不考虑编号顺序时
     * 1.找到当前链表的最后一个节点
     * 2.将最后一个节点next指向新的HeroNodeTest节点
     */
    public void addHero(HeroNodeTest heroNodeTest){
        //因为头结点不能动  所以我们就创建一个辅助节点
        HeroNodeTest temp = head;
        //遍历链表到最后一个next为空
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表最后的位置
        //将最后这个节点指向 heroNodeTest
        temp.next = heroNodeTest;
    }

    /**
     * 向链表中有序插入
     * @param heroNodeTest
     */
    public void addHeroOrder(HeroNodeTest heroNodeTest){
        //头结点不能动   创建一个辅助类
        HeroNodeTest temp = head;
        //创建一个flag判断添加的结点是否存在
        boolean flag = false;
        while (true){
            if (temp.next == null){
                //说明temp已经在链表的最后了 直接添加
                break;
            }else if (temp.next.no>heroNodeTest.no){
                //位置找到直接在temp后面加入
                break;
            }else if (temp.next.no == heroNodeTest.no){
                flag = true;
                //要加入的位置编号已经存在
                break;
            }
            //后移遍历链表
            temp = temp.next;
        }
        if (flag){
            System.out.printf("准备添加编号为%d的英雄已经存在",heroNodeTest.no);
            System.out.println();
        }else {
            //添加英雄  逻辑判断
            heroNodeTest.next = temp.next;
            temp.next = heroNodeTest;
        }

    }

    /**
     * 根据节点no更新英雄
     * @param newHero
     */
    public void update(HeroNodeTest newHero){
        if (head.next == null){
            //链表为空
            return;
        }
        //头结点不能动所以创建一个辅助节点
        HeroNodeTest temp = head;
        //定义一个boolean变量  判断是否有此节点
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }else if (temp.no == newHero.no){
                flag = true;
                break;
            }
            //当前为找到就继续后移
            temp = temp.next;
        }
        if (flag){
            temp.name = newHero.name;
            temp.nicknames = newHero.nicknames;
        }else {
            System.out.printf("未找到编号为%d 的英雄",newHero.no);
        }

    }

    /**
     * 根据编号删除节点
     * @param no
     */
    public void delete(int no ){
        //老规矩 头结点不能动 创建一个辅助节点
        HeroNodeTest temp = head;
        boolean flag = false;
        if(temp.next == null){
            return;
        }
        while (true){
            if (temp.next == null){
                break;
            }else if (temp.next.no == no){
                flag =true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("删除编号为%d 的英雄不存在\n",no);
        }
    }

    /**
     * 遍历输出链表
     */
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //头结点不能动  所以创建一个辅助类
        HeroNodeTest temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将节点向后移动   必须要将next后移一个位置
            temp = temp.next;
        }
    }
}

/**
 *定义一个英雄类
 */
class HeroNodeTest{

    public int no;
    public String name;
    public String nicknames;
    public HeroNodeTest next;

    public HeroNodeTest(int no, String name, String nicknames) {
        this.no = no;
        this.name = name;
        this.nicknames = nicknames;
    }

    @Override
    public String toString() {
        return "HeroNodeTest{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nicknames='" + nicknames + '\'' +
                '}';
    }
}