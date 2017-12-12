package moreThread;

import java.util.LinkedList;

public class Storage {
	private final int MAX_SIZE = 100;

    // �ֿ�洢������
    private LinkedList<Object> list = new LinkedList<Object>();

    // ������Ʒ
    public void produce(String producer)
    {
        synchronized (list)
        {
            // ����ֿ�����
            while (list.size() == MAX_SIZE)
            {
                System.out.println("�ֿ���������"+producer+"���� ��ʱ����ִ����������!");
                try
                {
                    // �������������㣬��������
                    list.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            // ������Ʒ            
            list.add(new Object());            

            System.out.println("��"+producer+"����������һ����Ʒ\t���ֲִ���Ϊ��:" + list.size());

            list.notifyAll();
        }
    }

    // ���Ѳ�Ʒ
    public void consume(String consumer)
    {
        synchronized (list)
        {
            //����ֿ�洢������
            while (list.size()==0)
            {
                System.out.println("�ֿ��ѿգ���"+consumer+"���� ��ʱ����ִ����������!");
                try
                {
                    // �������������㣬��������
                    list.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            
            list.remove();
            System.out.println("��"+consumer+"����������һ����Ʒ\t���ֲִ���Ϊ��:" + list.size());
            list.notifyAll();
        }
    }

    public LinkedList<Object> getList()
    {
        return list;
    }

    public void setList(LinkedList<Object> list)
    {
        this.list = list;
    }

    public int getMAX_SIZE()
    {
        return MAX_SIZE;
    }
}
