/**
 * Created by ScorpionOrange on 2016/12/11.
 */
interface Queue{
    // 返回队列的大小
    public int getSize();

    // 判断队列是否为空
    public boolean isEmpty();

    // 数据元素 x 入队
    public boolean enqueue(Object x);

    // 队首元素出队
    public Object dequeue();

    // 取对首元素
    public Object getFront();

    // 置队列为空操作
    public void setEmpty();
}

class SLNode{
    // 数据域
    private Object data;

    // 引用域指向下一个节点
    private SLNode nextLink;

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public SLNode getNextLink(){
        return nextLink;
    }

    public void setNextLink(SLNode nextLink){
        this.nextLink = nextLink;
    }
}

class QueueSLinked implements Queue{
    private SLNode front;
    private SLNode rear;
    private int size;

    public QueueSLinked(){
        front = new SLNode();
        rear = front;
        size = 0;
    }

    // 返回队列的大小
    public int getSize(){
        return size;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else {
            return false;
        }
    }

    // 数据元素 x 入队
    public boolean enqueue(Object x){
        SLNode p = new SLNode();
        p.setData(x);
        rear.setNextLink(p);
        rear = p;
        size++;
        return true;
    }

    // 队首元素出队
    public Object dequeue(){
        Object object;

        if(size < 1){
            object = null;
        }

        SLNode p = front.getNextLink();
        front.setNextLink(p.getNextLink());
        size--;
        if(size < 1){
            rear = front; // 如果队列为空，rear指向头节点
        }
        object = p.getData();
        return object;
    }

    // 取对首元素
    public Object getFront(){
        Object object;

        if (size < 1){
            object = null;
        }

        object = front.getNextLink().getData();
        return object;
    }

    // 置队列为空操作
    public void setEmpty(){
        front = new SLNode();
        rear = front;
        size = 0;
    }
}

public class QueueSLinkedDemo {
    public static void main(String[] args){
        QueueSLinked queueSLinked = new QueueSLinked();
        queueSLinked.enqueue(100);
        System.out.println("元素100入队列。");
        queueSLinked.enqueue(200);
        System.out.println("元素200入队列。");
        queueSLinked.enqueue(300);
        System.out.println("元素300入队列。");
        queueSLinked.enqueue(400);
        System.out.println("元素400入队列。");
        queueSLinked.enqueue(500);
        System.out.println("元素500入队列。");

        if(queueSLinked.isEmpty()){
            System.out.println("队列当前为空。");
        }
        else {
            System.out.println("队列当前不为空。");
        }

        System.out.println("队列当前有" + queueSLinked.getSize() + "个元素。");
        System.out.println();

        System.out.println("队首元素为：" + queueSLinked.getFront());
        System.out.println();

        queueSLinked.dequeue();
        System.out.println("一个元素出队列后，新队首元素为：" + queueSLinked.getFront());

        queueSLinked.setEmpty();
        if(queueSLinked.isEmpty()){
            System.out.println("置队列为空操作后，队列内为空。");
        }
        else {
            System.out.println("置队列为空操作不成功。");
        }
    }
}
