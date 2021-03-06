学习笔记
HashMap小结：
    1）底层数据结构 ：
        数组+链表+红黑树
        链表解决哈希冲突问题
        红黑树解决在极端情况下哈希表退化为链表的情况：当链表长度达到8会转化为红黑树
    2）Java7与Java8的区别：
        改变了在拉链的情况下的节点插入方式，Java7中是采用头插法，Java8是尾插法
        头插法的原因是主观的认为后插入的节点会更常被访问，从而提高效率
            问题在于哈希表扩容的过程中，需要进行rehash操作，这个时候有可能发生的状况就是产生环形链表，因为采用头插法会导致引用关系发生改变
        尾插法就可以保证在rehash的过程中不改变引用关系
    3）线程安全问题：
        不论是头插法还是尾插法都存在线程安全问题
        jdk1.7中，会产生环形链表或数据丢失的情况
        jdk1.8中，会产生数据覆盖
    4） Hashtable 与 concurrentHashMap
        现阶段Hashtable用的已经很少了，原因在于其很低效，全局一把锁，导致一个方法在进行的过程中其他方法无法被访问
               concurrentHashMap在jdk1.7与1.8中是有很大的改变的，在jdk1.7中，加锁的方式是采用分段锁，
                ConcurrentHashMap 是由 Segment 数组结构和 HashEntry 数组结构组成。
                Segment 实现了 ReentrantLock,所以 Segment 是一种可重入锁，扮演锁的角色。HashEntry 用于存储键值对数据。
                在jdk1.8中 ConcurrentHashMap就取消了分段锁的形式，采用CAS和synchronized来保证并发安全。数据结构跟HashMap1.8的结构类似，数组+链表/红黑二叉树。Java 8在链表长度超过一定阈值（8）时将链表（寻址时间复杂度为O(N)）转换为红黑树（寻址时间复杂度为O(log(N))）
